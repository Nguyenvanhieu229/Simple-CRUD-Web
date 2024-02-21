package com.example.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class XemBaoCaoThongKeController {
    @GetMapping("/thong-ke")
    public String hienGiaoDienBaoCaoThongKe(HttpServletRequest request, HttpSession session) {
        return "gdBaoCaoThongKe";
    }
}
