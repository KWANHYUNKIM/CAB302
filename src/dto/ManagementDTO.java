package dto;

public class ManagementDTO {
    /**
     * ManagementDTO
     * It is an object used to send data from a Database
     * to a service or controller.
     */
    private String id;
    private String password;
    private String name;
    private String department;
    private String fakepassword;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }
    public String setPassword(String password) { this.password = password; return password ;}

    public String getFakePassword() {
        return fakepassword;
    }
    public String setFakePassword(String fakepassword) { this.fakepassword = fakepassword; return fakepassword ;}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "ManagementDTO [id=" + id + ", password=" + password + "fakepassword=" + fakepassword + ", name=" + name +
                ", department=" + department + "]";
    }
}