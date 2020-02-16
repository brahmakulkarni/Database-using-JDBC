import java.util.*;
import java.sql.*;

public class DB_Helper {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/candy";

    static final String USER = "root";
    static final String PASS = "";

    static Connection conn = null;
    static Statement stmt = null;
    // static ResultSet rs; 

    public void initialize() {
        
        try{
            //STEP 2b: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }

    public int checkIfSellerExists(int id) {
        try {
            String sql;
            sql = "select seller_id from Seller where seller_id = " + String.valueOf(id);
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next() == false) {
                return 0;
            }
            return 1;
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            return 2;
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return 2;
        }
    }

    public int checkIfCustomerExists(int id) {
        try {
            String sql;
            sql = "select cust_id from Customer where cust_id = " + String.valueOf(id);
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next() == false) {
                return 0;
            }
            return 1;
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            return 2;
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return 2;
        }
    }

    public int checkIfCandyExists(int id) {
        try {
            String sql;
            sql = "select candy_id from Candy where candy_id = " + String.valueOf(id);
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next() == false) {
                return 0;
            }
            return 1;
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            return 2;
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return 2;
        }
    }

    public void addSeller(int id, String name, String address, String email, int mobile) {
        Seller s = new Seller(id,name,address,email,mobile);

        try {
            String sql;
            sql = "insert into Seller values ('" + String.valueOf( s.getSeller_id()) + "','" + s.getSeller_name() + "','" + s.getSeller_addr() + "','" + s.getSeller_email() + "','" + String.valueOf(s.getSeller_mobile()) +"')";
            stmt.executeUpdate(sql);
            System.out.println("Seller added.");
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }

    public void addCustomer(int id, String name, String address, String email, int mobile) {
        Customer c = new Customer(id,name,address,email,mobile);

        try {
            String sql;
            sql = "insert into Customer values ('" + String.valueOf(c.getCust_id()) + "','" + c.getCust_name() + "','" + c.getCust_addr() + "','" + c.getCust_email() + "','" + String.valueOf(c.getCust_mobile()) +"')";
            stmt.executeUpdate(sql);
            System.out.println("Customer added.");
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }

    public void addCandy(int id, String name, String type, int quantity, int egg, int price, int weight) {
        Candy candy = new Candy(id,name,type,quantity,egg,price,weight);

        try {
            String sql;
            sql = "insert into Candy values ('" + String.valueOf(candy.getCandy_id()) + "','" + candy.getName() + "','" + candy.getCandy_type() + "','" + String.valueOf(candy.getStock()) + "','" + String.valueOf(candy.getContains_egg()) +"','" + String.valueOf(candy.getPrice()) + "','" + String.valueOf(candy.getWeight()) + "')";
            stmt.executeUpdate(sql);
            System.out.println("Candy added.");
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }

    public void updateCandy(int id, int quantity) {
        try {
            String sql1,sql2;
            sql1 = "select candy_stock from Candy where candy_id = " + String.valueOf(id);
            ResultSet rs1 = stmt.executeQuery(sql1);
            int stock = 0;
            while (rs1.next()) {
                stock = rs1.getInt("candy_stock");
            }
            stock += quantity;
            sql2 = "update Candy set candy_stock = " + String.valueOf(stock) + " where candy_id = " + String.valueOf(id);
            stmt.executeUpdate(sql2);
            System.out.println("Candy updated.");
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }

    public int isSellerInCandySeller(int id) {
        try {
            String sql = "select seller_id_fk from Candy_Seller where seller_id_fk = " + String.valueOf(id);
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next() == false) {
                return 0;
            }
            return 1;
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            return 2;
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return 2;
        }
    }

    public void addCandySeller(int id, int quantity, int seller_id, int candy_id) {
        Candy_Seller cs = new Candy_Seller(id,quantity,0,seller_id,candy_id);

        try {
            String sql;
            sql = "insert into Candy_Seller values ('" + String.valueOf(cs.getId()) + "','" + String.valueOf(cs.getAdd_quantity()) + "','" + String.valueOf(cs.getCandy_status()) + "','" + String.valueOf(cs.getSeller_id_fk()) + "','" + String.valueOf(cs.getCandy_id_fk()) + "')";
            stmt.executeUpdate(sql);
            System.out.println("CandySeller link added.");
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }

    public void updateCandySeller(int quantity, int seller_id, int candy_id) {
        try {
            String sql1,sql2;
            sql1 = "select id,add_quantity from Candy_Seller where seller_id_fk = " + String.valueOf(seller_id) + " and candy_id_fk = " + String.valueOf(candy_id);
            ResultSet rs = stmt.executeQuery(sql1);
            int candy_seller_id = 0, curr_quantity = 0;
            while (rs.next()) {
                candy_seller_id = rs.getInt("id");
                curr_quantity = rs.getInt("add_quantity");
            }
            sql2 = "update Candy_Seller set add_quantity = " + String.valueOf(curr_quantity+quantity) + " where id = " + String.valueOf(candy_seller_id);
            stmt.executeUpdate(sql2);
            System.out.println("CandySeller updated.");
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }

    public int browse() {
        try {
            String sql;
            sql = "select * from Candy,Candy_Seller where candy_id = candy_id_fk and candy_status = 1";
            ResultSet rs = stmt.executeQuery(sql);
            int id, stock, egg, price, weight;
            String name, type;
            boolean condition = rs.next();
            while (condition) {
                id = rs.getInt("candy_id");
                name = rs.getString("candy_name");
                type = rs.getString("candy_type");
                stock = rs.getInt("candy_stock");
                egg = rs.getInt("contains_egg");
                price = rs.getInt("candy_price");
                weight = rs.getInt("candy_weight");
                System.out.println("ID: " + String.valueOf(id) + "; Name: " + name + "; Type: " + type + "; Stock: " + String.valueOf(stock) + "; Contains egg: " + String.valueOf(egg) + "; Price: " + String.valueOf(price) + "; Weight: " + String.valueOf(weight)); 
                condition = rs.next();
            }
            if (condition == false) {
                System.out.println("There are no available candy at the moment.");
                return 0;
            }
            return 1;
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            return -1;
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return -1;
        }
    }

    public int browse_admin() {
        try {
            String sql;
            sql = "select * from Candy,Candy_Seller where candy_id = candy_id_fk and candy_status = 0";
            ResultSet rs = stmt.executeQuery(sql);
            int id, stock, egg, price, weight;
            String name, type;
            boolean condition = rs.next();
            if (condition == true) {
                while (condition) {
                    id = rs.getInt("candy_id");
                    name = rs.getString("candy_name");
                    type = rs.getString("candy_type");
                    stock = rs.getInt("candy_stock");
                    egg = rs.getInt("contains_egg");
                    price = rs.getInt("candy_price");
                    weight = rs.getInt("candy_weight");
                    System.out.println("ID: " + String.valueOf(id) + "; Name: " + name + "; Type: " + type + "; Stock: " + String.valueOf(stock) + "; Contains egg: " + String.valueOf(egg) + "; Price: " + String.valueOf(price) + "; Weight: " + String.valueOf(weight)); 
                    condition = rs.next();
                }
            }
            else {
                System.out.println("There are no unauthorized candy at the moment.");
                return 0;
            }
            return 1;
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            return -1;
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return -1;
        }
    }

    public int isAuthenticated(int id) {
        try {
            String sql;
            sql = "select candy_status from Candy,Candy_Seller where candy_id = candy_id_fk and candy_id = " + String.valueOf(id);
            ResultSet rs = stmt.executeQuery(sql);
            int status = 0;
            while (rs.next()) {
                status = rs.getInt("candy_status");
                if (status == 0) {
                    return 0;
                }
            }
            return 1;
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            return 2;
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return 2;
        }
        // return id;
    }

    public void authenticateCandy(int id) {
        try {
            String sql;
            sql = "update Candy_Seller set candy_status = " + String.valueOf(1) + " where candy_id_fk = " + String.valueOf(id);
            stmt.executeUpdate(sql);
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }

    public int getCandyStock(int id) {
        try {
            String sql1;
            sql1 = "select candy_stock from Candy where candy_id = " + String.valueOf(id);
            ResultSet rs = stmt.executeQuery(sql1);
            int stock = 0;
            while (rs.next()) {
                stock = rs.getInt("candy_stock");
            }
            return stock;
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            return -1;
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return -1;
        }
    }

    public void buyCandy(int id, int stock, int quantity) {
        try {
            String sql;
            stock -= quantity;
            sql = "update Candy set candy_stock = " + String.valueOf(stock) + " where candy_id = " + String.valueOf(id);
            stmt.executeUpdate(sql);
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }

    public void addPurchase(int id, int quantity, int cust_id, int candy_id) {
        Purchase p = new Purchase(id, quantity, 0, cust_id, candy_id);

        try {
            String sql1;
            sql1 = "select candy_price from Candy where candy_id = " + String.valueOf(candy_id);
            ResultSet rs = stmt.executeQuery(sql1);
            int price = 0;
            while (rs.next()) {
                price = rs.getInt("candy_price");
            }
            int bill = price*quantity;
            p.setTotal_bill(bill); 
            String sql2;
            sql2 = "insert into Purchase values ('" + String.valueOf(p.getPurchase_id()) + "','" + String.valueOf(p.getPurchase_quantity()) + "','" + String.valueOf(p.getTotal_bill()) + "','" + String.valueOf(p.getCust_id_purchase()) + "','" + String.valueOf(p.getCandy_id_purchase()) + "')";
            stmt.executeUpdate(sql2);
            System.out.println("Purchase details added.");
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }

    public void terminate(){
        try{
            if(stmt!=null)
                stmt.close();
        }catch(SQLException se2){
        }// out of our hands
        try{
            if(conn!=null)
                conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }//end finally try
    }
}