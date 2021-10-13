package com.example.don8;

public class UserObject {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private boolean veggies;
    private boolean fruit;
    private boolean grains;
    private boolean cans;
    private boolean meals;
    private boolean dropOff;

//    UserObject(String name,
//             String email,
//             String password,
//             String phoneNumber,
//             String address,
//             String city,
//             String state,
//             String zipCode,
//             boolean veggies,
//             boolean fruit,
//             boolean grains,
//             boolean cans,
//             boolean meals,
//             boolean dropOff) {
//        this.name = name;
//        this.email = email;
//        this.password = password;
//        this.phoneNumber = phoneNumber;
//        this.address = address;
//        this.city = city;
//        this.state = state;
//        this.zipCode = zipCode;
//        this.veggies = veggies;
//        this.fruit = fruit;
//        this.grains = grains;
//        this.cans = cans;
//        this.meals = meals;
//        this.dropOff = dropOff;
//    }


    public UserObject(String name, String email, String password, String phoneNumber, String address, String city, String state, String zipCode, boolean veggies, boolean fruit, boolean grains, boolean cans, boolean meals, boolean dropOff) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.veggies = veggies;
        this.fruit = fruit;
        this.grains = grains;
        this.cans = cans;
        this.meals = meals;
        this.dropOff = dropOff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public boolean isVeggies() {
        return veggies;
    }

    public void setVeggies(boolean veggies) {
        this.veggies = veggies;
    }

    public boolean isFruit() {
        return fruit;
    }

    public void setFruit(boolean fruit) {
        this.fruit = fruit;
    }

    public boolean isGrains() {
        return grains;
    }

    public void setGrains(boolean grains) {
        this.grains = grains;
    }

    public boolean isCans() {
        return cans;
    }

    public void setCans(boolean cans) {
        this.cans = cans;
    }

    public boolean isMeals() {
        return meals;
    }

    public void setMeals(boolean meals) {
        this.meals = meals;
    }

    public boolean isDropOff() {
        return dropOff;
    }

    public void setDropOff(boolean dropOff) {
        this.dropOff = dropOff;
    }

    @Override
    public String toString() {
        return "UserObject{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", veggies=" + veggies +
                ", fruit=" + fruit +
                ", grains=" + grains +
                ", cans=" + cans +
                ", meals=" + meals +
                ", dropOff=" + dropOff +
                '}';
    }
}
