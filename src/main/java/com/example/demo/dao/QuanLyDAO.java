package com.example.demo.dao;
import com.example.demo.entity.QuanLy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuanLyDAO extends DAO{
    public QuanLy ktraDangNhap(String username, String password) throws Exception {

        String sql = "SELECT tv.id, tv.username, tv.password, tv.ho_ten, tv.dia_chi, " +
                "tv.so_dien_thoai, tv.gioi_tinh, ql.phong_ban " +
                "FROM tblthanhvien tv " +
                "JOIN tblquanly ql ON tv.id = ql.id " +
                "WHERE tv.username = ? AND tv.password = ?";
        PreparedStatement my_query = conn.prepareStatement(sql);
        my_query.setString(1, username);
        my_query.setString(2, password);
        ResultSet rs = my_query.executeQuery();
        while (rs.next()) {
            QuanLy ql = new QuanLy();
            ql.setId(rs.getInt("tv.id"));
            ql.setPassword(rs.getString("tv.password"));
            ql.setUsername(rs.getString("tv.username"));
            ql.setGioiTinh(rs.getString("tv.gioi_tinh"));
            ql.setDiaChi(rs.getString("tv.dia_chi"));
            ql.setHoTen(rs.getString("tv.ho_ten"));
            ql.setSoDienThoai(rs.getString("tv.so_dien_thoai"));
            ql.setPhongBan(rs.getString("ql.phong_ban"));
            return ql;
        }
        return null;
    }

    public QuanLy dangKy(QuanLy ql) throws Exception {

        String sqlThanhVien = "INSERT INTO tblthanhvien (password, username, gioi_tinh, dia_chi, ho_ten, so_dien_thoai) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sqlThanhVien, PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setString(1, ql.getPassword());
        ps.setString(2, ql.getUsername());
        ps.setString(3, ql.getGioiTinh());
        ps.setString(4, ql.getDiaChi());
        ps.setString(5, ql.getHoTen());
        ps.setString(6, ql.getSoDienThoai());

        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            int generatedId = rs.getInt(1);
            ql.setId(generatedId);
        }

        String sqlQuanLy = "INSERT INTO tblquanly (id, phong_ban) VALUES (?, ?)";
        PreparedStatement ps2 = conn.prepareStatement(sqlQuanLy);
        ps2.setInt(1, ql.getId());
        ps2.setString(2, ql.getPhongBan());
        ps2.executeUpdate();
        return ql;
    }
}
