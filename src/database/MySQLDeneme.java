package database;

import java.sql.*;

public class MySQLDeneme {


    public static void main(String[] args) {
        addBook(7, "The Shadow Over Innsmouth", 8, 354.00);

        printAllBooks();

    }


    public static void printAllBooks() {
        String url = "jdbc:mysql://localhost:3306/java_sql";
        String username = "root";
        String password = "frkn3756";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM books");

            while(resultset.next()) {
                System.out.println(resultset.getInt(1) + " " + resultset.getString(2) + " " + resultset.getInt(3));
            }
            connection.close();
        }
        catch(Exception e) {System.out.println(e);}
    }

    public static void addBook(int barcode, String bookName, int edition, Double price) {
        String url = "jdbc:mysql://localhost:3306/java_sql";
        String username = "root";
        String password = "frkn3756";

        String update = "INSERT INTO books (Barcode, Book_name, Edition, Price) " +
                "VALUES (" + barcode + ", '" + bookName + "', " + edition + ", " + price + ");";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            statement.executeUpdate(update);
        }
        catch(Exception e) {System.out.println(e);}
    }



}
