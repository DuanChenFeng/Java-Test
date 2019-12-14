package com.sitech.entity;

/**
*@author 段道博
*@date 2019年12月13日上午11:07:15
*
*/
public class SwapInfo {
	private int id;
	
	private int swap_total;
	
	private int swap_free;
	
	private int swap_used;
	
	private int swap_buff;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSwap_total() {
		return swap_total;
	}

	public void setSwap_total(int swap_total) {
		this.swap_total = swap_total;
	}

	public int getSwap_free() {
		return swap_free;
	}

	public void setSwap_free(int swap_free) {
		this.swap_free = swap_free;
	}

	public int getSwap_used() {
		return swap_used;
	}

	public void setSwap_used(int swap_used) {
		this.swap_used = swap_used;
	}

	public int getSwap_buff() {
		return swap_buff;
	}

	public void setSwap_buff(int swap_buff) {
		this.swap_buff = swap_buff;
	}

	@Override
	public String toString() {
		return "SwapInfo [swap_total=" + swap_total + ", swap_free=" + swap_free + ", swap_used=" + swap_used
				+ ", swap_buff=" + swap_buff + "]";
	}
	
}
