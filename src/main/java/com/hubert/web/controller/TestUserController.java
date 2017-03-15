package com.hubert.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hubert.core.redis.RedisCache;
import com.hubert.core.utils.CacheUtils;
import com.hubert.core.utils.IniUtil;
import com.hubert.core.utils.SpringContextUtils;
import com.hubert.service.bs.TestUserBs;
import com.hubert.service.is.entity.TestUser;

@Controller
@RequestMapping("/testUser")
public class TestUserController {
	
	private static Logger logger = Logger.getLogger(TestUserController.class);
	
	@Autowired
	private TestUserBs testUserBs;
	
	@RequestMapping(value = "/queryUserTest", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<TestUser> queryUserTest() throws IOException{
		List<TestUser> result = testUserBs.queryTestUser();
		RedisCache sharedCache = (RedisCache) CacheUtils.getSharedCache();
		//必须序列化
		sharedCache.put("test", JSON.toJSONString(result));
		return testUserBs.queryTestUser();
	}
	
	@RequestMapping(value = "/queryRedisUserTest", method = RequestMethod.GET)
	@ResponseBody
	public String queryRedisUserTest() throws IOException{
		RedisCache sharedCache = CacheUtils.getSharedCache();
		ValueWrapper cacheValue = sharedCache.get("test");
		Object obj = cacheValue.get();
		return obj.toString();
	}
	
}
