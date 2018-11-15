package org.lucas.funny.console.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.lucas.funny.console.model.TPermissionModel;
import org.lucas.funny.console.model.TRoleModel;
import org.lucas.funny.console.model.TUserModel;
import org.lucas.funny.console.service.IPermissionService;
import org.lucas.funny.console.service.IRoleService;
import org.lucas.funny.console.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

	@Autowired
	IUserService userService;
	@Autowired
	IRoleService roleService;
	@Autowired
	IPermissionService permissionService;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String)principals.getPrimaryPrincipal();
		TUserModel user = userService.selectByUsername(username);
		List<String> roleList = new ArrayList<String>();
        List<String> permissionList = new ArrayList<String>();
        List<TRoleModel> roleModelList = roleService.selectRolesByUserid(user.getId());
        for(TRoleModel role:roleModelList) {
        	roleList.add(role.getRolename());
        }
        List<TPermissionModel> permissionModelList = permissionService.selectPermissionsByUserid(user.getId());
        for(TPermissionModel permission:permissionModelList) {
        	permissionList.add(permission.getCode());
        }
        SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
        /*根据用户ID查询角色（role），放入到Authorization里.*/
        info.addRoles(roleList);
        /*根据用户ID查询权限（permission），放入到Authorization里.*/
        info.addStringPermissions(permissionList);
        return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String)token.getPrincipal();
        String password = new String((char[])token.getCredentials());
        TUserModel user = userService.login(username, password);
        if(user == null){
			throw new AccountException("帐号或密码不正确！");
        }
        if(user.getStatus()){
            throw new DisabledAccountException("帐号已经禁止登录！");
        }
        String md5passwd = ShiroUtil.getMd5String(user.getUsername(), password);
        UsernamePasswordToken authcToken = (UsernamePasswordToken)token;
        authcToken.setPassword(md5passwd.toCharArray());
        //**密码加盐**交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        return new SimpleAuthenticationInfo(username,password,ByteSource.Util.bytes("3.141592653"), getName());
	}
	/**
     * 清空当前用户权限信息
     */
    public  void clearCachedAuthorizationInfo() {
        PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
        SimplePrincipalCollection principals = new SimplePrincipalCollection(
                principalCollection, getName());
        super.clearCachedAuthorizationInfo(principals);
    }
    /**
     * 指定principalCollection 清除
     */
    public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(
                principalCollection, getName());
        super.clearCachedAuthorizationInfo(principals);
    }
}
