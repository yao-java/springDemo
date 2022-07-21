package com.test.controller;

import com.github.pagehelper.PageInfo;
import com.test.annotation.NotControllerResponseAdvice;
import com.test.model.entity.IotDeviceLog;
import com.test.service.IotDeviceLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yao
 * @description
 * @date 2022-07-08 10:08
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private IotDeviceLogService iotDeviceLogService;

    @Autowired
    private RedisTemplate redisTemplate;


    @PostMapping("/list")
    public PageInfo<IotDeviceLog> list(){
        PageInfo<IotDeviceLog> page = iotDeviceLogService.page(2, 20);
        return page;
    }

    @PostMapping("/redis")
    @NotControllerResponseAdvice
    public String redis(){
        redisTemplate.opsForValue().set("test", "test");
        return "成功";
    }






}
