package com.fh.bean.menu;

/**
 * @program: 1904-hygl
 * @description: a
 * @author: 翟浩浩
 * @create: 2020-01-04 14:21
 **/

public class Menu {

    private Integer id;

    private String name;

    private Integer pid;

    private  String url;

    private String target= "zhu";

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
