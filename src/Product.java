public class Product {
	protected int Prd_ID;
	protected String Prd_Name;
	protected Double Prd_Price;
	protected int Prd_Stock;
	protected String Prd_Comments;
	
	public Product ( int ID, String name, Double price, int stock, String comments){
		this.Prd_ID = ID;
		this.Prd_Name = name;
		this.Prd_Price = price;
		this.Prd_Stock = stock;
		this.Prd_Comments = comments;
	}
	
	public int getID(){
		return this.Prd_ID;
	}
	
	public void setID(int ID){
		this.Prd_ID = ID;
	}
	
	public String getName(){
		return this.Prd_Name;
	}
	public void setName(String ProductName){
		this.Prd_Name = ProductName;
	}
	public double getPrice(){
		return this.Prd_Price;
	}
	
	public void setPrice(Double price){
		this.Prd_Price = price;
	}
	
	public int getStock(){
		return this.Prd_Stock;
	}
	
	public void setStock(int quantity){
		this.Prd_Stock = quantity;
	}
	
	public String getComments(){
		return this.Prd_Comments;
	}
	
	public void setComments(String comments){
		this.Prd_Comments = comments;
	}
}



