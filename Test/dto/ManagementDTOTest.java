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
    public String getId() throws Exception {
        when(mdto.getId()).thenReturn("ID");
        assertTrue("ID".equals(mdto.getId()));
        return getId();
    }
    @Test
    public String getPassword() throws Exception {
        when(mdto.getPassword()).thenReturn("PASSWORD");
        assertTrue("PASSWORD".equals(mdto.getPassword()));
        return getPassword();
    }
    @Test
    public String getName() throws Exception {
         when(mdto.getName()).thenReturn("NAME");
         assertTrue("NAME".equals(mdto.getName()));
         return getName();
    }
    @Test
    public String getDepartment() throws Exception{
        when(mdto.getName()).thenReturn("DEPARTMENT");
        assertTrue("DEPARTMENT".equals(mdto.getDepartment()));
        return getName();
    }

}