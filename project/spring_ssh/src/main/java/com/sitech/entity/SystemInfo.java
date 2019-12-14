package com.sitech.entity;

/**
*@author 段道博
*@date 2019年12月13日上午10:39:37
*
*/
public class SystemInfo {
	private int id;
	
	private String current_time;
	
	private String run_time;
	
	private int user_num;
	
	private double load_avg;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCurrent_time() {
		return current_time;
	}

	public void setCurrent_time(String current_time) {
		this.current_time = current_time;
	}

	public String getRun_time() {
		return run_time;
	}

	public void setRun_time(String run_time) {
		this.run_time = run_time;
	}

	public int getUser_num() {
		return user_num;
	}

	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}

	public double getLoad_avg() {
		return load_avg;
	}

	public void setLoad_avg(double load_avg) {
		this.load_avg = load_avg;
	}

	@Override
	public String toString() {
		return "SystemInfo [current_time=" + current_time + ", run_time=" + run_time + ", user_num=" + user_num
				+ ", load_avg=" + load_avg + "]";
	}
	
	

}
