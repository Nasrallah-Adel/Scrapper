/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author nasrallah
 */
public class connection {

    public static Connection conn(String DBname) {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DBname, "root", "root");
            System.out.println("connection start");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return con;
    }
}
