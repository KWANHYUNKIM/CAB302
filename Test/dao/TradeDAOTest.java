package dao;

import dto.TradeDTOTest;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TradeDAOTest
{
    @InjectMocks private TradeDTOTest tdtot;
    @InjectMocks Connection conn = null;
    @InjectMocks private PreparedStatement stmt = null;
    @InjectMocks private final String INSERT = "INSERT INTO management.trade(dep,asset,quantity,type) "
            + "values(?,?,?,?)";

    public int insertTrade() {

        conn = DataBase.getConnection();

        try {
            stmt = conn.prepareStatement(INSERT);

            stmt.setString(1, tdtot.getDepartment());
            stmt.setString(2, tdtot.getAsset());
            stmt.setString(3, tdtot.getQuantity());
            stmt.setString(4, tdtot.getType());
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