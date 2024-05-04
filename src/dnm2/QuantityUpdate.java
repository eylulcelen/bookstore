package dnm2;

public class QuantityUpdate {
	private String barcode;
    private int quantity;
    private int state;
    private double price;
    
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public QuantityUpdate(String barcode, int quantity, int state, double price) {
		super();
		this.barcode = barcode;
		this.quantity = quantity;
		this.state = state;
		this.price = price;
	}
        
}

