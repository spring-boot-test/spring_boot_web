package com.hubert.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import com.hubert.core.boot.BaseWebAdapter;
@Controller
public class WebMvcController extends BaseWebAdapter{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//super.addViewControllers(registry);
		registry.addViewController("/login").setViewName("thymeleaf/login/login");
		registry.addViewController("/index").setViewName("thymeleaf/index/index");
		registry.addViewController("/error").setViewName("thymeleaf/error/error");
		registry.addViewController("/404").setViewName("thymeleaf/error/error");
	}

}
