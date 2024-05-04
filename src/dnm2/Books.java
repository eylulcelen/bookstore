package dnm2;

public class Books {
	
	private String name;
	private String edition;
	private double price;
	private String barcode;
	private String genre;
<<<<<<< HEAD
	private int quantity;
	private int state; 
	//in out=state
=======
>>>>>>> 0c9681eddda56293c14e93d02e5a1682cf62b0f0
	
	
	public double calculateBalancePrice() {
	    return quantity * state;
	}

	public int calculateBalanceQuantity() {
	    return quantity;
	}

	public double calculateBalanceValue() {
	    return calculateBalanceQuantity() * price;
	}
	
<<<<<<< HEAD
    public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Books(String barcode, String name, String edition, double price, String genre) {
=======
    public Books(String barcode, String name, String edition, double price, String genre) {
>>>>>>> 0c9681eddda56293c14e93d02e5a1682cf62b0f0
        
        this.barcode = barcode;
        this.name = name;
        this.edition = edition;
        this.price = price;
        this.genre = genre;
    }
    
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
