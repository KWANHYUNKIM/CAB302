package dto;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class ManagementDTOTest {
    ManagementDTO mdto = Mockito.mock(ManagementDTO.class);
    @Test
    public void ManagementDTOTest() throws Exception {

    }
    @Test
    public void getId() throws Exception {
        when(mdto.getId()).thenReturn("ID");
        assertTrue("ID".equals(mdto.getId()));

    }
    @Test
    public void getPassword() throws Exception {
        when(mdto.getPassword()).thenReturn("PASSWORD");
        assertTrue("PASSWORD".equals(mdto.getPassword()));

    }
    @Test
    public void getName() throws Exception {
         when(mdto.getName()).thenReturn("NAME");
         assertTrue("NAME".equals(mdto.getName()));
    }
    @Test
    public void getDepartment() throws Exception{
        when(mdto.getDepartment()).thenReturn("DEPARTMENT");
        assertTrue("DEPARTMENT".equals(mdto.getDepartment()));
    }

}