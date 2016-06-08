package util;


import java.util.Properties;

import java.sql.*;
import java.io.*;

public class DBHandle {

	//public static Connection getDBHandle()

    private static Connection connection = null;
    public static Connection getDBHandle() {
        if (connection != null){
            System.out.println("returning non null obj");
            return connection;
        }
        else {
            try {
                Properties prop = new Properties();
               InputStream inputStream = DBHandle.class.getClassLoader().getResourceAsStream("/db.properties");
                //for running junit test cases
              // InputStream inputStream = ClassLoader.getSystemResourceAsStream("db.properties");
                prop.load(inputStream);
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");
                Class.forName(driver);
                connection = (Connection) DriverManager.getConnection(url, user, password);
                System.out.println("connected");
            } catch (ClassNotFoundException e) {
            	System.out.println(e);
                e.printStackTrace();
            } catch (SQLException e) {
            	System.out.println(e);
            	e.printStackTrace();
            } catch (FileNotFoundException e) {
            	System.out.println(e);
                e.printStackTrace();
            } catch (IOException e) {
            	System.out.println(e);
                e.printStackTrace();
            }
            return connection;
        }

    }    


}


