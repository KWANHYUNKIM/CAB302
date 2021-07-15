package dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CreditDAOTest {

    @InjectMocks Connection conn = null;
    @InjectMocks private PreparedStatement stmt = null;
    @InjectMocks private final String INSERT = "INSERT INTO management.credit(dep,credit) "
            + "values(?,?)";

    @Before
    public int insertCredit() {
        conn = DataBase.getConnection();
        try {
            stmt = conn.prepareStatement(INSERT);

            stmt.setString(1, "DEPARTMENT");
            stmt.setString(2, String.valueOf(100));

            stmt.executeUpdate();
            return 1;

        } catch(Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Test
    public void test()
    {
        Assert.assertEquals(1,insertCredit());
    }
}