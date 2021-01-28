package Insertions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Bean.grocery_bean;
import Connections.DBUtil;


public class DAO {
	
	public int itemInsert(grocery_bean item) throws ClassNotFoundException , SQLException {
		
		Connection con =DBUtil.DBConnection();
		PreparedStatement ps = con.prepareStatement("insert into items_list values(?,?,?)");
		ps.setInt(1,item.getItem_id());
		ps.setString(2, item.getName());
		ps.setInt(3, item.getCost());
		int a =ps.executeUpdate();
		return a;
	}
	
	public void itemDisplay(grocery_bean item) throws ClassNotFoundException,SQLException {
		
		Connection con =DBUtil.DBConnection();
		PreparedStatement ps = con.prepareStatement("select * from items_list");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1) + " "+rs.getString(2)+" "+rs.getInt(3));
		}
		rs.close();
	}
	
	public void totalCost(grocery_bean item) throws ClassNotFoundException,SQLException {
		
		Connection con =DBUtil.DBConnection();
		PreparedStatement ps = con.prepareStatement("select sum(cost) from items_list");
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1));
		}
		rs.close();
		
		
	}
	
	
	
	

}
