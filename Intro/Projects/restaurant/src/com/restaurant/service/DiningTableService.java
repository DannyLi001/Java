package com.restaurant.service;

import com.restaurant.dao.DiningTableDao;
import com.restaurant.domain.DiningTable;

import java.util.List;

/**
 * @author
 */
public class DiningTableService {
    private DiningTableDao diningTableDao = new DiningTableDao();

    public List<DiningTable> list(){
        return diningTableDao.queryMulti("select id, state from diningTable", DiningTable.class);
    }

    public DiningTable getDiningTableById(int id){
        return diningTableDao.querySingle("select * from diningTable where id = ?", DiningTable.class, id);
    }

    public boolean orderDiningTable(int id, String orderName, String orderTel){
        int update =
                diningTableDao.update("update diningTable set state='reserved', orderName = ?, orderTel = ? where id = ?", orderName, orderTel, id);
        return update > 0;
    }

    public boolean updateDiningTableState(int id, String state){
        int update = diningTableDao.update("update diningTable set state = ? where id = ?", state, id);
        return update > 0;
    }

    public boolean updateDiningTableToFree(int id, String state){
        int update = diningTableDao.update("update diningTable set state = ?, orderName = '', orderTel = '' where id = ?", state, id);
        return update > 0;
    }
}
