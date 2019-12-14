package com.sitech.entity;

/**
*@author 段道博
*@date 2019年12月11日上午9:42:51
*@Description	连接RedHat的 	ip  端口     用户名     密码
*/
public class ConnInfo {
	private String ip;
	
	private int port;
	
	private String username;
	
	private String password;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
