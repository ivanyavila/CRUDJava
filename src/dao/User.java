package dao;

import crud.country.ReadCountry;

import java.sql.Connection;

public class User {

    private int id;
    private String email;
    private String user;
    private long amount;
    private int country_id;
    private Country country;

    public User(int id, String email, String user, long amount, int country_id, Connection conn) {
        this.id = id;
        this.email = email;
        this.user = user;
        this.amount = amount;
        this.country_id = country_id;
        this.country = ReadCountry.getCountryByID(country_id, conn);
    }

    public int getId() { return id; }
    public String getEmail() { return email; }
    public void setEmail(String email) {this.email = email;}
    public String getUser() { return user; }
    public void setUser(String user) {this.user = user;}
    public long getAmount() {return amount;}
    public void setAmount(long amount) {this.amount = amount;}
    public int getCountry_id() { return country_id;}
    public void setCountry_id(int country_id) {this.country_id = country_id;}

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", user='" + user + '\'' +
                ", amount=" + amount +
                ", country_id=" + country_id +
                ", country=" + country.toString() +
                '}';
    }
}
