package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import dto.ManagementDTO;

/**
 * Management DAO
 * Get and stores values from the database
 * It functions for login registration. It stores all user
 * management data.
 * @author kwanhyun kim
 *
 */
public class ManagementDAO {

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    private final String LOGIN = "select department from management.user where id = ? and password = ?";
    private final String INSERT = "INSERT INTO management.user(id,password,fakepassword,name,department) "
            + "values(?,?,?,?,?)";
    private final String LIST = "select * from management.user";
    private ManagementDAO() {}
    private static ManagementDAO instance = new ManagementDAO();

    public static ManagementDAO getInstance() {
        return instance;
    }
    /**
     * idPassword
     The values in the database and user-supplied values are checked
     through id and password, and if the data is correct,
     the values provided vary depending on the user's department.
     **/
    public String idPassword(String id, String password ) {

        conn = DataBase.getConnection();

        try {
            stmt = conn.prepareStatement(LOGIN);

            stmt.setString(1, id);


            stmt.setString(2, password);

            rs = stmt.executeQuery();

            if(rs.next()) {

                if (rs.getString("department").equals("1234"))
                    return "admin";

                else if (rs.getString("department").equals("DevelopmentTeam"))
                     return "DevelopmentTeam";

                else
                    return "SoftwareTeam";

            }


        } catch(SQLException e) {
            e.printStackTrace();
        }

        return "-1";
    }

    /**
     * insertMember
     * It receives the values provided by the user
     * and stores them in the database.
     */
    public int insertMember(ManagementDTO mdto) {

        conn = DataBase.getConnection();

        try {
            stmt = conn.prepareStatement(INSERT);
            stmt.setString(1, mdto.getId());
            stmt.setString(2, mdto.getPassword());
            stmt.setString(3, mdto.getFakePassword());
            stmt.setString(4, mdto.getName());
            stmt.setString(5, mdto.getDepartment());

            stmt.executeUpdate();
            return 1;

        } catch(Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * managementList
     * It is a list of values stored in a database.
     */
    public List<ManagementDTO> managementList() {
        conn = DataBase.getConnection();
        List<ManagementDTO> list = new ArrayList<ManagementDTO>();

        try {
            stmt = conn.prepareStatement(LIST);
            rs = stmt.executeQuery();
            while (rs.next()) {
                ManagementDTO mdto = new ManagementDTO();
                mdto.setId(rs.getString("ID"));
                mdto.setPassword(rs.getString("PASSWORD"));
                mdto.setFakePassword(rs.getString("FAKEPASSWORD"));
                mdto.setName(rs.getString("NAME"));
                mdto.setDepartment(rs.getString("DEPARTMENT"));
                list.add(mdto);
            }

            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}