import conn.PostgreSQLConnection;
import crud.country.CreateCountry;
import crud.country.DeleteCountry;
import crud.country.ReadCountry;
import crud.country.UpdateCountry;
import crud.customer.CreateCustomer;
import crud.customer.DeleteCustomer;
import crud.customer.ReadCustomer;
import crud.customer.UpdateCustomer;
import dao.Country;
import dao.Customer;
import utils.Print;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection conn = PostgreSQLConnection.getConnection();
        //runCRUDCustomers(conn);
        runCRUDCountry(conn);

        PostgreSQLConnection.closeConnection();
    }

    public static void runCRUDCustomers(Connection conn) {
        Customer[] customers;
        //CUSTOMER CRUD:
        //READ
        customers = ReadCustomer.readAll(conn);
        Print.array(customers);

        //CREATE
        //Customer customer = new Customer("un-email@outlook.com", "un-nickname",10000L,3, conn);
        //CreateCustomer.create(conn, customer);

        //UPDATE
        //customers[1].setEmail("un-email-updated@outlook.com");
        //UpdateCustomer.update(conn, customers[1]);

        //DELETE
        //DeleteCustomer.deleteById(conn, customers[1].getId());

        //customers = ReadCustomer.readAll(conn);
        //Print.array(customers);
    }

    public static void runCRUDCountry(Connection conn) {
        Country[] countries;
        //COUNTRY CRUD:
        //READ
        countries = ReadCountry.readAll(conn);
        Print.array(countries);

        //CREATE
        //Country country = new Country("JP","YEN");
        //CreateCountry.create(conn, country);

        //UPDATE
        //countries[3].setCurrency("JPY");
        //UpdateCountry.update(conn, countries[3]);

        //DELETE
        //DeleteCountry.deleteById(conn, countries[3].getId());

        //countries = ReadCountry.readAll(conn);
        //Print.array(countries);
    }
}