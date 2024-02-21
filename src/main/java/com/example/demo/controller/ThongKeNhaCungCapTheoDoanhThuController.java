package com.example.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ThongKeNhaCungCapTheoDoanhThuController {
    @GetMapping("/thong-ke-theo-doanh-thu")
    public String thongKeTheoDoanhThu(HttpServletRequest request, HttpSession session) {
        return "gdThongKeNCCTheoDoanhThu";
    }

    @PostMapping("/thuc-hien-thong-ke")
    public String thongKe(HttpServletRequest request, HttpSession session) {
        return "gdThongKeNCCTheoDoanhThu";
    }

}
