package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import dto.TradeDTO;


public class TradeDAO {
    /**
     * TradeDAO
     * @author kwanhyun kim
     * TradeDAO stores and maintains values that occur
     * when buying and selling between DevelopmentTeam and SoftwareTeam.
     */
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;


    private final String INSERT = "INSERT INTO management.trade(dep,asset,quantity,type) "
            + "values(?,?,?,?)";
    private final String LIST = "select * from management.trade";
    private final String BUY = "delete * from management.trade where quantity = ? and asset = ?";

    private TradeDAO() {}
    private static TradeDAO instance = new TradeDAO();

    public static TradeDAO getInstance() {
        return instance;
    }

    public int Buy(int quantity, int asset) {

        conn = DataBase.getConnection();

        try {
            stmt = conn.prepareStatement(BUY);

            stmt.setString(1, String.valueOf(quantity));
            stmt.setString(2, String.valueOf(asset));

            rs = stmt.executeQuery();

            if(rs.next()) {

                return 1;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    /**
     * insertTrade
     * It receives the values provided by the user
     * and stores them in the database.
     */
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
    /**
     * tradeList
     * It is a list of values stored in a database.
     */
    public List<TradeDTO> tradeList() {
        conn = DataBase.getConnection();
        List<TradeDTO> list = new ArrayList<TradeDTO>();

        try {
            stmt = conn.prepareStatement(LIST);
            rs = stmt.executeQuery();
            while (rs.next()) {
                TradeDTO mdto = new TradeDTO();
                mdto.setDepartment(rs.getString("DEP"));
                mdto.setAsset(Integer.parseInt(rs.getString("ASSET")));
                mdto.setQuantity(Integer.parseInt(rs.getString("QUANTITY")));
                mdto.setType(rs.getString("TYPE"));
                list.add(mdto);
            }

            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}