package database;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import dnm2.menu2;

public class MySQLDeneme {


    public static void main(String[] args) {
        printAllBooks();
    }

    public static void loadBooks(DefaultTableModel model) {

        String url = "jdbc:mysql://localhost:3306/java_sql";
        String username = "root";
        String password = "frkn3756";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM books");

            while(resultset.next()) {

                model.addRow(new Object[] {
                        resultset.getInt(1),
                        resultset.getString(2),
                        resultset.getInt(3),
                        Double.parseDouble(resultset.getString(4))});
            }
            connection.close();
        }
        catch(Exception e) {System.out.println(e);;}}



    public static void addBook(int barcode, String bookName, int edition, Double price) {
        String url = "jdbc:mysql://localhost:3306/java_sql";
        String username = "root";
        String password = "frkn3756";

        String update = "INSERT INTO books VALUES (?, ?, ?, ?);";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(update);
            statement.setInt(1, barcode);
            statement.setString(2, bookName);
            statement.setInt(3, edition);
            statement.setDouble(4, price);
            statement.executeUpdate();

            connection.close();
        }
        catch(Exception e) {System.out.println(e);}
    }

    public static void deleteBook(String barcode) {
        String url = "jdbc:mysql://localhost:3306/java_sql";
        String username = "root";
        String password = "frkn3756";

        String delete = "DELETE FROM books WHERE barcode = ?;";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(delete);
            statement.setString(1,barcode);
            statement.executeUpdate();

            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }


    public static void searchBook(String barcode) {
        String url = "jdbc:mysql://localhost:3306/java_sql";
        String username = "root";
        String password = "frkn3756";

        String search = "SELECT * FROM books WHERE Barcode = ?;";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(search, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.setString(1, barcode);
            ResultSet resultSet = statement.executeQuery();

            if (!resultSet.next()) {
                return;
            }
            resultSet.first();

            menu2.getTxtbarcode().setText(resultSet.getString(1));
            menu2.getTxtbname().setText(resultSet.getString(2));
            menu2.getTxtedition().setText(resultSet.getString(3));
            menu2.getTxtprice().setText(resultSet.getString(4));

            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
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
                System.out.println(STR."\{resultset.getInt(1)} \{resultset.getString(2)} \{resultset.getInt(3)} \{resultset.getInt(4)}");
            }
            connection.close();
        }
        catch(Exception e) {System.out.println(e);}
    }

}
