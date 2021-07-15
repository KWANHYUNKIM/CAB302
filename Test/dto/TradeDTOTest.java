package dto;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class TradeDTOTest {

    TradeDTO tdto = Mockito.mock(TradeDTO.class);

    @Test
    public String getAsset() throws Exception{

        when(tdto.getAsset()).thenReturn(1);
        Assert.assertEquals(1,tdto.getAsset());
        return getAsset();
    }
    @Test
    public String getDepartment() throws Exception{
        when(tdto.getDepartment()).thenReturn("DEPARTMENT");
        assertTrue("DEPARTMENT".equals(tdto.getDepartment()));
        return getDepartment();
    }
    @Test
   public String getQuantity() throws Exception{
       when(tdto.getQuantity()).thenReturn(1);
       Assert.assertEquals(1,tdto.getQuantity());
       return getQuantity();
   }
   @Test
   public String getType() throws Exception{
       when(tdto.getType()).thenReturn("TYPE");
       assertTrue("TYPE".equals(tdto.getType()));
       return getType();
   }

}