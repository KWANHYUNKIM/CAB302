package gui.DevelopmentTeam.Function;


public class Buy {

    /**
     *  Buy
     *  If customer want to buy something, computer check the credit and asset and quantity.
     *
     */
    public boolean buy(int credit, int asset, int quantity) {

        try {
            int sum = asset * quantity;

            if (credit < sum)
                return false;
            else
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}