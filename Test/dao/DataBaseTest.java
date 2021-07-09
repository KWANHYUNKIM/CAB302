package dao;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.Assert.*;

public class DataBaseTest {

    @Test
    public void getConnection() {
        Connection conn = null;

        try {
            String id = "root";
            String pw = "0428";
            String url = "jdbc:mariadb://127.0.0.1:3307/management";

            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(url, id, pw);

            System.out.println("Database success");

        } catch (Exception e) {
            System.out.println("Database fail");
            e.printStackTrace();
        }
        
    }
}