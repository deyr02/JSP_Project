import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbAccess {
	private Connection JDBCconnection;
	String path ="";
	
	public DbAccess(String DbUrl){
		this.path = DbUrl;
	}
	protected void Connect() throws SQLException{
		if(JDBCconnection == null || JDBCconnection.isClosed()){
			try{
			
				Class.forName("org.sqlite.JDBC");
				JDBCconnection = DriverManager.getConnection("jdbc:sqlite:"+path);
			}
			catch (ClassNotFoundException e){
				throw new SQLException(e);
			}
			
			
		}
	}
	
	protected void DisConnect() throws SQLException{
		if(JDBCconnection != null && !JDBCconnection.isClosed()){
			JDBCconnection.close();
		}
	}
	
	public boolean insertProduct(Product product) throws SQLException{
		String Query = "Insert into Product(Prd_ID, Prd_Name, Prd_Price, Prd_Stock, Prd_Comments) VALUES(?,?,?,?,?)";
		Connect();
		PreparedStatement statement = JDBCconnection.prepareStatement(Query);
		statement.setInt(1, product.getID());
		statement.setString(2, product.getName());
		statement.setDouble(3, product.getPrice());
		statement.setInt(4, product.getStock());
		statement.setString(5, product.getComments());
		
		
		boolean insertedRow = statement.executeUpdate()>0;
		statement.close();
		DisConnect();
		return insertedRow;
	}
	public boolean insertAttendant(Attendant product) throws SQLException{
		String Query = "Insert into Attendant(Att_ID, Att_Name, Att_Address, Att_MobileNum, Att_Comments) VALUES(?,?,?,?,?)";
		Connect();
		PreparedStatement statement = JDBCconnection.prepareStatement(Query);
		statement.setInt(1, product.getID());
		statement.setString(2, product.getName());
		statement.setString(3, product.getAddress());
		statement.setString(4, product.getNum());
		statement.setString(5, product.getComments());
		
		
		boolean insertedRow = statement.executeUpdate()>0;
		statement.close();
		DisConnect();
		return insertedRow;
	}
	
	public List<Product> AllProduct() throws SQLException{
		List<Product> listProduct = new ArrayList<>();
		
		String Query = "Select * From PRODUCT;";
		Connect();
		Statement statement = JDBCconnection.createStatement();
		ResultSet resultSet = statement.executeQuery(Query);
		
		while (resultSet.next()){
			int id = resultSet.getInt("Prd_ID");
			String name = resultSet.getString("Prd_Name");
			Double price = resultSet.getDouble("Prd_Price");
			int stock = resultSet.getInt("Prd_Stock");
			String comment = resultSet.getString("Prd_Comments");
			
			Product product = new Product(id, name, price, stock, comment);
			listProduct.add(product);
		}
		resultSet.close();
		statement.close();
		DisConnect();
		return listProduct;
		
	}
	public List<Attendant> AllAttendant() throws SQLException{
		List<Attendant> listAttendant = new ArrayList<>();
		
		String Query = "Select * From ATTENDANT;";
		Connect();
		Statement statement = JDBCconnection.createStatement();
		ResultSet resultSet = statement.executeQuery(Query);
		
		while (resultSet.next()){
			int id = resultSet.getInt("Att_ID");
			String name = resultSet.getString("Att_Name");
			String address = resultSet.getString("Att_Address");
			String mobile = resultSet.getString("Att_MobileNum");
			String comments = resultSet.getString("Att_Comments");
			
			
			Attendant attendant = new Attendant(id, name, address, mobile, comments);
			listAttendant.add(attendant);
		}
		resultSet.close();
		statement.close();
		DisConnect();
		return listAttendant;
		
	}
	
	public boolean DeleteProduct(int product) throws SQLException {
		
		String Query = "DELETE FROM PRODUCT WHERE  Prd_ID = ?";
		Connect();
		PreparedStatement statement = JDBCconnection.prepareStatement(Query);
		statement.setInt(1, product);
		boolean rowDeleted = statement.executeUpdate()>0;
		statement.close();
		DisConnect();
		return rowDeleted;
	}
public boolean DeleteAttendant(int product) throws SQLException {
		
		String Query = "DELETE FROM ATTENDANT WHERE  Att_ID = ?";
		Connect();
		PreparedStatement statement = JDBCconnection.prepareStatement(Query);
		statement.setInt(1, product);
		boolean rowDeleted = statement.executeUpdate()>0;
		statement.close();
		DisConnect();
		return rowDeleted;
	}
	
	public boolean updateProduct(Product product) throws SQLException{
		String Query = "UPDATE Product SET Prd_Name =?, Prd_Price =?, Prd_Stock =?, Prd_Comments =?";
		Query += " Where Prd_ID = ?";
		Connect();
		PreparedStatement statement = JDBCconnection.prepareStatement(Query);
		
		statement.setString(1, product.getName());
		statement.setDouble(2, product.getPrice());
		statement.setInt(3, product.getStock());
		statement.setString(4, product.getComments());
		statement.setInt(5, product.getID());
		
		boolean rowUpdated = statement.executeUpdate()>0;
		statement.close();
		DisConnect();
		return rowUpdated;
	}
	
	public boolean updateAttendant(Attendant product) throws SQLException{
		String Query = "UPDATE ATTENDANT SET Att_Name =?, Att_Address =?, Att_MobileNum =?, Att_Comments =?";
		Query += " Where Att_ID = ?";
		Connect();
		PreparedStatement statement = JDBCconnection.prepareStatement(Query);
		
		statement.setString(1, product.getName());
		statement.setString(2, product.getAddress());
		statement.setString(3, product.getNum());
		statement.setString(4, product.getComments());
		statement.setInt(5, product.getID());
		
		boolean rowUpdated = statement.executeUpdate()>0;
		statement.close();
		DisConnect();
		return rowUpdated;
	}
	
	public Product getProduct(int ID) throws SQLException{
		Product product = null;
		String Query = "Select * FROM PRODUCT where Prd_ID =?";
		Connect();
		PreparedStatement statement = JDBCconnection.prepareStatement(Query);
		statement.setInt(1, ID);
		
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()){
			int id = resultSet.getInt("Prd_ID");
			String Name = resultSet.getString("Prd_Name");
			Double price = resultSet.getDouble("Prd_Price");
			int stock = resultSet.getInt("Prd_Stock");
			String comment = resultSet.getString("Prd_Comments");
			product = new Product(id, Name, price, stock, comment);
		}
		resultSet.close();
		statement.close();
		DisConnect();
		return product;
	}
	public Attendant getAttendant(int ID) throws SQLException{
		Attendant attendant = null;
		String Query = "Select * FROM ATTENDANT where Att_ID =?";
		Connect();
		PreparedStatement statement = JDBCconnection.prepareStatement(Query);
		statement.setInt(1, ID);
		
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()){
			int id = resultSet.getInt("Att_ID");
			String name = resultSet.getString("Att_Name");
			String address = resultSet.getString("Att_Address");
			String mobile = resultSet.getString("Att_MobileNum");
			String comments = resultSet.getString("Att_Comments");
			
			
			attendant = new Attendant(id, name, address, mobile, comments);
		}
		resultSet.close();
		statement.close();
		DisConnect();
		return attendant;
	}
	
	public int getMaxID() throws SQLException{
		int maxID =1000;
		String Query = "Select * From PRODUCT;";
		Connect();
		Statement statement = JDBCconnection.createStatement();
		ResultSet resultSet = statement.executeQuery(Query);
		
		while (resultSet.next()){
			maxID = resultSet.getInt("Prd_ID");
			
		}
		resultSet.close();
		statement.close();
		DisConnect();
		return maxID+1;
	}
	
	public int getMaxAttendantID() throws SQLException{
		int maxID =10000;
		String Query = "Select * From ATTENDANT;";
		Connect();
		Statement statement = JDBCconnection.createStatement();
		ResultSet resultSet = statement.executeQuery(Query);
		
		while (resultSet.next()){
			maxID = resultSet.getInt("Att_ID");
			
		}
		resultSet.close();
		statement.close();
		DisConnect();
		return maxID+1;
	}
}
