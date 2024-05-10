package dnm2;

import database.MySQL;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.JRadioButton;


public class menu2 extends JFrame {
	
	private static final ArrayList<Books> books = new ArrayList<>();
	private static final ArrayList<String> usedBarcodes = new ArrayList<>();
	private final Queue<QuantityUpdate> quantityUpdates = new LinkedList<>();

	private static JTextField txtBName;
	private static JNumberTextField txtEdition;
	private static JNumberTextField txtPrice;
    private static JTextField txtGenre;
	private final JNumberTextField txtsBarcode;

	private JTextArea textArea;
	private DefaultTableModel model;
	private JTable table;
	private static JNumberTextField txtbarcode;

    private final JTable table_1;
	private static JNumberTextField txtBarcode;
	private static JNumberTextField txtQuantity;
	private final JTable table_2;

    public static JTextField getTxtBName() {
        return txtBName;
    }

    public static JTextField getTxtEdition() {
        return txtEdition;
    }

    public static JTextField getTxtPrice() {
        return txtPrice;
    }

    public static JTextField getTxtbarcode() {
        return txtbarcode;
    }

    public static JTextField getTxtGenre() {
        return txtGenre;
    }

    public static JTextField getTxtQuantity() {
        return txtQuantity;
    }

    public static JTextField getTxtBarcode() {
        return txtBarcode;
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


		
		JFrame menuFrame = new JFrame();
		menuFrame.setTitle("Book Management System");
        menuFrame.setBounds(100, 100, 1000, 700);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.getContentPane().setLayout(null);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 10, 980, 655);
        menuFrame.getContentPane().add(tabbedPane);
        
        //BOOK CARD---------------------------------------------------------------------------------------------------------------
        
        JPanel panelBC = new JPanel();
        tabbedPane.addTab("Book Card", null, panelBC, null);
        panelBC.setLayout(null);
        
        JLabel labelCard = new JLabel("Book Card:");
        labelCard.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelCard.setBounds(10, 6, 149, 40);
        panelBC.add(labelCard);
        
        JPanel panelInfo = new JPanel();
        panelInfo.setBorder(new TitledBorder(null, "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelInfo.setBounds(20, 56, 320, 200);
        panelBC.add(panelInfo);
        panelInfo.setLayout(null);
        
        JLabel labelPrice = new JLabel("Price:");
        labelPrice.setBounds(10, 113, 104, 19);
        panelInfo.add(labelPrice);
        labelPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        txtPrice = new JNumberTextField();
        txtPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtPrice.setBounds(124, 112, 180, 21);
        panelInfo.add(txtPrice);
        txtPrice.setColumns(10);

        JLabel labelBarcode = new JLabel("Barcode:");
        labelBarcode.setFont(new Font("Tahoma", Font.PLAIN, 15));
        labelBarcode.setBounds(10, 22, 104, 19);
        panelInfo.add(labelBarcode);
        
        txtbarcode = new JNumberTextField();
        txtbarcode.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtbarcode.setBounds(124, 21, 180, 21);
        panelInfo.add(txtbarcode);
        txtbarcode.setColumns(10);
        
        JLabel labelBName = new JLabel("Book Name:");
        labelBName.setBounds(10, 52, 82, 19);
        panelInfo.add(labelBName);
        labelBName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        txtBName = new JTextField(10);
        txtBName.setBounds(124, 51, 180, 21);
        panelInfo.add(txtBName);
        txtBName.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JLabel labelEdition = new JLabel("Edition:");
        labelEdition.setBounds(10, 84, 104, 19);
        panelInfo.add(labelEdition);
        labelEdition.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        txtEdition = new JNumberTextField();
        txtEdition.setBounds(124, 81, 180, 21);
        panelInfo.add(txtEdition);
        txtEdition.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtEdition.setColumns(10);

        JLabel lblgenre = new JLabel("Genre:");
        lblgenre.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblgenre.setBounds(10, 142, 104, 19);
        panelInfo.add(lblgenre);

        txtGenre = new JTextField(10);
        txtGenre.setBounds(124, 142, 180, 21);
        txtGenre.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panelInfo.add(txtGenre);



        
        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	
                String barcode = txtbarcode.getText();
                String bookName = txtBName.getText();
                String edition = txtEdition.getText();
                double price = Double.parseDouble(txtPrice.getText());
                String genre = txtGenre.getText();


                if (!isBarcodeUnique(barcode)) {
                	JOptionPane.showMessageDialog(null, "Barcode has been already used.");
                }
                else {
                Books book = new Books(barcode, bookName, edition, price, genre);
                books.add(book);
                JOptionPane.showMessageDialog(null, "Book saved successfully.");
                MySQL.addBook();
                
                model = new DefaultTableModel();
                DefaultTableModel model= (DefaultTableModel)table_1.getModel();
                table_1.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
                model.addRow(new Object[]{barcode, bookName, edition, price, genre});
                }
                
        	}
        });
        
        
        btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSave.setBounds(30, 270, 85, 37);
        panelBC.add(btnSave);


        textArea = new JTextArea();
        textArea.setEditable(false);
        
        
        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               clear();
            }
        });
        
        
        btnClear.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnClear.setBounds(245, 270, 85, 39);
        panelBC.add(btnClear);
        
        JPanel searchPanel = new JPanel();
        searchPanel.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        searchPanel.setBounds(45, 350, 266, 127);
        panelBC.add(searchPanel);
        searchPanel.setLayout(null);
        
        JLabel labelsBarcode = new JLabel("Book's barcode:");
        labelsBarcode.setFont(new Font("Tahoma", Font.PLAIN, 15));
        labelsBarcode.setBounds(10, 35, 130, 19);
        searchPanel.add(labelsBarcode);
        
        txtsBarcode = new JNumberTextField();
        txtsBarcode.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtsBarcode.setColumns(10);
        txtsBarcode.setBounds(131, 34, 125, 21);
        searchPanel.add(txtsBarcode);
        
        
        JButton btnSearch = new JButton("Search");
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                String barcode = txtsBarcode.getText();
                Books foundBook = searchBookByBarcode(barcode);
                
                if (foundBook != null) {

                    MySQL.searchBook(barcode);

                } 
                else{
                     JOptionPane.showMessageDialog(menuFrame, "Book not found.");
                     MySQL.searchBook(barcode);
                }
            	
            }
        });
    

        btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSearch.setBounds(81, 77, 85, 40);
        searchPanel.add(btnSearch);
        
        
        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                String barcode = txtbarcode.getText();
                Books foundBook = searchBookByBarcode(barcode);
                
                if (foundBook != null) {
                	
                    String updatedName = txtBName.getText();
                    String updatedEdition = txtEdition.getText();
                    double updatedPrice = Double.parseDouble(txtPrice.getText());
                    String updatedGenre = txtGenre.getText();

                    

                    foundBook.setName(updatedName);
                    foundBook.setEdition(updatedEdition);
                    foundBook.setPrice(updatedPrice);
                    foundBook.setGenre(updatedGenre);

                    
                    updateBookInTable1(foundBook);

                    MySQL.updateBook(barcode);
                    
                    JOptionPane.showMessageDialog(menuFrame, "Book updated successfully.");
                } 
                else {
                    JOptionPane.showMessageDialog(menuFrame, "Book not found.");
                    MySQL.updateBook(barcode);
                }	
            }
        });
        
        
        btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnUpdate.setBounds(30, 520, 85, 40);
        panelBC.add(btnUpdate);
        
        
        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                String barcode = txtsBarcode.getText();
                Books foundBook = searchBookByBarcode(barcode);
                
                if (foundBook != null) {
                    
                    books.remove(foundBook);
                    removeBookFromTable(foundBook);
                    
                    JOptionPane.showMessageDialog(menuFrame, "Book deleted successfully.");
                    MySQL.deleteBook(barcode);
                    clear();


                }
                else {
                    JOptionPane.showMessageDialog(menuFrame, "Book not found.");
                    MySQL.deleteBook(barcode);
                }
            }
        });
        
        
        btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnDelete.setBounds(245, 520, 85, 40);
        panelBC.add(btnDelete);
        
        
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(345, 17, 610, 575);
        panelBC.add(scrollPane);
        
        table_1 = new JTable();
        table_1.setModel(new DefaultTableModel(
        	new Object[][] {},new String[] {"Barcode", "Book Name", "Edition", "Price", "Genre"}

        )
        {
        	final Class[] columnTypes = new Class[] {String.class, String.class, String.class, Double.class, String.class};
        	public Class getColumnClass(int columnIndex) {
        		return columnTypes[columnIndex];
        	}
        });
        table_1.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
        table_1.setDefaultRenderer(Double.class, new CustomTableCellRenderer());

        table_1.getColumnModel().getColumn(0).setMaxWidth(50);
        table_1.getColumnModel().getColumn(1).setMinWidth(250);
        table_1.getColumnModel().getColumn(2).setMaxWidth(50);
        table_1.getColumnModel().getColumn(3).setMaxWidth(50);


        scrollPane.setViewportView(table_1);

        model = new DefaultTableModel();
        DefaultTableModel model= (DefaultTableModel)table_1.getModel();
        MySQL.loadBooks(model, books);


        //IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
        //STOCK CARD--------------------------------------------------------------------------------------------------------------
        
        JPanel panelSC = new JPanel();
        tabbedPane.addTab("Stock Card", null, panelSC, null);
        panelSC.setLayout(null);
        
        JLabel lblStockCard = new JLabel("Stock Card:");
        lblStockCard.setBounds(10, 6, 149, 40);
        lblStockCard.setFont(new Font("Tahoma", Font.BOLD, 20));
        panelSC.add(lblStockCard);
        
        JPanel panel = new JPanel();
        panel.setBounds(10, 56, 939, 81);
        panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Enter Stock", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panelSC.add(panel);
        panel.setLayout(null);
        
        JLabel lblBarcode = new JLabel("Barcode:");
        lblBarcode.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblBarcode.setBounds(25, 32, 95, 19);
        panel.add(lblBarcode);
        
        JLabel lblQuantity = new JLabel("Quantity:");
        lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblQuantity.setBounds(236, 32, 95, 19);
        panel.add(lblQuantity);
        
        JRadioButton rdBtnIn = new JRadioButton("In");
        rdBtnIn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        rdBtnIn.setBounds(450, 33, 53, 19);
        panel.add(rdBtnIn);
        
        JRadioButton rdBtnOut = new JRadioButton("Out");
        rdBtnOut.setFont(new Font("Tahoma", Font.PLAIN, 15));
        rdBtnOut.setBounds(525, 33, 70, 21);
        panel.add(rdBtnOut);
        
        txtBarcode = new JNumberTextField();
        txtBarcode.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtBarcode.setColumns(10);
        txtBarcode.setBounds(107, 31, 104, 21);
        panel.add(txtBarcode);
        
        txtQuantity = new JNumberTextField();
        txtQuantity.setBounds(319, 33, 104, 21);
        panel.add(txtQuantity);
        txtQuantity.setColumns(10);
        
        
        ButtonGroup stateGroup = new ButtonGroup();
        stateGroup.add(rdBtnIn);
        stateGroup.add(rdBtnOut);

        
        JButton btnEnter = new JButton("Enter");
        btnEnter.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
                String barcode = txtBarcode.getText();
                int quantity = Integer.parseInt(txtQuantity.getText());
                double price = searchBookByBarcode(barcode).getPrice();
                int state = rdBtnIn.isSelected() ? 1 : -1;
                int balance = quantity * state;
                
                Books foundBook = searchBookByBarcode(barcode);
                
                quantityUpdates.offer(new QuantityUpdate(barcode, quantity, state, price, balance));
                updateQuantityTotals();

                MySQL.updateQuantity(barcode,quantity);
                
                DefaultTableModel model = (DefaultTableModel) table_2.getModel();
                model.addRow(new Object[]{barcode, state == 1 ? quantity : "", state == 1 ? price : "", state == -1 ? quantity : "", state == -1 ? price : "", balance, balance*price});
                table_2.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
                if (foundBook != null) {
                    foundBook.setBalance(foundBook.getQuantity() + (quantity * state));
                    updateBookInTable2(foundBook);
                    JOptionPane.showMessageDialog(menuFrame, "Book Stock updated successfully.");
                } else {
                    JOptionPane.showMessageDialog(menuFrame, "Book not found.");
                }
        	}
        	
        });
		
        
        btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnEnter.setBounds(610, 21, 85, 40);
        panel.add(btnEnter);
        
        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(10, 159, 939, 435);
        panelSC.add(scrollPane_2);
        
        table_2 = new JTable();
        scrollPane_2.setViewportView(table_2);
        table_2.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"Barcode", "In Quantity", "In Value", "Out Quantity", "Out Value", "Balance Quantity", "Balance Value"
        	}
        ) {
        	final boolean[] columnEditable = new boolean[] {
        		false, true, true, true, true, true, true
        	};
        	public boolean isCellEditable(int row, int column) {
        		return columnEditable[column];
        	}
        	
        	
        });
        
        
        
    
        menuFrame.setVisible(true);

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
    	
        txtbarcode.setText("");
        txtBName.setText("");
        txtEdition.setText("");
        txtPrice.setText("");
        txtGenre.setText("");
        
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
    
    private void updateBookInTable1(Books book) {
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
    
    private void updateBookInTable2(Books book) {
    	
    	for (int i =0; i < table_2.getRowCount(); i++) {
            if (table_2.getValueAt(i, 0).equals(book.getBarcode())) {
                DefaultTableModel model = (DefaultTableModel) table_2.getModel();
                model.setValueAt(book.getQuantity(), i, 1);
                model.setValueAt(book.getState() == 1 ? book.getQuantity() * book.getPrice() : "", i, 2);
                model.setValueAt(book.getState() == -1 ? book.getQuantity() : "", i, 3);
                model.setValueAt(book.getState() == -1 ? book.getQuantity() * book.getPrice() * -1 : "", i, 4);
                model.setValueAt(book.calculateBalanceQuantity(), i, 5);
                model.setValueAt(book.calculateBalanceValue(), i, 6);
                break;
            }
        }
    }
    
    
    private void updateQuantityTotals() {
        Map<String, Integer> quantityMap = new HashMap<>();
        
        for (QuantityUpdate update : quantityUpdates) {
            String barcode = update.getBarcode();
            int quantity = update.getQuantity();
            int state = update.getState();
            double price = update.getPrice();
            int balance = update.getBalance();
            balance=state * quantity;
            quantityMap.put(barcode, quantityMap.getOrDefault(barcode, 0) + (balance));
            
        }

        DefaultTableModel model = (DefaultTableModel) table_2.getModel();
        
        
        for (Map.Entry<String, Integer> entry : quantityMap.entrySet()) {
        	Books book = searchBookByBarcode(entry.getKey());
            double price = book != null ? book.getPrice() : 0.0;
            model.addRow(new Object[]{entry.getKey(),"","","","" ,entry.getValue(),entry.getValue()*price});
            
        }

        
    }
    
    
    
    
}



