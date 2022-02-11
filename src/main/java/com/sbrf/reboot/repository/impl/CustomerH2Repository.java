package com.sbrf.reboot.repository.impl;

import com.sbrf.reboot.dto.Customer;
import com.sbrf.reboot.repository.CustomerRepository;
import lombok.NonNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerH2Repository implements CustomerRepository {

    private final String JDBC_DRIVER = "org.h2.Driver";
    private final String DB_URL = "jdbc:h2:~/test";

    private final String USER = "sa";
    private final String PASS = "";

    private static Connection conn;
    private Statement stmt;

    public CustomerH2Repository() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = conn.createStatement();
    }

    @Override
    public boolean createCustomer(@NonNull String userName, String eMail) throws SQLException {
        stmt.execute("INSERT INTO CUSTOMER(name, eMail) VALUES(" + "'" + userName + "','" + eMail + "')");
        return true;
    }

    @Override
    public List<Customer> getAll() throws SQLException {
        List<Customer> customers = new ArrayList<>();

        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM CUSTOMER");
        while (rs.next()) {
            Customer customer = new Customer();
            customer.setId(rs.getLong("id"));
            customer.setName(rs.getString("name"));
            customer.setEMail(rs.getString("eMail"));

            customers.add(customer);
        }
        return customers;
    }
}


