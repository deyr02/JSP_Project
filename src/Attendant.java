public class Attendant {
	int Att_ID;
	String Att_Name ="";
	String Att_Address ="";
	String Att_MobileNum = "";
	String Att_Comments ="";
	
	public Attendant(int ID, String Name, String Address, String MobileNum, String Comments){
		this.Att_ID = ID;
		this.Att_Name = Name;
		this.Att_Address = Address;
		this.Att_MobileNum = MobileNum;
		this.Att_Comments = Comments;
	}
	
	public int getID(){
		return this.Att_ID;
	}
	public void setID(int A_ID){
		this.Att_ID= A_ID;
	}
	public String getName(){
		return this.Att_Name;
	}
	public void setName(String Name){
		this.Att_Name = Name;
	}
	
	public String getAddress(){
		return this.Att_Address;
	}
	
	public void setAddress(String address){
		this.Att_Address = address;
	}
	
	public String getNum(){
		return this.Att_MobileNum;
	}
	public void setNum(String Num){
		this.Att_MobileNum = Num;
	}
	
	public String getComments(){
		return this.Att_Comments;
	}
	public void setComments(String comments){
		this.Att_Comments = comments;
	}
	

}
