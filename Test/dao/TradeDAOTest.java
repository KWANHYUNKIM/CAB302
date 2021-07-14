package dao;

import dto.TradeDTO;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TradeDAOTest
{
    @InjectMocks private TradeDAO tdao;
    @InjectMocks Connection conn = null;
    @InjectMocks private PreparedStatement stmt = null;
    @InjectMocks private ResultSet rs = null;
    @InjectMocks private final String INSERT = "INSERT INTO management.trade(dep,asset,quantity,type) "
            + "values(?,?,?,?)";

    public int insertTrade(TradeDTO cdto) {

        conn = DataBase.getConnection();

        try {
            stmt = conn.prepareStatement(INSERT);

            stmt.setString(1, cdto.getDepartment());
            stmt.setString(2, String.valueOf(cdto.getAsset()));
            stmt.setString(3, String.valueOf(cdto.getQuantity()));
            stmt.setString(4, cdto.getType());
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

    }

}