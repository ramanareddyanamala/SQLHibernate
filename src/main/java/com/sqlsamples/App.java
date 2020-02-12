package com.sqlsamples;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        String connectionUrl = "jdbc:sqlserver://10.65.196.100;databaseName=ipaybridge2_dev;integratedSecurity=true;user=CASHE\ramana.yanamala;password=Password1%;"; //;authenticationScheme=JavaKerberos
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
