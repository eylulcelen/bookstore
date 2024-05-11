package database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;

import GUI.Books;
import GUI.Menu;

public class MySQL {



    private static final String url = "jdbc:mysql://localhost:3306/java_sql";
    private static final String username = "root";
    private static final String password = "frkn3756";





    public static void addBook() {

        String update = "INSERT INTO books VALUES (?, ?, ?, ?, ?, ?);";

        String barcode = Menu.getTxtbarcode().getText();
        String name = Menu.getTxtBName().getText();
        String edition = Menu.getTxtEdition().getText();
        String price = Menu.getTxtPrice().getText();
        String genre = Menu.getTxtGenre().getText();

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

    //as the Books arraylist and the database work in parallel for convenience no need to implement this method
    //but in a real scenario this method would be used instead
    public static void searchBook(String barcode) {

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

            Menu.getTxtbarcode().setText(resultSet.getString(1));
            Menu.getTxtBName().setText(resultSet.getString(2));
            Menu.getTxtEdition().setText(resultSet.getString(3));
            Menu.getTxtPrice().setText(resultSet.getString(4));
            Menu.getTxtGenre().setText(resultSet.getString(6));

            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static void updateBook(String barcode) {

        String updatedName = Menu.getTxtBName().getText();
        String updatedEdition = Menu.getTxtEdition().getText();
        String updatedPrice = Menu.getTxtPrice().getText();
        String updatedGenre = Menu.getTxtGenre().getText();

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

            connection.close();
        }
        catch(Exception e) {System.out.println(e);}
    }


    public static void updateQuantity(String barcode, int quantity) {

        String update = "UPDATE books SET Quantity = Quantity + ? Where Barcode = ?;";


        if (Menu.getRdBtnOut().isSelected()) {
            quantity *= -1;
        }
        if(!Menu.getRdBtnIn().isSelected() && !Menu.getRdBtnOut().isSelected()) {
            JOptionPane.showMessageDialog(Menu.getMenuFrame(), "Please choose in or out");
            return;
        }




        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(update);
            statement.setInt(1,quantity);
            statement.setString(2,barcode);
            statement.executeUpdate();
            connection.close();


        }catch (Exception e) {
            System.out.println(e);
        }
    }



    public static void loadBooks(DefaultTableModel model, ArrayList<Books> array) {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM books");

            while(resultset.next()) {

                String barcode = resultset.getString(1);
                String name = resultset.getString(2);
                String edition = resultset.getString(3);
                double price = resultset.getDouble(4);
                String genre = resultset.getString(6);

                Books book = new Books(barcode, name, edition, price, genre);
                array.add(book);
                book.setQuantity(resultset.getInt(5));
                book.setBalance(resultset.getInt(5));

                model.addRow(new Object[] {String.valueOf(barcode), name, edition, price, genre});
            }
            connection.close();
        }
        catch(Exception e) {System.out.println(e);}}


    public static int getQuantityFromDatabase(String barcode) {
        int quantity = 0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String query = "SELECT quantity FROM books WHERE Barcode = ?";

            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.setString(1,barcode);

            ResultSet resultSet = statement.executeQuery();
            resultSet.first();

            quantity = resultSet.getInt(1);

            connection.close();


        } catch (Exception e) {System.out.println(e);}

        return quantity;

    }





















    public static void printAllBooks() {

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

