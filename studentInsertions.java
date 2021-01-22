package Insertions;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Bean.studentBean;
import Connections.DBUtil;


public class studentInsertions {

	public int studentInsert(studentBean student) throws ClassNotFoundException , SQLException {
		Connection con =DBUtil.DBConnection();
		//prepared-Statements
		PreparedStatement ps = con.prepareStatement("insert into studentDB values(?,?,?)");
		ps.setInt(1,student.getRegno());
		ps.setString(2,student.getName());
		ps.setString(3,student.getEmail());
		int a=ps.executeUpdate();
		con.close();
		return a;
	}
	
	public int studentDelete(studentBean student) throws ClassNotFoundException , SQLException {
		Connection con =DBUtil.DBConnection();
		PreparedStatement ps = con.prepareStatement("delete from studentDB where id=?");
		ps.setInt(1,student.getRegno());
		int b=ps.executeUpdate();
		con.close();
		return b;
	}
	
	public int studentUpdate(studentBean student) throws ClassNotFoundException , SQLException {
		Connection con =DBUtil.DBConnection();
		PreparedStatement ps = con.prepareStatement("update studentDB set name=? where id=?");
		ps.setInt(1,student.getRegno());
		ps.setString(2,student.getName());
		int c=ps.executeUpdate();
		con.close();
		return c;
	}
	
	public void studentDisplay(studentBean student) throws ClassNotFoundException , SQLException {
		Connection con =DBUtil.DBConnection();
		PreparedStatement ps = con.prepareStatement("select * from studentDB where id=?");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1) + " "+rs.getString(2)+" "+rs.getString(3));
		}
		rs.close();
	}
	
	
}
