package com.restaurant.service;

import com.restaurant.dao.BillDao;
import com.restaurant.dao.MultiTableDao;
import com.restaurant.domain.Bill;
import com.restaurant.domain.MultiTableBean;

import java.util.List;
import java.util.UUID;

/**
 * @author
 */
public class BillService {
    private BillDao billDao = new BillDao();
    private MenuService menuService = new MenuService();
    private DiningTableService diningTableService = new DiningTableService();
    private MultiTableDao multiTableDao = new MultiTableDao();

    public List<Bill> list(){
        return billDao.queryMulti("select * from bill", Bill.class);
    }

    public List<MultiTableBean> list2(){
        return multiTableDao.queryMulti("select name from bill, menu where bill.menuId = menu.id", MultiTableBean.class);
    }

    public boolean orderMenu(int menuId, int nums, int diningTableId) {
        String billId = UUID.randomUUID().toString();
        int update = billDao.update("insert into bill values(null,?,?,?,?,?,now(),'unpaid')",
                billId, menuId, nums, menuService.getMenuById(menuId).getPrice() * nums, diningTableId);
        if (update < 1) {
            return false;
        }
        return diningTableService.updateDiningTableState(diningTableId, "dining");
    }

    public boolean hasPayBillByDiningTableId(int diningTableId){
        Bill bill =
                billDao.querySingle("select * from bill where diningTableId = ? and state = 'unpaid'", Bill.class, diningTableId);
        return bill != null;
    }

    public boolean payBill(int diningTableId, String state){
        int update =
                billDao.update("update bill set state = ? where diningTableId = ? and state = 'unpaid'", state, diningTableId);
        if (update < 1){
            return false;
        }
        return diningTableService.updateDiningTableToFree(diningTableId, "empty");
    }
}
