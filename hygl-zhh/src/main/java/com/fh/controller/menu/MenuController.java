package com.fh.controller.menu;

import com.fh.bean.menu.Menu;
import com.fh.biz.menu.MenuService;
import com.fh.utils.ResponseServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: 1904-hygl
 * @description: 左边菜单
 * @author: 翟浩浩
 * @create: 2020-01-04 14:50
 **/
@RestController
@CrossOrigin
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping
    public ResponseServer findMenuList(){
        List<Map> deptMapList = new ArrayList<>();
        List<Menu> menuList = menuService.findMenuList();
        for (Menu menu : menuList) {
            Map map = new HashMap<>();
            map.put("id", menu.getId());
            map.put("name", menu.getName());
            map.put("pId", menu.getPid());
            map.put("url", menu.getUrl());
            map.put("target", menu.getTarget());
            deptMapList.add(map);
        }
        return ResponseServer.success(deptMapList);
    }
}
