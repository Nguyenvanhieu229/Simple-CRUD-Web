package com.example.demo.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    protected Connection conn;

    public DAO() {
        // Khởi tạo kết nối trong hàm khởi tạo
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/pttkhttt";
            String username = "root";
            String password = "123456";
            this.conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Xử lý ngoại lệ theo ý của bạn
        }
    }

}
