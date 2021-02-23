

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AppController
 */
@WebServlet("/AppController")
public class AppController extends HttpServlet {
	private static final long serialVersionUID = 1L;
		private DbAccess access;
       public void init(){
    	   String path = this.getServletContext().getRealPath("Exercise_4.sqlite");
    	   access = new DbAccess(path);
       }
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
		PrintWriter p = response.getWriter();
		String s= request.getParameter("Protocol");
	
		if (s.equals("AddProduct")){
			showNewForm(request, response);
		}
		else if(s.equals("DisplayProductList")){
			
			try {
				productList(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(s.equals("InsertProduct")){
			try {
				insertProduct(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (s.equals("EditProduct")){
			try {
				showEditForm(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		else if (s.equals("UpdateProduct")){
			try {
				UpdateProduct(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		else if (s.equals("DeleteProduct")){
			try {
				deleteProduct(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if (s.equals("SearchProduct")){
			try {
				SearchProduct(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(s.equals("DisplayattendentList")){
					
					try {
						attendantList(request, response);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
		else if(s.equals("AddAttendant")){
			
			showAddAttendant(request, response);
			
		}
		else if(s.equals("InsertAttendant")){
			try {
				insertAttendant(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (s.equals("EditAttendant")){
			try {
				showAttendantEditForm(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if (s.equals("UpdateAttendant")){
			try {
				UpdateAttendant(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		else if (s.equals("DeleteAttendant")){
			try {
				deleteAttendant(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if (s.equals("SearchAttendant")){
			try {
				SearchAttendant(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void productList(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException{
		List<Product> productLists = access.AllProduct();
		request.setAttribute("productList", productLists);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ProductDetails.jsp");
		dispatcher.forward(request, response);
	}
	private void attendantList(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException{
		List<Attendant> attendantLists = access.AllAttendant();
		request.setAttribute("productList", attendantLists);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Attendent.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int id = Integer.parseInt(request.getParameter("PID"));
		Product EditRow = access.getProduct(id);
		request.setAttribute("Row", EditRow);
		RequestDispatcher dispatcher = request.getRequestDispatcher("EditProduct.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showAttendantEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int id = Integer.parseInt(request.getParameter("PID"));
		Attendant EditRow = access.getAttendant(id);
		request.setAttribute("Row", EditRow);
		RequestDispatcher dispatcher = request.getRequestDispatcher("EditAttendant.jsp");
		dispatcher.forward(request, response);
	}
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("CreateProduct.jsp");
		dispatcher.forward(request, response);
	}
	private void showAddAttendant(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("CreateAttendant.jsp");
		dispatcher.forward(request, response);
	}
	private void insertProduct(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int ID = access.getMaxID();
		String ProductName = request.getParameter("productName");
		Double ProductPrice =  Double.parseDouble(request.getParameter("productPrice"));
		int ProductStock = Integer.parseInt(request.getParameter("productStock"));
		String ProductComments = request.getParameter("productComments");
		Product newProduct = new Product(ID, ProductName, ProductPrice, ProductStock, ProductComments);
		access.insertProduct(newProduct);
		productList(request, response);
		
	}
	
	private void insertAttendant(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int ID = access.getMaxAttendantID();
		String Name = request.getParameter("attendantName");
		String address = request.getParameter("attendantAddress");
		String Mobile = request.getParameter("AttendantMobile");
		String comments =request.getParameter("attendantComments");
		
		Attendant newAttendant = new Attendant(ID, Name, address, Mobile, comments);
		access.insertAttendant(newAttendant);
		attendantList(request, response);
		
	}
	
	private void UpdateProduct(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int ID =Integer.parseInt(request.getParameter("id"));;
		String ProductName = request.getParameter("productName");
		Double ProductPrice =  Double.parseDouble(request.getParameter("productPrice"));
		int ProductStock = Integer.parseInt(request.getParameter("productStock"));
		String ProductComments = request.getParameter("productComments");
		Product newProduct = new Product(ID, ProductName, ProductPrice, ProductStock, ProductComments);
		access.updateProduct(newProduct);
		try {
			productList(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void UpdateAttendant(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int ID =Integer.parseInt(request.getParameter("id"));;
		String Name = request.getParameter("attendantName");
		String address = request.getParameter("attendantAddress");
		String Mobile = request.getParameter("attendantMobile");
		String comments =request.getParameter("comments");
		
		Attendant newAttendant = new Attendant(ID, Name, address, Mobile, comments);
		access.updateAttendant(newAttendant);
		try {
			attendantList(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int ID = Integer.parseInt(request.getParameter("PID"));

		access.DeleteProduct(ID);
		try {
			productList(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void deleteAttendant(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int ID = Integer.parseInt(request.getParameter("PID"));

		access.DeleteAttendant(ID);
		try {
			attendantList(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void SearchProduct(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		String ProductName = request.getParameter("SearchString");
		List<Product> search = access.AllProduct();
		List<Product> productListss =  new ArrayList<>();
		for(int i =0; i<search.size(); i++){
			if (search.get(i).getName().equalsIgnoreCase(ProductName)){
				productListss.add(search.get(i));
			}
		}
		request.setAttribute("productListss", productListss);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ProductDetails.jsp");
		dispatcher.forward(request, response);
	}
	
	private void SearchAttendant(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		String AttendantName = request.getParameter("SearchString");
		List<Attendant> search = access.AllAttendant();
		List<Attendant> productListss =  new ArrayList<>();
		for(int i =0; i<search.size(); i++){
			if (search.get(i).getName().equalsIgnoreCase(AttendantName)){
				productListss.add(search.get(i));
			}
		}
		request.setAttribute("productListss", productListss);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Attendent.jsp");
		dispatcher.forward(request, response);
	}

}
