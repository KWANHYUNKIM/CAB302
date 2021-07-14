package dto;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class TradeDTOTest {

    @Test
    public void Instance() throws Exception{
        TradeDTO tdto = Mockito.mock(TradeDTO.class);
        when(tdto.getAsset()).thenReturn(1);
        when(tdto.getDepartment()).thenReturn("DEPARTMENT");
        when(tdto.getQuantity()).thenReturn(1);
        when(tdto.getType()).thenReturn("TYPE");

        Assert.assertEquals(1,tdto.getAsset());
        assertTrue("DEPARTMENT".equals(tdto.getDepartment()));
        Assert.assertEquals(1,tdto.getQuantity());
        assertTrue("TYPE".equals(tdto.getType()));

    }
}