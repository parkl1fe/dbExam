package model;

public class User {

    private Integer id;
    private String password;

    public User(Integer id, String password) {
        this.id = id;
        this.password = password;
    }

    public User(String password) {
        this.id = null;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                '}';
    }
}
