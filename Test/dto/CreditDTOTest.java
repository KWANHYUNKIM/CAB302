package dto;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class CreditDTOTest {

    @Test
    public void Instance() throws Exception{
        CreditDTO cdto = Mockito.mock(CreditDTO.class);
        when(cdto.getCredit()).thenReturn(1);
        when(cdto.getDepartment()).thenReturn("DEPARTMENT");

        Assert.assertEquals(1,cdto.getCredit());
        Assert.assertEquals("DEPARTMENT",cdto.getDepartment());

    }
}

