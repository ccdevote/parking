package com.parking.dao;

import com.parking.bean.Order;

public interface ParkingDao {

    int addOrder(Order order) throws DaoException;
}
