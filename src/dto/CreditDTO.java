package dto;


public class CreditDTO {

    /**
     * CreditDTO
     * It is an object used to send data from a Database
     * to a service or controller.
     */
    private String department;
    private int credit;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String toString() {
        return "CreditDTO [department=" + department + ", credit=" + credit + "]";

    }
}
