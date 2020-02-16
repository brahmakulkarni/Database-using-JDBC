public class Candy_Seller {
	private int id;
	private int add_quantity;
	private int candy_status;
	private int seller_id_fk;
	private int candy_id_fk;
	
	public Candy_Seller(int id, int quantity, int status) {
		this.id = id;
		this.add_quantity = quantity;
		this.candy_status = status;
	}

	public Candy_Seller(int id, int quantity, int status, int seller_id, int candy_id) {
		this.id = id;
		this.add_quantity = quantity;
		this.candy_status = status;
		this.seller_id_fk = seller_id;
		this.candy_id_fk = candy_id;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAdd_quantity() {
		return add_quantity;
	}
	public void setAdd_quantity(int add_quantity) {
		this.add_quantity = add_quantity;
	}
	public int getCandy_status() {
		return candy_status;
	}
	public void setCandy_status(int candy_status) {
		this.candy_status = candy_status;
	}
	public int getSeller_id_fk() {
		return seller_id_fk;
	}
	public void setSeller_id_fk(int seller_id_fk) {
		this.seller_id_fk = seller_id_fk;
	}
	public int getCandy_id_fk() {
		return candy_id_fk;
	}
	public void setCandy_id_fk(int candy_id_fk) {
		this.candy_id_fk = candy_id_fk;
	}
}