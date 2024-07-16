package dao;

public class Country {

    private int id;
    private String abbrev;
    private String currency;

    public Country(int id, String abbrev, String currency) {
        this.id = id;
        this.abbrev = abbrev;
        this.currency = currency;
    }

    public Country(String abbrev, String currency) {
        this.abbrev = abbrev;
        this.currency = currency;
    }

    public int getId() {return id;}
    public String getAbbrev() {return abbrev;}
    public void setAbbrev(String country) {this.abbrev = country;}
    public String getCurrency() {return currency;}
    public void setCurrency(String currency) {this.currency = currency;}

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", abbrev='" + abbrev + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
