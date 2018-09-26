package org.lucas.funny.console.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class UserRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//String account = (String)principals.getPrimaryPrincipal();
        /*AdminUser pojo = new AdminUser();
        pojo.setAccount(account);
        Long userId = adminUserService.selectOne(pojo).getId();*/
        SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
        /*根据用户ID查询角色（role），放入到Authorization里.*/
        /*info.setRoles(adminUserService.findRoleByUserId(userId));*/
        /*根据用户ID查询权限（permission），放入到Authorization里.*/
        /*info.setStringPermissions(adminUserService.findPermissionByUserId(userId));*/
        return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String)token.getPrincipal();
        String password = new String((char[])token.getCredentials());
        /*AdminUser user = adminUserService.login(username, password);
        if(null==user){
            throw new AccountException("帐号或密码不正确！");
        }
        if(user.getIsDisabled()){
            throw new DisabledAccountException("帐号已经禁止登录！");
        }*/
        //**密码加盐**交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        //return new SimpleAuthenticationInfo(user.getAccount(),user.getPassword(),ByteSource.Util.bytes("3.141592653"), getName());
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
