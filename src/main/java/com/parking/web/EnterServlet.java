package com.parking.web;

import com.parking.bean.Order;
import com.parking.service.ParkingService;
import com.parking.service.impl.SampleParkingService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EnterServlet extends HttpServlet {
    private final ParkingService parkingService = new SampleParkingService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String carNo = req.getParameter("carNo");
        Order order = parkingService.enter(carNo);
        resp.getOutputStream().write(order.toString().getBytes());
        resp.getOutputStream().flush();
    }
}
