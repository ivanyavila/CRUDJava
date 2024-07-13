package dao;

public class Country {

    private int id;
    private String country;
    private String currency;

    public Country(int id, String country, String currency) {
        this.id = id;
        this.country = country;
        this.currency = currency;
    }

    public int getId() {return id;}
    public String getCountry() {return country;}
    public void setCountry(String country) {this.country = country;}
    public String getCurrency() {return currency;}
    public void setCurrency(String currency) {this.currency = currency;}

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
