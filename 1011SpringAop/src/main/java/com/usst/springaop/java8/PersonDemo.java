package com.usst.springaop.java8;

public class PersonDemo {
    private String username;
    private String password;
    private String address;
    private String email;
    private String phone;
    private Float salary;
    private Integer sex;

    public PersonDemo() {
    }

    public PersonDemo(String username, String password, String address, String email, String phone, Float salary, Integer sex) {
        this.username = username;
        this.password = password;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", sex=" + sex +
                '}';
    }

}
