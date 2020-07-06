package com.alan.cake.admin.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alan.cake.admin.model.SysUser;
import com.alan.cake.admin.security.JwtAuthenticatioToken;
import com.alan.cake.admin.service.SysUserService;
import com.alan.cake.admin.util.PasswordUtils;
import com.alan.cake.admin.util.SecurityUtils;
import com.alan.cake.admin.vo.LoginBean;
import com.alan.cake.core.http.HttpResult;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

@RestController
public class SysLoginController {

	@Autowired
	private Producer producer;
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping(value = "captcha.jpg")
	public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Cache-Control", "no-store, not-cache");
		response.setContentType("image/jpeg");
		// 生成文字驗證碼
		String text = producer.createText();
		// 生成圖片驗證碼
		BufferedImage image = producer.createImage(text);
		// 保存驗證碼到session
		request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);
		ServletOutputStream output = response.getOutputStream();
		ImageIO.write(image, "jpg", output);
		IOUtils.closeQuietly(output);
	}

	@PostMapping(value = "/login")
	public HttpResult login(@RequestBody LoginBean loginBean, HttpServletRequest request) throws IOException {
		String username = loginBean.getAccount();
		String password = loginBean.getPassword();
		String captcha = loginBean.getCaptcha();
		// 从session中获取之前保存的验证码跟前台传来的验证码进行匹配
		Object kaptcha = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
		if (kaptcha == null) {
			return HttpResult.error("验证码已失效");
		}
		if (!captcha.equals(kaptcha)) {
			return HttpResult.error("验证码不正确");
		}
		// 用户信息
		SysUser user = sysUserService.findByName(username);
		// 账号不存在、密码错误
		if (user == null) {
			return HttpResult.error("账号不存在");
		}
		if (!PasswordUtils.matches(user.getSalt(), password, user.getPassword())) {
			return HttpResult.error("密码不正确");
		}
		// 账号锁定
		if (user.getStatus() == 0) {
			return HttpResult.error("账号已被锁定,请联系管理员");
		}
		// 系统登录认证
		JwtAuthenticatioToken token = SecurityUtils.login(request, username, password, authenticationManager);
		return HttpResult.ok(token);
	}
}
