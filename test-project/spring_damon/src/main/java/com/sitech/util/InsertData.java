package com.sitech.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
*@author 段道博
*@date 2019年12月13日下午2:17:08
*
*/
public class InsertData {
	
	private static String url = "jdbc:mysql://localhost:3306/ecjtu?useUnicode=true"
			+ "&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false"
			+ "&allowMultiQueries=true&allowPublicKeyRetrieval=true";
	
	private static String user = "root";
	
	private static String password = "18879230602";
	
	//连接数据库
	private static Connection connection() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
	//断开数据库的连接
	private static void close_conn(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//读取文件内容
	public static String read_file(String path) throws IOException {
		FileReader fr = new FileReader(new File(path));
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(fr);
		
		StringBuffer sb = new StringBuffer();
		String str = "";
		
		while ((str = br.readLine()) != null) {
			sb.append(str + "\n");
		}
		
		return sb.toString();
	}
	
	//插入数据-系统信息表数据
	public static void insert_sys_data(String data) throws IOException, SQLException {
		Connection conn = connection();
		
		String[] split = data.split(",");
		
		String sql = "insert into system_info(`current_time`,run_time,user_num,load_avg) "
				+ " values(" + "'" +split[0] + "'" + "," + "'" + split[1] + "'" 
				+ "," + split[2] + "," + Double.valueOf(split[3]) + ");";
		
		Statement statement = conn.createStatement();
		
		statement.execute(sql);
		
		close_conn(conn);
		
	}
	
	//插入数据-cpu状态信息表
	public static void insert_cpu_data(String data) throws IOException, SQLException {
		Connection conn = connection();
		
		String[] split = data.split(",");
		
		String sql = "insert into cpu_info("
				+ "user_cpu,sys_cpu,pro_cpu,free_cpu,wait_cpu,hard_cpu,soft_cpu,stoken_cpu) "
				+ "values(" + Float.valueOf(split[0]) + "," + Float.valueOf(split[1]) + "," 
				+ Float.valueOf(split[2]) + "," + Float.valueOf(split[3]) + "," 
				+ Float.valueOf(split[4]) + "," + Float.valueOf(split[5]) + "," 
				+ Float.valueOf(split[6]) + "," + Float.valueOf(split[7]) + ");";
		
		Statement statement = conn.createStatement();
		
		statement.execute(sql);
		
		close_conn(conn);
	}
	
	//插入数据-datanode状态信息表
	public static void insert_dn_data(String data) throws IOException, SQLException {
		Connection conn = connection();		
		String[] split = data.split("\n");		
		for (String info : split) {
			String[] split2 = info.split(",");			
			String node_ip = split2[0].trim();			
			String host_name = split2[1].trim();			
			String node_status = split2[2].trim();			
			String node_capacity = split2[3].trim();			
			String dfs_used = split2[4].trim();			
			String non_dfs = split2[5].trim();			
			String dfs_remain = split2[6].trim();			
			String dfs_used_pro = split2[7].trim();			
			String contact_time = split2[8].trim();			
			String sql = "insert into dn_info("
					+ "node_ip,host_name,node_status,node_capacity,dfs_used,non_dfs,"
					+ "dfs_remain,dfs_used_pro,contact_time) "
					+ "values(" + "'" + node_ip + "'" + "," + "'" + host_name + "'" + "," 
					+ "'" + node_status + "'" + "," 
					+ Double.valueOf(node_capacity) + "," + Double.valueOf(dfs_used) + "," 
					+ Double.valueOf(non_dfs) + "," + Double.valueOf(dfs_remain) + "," 
					+ "'" + dfs_used_pro + "'" +  "," + "'" + contact_time + "'" + ");";			
			Statement stmt = conn.createStatement();			
			stmt.execute(sql);
			
		}
	}
	
}
