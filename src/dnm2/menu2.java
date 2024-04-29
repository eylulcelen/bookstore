package dnm2;

import database.MySQLDeneme;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JRadioButton;


public class menu2 extends JFrame {
	
	private static ArrayList<Books> books = new ArrayList<>();
	private static ArrayList<String> usedBarcodes = new ArrayList<>();
	

	private static JTextField txtbname;
	private static JTextField txtedition;
	private static JTextField txtprice;
	private JTextField txtsbarcode;
	private JTextArea textArea;
	private DefaultTableModel model;
	private JTable table;
	private static JTextField txtbarcode;
	private JTable table_1;
	private JRadioButton rdbtnhorror;
	private JRadioButton rdbtnromance;
	private JRadioButton rdbtnmystery;
	private JRadioButton rdbtnpoetry;

    public static JTextField getTxtbname() {
        return txtbname;
    }

    public static JTextField getTxtedition() {
        return txtedition;
    }

    public static JTextField getTxtprice() {
        return txtprice;
    }

    public static JTextField getTxtbarcode() {
        return txtbarcode;
    }

    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new menu2();

			}});
	}
	

	/**
	 * Create the frame.
	 */
	
	public menu2() {



		JFrame menuframe = new JFrame();
		menuframe.setTitle("Book Management System");
        menuframe.setBounds(100, 100, 760, 500);
        menuframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuframe.getContentPane().setLayout(null);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 10, 731, 458);
        menuframe.getContentPane().add(tabbedPane);
        
        //BOOKCARD---------------------------------------------------------------------------------------------------------------
        
        JPanel panelbc = new JPanel();
        tabbedPane.addTab("Book Card", null, panelbc, null);
        panelbc.setLayout(null);
        
        JLabel lblbcard = new JLabel("Book Card:");
        lblbcard.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblbcard.setBounds(10, 6, 149, 40);
        panelbc.add(lblbcard);
        
        JPanel panelinfo = new JPanel();
        panelinfo.setBorder(new TitledBorder(null, "Registeration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelinfo.setBounds(20, 56, 266, 243);
        panelbc.add(panelinfo);
        panelinfo.setLayout(null);
        
        JLabel lblprice = new JLabel("Price:");
        lblprice.setBounds(10, 113, 104, 19);
        panelinfo.add(lblprice);
        lblprice.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        txtprice = new JTextField();
        txtprice.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtprice.setBounds(124, 112, 104, 21);
        panelinfo.add(txtprice);
        txtprice.setColumns(10);
        
        JLabel lblbarcode = new JLabel("Barcode:");
        lblbarcode.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblbarcode.setBounds(10, 22, 104, 19);
        panelinfo.add(lblbarcode);
        
        txtbarcode = new JTextField();
        txtbarcode.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtbarcode.setColumns(10);
        txtbarcode.setBounds(124, 21, 104, 21);
        panelinfo.add(txtbarcode);
        
        JLabel lblbname = new JLabel("Book Name:");
        lblbname.setBounds(10, 52, 82, 19);
        panelinfo.add(lblbname);
        lblbname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        txtbname = new JTextField();
        txtbname.setBounds(124, 51, 104, 21);
        panelinfo.add(txtbname);
        txtbname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtbname.setColumns(10);
        
        JLabel lbledition = new JLabel("Edition:");
        lbledition.setBounds(10, 84, 104, 19);
        panelinfo.add(lbledition);
        lbledition.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        txtedition = new JTextField();
        txtedition.setBounds(124, 81, 104, 21);
        panelinfo.add(txtedition);
        txtedition.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtedition.setColumns(10);

        
        JLabel lblgenre = new JLabel("Genre:");
        lblgenre.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblgenre.setBounds(10, 142, 104, 19);
        panelinfo.add(lblgenre);
        
        rdbtnhorror = new JRadioButton("Horror");
        rdbtnhorror.setFont(new Font("Tahoma", Font.PLAIN, 15));
        rdbtnhorror.setBounds(124, 141, 103, 21);
        panelinfo.add(rdbtnhorror);
        
        rdbtnromance = new JRadioButton("Romance");
        rdbtnromance.setFont(new Font("Tahoma", Font.PLAIN, 15));
        rdbtnromance.setBounds(125, 164, 103, 21);
        panelinfo.add(rdbtnromance);
        
        rdbtnmystery = new JRadioButton("Mystery");
        rdbtnmystery.setFont(new Font("Tahoma", Font.PLAIN, 15));
        rdbtnmystery.setBounds(124, 187, 103, 21);
        panelinfo.add(rdbtnmystery);
        
        rdbtnpoetry = new JRadioButton("Poetry");
        rdbtnpoetry.setFont(new Font("Tahoma", Font.PLAIN, 15));
        rdbtnpoetry.setBounds(124, 210, 103, 21);
        panelinfo.add(rdbtnpoetry);
        
        ButtonGroup genreGroup = new ButtonGroup();
        genreGroup.add(rdbtnhorror);
        genreGroup.add(rdbtnromance);
        genreGroup.add(rdbtnmystery);
        genreGroup.add(rdbtnpoetry);
        
        

        JButton btnsave = new JButton("Save");
        btnsave.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	
                String barcode = txtbarcode.getText();
                String bookName = txtbname.getText();
                String edition = txtedition.getText();
                double price = Double.parseDouble(txtprice.getText());
                String genre = "";
                if (rdbtnhorror.isSelected()) {
                    genre = "Horror";
                } else if (rdbtnromance.isSelected()) {
                    genre = "Romance";
                } else if (rdbtnmystery.isSelected()) {
                    genre = "Mystery";
                } else if (rdbtnpoetry.isSelected()) {
                    genre = "Poetry";
                }
                
                
                if (!isBarcodeUnique(barcode)) {
                	JOptionPane.showMessageDialog(null, "Barcode has been already used.");
                }
                else {
                Books book = new Books(barcode, bookName, edition, price, genre);
                books.add(book);
                JOptionPane.showMessageDialog(null, "Book saved successfully.");
                
                model = new DefaultTableModel();
                DefaultTableModel model= (DefaultTableModel)table_1.getModel();
                model.addRow(new Object[]{barcode, bookName, edition, price, genre});
                }
                
        	}
        });


        
        btnsave.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnsave.setBounds(30, 309, 85, 37);
        panelbc.add(btnsave);
        
        
        textArea = new JTextArea();
        textArea.setEditable(false);
        
        
        JButton btnclear = new JButton("Clear");
        btnclear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               clear();
            }
        });
        
        
        btnclear.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnclear.setBounds(185, 309, 85, 39);
        panelbc.add(btnclear);
        
        JPanel searchpanel = new JPanel();
        searchpanel.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        searchpanel.setBounds(384, 271, 266, 127);
        panelbc.add(searchpanel);
        searchpanel.setLayout(null);
        
        JLabel lblsbarcode = new JLabel("Book's barcode:");
        lblsbarcode.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblsbarcode.setBounds(10, 35, 130, 19);
        searchpanel.add(lblsbarcode);
        
        txtsbarcode = new JTextField();
        txtsbarcode.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtsbarcode.setColumns(10);
        txtsbarcode.setBounds(131, 34, 125, 21);
        searchpanel.add(txtsbarcode);
        
        
        JButton btnSearch = new JButton("Search");
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                String barcode = txtsbarcode.getText();
                Books foundBook = searchBookByBarcode(barcode);
                
                if (foundBook != null) {
                	
                	/*
                    JOptionPane.showMessageDialog(menuframe, "Book found:\nBarcode: " + foundBook.getBarcode() +"\nName: " + foundBook.getName() +
                    		"\nEdition: " + foundBook.getEdition() +"\nPrice: " + foundBook.getPrice());
                    */
                    
                    txtbarcode.setText(foundBook.getBarcode());
                    txtbname.setText(foundBook.getName());
                    txtedition.setText(foundBook.getEdition());
                    txtprice.setText(String.valueOf(foundBook.getPrice()));
                    String genre = foundBook.getGenre();
                    if (genre.equals("Horror")) {
                        rdbtnhorror.setSelected(true);
                    } else if (genre.equals("Romance")) {
                        rdbtnromance.setSelected(true);
                    } else if (genre.equals("Mystery")) {
                        rdbtnmystery.setSelected(true);
                    } else if (genre.equals("Poetry")) {
                        rdbtnpoetry.setSelected(true);
                    }
                    
                } 
                else{
                     JOptionPane.showMessageDialog(menuframe, "Book not found.");
                }

                MySQLDeneme.searchBook(barcode);
            	
            }
        });
    

        btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSearch.setBounds(81, 77, 85, 40);
        searchpanel.add(btnSearch);
        
        
        JButton btnupdate = new JButton("Update");
        btnupdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                String barcode = txtbarcode.getText();
                Books foundBook = searchBookByBarcode(barcode);
                
                if (foundBook != null) {
                	
                    String updatedName = txtbname.getText();
                    String updatedEdition = txtedition.getText();
                    double updatedPrice = Double.parseDouble(txtprice.getText());

                    
                    String updatedGenre = "";
                    if (rdbtnhorror.isSelected()) {
                        updatedGenre = "Horror";
                    } else if (rdbtnromance.isSelected()) {
                        updatedGenre = "Romance";
                    } else if (rdbtnmystery.isSelected()) {
                        updatedGenre = "Mystery";
                    } else if (rdbtnpoetry.isSelected()) {
                        updatedGenre = "Poetry";
                    }
                    
                    //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA

                    foundBook.setName(updatedName);
                    foundBook.setEdition(updatedEdition);
                    foundBook.setPrice(updatedPrice);
                    foundBook.setGenre(updatedGenre);

                    
                    updateBookInTable(foundBook);
                    
                    JOptionPane.showMessageDialog(menuframe, "Book updated successfully.");


                }
                else {
                    JOptionPane.showMessageDialog(menuframe, "Book not found.");

                }
            }


        });
        
        
        btnupdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnupdate.setBounds(355, 206, 85, 40);
        panelbc.add(btnupdate);
        
        
        JButton btndelete = new JButton("Delete");
        btndelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                String barcode = txtsbarcode.getText();
                Books foundBook = searchBookByBarcode(barcode);
                
                if (foundBook != null) {
                    
                    books.remove(foundBook);
                    removeBookFromTable(foundBook);
                    
                    JOptionPane.showMessageDialog(menuframe, "Book deleted successfully.");
                    clear();
                } 
                else {
                    JOptionPane.showMessageDialog(menuframe, "Book not found.");
                }

                MySQLDeneme.deleteBook(barcode);
            }
        });
        
        
        btndelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btndelete.setBounds(605, 206, 85, 40);
        panelbc.add(btndelete);
        
        
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(345, 17, 360, 181);
        panelbc.add(scrollPane);
        
        table_1 = new JTable();
        table_1.setModel(new DefaultTableModel(
        	new Object[][] {},new String[] {"Barcode", "Book Name", "Edition", "Price", "Genre"}
        ) 
        {
        	Class[] columnTypes = new Class[] {String.class, String.class, String.class, Double.class, String.class};
        	public Class getColumnClass(int columnIndex) {
        		return columnTypes[columnIndex];
        	}
        });
        scrollPane.setViewportView(table_1);

        model = new DefaultTableModel();
        DefaultTableModel model= (DefaultTableModel)table_1.getModel();
        MySQLDeneme.loadBooks(model);
        
        
        //STOCKCARD--------------------------------------------------------------------------------------------------------------
        
        JPanel panelsc = new JPanel();
        tabbedPane.addTab("Stock Card", null, panelsc, null);
        panelsc.setLayout(null);
        
        JLabel lblStockCard = new JLabel("Stock Card:");
        lblStockCard.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblStockCard.setBounds(10, 6, 149, 40);
        panelsc.add(lblStockCard);
    
        menuframe.setVisible(true);

	}


    //METHOD---------------------------------------------------------------------------------------------------------------------
	
    private boolean isBarcodeUnique(String barcode) {
        if(!usedBarcodes.contains(barcode)){
            usedBarcodes.add(barcode);
            return true;
        }
        else
            return false;
    }
    
    private Books searchBookByBarcode(String barcode) {
        for (Books book : books) {
            if (book.getBarcode().equals(barcode)) {
                return book;
            }
        }
        return null;
    }
    
    private void clear() {
    	
    	//rdbtns are not clear AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
        txtbarcode.setText("");
        txtbname.setText("");
        txtedition.setText("");
        txtprice.setText("");
        
        /*
         
        String genre = "";
        if (genre.equals("Horror")) {
            rdbtnhorror.setSelected(false);
        } else if (genre.equals("Romance")) {
            rdbtnromance.setSelected(false);
        } else if (genre.equals("Mystery")) {
            rdbtnmystery.setSelected(false);
        } else if (genre.equals("Poetry")) {
            rdbtnpoetry.setSelected(false);
        }
        
       	
        rdbtnhorror.setSelected(false);
        rdbtnromance.setSelected(false);
        rdbtnmystery.setSelected(false);
        rdbtnpoetry.setSelected(false);
        
        AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
        */
    }
    
    private void removeBookFromTable(Books book) {
        for (int i = 0; i < table_1.getRowCount(); i++) {
            if (table_1.getValueAt(i, 0).equals(book.getBarcode())) {
                DefaultTableModel model = (DefaultTableModel) table_1.getModel();
                model.removeRow(i);
                break;
            }
        }
    }
    
    private void updateBookInTable(Books book) {
        for (int i = 0; i < table_1.getRowCount(); i++) {
            if (table_1.getValueAt(i, 0).equals(book.getBarcode())) {
                DefaultTableModel model = (DefaultTableModel) table_1.getModel();
                model.setValueAt(book.getName(), i, 1);
                model.setValueAt(book.getEdition(), i, 2);
                model.setValueAt(book.getPrice(), i, 3);
                model.setValueAt(book.getGenre(), i, 4);
                break;
            }
        }
    }
}
    
    




