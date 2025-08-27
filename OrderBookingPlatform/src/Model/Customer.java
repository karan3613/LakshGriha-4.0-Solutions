package Model;

public class Customer {
    private String name;
    private String dateOfRegistration;
    private String address;
    private String city;
    private String phone;
    private String email;
    private String pin ;
    public Customer(){}
    public Customer(String name, String dateOfRegistration, String address, String city, String pin, String phone, String email) {
        this.name = name;
        this.dateOfRegistration = dateOfRegistration;
        this.address = address;
        this.city = city;
        this.pin = pin;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(String dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    // Getters and Setters
}

