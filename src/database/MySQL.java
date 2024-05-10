package database;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import dnm2.menu2;

public class MySQL {


    public static void main(String[] args) {
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
                        Double.parseDouble(resultset.getString(4)),
                        resultset.getString(6)});
            }
            connection.close();
        }
        catch(Exception e) {System.out.println(e);}}



    public static void addBook() {
        String url = "jdbc:mysql://localhost:3306/java_sql";
        String username = "root";
        String password = "frkn3756";

        String update = "INSERT INTO books VALUES (?, ?, ?, ?, ?, ?);";

        String barcode = menu2.getTxtBarcode().getText();
        String name = menu2.getTxtBName().getText();
        String edition = menu2.getTxtEdition().getText();
        String price = menu2.getTxtPrice().getText();
        String genre = menu2.getTxtGenre().getText();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(update);
            statement.setString(1, barcode);
            statement.setString(2, name);
            statement.setString(3, edition);
            statement.setString(4, price);
            statement.setString(5,"0");
            statement.setString(6, genre);
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

            menu2.getTxtBarcode().setText(resultSet.getString(1));
            menu2.getTxtBName().setText(resultSet.getString(2));
            menu2.getTxtEdition().setText(resultSet.getString(3));
            menu2.getTxtPrice().setText(resultSet.getString(4));
            menu2.getTxtGenre().setText(resultSet.getString(6));

            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static void updateBook(String barcode) {
        String url = "jdbc:mysql://localhost:3306/java_sql";
        String username = "root";
        String password = "frkn3756";

        String updatedName = menu2.getTxtBName().getText();
        String updatedEdition = menu2.getTxtEdition().getText();
        String updatedPrice = menu2.getTxtPrice().getText();
        String updatedGenre = menu2.getTxtGenre().getText();

        try {
            String update = "UPDATE books SET Book_name = ?, Edition = ?, Price = ?, Genre = ? WHERE barcode = ?";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(update);
            statement.setString(1, updatedName);
            statement.setString(2, updatedEdition);
            statement.setString(3, updatedPrice);
            statement.setString(4, updatedGenre);
            statement.setString(5,barcode);
            statement.executeUpdate();
        }
        catch(Exception e) {System.out.println(e);}
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
