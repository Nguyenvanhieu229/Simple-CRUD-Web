package com.example.demo.controller;

import com.example.demo.dao.QuanLyDAO;
import com.example.demo.entity.QuanLy;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DangKyController {

    @PostMapping("/dang-ki")
    public String dangKiQuanLy(HttpServletRequest request, HttpSession session) throws Exception{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String hoTen = request.getParameter("ho_ten");
        String diaChi = request.getParameter("dia_chi");
        String soDienThoai = request.getParameter("so_dien_thoai");
        String phongBan = request.getParameter("phong_ban");
        String gioiTinh = request.getParameter("gioi_tinh");
        QuanLy ql = new QuanLy();
        ql.setPhongBan(phongBan);
        ql.setHoTen(hoTen);
        ql.setDiaChi(diaChi);
        ql.setUsername(username);
        ql.setPassword(password);
        ql.setSoDienThoai(soDienThoai);
        ql.setGioiTinh(gioiTinh);
        QuanLy sauLuu = new QuanLyDAO().dangKy(ql);
        session.setAttribute("quanLy", sauLuu);
        return "gdChinhQuanLy";
    }

}
