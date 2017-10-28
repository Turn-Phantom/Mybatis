package com.li.pra.mybatis1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_Con {
	public static void main(String [] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//通过驱动管理器获取连接
			conn = DriverManager.getConnection("jdbc:mysql://192.168.1.152:3306/li?characterEncoding=UTF-8","root","root");
			
			//定义sql
			String sql = "SELECT * from user where username = ?";
			//预处理sql语句
			ps = conn.prepareStatement(sql);
			//设置占位符参数
			ps.setString(1, "王五");
			//查询结果集
			rs = ps.executeQuery();
			//遍历结果集
			while(rs.next()) {
				System.out.println(rs.getString("id")+" "+rs.getString("username"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			//释放资源
			if(rs != null ) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
/*
 * jdbc问题：
 * 1、数据库的连接创建、释放频繁会造成系统资源浪费，影响系统西性能
 * 		（优化方法：使用数据库连接池）
 * 2、sql语句在代码中硬编码，代码不易维护，sql代码变动大
 * 3、使PrepareStatement向占位符传参存在硬编码，sql的where语句不固定，修改sql需要修改代码，系统不易维护
 * 4、结果集解析存在硬编码（查询列名）
 */
