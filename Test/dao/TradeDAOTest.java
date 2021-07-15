package dao;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TradeDAOTest
{

    @InjectMocks Connection conn = null;
    @InjectMocks private PreparedStatement stmt = null;
    @InjectMocks private final String INSERT = "INSERT INTO management.trade(dep,asset,quantity,type) "
            + "values(?,?,?,?)";

    public int insertTrade() {

        conn = DataBase.getConnection();

        try {
            stmt = conn.prepareStatement(INSERT);

            stmt.setString(1, "DEPARTMENT");
            stmt.setString(2, String.valueOf(100));
            stmt.setString(3, String.valueOf(100));
            stmt.setString(4, "TYPE");
            stmt.executeUpdate();
            return 1;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Test
    public void Test()
    {
        Assert.assertEquals(1,insertTrade());
    }

}