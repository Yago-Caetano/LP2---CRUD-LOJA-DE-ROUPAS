package com.crud.dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class ItemDAO {

    public ItemDAO() {  //DESKTOP-H7JQKH4\\SQLEXPRESS; Database=N2_dudu_Viotti_ecommerce; integrated security=true
        String connectionUrl = "jdbc:sqlserver:DESKTOP-H7JQKH4\\\\SQLEXPRESS;databaseName=master;user=sa;password=123456";
        /*"jdbc:sqlserver://localhost:1433;databaseName=master;user=sa;password=123456";*/

        try {
            // Load SQL Server JDBC driver and establish connection.
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(connectionUrl)) {
                System.out.println("Done.");
            }
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }
    }
}
