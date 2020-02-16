public class Purchase {
	private int purchase_id;
	private int purchase_quantity;
	private int total_bill;
	private int cust_id_purchase;
	private int candy_id_purchase;

	public Purchase(int id, int quantity, int bill,int cust_id, int candy_id) {
		this.purchase_id = id;
		this.purchase_quantity = quantity;
		this.total_bill = bill;
		this.cust_id_purchase = cust_id;
		this.candy_id_purchase = candy_id;
	}
	
	public int getPurchase_id() {
		return purchase_id;
	}
	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}
	public int getPurchase_quantity() {
		return purchase_quantity;
	}
	public void setPurchase_quantity(int purchase_quantity) {
		this.purchase_quantity = purchase_quantity;
	}
	public int getTotal_bill() {
		return total_bill;
	}
	public void setTotal_bill(int total_bill) {
		this.total_bill = total_bill;
	}
	public int getCust_id_purchase() {
		return cust_id_purchase;
	}
	public void setCust_id_purchase(int cust_id_purchase) {
		this.cust_id_purchase = cust_id_purchase;
	}
	public int getCandy_id_purchase() {
		return candy_id_purchase;
	}
	public void setCandy_id_purchase(int candy_id_purchase) {
		this.candy_id_purchase = candy_id_purchase;
	}
}