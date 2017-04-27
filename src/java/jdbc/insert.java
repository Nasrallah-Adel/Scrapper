/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import Scrapper.c_model;
import Scrapper.e_model;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author nasrallah
 */
public class insert {

    Connection con;
    Statement st;

    public insert() {
        con = connection.conn("LinkMe");
    }

    /*
    
    
    
    
    
     */
//    public static void s(c_model c) {
//        insert_course(c);
//    }
//    public static void main(String[] args) {
//        c_model c = new c_model();
//        c.setC_img_src("qsssa");
//        c.setC_insta("dfdfdfasdf");
//        c.setC_name("fafafa");
//        c.setC_src("sss");
//        s(c);
//    }
    public boolean insert_course(c_model course) {

        try {
            if (course != null) {

                st = (Statement) con.createStatement();

                st.execute("INSERT INTO `LinkMe`.`courses`\n"
                        + "(`name`,\n"
                        + "`sourceImage`,\n"
                        + "`inst`,\n"
                        + "`link`)\n"
                        + "VALUES\n"
                        + "('" + course.getC_name() + "',\n"
                        + "'" + course.getC_img_src() + "',\n"
                        + "'" + course.getC_insta() + "',\n"
                        + "'" + course.getC_src() + "');");

                System.out.println("saved");
            }
        } catch (Exception e) {

            e.printStackTrace();
            return false;

        }

        return true;
    }

    public boolean insert_Event(e_model event) {

        try {
            if (event != null) {

                st = (Statement) con.createStatement();

                st.execute("INSERT INTO `LinkMe`.`Event`\n"
                        + "(`name`,\n"
                        + "`SrcImage`,\n"
                        + "`speaker`,\n"
                        + "`date`,\n"
                        + "`linke`)\n"
                        + "VALUES\n"
                        + "('" + event.getE_name() + "',\n"
                        + "'" + event.getImg() + "',\n"
                        + "'" + event.getSpeaker() + "',\n"
                        + "'" + event.getDate() + "',\n"
                        + "'" + event.getSrc() + "');");

                System.out.println("saved");
            }

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        }

        return true;
    }

}
