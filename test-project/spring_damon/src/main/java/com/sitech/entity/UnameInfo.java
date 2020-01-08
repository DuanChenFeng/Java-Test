package com.sitech.entity;

/**
*@author 段道博
*@date 2019年12月13日上午11:10:27
*
*/
public class UnameInfo {
	private int id;
	
	private String sys_name;
	
	private String host_name;
	
	private String sys_version;
	
	private String kernel_version;
	
	private String processor_sys;
	
	private String cpu_name;
	
	private String hard_platform;
	
	private String operating_sys;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSys_name() {
		return sys_name;
	}

	public void setSys_name(String sys_name) {
		this.sys_name = sys_name;
	}

	public String getHost_name() {
		return host_name;
	}

	public void setHost_name(String host_name) {
		this.host_name = host_name;
	}

	public String getSys_version() {
		return sys_version;
	}

	public void setSys_version(String sys_version) {
		this.sys_version = sys_version;
	}

	public String getKernel_version() {
		return kernel_version;
	}

	public void setKernel_version(String kernel_version) {
		this.kernel_version = kernel_version;
	}

	public String getProcessor_sys() {
		return processor_sys;
	}

	public void setProcessor_sys(String processor_sys) {
		this.processor_sys = processor_sys;
	}

	public String getCpu_name() {
		return cpu_name;
	}

	public void setCpu_name(String cpu_name) {
		this.cpu_name = cpu_name;
	}

	public String getHard_platform() {
		return hard_platform;
	}

	public void setHard_platform(String hard_platform) {
		this.hard_platform = hard_platform;
	}

	public String getOperating_sys() {
		return operating_sys;
	}

	public void setOperating_sys(String operating_sys) {
		this.operating_sys = operating_sys;
	}

	@Override
	public String toString() {
		return "UnameInfo [sys_name=" + sys_name + ", host_name=" + host_name + ", sys_version=" + sys_version
				+ ", kernel_version=" + kernel_version + ", processor_sys=" + processor_sys + ", cpu_name=" + cpu_name
				+ ", hard_platform=" + hard_platform + ", operating_sys=" + operating_sys + "]";
	}
	
}
