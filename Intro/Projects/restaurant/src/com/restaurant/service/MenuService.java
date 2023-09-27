package com.restaurant.service;

import com.restaurant.dao.MenuDao;
import com.restaurant.domain.Menu;

import java.util.List;

/**
 * @author
 */
public class MenuService {
    private MenuDao menuDao = new MenuDao();

    public List<Menu> list(){
        return menuDao.queryMulti("select * from menu", Menu.class);
    }

    public Menu getMenuById(int id){
        return menuDao.querySingle("select * from menu where id = ?", Menu.class, id);
    }
}
