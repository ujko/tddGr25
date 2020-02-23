package daoExample.model;

import java.io.Serializable;

public class Person implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String ipAddress;

    public int getId() {
        return id;
    }

    public Person empty() {
        id = -1;
        return this;
    }

    public Person setId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        if (firstName.matches("[A-Za-z\\s\\-\\']+")) {
            this.firstName = firstName;
            return this;
        }
        throw new IllegalArgumentException("Illegal parameter " + firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Person setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Person setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public Person setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }

    public String getPersonInCsvFormat() {
        return String.format("%d,%s,%s,%s,%s,%s", id, firstName, lastName, email, gender, ipAddress);
    }
}
