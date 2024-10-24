package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Category;

//rajouter méthode pour toutes les formations contenant un mot clé

public class CategoryDao implements Dao<Category>  {

		/** create Category**/
		@Override
		public boolean create(Category obj) {
			String str = "INSERT INTO customer (idCategory, name, description) VALUES (?,?,?);";	
			try (PreparedStatement ps = connection.prepareStatement(str)){
				ps.setInt(1, obj.getIdCategory());
				ps.setString(2, obj.getName());
				ps.setString(3, obj.getDescription());
				if( ps.executeUpdate() == 1)	return true;
			} catch (SQLException e) {
				logger.severe("Problème SQL sur la création d'un article " + e.getMessage());
			} 	
			return false;
		}
		/** read one Category/id**/
		@Override
		public Category read(int idCategory) {
			try (Statement statement = connection.createStatement()){
				String str = "SELECT * FROM category where idCategory = " + idCategory + ";";									
				ResultSet rs = statement.executeQuery(str);
				if(rs.next()) return new Category(rs.getInt(1), rs.getString(2) , rs.getString(3));
			} catch (SQLException e) {
				logger.severe("Problème SQL sur la lecture d'une formation " + e.getMessage());
			} 	
			return null;
		}
		/** update Category**/
		@Override
		public boolean update(Category obj) {
			String str = "UPDATE category set name = ?, description = ?;";
			try (PreparedStatement ps = connection.prepareStatement(str)){
				ps.setString(1, obj.getName());
				ps.setString(2, obj.getDescription());
				if( ps.executeUpdate() == 1)	return true;
			} catch (SQLException e) {
				logger.severe("Problème SQL sur la mise Ã  jour d'un article " + e.getMessage());
			} 	
			return false;
		}
		/** delete Category**/
		@Override
		public boolean delete(Category obj) {
			try (Statement statement = connection.createStatement()){
				String str = "DELETE FROM category where idCategory=" + obj.getIdCategory() + ";";									
				statement.executeUpdate(str);		
				return true; //suppression ok
			} catch (SQLException e) {
				logger.severe("Problème SQL sur la suppression d'un article " + e.getMessage());
			} 	
			return false; //non supprimé
		}
		/** read all Category**/
		@Override
		public ArrayList<Category> readAll() {
			ArrayList<Category> categories = new ArrayList<Category>();
			String strSql = "SELECT * FROM customer";		
			try(Statement statement = connection.createStatement()){
				try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
					while(resultSet.next()) {
						int rsIdCategory = resultSet.getInt(1);	
						String rsName = resultSet.getString(2);
						String rsDescription = resultSet.getString(3);		
						categories.add((new Category(rsIdCategory,rsName,rsDescription)));						
					}	
				}
			} catch (SQLException e) {
				logger.severe("Problème SQL sur revoi de tous articles " + e.getMessage());
			}	
			return categories;
		}
		/** read all Category by name **/
		public ArrayList<Category> readAllByName(String name) {
			ArrayList<Category> categories = new ArrayList<Category>();
			String strSql = "SELECT * FROM category where name = " + name;		
			try(Statement statement = connection.createStatement()){
				try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
					while(resultSet.next()) {
						int rsIdCategory = resultSet.getInt(1);	
						String rsName = resultSet.getString(2);
						String rsDescription = resultSet.getString(3);
						categories.add((new Category(rsIdCategory,rsName,rsDescription)));	
					}	
				}
			} catch (SQLException e) {
				logger.severe("pb sql sur renvoi des articles d'une catÃ©gorie " + e.getMessage());
			}			
			return categories;
		}
	}


