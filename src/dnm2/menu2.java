package dnm2;
import database.MySQLDeneme;


import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;


public class menu2 extends JFrame {
	
	private static ArrayList<Books> books = new ArrayList<>();
	private static ArrayList<String> usedBarcodes = new ArrayList<>();
	

	private JTextField txtbname;
	private JTextField txtedition;
	private JTextField txtprice;
	private JTextField txtsbarcode;
	private JTextArea textArea;
	private DefaultTableModel model;
	private JTable table;
	private JTextField txtbarcode;
	private JTable table_1;


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
        menuframe.setBounds(100, 100, 560, 400);
        menuframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuframe.getContentPane().setLayout(null);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 10, 526, 343);
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
        panelinfo.setBounds(10, 56, 219, 142);
        panelbc.add(panelinfo);
        panelinfo.setLayout(null);
        
        JLabel lblprice = new JLabel("Price:");
        lblprice.setBounds(10, 113, 104, 19);
        panelinfo.add(lblprice);
        lblprice.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        txtprice = new JTextField();
        txtprice.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtprice.setBounds(102, 112, 104, 21);
        panelinfo.add(txtprice);
        txtprice.setColumns(10);
        
        JLabel lblbarcode = new JLabel("Barcode:");
        lblbarcode.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblbarcode.setBounds(10, 22, 104, 19);
        panelinfo.add(lblbarcode);
        
        txtbarcode = new JTextField();
        txtbarcode.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtbarcode.setColumns(10);
        txtbarcode.setBounds(102, 21, 104, 21);
        panelinfo.add(txtbarcode);
        
        JLabel lblbname = new JLabel("Book Name:");
        lblbname.setBounds(10, 52, 82, 19);
        panelinfo.add(lblbname);
        lblbname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        txtbname = new JTextField();
        txtbname.setBounds(102, 51, 104, 21);
        panelinfo.add(txtbname);
        txtbname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtbname.setColumns(10);
        
        JLabel lbledition = new JLabel("Edition:");
        lbledition.setBounds(10, 84, 104, 19);
        panelinfo.add(lbledition);
        lbledition.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        txtedition = new JTextField();
        txtedition.setBounds(102, 82, 104, 21);
        panelinfo.add(txtedition);
        txtedition.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtedition.setColumns(10);
        
        JButton btnsave = new JButton("Save");
        btnsave.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	
                String barcode = txtbarcode.getText();
                String bookName = txtbname.getText();
                String edition = txtedition.getText();
                double price = Double.parseDouble(txtprice.getText());
                
                
                if (!isBarcodeUnique(barcode)) {
                	JOptionPane.showMessageDialog(null, "Barcode has been already used.");
                }
                else {
                Books book = new Books(barcode, bookName, edition, price);
                books.add(book);
                JOptionPane.showMessageDialog(null, "Book saved successfully.");
                
                model = new DefaultTableModel();
                DefaultTableModel model= (DefaultTableModel)table_1.getModel();
                model.addRow(new Object[] {txtbarcode.getText(),txtbname.getText(),txtedition.getText(),Double.parseDouble(txtprice.getText())});
                }

                MySQLDeneme.addBook(Integer.parseInt(barcode), bookName, Integer.parseInt(edition), price);
                
        	}
        });
        
        
        btnsave.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnsave.setBounds(20, 208, 85, 37);
        panelbc.add(btnsave);
        
        
        textArea = new JTextArea();
        textArea.setEditable(false);
        
        
        JButton btnclear = new JButton("Clear");
        btnclear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearRegistrationFields();
            }
        });
        
        
        btnclear.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnclear.setBounds(132, 206, 85, 39);
        panelbc.add(btnclear);
        
        JPanel searchpanel = new JPanel();
        searchpanel.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        searchpanel.setBounds(51, 257, 400, 56);
        panelbc.add(searchpanel);
        searchpanel.setLayout(null);
        
        JLabel lblsbarcode = new JLabel("Book's barcode:");
        lblsbarcode.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblsbarcode.setBounds(10, 27, 130, 19);
        searchpanel.add(lblsbarcode);
        
        txtsbarcode = new JTextField();
        txtsbarcode.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtsbarcode.setColumns(10);
        txtsbarcode.setBounds(123, 26, 125, 21);
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
                } 
                else{
                     JOptionPane.showMessageDialog(menuframe, "Book not found.");
                }
            	
            }
        });
    

        btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSearch.setBounds(291, 10, 85, 40);
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
                    
                    foundBook.setName(updatedName);
                    foundBook.setEdition(updatedEdition);
                    foundBook.setPrice(updatedPrice);
                    
                    updateBookInTable(foundBook);
                    
                    JOptionPane.showMessageDialog(menuframe, "Book updated successfully.");
                } 
                else {
                    JOptionPane.showMessageDialog(menuframe, "Book not found.");
                }



            }
        });
        
        
        btnupdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnupdate.setBounds(268, 206, 85, 40);
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
                    clearRegistrationFields();
                } 
                else {
                    JOptionPane.showMessageDialog(menuframe, "Book not found.");
                }
            }
        });
        
        
        btndelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btndelete.setBounds(386, 206, 85, 40);
        panelbc.add(btndelete);
        
        
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(239, 17, 272, 181);
        panelbc.add(scrollPane);
        
        table_1 = new JTable();
        table_1.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"Barcode", "Book Name", "Edition", "Price"
        	}
        ) {
        	Class[] columnTypes = new Class[] {
        		String.class, String.class, String.class, Double.class
        	};
        	public Class getColumnClass(int columnIndex) {
        		return columnTypes[columnIndex];
        	}
        });
        scrollPane.setViewportView(table_1);
        
        
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
    
    private void clearRegistrationFields() {
        txtbarcode.setText("");
        txtbname.setText("");
        txtedition.setText("");
        txtprice.setText("");
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
                break;
            }
        }
    }
}
    
    




