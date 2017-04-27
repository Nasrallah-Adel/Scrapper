/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nasrallah
 */
public class selection {

    Connection con;

    public selection() {
        con = connection.conn("feed");
    }

    public void get_all_course(String[][] all) {
        int i = 0;
        PreparedStatement pre;
        try {
            pre = (PreparedStatement) con.prepareStatement("SELECT * FROM course ; ");

            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                all[i][0] = rs.getString("c_name");
                all[i][1] = rs.getString("c_src");
                all[i][2] = rs.getString("c_img_src");
                all[i][3] = rs.getString("c_insta");

                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(selection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int get_count_course() {
        int i = 0;
        PreparedStatement pre;
        try {
            pre = (PreparedStatement) con.prepareStatement("SELECT * FROM course ; ");

            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(selection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return i;
    }
}
