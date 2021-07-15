package dao;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ManagementDAOTest {


    @InjectMocks Connection conn = null;
    @InjectMocks private PreparedStatement stmt = null;
    @InjectMocks private final String INSERT = "INSERT INTO management.user(id,password,fakepassword,name,department) "
            + "values(?,?,?,?,?)";
    @InjectMocks private final String LIST = "select * from management.user";

    public int insertMember() {
        conn = DataBase.getConnection();
        try {
            stmt = conn.prepareStatement(INSERT);
            stmt.setString(1, "ID");
            stmt.setString(2, "PASSWORD");
            stmt.setString(3, "FAKEPASSWORD");
            stmt.setString(4, "NAME");
            stmt.setString(5, "DEPARTMENT");
            stmt.executeUpdate();
            return 1;

        } catch(Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    @Test
    public void test(){
        Assert.assertEquals(1,insertMember());

    }
}