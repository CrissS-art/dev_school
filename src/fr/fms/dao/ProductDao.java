package fr.fms.dao;

import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.fms.entities.Product;

public class ProductDao implements Dao<Product> {
	/** create product**/
	@Override
	public boolean create(Product obj) {
		String str = "INSERT INTO customer (Name, Description, Length, Type, Price) VALUES (?,?,?,?,?);";	
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getDescription());
			ps.setInt(3, obj.getLength());
			ps.setString(4, obj.getType());	
			ps.setInt(5, obj.getPrice());
			if( ps.executeUpdate() == 1)	return true;
		} catch (SQLException e) {
			logger.severe("pProblème SQL sur la création d'un article " + e.getMessage());
		} 	
		return false;
	}
	/** read one product/id**/
	@Override
	public Product read(int idProduct) {
		try (Statement statement = connection.createStatement()){
			String str = "SELECT * FROM customer where idProduct=" + idProduct + ";";									
			ResultSet rs = statement.executeQuery(str);
			if(rs.next()) return new Product(rs.getInt(1), rs.getString(2) , rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6));
		} catch (SQLException e) {
			logger.severe("Problème SQL sur la lecture d'une formation " + e.getMessage());
		} 	
		return null;
	}
	/** update product**/
	@Override
	public boolean update(Product obj) {
		String str = "UPDATE customer set name = ?, description = ?, length = ?, type = ?, price = ? where idProduct = ?;";
		try (PreparedStatement ps = connection.prepareStatement(str)){				
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getDescription());
			ps.setInt(3, obj.getLength());
			ps.setString(4, obj.getType());	
			ps.setInt(5, obj.getPrice());
			if( ps.executeUpdate() == 1)	return true;
		} catch (SQLException e) {
			logger.severe("pb sql sur la mise Ã  jour d'un article " + e.getMessage());
		} 	
		return false;
	}
	/** delete product**/
	@Override
	public boolean delete(Product obj) {
		try (Statement statement = connection.createStatement()){
			String str = "DELETE FROM customer where idProduct=" + obj.getIdProduct() + ";";									
			statement.executeUpdate(str);		
			return true; //suppression ok
		} catch (SQLException e) {
			logger.severe("pb sql sur la suppression d'un article " + e.getMessage());
		} 	
		return false; //non supprimé
	}
	/** read all products**/
	@Override
	public ArrayList<Product> readAll() {
		ArrayList<Product> products = new ArrayList<Product>();
		String strSql = "SELECT * FROM customer";		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int rsIdProduct = resultSet.getInt(1);	
					String rsName = resultSet.getString(2);
					String rsDescription = resultSet.getString(3);
					int rsLength = resultSet.getInt(4);
					String rsType = resultSet.getString(5);
					int rsPrice = resultSet.getInt(6);		
					products.add((new Product(rsIdProduct,rsName,rsDescription,rsLength,rsType,rsPrice)));						
				}	
			}
		} catch (SQLException e) {
			logger.severe("pb sql sur revoi de tous articles " + e.getMessage());
		}	
		return products;
	}
//	/** read all products by category distanciel présentiel**/
//	public ArrayList<Product> readAllByCat(int id) {
//		ArrayList<Product> articles = new ArrayList<Product>();
//		String strSql = "SELECT * FROM T_Articles where idCategory=" + id;		
//		try(Statement statement = connection.createStatement()){
//			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
//				while(resultSet.next()) {
//					int rsIdProduct = resultSet.getInt(1);	
//					String rsName = resultSet.getString(2);
//					String rsDescription = resultSet.getString(3);
//					int rsLength = resultSet.getInt(4);
//					String rsType = resultSet.getString(5);
//					int rsPrice = resultSet.getInt(6);			
//					articles.add((new Product(rsIdProduct,rsName,rsDescription,rsLength,rsType,rsPrice)));						
//				}	
//			}
//		} catch (SQLException e) {
//			logger.severe("pb sql sur renvoir des articles d'une catÃ©gorie " + e.getMessage());
//		}			
//		return articles;
//	}
}
