package dto;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;
public class CreditDTOTest {

@Test
public void CreditMock(){
    CreditDTOTest credit = Mockito.mock(CreditDTOTest.class);
    assertTrue(credit != null);

}
}

