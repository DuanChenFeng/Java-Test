package com.sitech.entity;

/**
*@author 段道博
*@date 2019年12月28日下午2:56:50
*
*/
public class User {
	
	private int id;
	
	private String name;
	
	private String passwd;
	
	private int isadmin;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public int getIsadmin() {
		return isadmin;
	}

	public void setIsadmin(int isadmin) {
		this.isadmin = isadmin;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", passwd=" + passwd + ", isadmin=" + isadmin + "]";
	}
	
}
