package com.example.demo.controller;

import com.example.demo.dao.QuanLyDAO;
import com.example.demo.entity.QuanLy;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DangNhapController {


    @GetMapping("")
    public String showLogin() {
        return "gdDangNhap";
    }

    @PostMapping("/login")
    public String dangNhap(HttpServletRequest request, HttpSession session) throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        QuanLy ql = new QuanLyDAO().ktraDangNhap(username, password);
        if(ql != null) {
            session.setAttribute("quanLy", ql);
            return "gdChinhQuanLy";
        }
        else {
            return "gdDangNhap";
        }
    }

    @GetMapping("/new")
    public String dangKi() {
        return "gdDangKy";
    }
}



