package com.fh.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: 1904-hygl
 * @description: 测试swagger
 * @author: 翟浩浩
 * @create: 2020-01-13 17:07
 **/
@RestController
@RequestMapping("user")
@Api(value = "测试swagger类")
public class UserController {

    @ApiOperation(value = "查询用户名")
    @ApiImplicitParam(name = "name", value = "名称", paramType = "query", required = true, dataType = "String")
    @GetMapping
    public String getUser(String name){
        return name;
    }
}
