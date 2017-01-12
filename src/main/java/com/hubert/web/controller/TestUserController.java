package com.hubert.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hubert.service.bs.TestUserBs;
import com.hubert.service.is.entity.TestUser;

@Controller
@RequestMapping("/testUser")
public class TestUserController {
	
	@Autowired
	private TestUserBs testUserBs;
	
	@RequestMapping(value = "/queryUserTest", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<TestUser> queryUserTest(){
		return testUserBs.queryTestUser();
	}
}
