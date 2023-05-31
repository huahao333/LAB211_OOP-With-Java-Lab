package Manage;




public class Dealer {
    String id;
    String name;
    String address;
    String phone;
    String status;
    
    public void Dealer(){
        
    }

    public Dealer(String id, String name, String address, String phone, String status) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ID=" + id + "| NAME=" + name + "| ADDRESS=" + address + "| PHONE=" + phone + "| STATUS=" + status+"\n";
    }
    
}
