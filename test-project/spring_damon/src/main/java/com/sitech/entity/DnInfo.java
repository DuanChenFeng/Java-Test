package com.sitech.entity;

/**
*@author 段道博
*@date 2020年1月2日上午10:09:57
*
*/
public class DnInfo {
	private int id;
	
	//节点ip
	private String node_ip;
	
	//主机名
	private String host_name;
	
	//节点状态
	private String node_status;
	
	//节点容量
	private Double node_capacity;
	
	//已使用的
	private Double dfs_used;
	
	//未使用的
	private Double non_dfs;
	
	//剩余的
	private Double dfs_remain;
	
	//使用百分比
	private String dfs_used_pro;
	
	//时间
	private String contact_time;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNode_ip() {
		return node_ip;
	}

	public void setNode_ip(String node_ip) {
		this.node_ip = node_ip;
	}

	public String getHost_name() {
		return host_name;
	}

	public void setHost_name(String host_name) {
		this.host_name = host_name;
	}

	public String getNode_status() {
		return node_status;
	}

	public void setNode_status(String node_status) {
		this.node_status = node_status;
	}

	public Double getNode_capacity() {
		return node_capacity;
	}

	public void setNode_capacity(Double node_capacity) {
		this.node_capacity = node_capacity;
	}

	public Double getDfs_used() {
		return dfs_used;
	}

	public void setDfs_used(Double dfs_used) {
		this.dfs_used = dfs_used;
	}

	public Double getNon_dfs() {
		return non_dfs;
	}

	public void setNon_dfs(Double non_dfs) {
		this.non_dfs = non_dfs;
	}

	public Double getDfs_remain() {
		return dfs_remain;
	}

	public void setDfs_remain(Double dfs_remain) {
		this.dfs_remain = dfs_remain;
	}

	public String getDfs_used_pro() {
		return dfs_used_pro;
	}

	public void setDfs_used_pro(String dfs_used_pro) {
		this.dfs_used_pro = dfs_used_pro;
	}

	public String getContact_time() {
		return contact_time;
	}

	public void setContact_time(String contact_time) {
		this.contact_time = contact_time;
	}

	@Override
	public String toString() {
		return "DnInfo [node_ip=" + node_ip + ", host_name=" + host_name + ", node_status=" + node_status
				+ ", node_capacity=" + node_capacity + ", dfs_used=" + dfs_used + ", non_dfs=" + non_dfs
				+ ", dfs_remain=" + dfs_remain + ", dfs_used_pro=" + dfs_used_pro + ", contact_time=" + contact_time
				+ "]";
	}
	
}
