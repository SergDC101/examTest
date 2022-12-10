package com.example.demoexamtest;
import java.sql.*;


public class dbConnect {

    Connection dbConnect;

    private static final String host = "127.0.0.1";
    private static final String port = "3307";
    private static final String nameDB = "examtest";
    private static final String userDB = "root";
    private static final String passDB = "359678";

    public Connection getDbConnect() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" +host+ ":"
                +port+ "/" +nameDB;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnect = DriverManager.getConnection(connectionString, userDB, passDB);
        return dbConnect;
    }


    public ResultSet getUser(String loginText, String passText) throws SQLException, ClassNotFoundException {
        ResultSet resSet = null;
        String select = "SELECT * FROM "+nameDB+".wokers WHERE login = ? and password = ?";

        PreparedStatement preparedStatement = getDbConnect().prepareStatement(select);
        preparedStatement.setString(1, loginText);
        preparedStatement.setString(2, passText);
        resSet = preparedStatement.executeQuery();

        return resSet;
    }
}
