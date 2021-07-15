package dto;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class TradeDTOTest {

    TradeDTO tdto = Mockito.mock(TradeDTO.class);

    @Test
    public void getAsset() throws Exception{

        when(tdto.getAsset()).thenReturn(1);
        Assert.assertEquals(1,tdto.getAsset());

    }
    @Test
    public void getDepartment() throws Exception{
        when(tdto.getDepartment()).thenReturn("DEPARTMENT");
        assertTrue("DEPARTMENT".equals(tdto.getDepartment()));

    }
    @Test
   public void getQuantity() throws Exception{
       when(tdto.getQuantity()).thenReturn(1);
       Assert.assertEquals(1,tdto.getQuantity());

   }
   @Test
   public void getType() throws Exception{
       when(tdto.getType()).thenReturn("TYPE");
       assertTrue("TYPE".equals(tdto.getType()));

   }

}