package com.parking.dao.impl;

import com.parking.bean.Order;
import com.parking.dao.Connections;
import com.parking.dao.DaoException;
import com.parking.dao.ParkingDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySqlParkongDao implements ParkingDao {

    @Override
    public int addOrder(Order order) throws DaoException {
        String sql = "insert into t_order(order_id,car_no,enter_time,gmt_create) values(?, ?, ?, ?)";
        Connection conn = Connections.getConnection();
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, order.getOrderId());
            statement.setString(2, order.getCarNo());
            statement.setDate(3, new java.sql.Date(order.getEnterTime().getTime()));
            statement.setDate(4, new java.sql.Date(order.getGmtCreate().getTime()));
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("写入订单失败.", e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new DaoException("关闭statement失败", e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new DaoException("关闭Connection失败", e);
                }
            }
        }
    }
}
