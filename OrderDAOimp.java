package eStoreProduct.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import eStoreProduct.model.Orders;
import eStoreProduct.model.Product;

public class OrderDAOimp implements OrderDAO {

	
	private static final String JDBC_DRIVER = "org.postgresql.Driver";
	private static final String DB_URL = "jdbc:postgresql://192.168.110.48:5432/plf_training";
	private static final String USERNAME = "plf_training_admin";
	private static final String PASSWORD = "pff123";
	public List<Orders> getorderProds() {
		// TODO Auto-generated method stub
		
		ArrayList<Orders> order_pro = new ArrayList<Orders>();
		
		try {
			Class.forName(JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			//System.out.println(cust_id + " from model");
			String query = "SELECT sp.prod_id,sp.prod_title,sp.prod_brand,sp.image_url,sp.prod_desc,sps.prod_price,o.ordr_id FROM slam_orders_dup o JOIN slam_OrderProducts op ON o.Ordr_id = op.Ordr_id JOIN slam_products sp ON op.prod_id = sp.prod_id JOIN slam_productstock sps ON sp.prod_id = sps.prod_id WHERE o.ordr_cust_id = ?;\r\n"
					+ "";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, 1);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("prod_id");
				String name = resultSet.getString("prod_title");
				double price = resultSet.getDouble("prod_price");
				String description = resultSet.getString("prod_desc");
				String imageUrl = resultSet.getString("image_url");
				int ordid=resultSet.getInt("ordr_id");
				Orders product = new Orders(id, name, price, description, imageUrl,ordid);
				order_pro.add(product);
			}
			//System.out.println(products.toString());
			resultSet.close();
			statement.close();
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return order_pro;
	}
	
		
	}


