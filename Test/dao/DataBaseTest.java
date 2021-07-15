package dao;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.Statement;

public class DataBaseTest {
    @InjectMocks private DataBase db;
    @Mock private Connection mockConnection;
    @Mock private Statement mockStatement;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMockDBConnection() throws Exception {
        Mockito.when(mockConnection.createStatement()).thenReturn(mockStatement);
        Mockito.when(mockConnection.createStatement().executeUpdate((String) Mockito.any())).thenReturn(1);
        Connection value = db.getConnection();
        //Assert.assertEquals(value, "org.mariadb.jdbc.MariaDbConnection@184497d1");
        Mockito.verify(mockConnection.createStatement(), Mockito.times(1));
    }
}