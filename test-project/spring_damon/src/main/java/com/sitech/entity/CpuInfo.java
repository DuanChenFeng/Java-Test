package com.sitech.entity;

/**
*@author 段道博
*@date 2019年12月13日上午11:03:44
*
*/
public class CpuInfo {
	private int id;
	
	private float user_cpu;
	
	private float sys_cpu;
	
	private float pro_cpu;
	
	private float free_cpu;
	
	private float wait_cpu;
	
	private float hard_cpu;
	
	private float soft_cpu;
	
	private float stoken_cpu;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getUser_cpu() {
		return user_cpu;
	}

	public void setUser_cpu(float user_cpu) {
		this.user_cpu = user_cpu;
	}

	public float getSys_cpu() {
		return sys_cpu;
	}

	public void setSys_cpu(float sys_cpu) {
		this.sys_cpu = sys_cpu;
	}

	public float getPro_cpu() {
		return pro_cpu;
	}

	public void setPro_cpu(float pro_cpu) {
		this.pro_cpu = pro_cpu;
	}

	public float getFree_cpu() {
		return free_cpu;
	}

	public void setFree_cpu(float free_cpu) {
		this.free_cpu = free_cpu;
	}

	public float getWait_cpu() {
		return wait_cpu;
	}

	public void setWait_cpu(float wait_cpu) {
		this.wait_cpu = wait_cpu;
	}

	public float getHard_cpu() {
		return hard_cpu;
	}

	public void setHard_cpu(float hard_cpu) {
		this.hard_cpu = hard_cpu;
	}

	public float getSoft_cpu() {
		return soft_cpu;
	}

	public void setSoft_cpu(float soft_cpu) {
		this.soft_cpu = soft_cpu;
	}

	public float getStoken_cpu() {
		return stoken_cpu;
	}

	public void setStoken_cpu(float stoken_cpu) {
		this.stoken_cpu = stoken_cpu;
	}

	@Override
	public String toString() {
		return "CpuInfo [user_cpu=" + user_cpu + ", sys_cpu=" + sys_cpu + ", pro_cpu=" + pro_cpu + ", free_cpu="
				+ free_cpu + ", wait_cpu=" + wait_cpu + ", hard_cpu=" + hard_cpu + ", soft_cpu=" + soft_cpu
				+ ", stoken_cpu=" + stoken_cpu + "]";
	}
	
}
