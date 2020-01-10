package com.fh.biz.menu;

import com.fh.bean.menu.Menu;
import com.fh.mapper.menu.MenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: 1904-hygl
 * @description: 菜单实现类
 * @author: 翟浩浩
 * @create: 2020-01-04 14:51
 **/
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;
    @Override
    public List<Menu> findMenuList() {
        return menuDao.findMenuList();
    }
}
