package org.lucas.funny.console.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.lucas.funny.console.common.ImageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String index() {
		return "login";
	}

	@RequestMapping("/toLogin")
	public String login(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rememberMe = request.getParameter("rememberMe");
		String host = this.getRemoteHost(request);
		UsernamePasswordToken token = new UsernamePasswordToken();
		token.setUsername(username);
		token.setPassword(password.toCharArray());
		token.setRememberMe("".equals(rememberMe)?false:true);
		token.setHost(host);
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.login(token);
		return "index";
	}
	
	public String getRemoteHost(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getRemoteAddr();
        }
        return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
    }
	/**
	 *  用于生成首页验证码 需要在shiro中配置权限为anon
	 */
    @RequestMapping(value = "codeImage")
    public void image(HttpServletRequest request, HttpServletResponse response) {
        try {
            int width = 100, height = 35;
            // 建立指定宽、高和BufferedImage对象
            String code = ImageUtil.generateVerifyCode(4, "23456789abdefghmnpqrtyABDEFGHMNPQRTY");
            BufferedImage image = ImageUtil.outputImage(width, height, code);
            request.getSession().setAttribute("code", code);
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/jpeg");
            OutputStream os = response.getOutputStream();
            ImageIO.write(image, "jpeg", os);
            os.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
