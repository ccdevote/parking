package com.parking.service;

import com.parking.bean.Order;

public interface ParkingService {

    Order enter(String carNo);
}
