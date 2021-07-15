package dao;

import dto.CreditDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CreditDAO {
    /**
     * Credit DAO
     * Get and stores values from the database
     * It is used when managers provide credit to users.
     * @author kwanhyun kim
     *
     */
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;


    private final String INSERT = "INSERT INTO management.credit(dep,credit) "
            + "values(?,?)";
    private final String LIST = "select * from management.credit";

    private CreditDAO() {}
    private static CreditDAO instance = new CreditDAO();

    public static CreditDAO getInstance() {
        return instance;
    }

    /**
     * InserCredit
     * Store the value in the database
     **/
    public int insertCredit(CreditDTO cdto) {

        conn = DataBase.getConnection();

        try {
            stmt = conn.prepareStatement(INSERT);

            stmt.setString(1, cdto.getDepartment());
            stmt.setString(2, String.valueOf(cdto.getCredit()));

            stmt.executeUpdate();
            return 1;

        } catch(Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    /**
     CreditList
     If all values are extracted from the database and used, they can cause security problems,
     so save them in the list.
     **/
    public List<CreditDTO> creditList() {
        conn = DataBase.getConnection();
        List<CreditDTO> list = new ArrayList<CreditDTO>();

        try {
            stmt = conn.prepareStatement(LIST);
            rs = stmt.executeQuery();
            while (rs.next()) {
                CreditDTO cdto = new CreditDTO();
                cdto.setDepartment(rs.getString("DEP"));
                cdto.setCredit(Integer.parseInt(rs.getString("CREDIT")));

                list.add(cdto);
            }

            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}