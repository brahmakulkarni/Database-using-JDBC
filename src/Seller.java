public class Seller {
	private int seller_id;
	private String seller_name;
	private String seller_addr;
	private String seller_email;
	private int seller_mobile;

	public Seller(int id, String name, String address, String email, int mobile) {
		this.seller_id = id;
		this.seller_name = name;
		this.seller_addr = address;
		this.seller_email =email;
		this.seller_mobile = mobile;
	}
	
	public int getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}
	public String getSeller_name() {
		return seller_name;
	}
	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}
	public String getSeller_addr() {
		return seller_addr;
	}
	public void setSeller_addr(String seller_addr) {
		this.seller_addr = seller_addr;
	}
	public String getSeller_email() {
		return seller_email;
	}
	public void setSeller_email(String seller_email) {
		this.seller_email = seller_email;
	}
	public int getSeller_mobile() {
		return seller_mobile;
	}
	public void setSeller_mobile(int seller_mobile) {
		this.seller_mobile = seller_mobile;
	}
}
