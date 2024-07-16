package dao;

import crud.country.ReadCountry;

import java.sql.Connection;

public class Customer {

    private int id;
    private String email;
    private String nickname;
    private long amount;
    private int country_id;
    private Country country;

    public Customer(int id, String email, String nickname, long amount, int country_id, Connection conn) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.amount = amount;
        this.country_id = country_id;
        this.country = ReadCountry.readByID(country_id, conn);
    }

    public Customer(String email, String nickname, long amount, int country_id, Connection conn) {
        this.email = email;
        this.nickname = nickname;
        this.amount = amount;
        this.country_id = country_id;
        this.country = ReadCountry.readByID(country_id, conn);
    }

    public int getId() { return id; }
    public String getEmail() { return email; }
    public void setEmail(String email) {this.email = email;}
    public String getNickname() { return nickname; }
    public void setNickname(String user) {this.nickname = user;}
    public long getAmount() {return amount;}
    public void setAmount(long amount) {this.amount = amount;}
    public int getCountry_id() { return country_id;}
    public void setCountry_id(int country_id) {this.country_id = country_id;}
    public Country getCountry() { return country; }
    public void setCountry(Country country) {this.country = country;}


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", amount=" + amount +
                ", country_id=" + country_id +
                ", country=" + country.toString() +
                '}';
    }
}
