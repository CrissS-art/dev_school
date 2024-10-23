package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Customer;

public class CustomerDao implements Dao<Customer> {

	@Override
	public boolean create(Customer obj) {
		String str = "INSERT INTO customer (firstname,lastname,email,phoneNumber,idUser) VALUES (?,?,?,?,?);";
		try (PreparedStatement ps = connection.prepareStatement(str,Statement.RETURN_GENERATED_KEYS)){
			ps.setString(1, obj.getFirstname());
			ps.setString(2, obj.getLastname());			
			ps.setString(3, obj.getEmail());
			ps.setInt(4, obj.getIdUser());
			ps.execute();
			try(ResultSet generatedKeySet = ps.getGeneratedKeys()){
				if(generatedKeySet.next()) {
					//obj.setIdCustomer(0);
					return true;
				}	
			}		
		} catch (SQLException e) {
			logger.severe("Problème SQL sur la création d'un client");
		} 				
		return false;
	}
/** read a specific customer**/
	@Override
	public Customer read(int idCustomer) {
		String str = "select * from customer where IdCustomer=?";
		try(PreparedStatement ps = connection.prepareStatement(str)){
			ps.setInt(1, idCustomer);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),  rs.getInt(5));
		} catch (SQLException e) {
			logger.severe("Problème SQL sur la lecture d'un client " + e.getMessage());
		}
		return null;
	}

	@Override
	public boolean update(Customer obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Customer obj) {
		// TODO Auto-generated method stub
		return false;
	}
	/** read all customers**/
	@Override
	public ArrayList<Customer> readAll() {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		String strSql = "SELECT * FROM customer";		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int idCustomer = resultSet.getInt(1);	
					String firstname = resultSet.getString(2);
					String lastname = resultSet.getString(3);
					String email = resultSet.getString(4);
					int idUser = resultSet.getInt(5);
					customers.add((new Customer(idCustomer,firstname,lastname,email,idUser)));						
				}	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return customers;
	}
	
}
