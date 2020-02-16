public class Customer {
	private int cust_id;
	private String cust_name;
	private String cust_addr;
	private String cust_email;
	private int cust_mobile;

	public Customer(int id, String name, String address, String email, int mobile) {
		this.cust_id = id;
		this.cust_name = name;
		this.cust_addr = address;
		this.cust_email =email;
		this.cust_mobile = mobile;
	}
	
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getCust_addr() {
		return cust_addr;
	}
	public void setCust_addr(String cust_addr) {
		this.cust_addr = cust_addr;
	}
	public String getCust_email() {
		return cust_email;
	}
	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}
	public int getCust_mobile() {
		return cust_mobile;
	}
	public void setCust_mobile(int cust_mobile) {
		this.cust_mobile = cust_mobile;
	}
}