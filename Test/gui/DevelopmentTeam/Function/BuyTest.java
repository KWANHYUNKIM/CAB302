package gui.DevelopmentTeam.Function;

import org.junit.Test;

import static org.junit.Assert.*;

public class BuyTest {

    @Test
    public void buy() {
        try {
            int asset = 100;
            int quantity = 50;
            int credit = 600;

            int sum = asset * quantity;

            if (credit < sum)
                System.out.print("False");
            else
                System.out.print("True");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}