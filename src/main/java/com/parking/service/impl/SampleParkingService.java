package com.parking.service.impl;

import com.parking.bean.Order;
import com.parking.dao.DaoException;
import com.parking.dao.ParkingDao;
import com.parking.dao.impl.MySqlParkongDao;
import com.parking.service.ParkingService;

import java.util.Date;

public class SampleParkingService implements ParkingService {

    private final ParkingDao parkingDao = new MySqlParkongDao();

    @Override
    public Order enter(String carNo) {
        Order order = new Order();
        order.setOrderId("testorder_id_01");
        order.setCarNo(carNo);
        order.setEnterTime(new Date());
        order.setGmtCreate(new Date());
        try {
            int ret = parkingDao.addOrder(order);
            if (ret < 1) {
                throw new DaoException("写入订单失败");
            }
            return order;
        } catch (DaoException e) {
            throw new SecurityException("入场失败.", e);
        }
    }
}
