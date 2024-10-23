package fr.fms.dao;

import java.lang.System.Logger;
import java.sql.Connection;

public interface Dao {
	public static Connection connection = BddConnection.getConnection();
	public static final Logger logger = Logger.getLogger(Dao.class.getName());

	public boolean create(T obj);	

	public T read(int id);		
	
	public boolean update(T obj);	

	public boolean delete(T obj);	
	
	public ArrayList<T> readAll();
}


