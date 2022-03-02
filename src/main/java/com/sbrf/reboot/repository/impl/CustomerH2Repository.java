package com.sbrf.reboot.repository.impl;

import com.sbrf.reboot.dto.Customer;
import com.sbrf.reboot.repository.CustomerRepository;
import lombok.NonNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerH2Repository implements CustomerRepository {

    private final String JDBC_DRIVER = "org.h2.Driver";
    private final String DB_URL = "jdbc:h2:~/test";

    private final String USER = "sa";
    private final String PASS = "";

    public CustomerH2Repository() throws ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
    }

    @Override
    public boolean createCustomer(@NonNull String userName, String eMail) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE CUSTOMER(id, name, eMail");
            stmt.executeUpdate("INSERT INTO CUSTOMER(name, eMail) VALUES(" + "'" + userName + "','" + eMail + "')");
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
        }
        return true;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM CUSTOMER");
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setName(rs.getString("name"));
                customer.setEMail(rs.getString("eMail"));

                customers.add(customer);
            }
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
        }
        return customers;
    }
}


