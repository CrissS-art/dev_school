package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Product;

//créer une méthode permmettant de recuperer les formations en distanciel ou en présenciel

public class ProductDao implements Dao<Product> {
	/** create product**/
	@Override
	public boolean create(Product obj) {
		String str = "INSERT INTO product (Name, Description, Length, Type, Price) VALUES (?,?,?,?,?);";	
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getDescription());
			ps.setInt(3, obj.getLength());
			ps.setString(4, obj.getType());	
			ps.setInt(5, obj.getPrice());
			if( ps.executeUpdate() == 1)	return true;
		} catch (SQLException e) {
			logger.severe("Problème SQL sur la création d'un article " + e.getMessage());
		} 	
		return false;
	}
	/** read one product/id**/
	@Override
	public Product read(int idProduct) {
		try (Statement statement = connection.createStatement()){
			String str = "SELECT * FROM product where idProduct=" + idProduct + ";";									
			ResultSet rs = statement.executeQuery(str);
			if(rs.next()) return new Product(rs.getInt(1), rs.getString(2) , rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6));
		} catch (SQLException e) {
			logger.severe("Probleme SQL sur la lecture d'une formation " + e.getMessage());
		} 	
		return null;
	}
	/** update product**/
	@Override
	public boolean update(Product obj) {
		String str = "UPDATE product set name = ?, description = ?, length = ?, type = ?, price = ? where idProduct = ?;";
		try (PreparedStatement ps = connection.prepareStatement(str)){				
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getDescription());
			ps.setInt(3, obj.getLength());
			ps.setString(4, obj.getType());	
			ps.setInt(5, obj.getPrice());
			if( ps.executeUpdate() == 1)	return true;
		} catch (SQLException e) {
			logger.severe("Probleme SQL sur la mise Ã  jour d'un article " + e.getMessage());
		} 	
		return false;
	}
	/** delete product**/
	@Override
	public boolean delete(Product obj) {
		try (Statement statement = connection.createStatement()){
			String str = "DELETE FROM product where idProduct=" + obj.getIdProduct() + ";";									
			statement.executeUpdate(str);		
			return true; //suppression ok
		} catch (SQLException e) {
			logger.severe("Probleme SQL sur la suppression d'un article " + e.getMessage());
		} 	
		return false; //non supprimé
	}
	/** read all products**/
	@Override
	public ArrayList<Product> readAll() {
		ArrayList<Product> products = new ArrayList<Product>();
		String strSql = "SELECT * FROM product";		
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
			logger.severe("Probleme SQL sur le renvoi de tous articles " + e.getMessage());
		}	
		return products;
	}
	
	/** read all products by name: search by keyword**/
	
	
	/** read all products by category distanciel présentiel**/
//	public ArrayList<Product> readAllByType(String type) {
//		ArrayList<Product> products = new ArrayList<Product>();
//		String strSql = "SELECT * FROM product where type = " + type;		
//		try(Statement statement = connection.createStatement()){
//			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
//				while(resultSet.next()) {
//					int rsIdProduct = resultSet.getInt(1);	
//					String rsName = resultSet.getString(2);
//					String rsDescription = resultSet.getString(3);
//					int rsLength = resultSet.getInt(4);
//					String rsType = resultSet.getString(5);
//					int rsPrice = resultSet.getInt(6);			
//					products.add((new Product(rsIdProduct,rsName,rsDescription,rsLength,rsType,rsPrice)));	
//				}	
//			}
//		} catch (SQLException e) {
//			logger.severe("Probleme SQL sur renvoi des articles d'une categorie " + e.getMessage());
//		}			
//		return products;
	}

