package com.fh.mapper.menu;

import com.fh.bean.menu.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MenuDao {

    List<Menu> findMenuList();
}
