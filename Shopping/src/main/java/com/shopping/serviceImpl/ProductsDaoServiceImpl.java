package com.shopping.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shopping.model.Products;
import com.shopping.service.ProductsDaoService;
import com.shopping.util.DButil;

@Service
public class ProductsDaoServiceImpl implements ProductsDaoService {

	ArrayList<Products> productList=new ArrayList<Products>();
	
	private static Connection connection=null;
	
	public ProductsDaoServiceImpl() {
		try {
			connection=DButil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Products> getProducts(){
		productList.clear();
		String getProductQuery="SELECT * FROM products";
		PreparedStatement stmt;
		try {
			stmt=connection.prepareStatement(getProductQuery);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				Products prod=new Products();
				prod.setProId(rs.getInt(1));
				prod.setProCatId(rs.getInt(2));
				prod.setProName(rs.getString(3));
				prod.setProDes(rs.getString(4));
				prod.setProPrice(rs.getInt(5));
				prod.setProdImg(rs.getString(6));
				productList.add(prod);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
		
	}

	@Override
	public void addProducts(Products product) {
		int ProId=product.getProId();
		int ProCatId=product.getProCatId();
		String ProName=product.getProName();
		String ProDes=product.getProDes();
		int ProPrice=product.getProPrice();
		String ProdImg=product.getProdImg();
		
		String insertQuery="INSERT INTO products VALUES("+ProId+","+ProCatId+",'"+ProName+"','"+ProDes+"',"+ProPrice+",'"+ProdImg+"');";
		
		PreparedStatement stmt;
		try {
			stmt=connection.prepareStatement(insertQuery);
			stmt.executeUpdate();
			System.out.println("Products added Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Duplicate product Id");
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProducts(int ProId) {
		String deleteQuery="DELETE FROM products WHERE ProId="+ProId+";";
		
		PreparedStatement stmt;
		try {
			stmt=connection.prepareStatement(deleteQuery);
			stmt.executeUpdate();
			System.out.println("Product deleted successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateProducts(Products product) {
		int ProId=product.getProId();
		int ProCatId=product.getProCatId();
		String ProName=product.getProName();
		String ProDes=product.getProDes();
		int ProPrice=product.getProPrice();
		String ProdImg=product.getProdImg();
		
		String updateQuery="UPDATE products SET ProCatId="+ProCatId+","+"ProName='"+ProName+"',"+"ProDes='"+ProDes+"',"+"ProPrice='"+ProPrice+"',"+"ProdImg='"+ProdImg+"'WHERE ProId="+ProId+";";
		PreparedStatement stmt;
		try {
			stmt=connection.prepareStatement(updateQuery);
			stmt.executeUpdate();
			System.out.println("Product updated successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
