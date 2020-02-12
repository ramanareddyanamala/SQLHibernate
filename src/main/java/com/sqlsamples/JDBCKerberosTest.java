package com.sqlsamples;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCKerberosTest {

	public static void main(String[] args) {


		//Logger logger = Logger.getLogger("com.microsoft.sqlserver.jdbc");
		//logger.setLevel(Level.ALL);

		//try
		//{
		//	FileHandler fileHandler = new FileHandler("jdbc.log");
		//	fileHandler.setFormatter(new java.util.logging.SimpleFormatter());
		//	logger.addHandler(fileHandler);
		//}
		//catch(IOException e)
		//{
		//	e.printStackTrace();
		//}

    // Building the Connection URL
    // https://docs.microsoft.com/sql/connect/jdbc/building-the-connection-url
    
    // Setting the Connection Properties
    // https://docs.microsoft.com/sql/connect/jdbc/setting-the-connection-properties
    
    // Using Kerberos Integrated Authentication to Connect to SQL Server
    // https://docs.microsoft.com/sql/connect/jdbc/using-kerberos-integrated-authentication-to-connect-to-sql-server

		// **** Update the Server Name and Database Name ****
		// Create a variable for the connection string.
		String connectionUrl = "jdbc:sqlserver://10.65.196.100;databaseName=ipaybridge2_dev;integratedSecurity=true;authenticationScheme=JavaKerberos";


		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		System.setProperty("java.security.krb5.conf", "/Users/ramana.yanamala/Documents/krb5.conf");
		//System.setProperty("sun.security.krb5.debug", "true");
		System.setProperty("java.security.auth.login.config", "/Users/ramana.yanamala/Documents/SQLJDBCDriver.config");


		try {
		  // Establish the connection.
		  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		  con = DriverManager.getConnection(connectionUrl);

		  DatabaseMetaData dbmd = con.getMetaData();

		  System.out.println("dbmd:driver version = " + dbmd.getDriverVersion());
		  System.out.println("dbmd:driver name = " + dbmd.getDriverName());
		  System.out.println("db name = " + dbmd.getDatabaseProductName());
		  System.out.println("db ver = " + dbmd.getDatabaseProductVersion());

		}

		// Handle any errors that may have occurred.

		catch (Exception e) {
		  e.printStackTrace();
		}
    }
	
}
