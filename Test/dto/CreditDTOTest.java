package dto;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class CreditDTOTest {
    CreditDTO cdto = Mockito.mock(CreditDTO.class);
    @Test
    public int getCredit() throws Exception{

        when(cdto.getCredit()).thenReturn(1);
        Assert.assertEquals(1,cdto.getCredit());
        return getCredit();

    }
    @Test
    public String getDepartment() throws Exception{
        when(cdto.getDepartment()).thenReturn("DEPARTMENT");
        Assert.assertEquals("DEPARTMENT",cdto.getDepartment());
        return getDepartment();
    }
}

