package com.mb.restproject.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Repo {

	public ArrayList<NewResource> resourceRepo;
	Connection conn = null;

	public Repo() {
		resourceRepo = new ArrayList<NewResource>();
		String url = "jdbc:mysql://localhost:3306/archa";
		String userName = "root";
		String password = "root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<NewResource> getResourceRepo() {

		try {
			String sql = "select * from bags";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				NewResource r = new NewResource();
				r.setName(rs.getString(1));
				r.setQty(rs.getInt(2));
				r.setPrice(rs.getInt(3));
				r.setCprice(rs.getInt(4));
				resourceRepo.add(r);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resourceRepo;
	}

	public void add(NewResource n) {
		try {
			String sql = "insert into bags (`name`,`qty`,`salesprice`,`costprice`) VALUES ('" + n.getName() + "', '"
					+ n.getQty() + "', '" + n.getPrice() + "', '" + n.getCprice() + "')";
			Statement st = conn.prepareStatement(sql);
			st.executeUpdate(sql);
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public NewResource getResourceRepo(String id) {

		try {
			String sql = "select * from bags where name='" + id + "'";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				NewResource r = new NewResource();
				r.setName(rs.getString(1));
				r.setQty(rs.getInt(2));
				r.setPrice(rs.getInt(3));
				r.setCprice(rs.getInt(4));
				return r;

			}
			NewResource r = new NewResource();
			return r;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public void update(NewResource n) {
		try {
			String sql = "update bags set name=?,qty=?,salesprice=?, costprice=? where name=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,n.getName());
			st.setInt(2,n.getQty());
			st.setInt(3,n.getPrice());
			st.setInt(4,n.getCprice());
			st.setString(5,n.getName());
			st.executeUpdate();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	public void delete(String id) {
		try {
			String sql = "delete from bags  where name=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,id);			
			st.executeUpdate();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
