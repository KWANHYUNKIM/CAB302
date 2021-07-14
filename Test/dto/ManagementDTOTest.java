package dto;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class ManagementDTOTest {

    @Test
    public void Instance() throws Exception{
         ManagementDTO mdto = Mockito.mock(ManagementDTO.class);
         when(mdto.getId()).thenReturn("ID");
         when(mdto.getPassword()).thenReturn("PASSWORD");
         when(mdto.getName()).thenReturn("DEPARTMENT");

         assertTrue("ID".equals(mdto.getId()));
         assertTrue("PASSWORD".equals(mdto.getPassword()));
         assertTrue("DEPARTMENT".equals(mdto.getDepartment()));

    }

}