package org.lucas.funny.console.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class RememberMeFilter extends FormAuthenticationFilter {

	@Override
	protected boolean isAccessAllowed(ServletRequest request,ServletResponse response,Object mappedValue){
		Subject subject = getSubject(request,response);
		Session session = subject.getSession();
		/**满足三个条件：选择记住我,非密码登录,session为空*/
		if(!subject.isAuthenticated() && subject.isRemembered() && session.getAttribute("user") == null){
			Object principal = subject.getPrincipal();
			if(principal!=null){
				/*AdminUser pojo = new AdminUser();
				pojo.setAccount(principal.toString());
				AdminUser user = adminUserService.selectOne(pojo);
				session.setAttribute("user", user.getAccount());*/
			}
		}
		return subject.isAuthenticated()||subject.isRemembered();
	}
}
