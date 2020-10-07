package model;

import java.sql.Date;

public class User_details {

    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String tel_number;
    private Date birth_date;


    public User_details(Integer id, String name, String surname,
                        String email, String tel_number, Date birth_date) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.tel_number = tel_number;
        this.birth_date = birth_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel_number() {
        return tel_number;
    }

    public void setTel_number(String tel_number) {
        this.tel_number = tel_number;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }
}
