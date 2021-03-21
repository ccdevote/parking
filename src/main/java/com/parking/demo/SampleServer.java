package com.parking.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class SampleServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket ss = new ServerSocket(8080);

        while (true) {
            // 等待客户端连接
            Socket socket = ss.accept();
            //System.out.println("客户端已接入, ip:" + socket.getInetAddress());
            // 读取客户端输入的数据
            InputStream in = socket.getInputStream();
            // TODO 处理数据
            // uri= /parking
            // 返回数据给客户端
            OutputStream out = socket.getOutputStream();
            out.write("hello".getBytes());

            TimeUnit.SECONDS.sleep(5);
        }
    }
}
