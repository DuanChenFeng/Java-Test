package com.sitech.entity;

/**
*@author 段道博
*@date 2019年12月13日上午11:05:57
*
*/
public class MemInfo {
	private int id;
	
	private int mem_total;
	
	private int mem_free;
	
	private int mem_used;
	
	private int mem_buff;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMem_total() {
		return mem_total;
	}

	public void setMem_total(int mem_total) {
		this.mem_total = mem_total;
	}

	public int getMem_free() {
		return mem_free;
	}

	public void setMem_free(int mem_free) {
		this.mem_free = mem_free;
	}

	public int getMem_used() {
		return mem_used;
	}

	public void setMem_used(int mem_used) {
		this.mem_used = mem_used;
	}

	public int getMem_buff() {
		return mem_buff;
	}

	public void setMem_buff(int mem_buff) {
		this.mem_buff = mem_buff;
	}

	@Override
	public String toString() {
		return "MemInfo [mem_total=" + mem_total + ", mem_free=" + mem_free + ", mem_used=" + mem_used + ", mem_buff="
				+ mem_buff + "]";
	}
	
}
