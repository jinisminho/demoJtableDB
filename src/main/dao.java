/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import database.MyConnection;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author Hoang Pham
 */
public class dao {

    Connection conn;
    ResultSet rs;
    PreparedStatement preStm;

    void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (preStm != null) {
                preStm.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Vector<Obj> getItem() {
        Vector<Obj> list = new Vector<>();
        String user, name, pass, role;
        try {
            String url = "Select * From registration";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(url);
            rs = preStm.executeQuery();
            while (rs.next()) {
                user = rs.getString("username");
                name = rs.getString("fullname");
                pass = rs.getString("password");
                role = rs.getString("role");
                Obj tmp = new Obj(name, user, pass, role);
                list.add(tmp);
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return list;
    }
}
