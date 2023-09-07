package com.shopping.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shopping.model.Orders;
import com.shopping.service.OrdersDaoService;
import com.shopping.util.DButil;

@Service
public class OrdersDaoServiceImpl implements OrdersDaoService {

	ArrayList<Orders> orderList=new ArrayList<Orders>();
	
	private static Connection connection=null;
	
	public OrdersDaoServiceImpl(){
		try {
			connection=DButil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Orders> getOrders() {
		orderList.clear();
		String getOrderQuery="SELECT * FROM orders;";
		PreparedStatement stmt;
		
		try {
			stmt=connection.prepareStatement(getOrderQuery);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				Orders order=new Orders();
				order.setOrderid(rs.getInt(1));
				order.setCustomerusername(rs.getString(2));
				order.setProductid(rs.getInt(3));
				order.setQty(rs.getInt(4));
				order.setOrderprice(rs.getInt(5));
				orderList.add(order);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orderList;
	}

	@Override
	public void addOrders(Orders order) {
		int orderid=order.getOrderid();
		String customerusername=order.getCustomerusername();
		int productid=order.getProductid();
		int qty=order.getQty();
		int orderprice=order.getOrderprice();
		
		String insertQuery="INSERT INTO orders VALUES("+orderid+",'"+customerusername+"',"+productid+","+qty+","+orderprice+");";
		
		PreparedStatement stmt;
		
		try {
			stmt=connection.prepareStatement(insertQuery);
			stmt.executeUpdate();
			System.out.println("Order placed successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
