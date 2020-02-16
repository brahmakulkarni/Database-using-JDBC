import java.util.Set;

public class Candy {
	private int candy_id;
	private String candy_name;
	// private String manufacturer_name;
	private String candy_type;
	private int candy_stock;
	private int contains_egg;
	private int candy_price;
	private int candy_weight;

	public Candy(int id, String name, String type, int stock, int egg, int price, int weight) {
		this.candy_id = id;
		this.candy_name = name;
		this.candy_type = type;
		this.candy_stock = stock;
		this.contains_egg = egg;
		this.candy_price = price;
		this.candy_weight = weight;
	}
	
	// private Set customers;
	
	public int getCandy_id() {
		return candy_id;
	}
	public void setCandy_id(int s_num) {
		this.candy_id = s_num;
	}
	public String getName() {
		return candy_name;
	}
	public void setName(String name) {
		this.candy_name = name;
	}
	public String getCandy_type() {
		return candy_type;
	}
	public void setCandy_type(String candy_type) {
		this.candy_type = candy_type;
	}
	public int getStock() {
		return candy_stock;
	}
	public void setStock(int stock) {
		this.candy_stock = stock;
	}
	public int getContains_egg() {
		return contains_egg;
	}
	public void setContains_egg(int contains_egg) {
		this.contains_egg = contains_egg;
	}
	public int getPrice() {
		return candy_price;
	}
	public void setPrice(int price) {
		this.candy_price = price;
	}
	public int getWeight() {
		return candy_weight;
	}
	public void setWeight(int weight) {
		this.candy_weight = weight;
	}
}
