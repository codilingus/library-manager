package pl.codilingus.library;

import javax.persistence.*;

@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private int age;
    private long pesel;


    public User(String firstName, String lastName, int age,long pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.pesel = pesel;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getPesel() {
        return pesel;
    }

    public void setPesel(long pesel) {
        this.pesel = pesel;
    }
}
