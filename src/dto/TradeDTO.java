package dto;

public class TradeDTO {
    /**
     * TradeDTO
     * It is an object used to send data from a Database
     * to a service or controller.
     */

    private String department;
    private String type;
    private int asset;
    private int quantity;


    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAsset(){return asset; }
    public void setAsset(Integer asset){this.asset = asset;}

    public int getQuantity(){return quantity; }
    public void setQuantity(Integer quantity){this.quantity = quantity;}

    public String getType() {
        return type;
    }
    public void setType(String type ) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CreditDTO [development=" + department +
                "asset=" + asset + "Quantity="+ quantity + "Type=" + type + "]";
    }
}