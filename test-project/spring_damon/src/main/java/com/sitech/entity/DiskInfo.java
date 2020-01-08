package com.sitech.entity;

/**
*@author 段道博
*@date 2019年12月13日上午11:08:29
*
*/
public class DiskInfo {
	private int id;
	
	private String disk_filesysl;
	
	private double disk_total;
	
	private double disk_used;
	
	private double disk_usable;
	
	private double disk_used_ratio;
	
	private String disk_mount_point;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDisk_filesysl() {
		return disk_filesysl;
	}

	public void setDisk_filesysl(String disk_filesysl) {
		this.disk_filesysl = disk_filesysl;
	}

	public double getDisk_total() {
		return disk_total;
	}

	public void setDisk_total(double disk_total) {
		this.disk_total = disk_total;
	}

	public double getDisk_used() {
		return disk_used;
	}

	public void setDisk_used(double disk_used) {
		this.disk_used = disk_used;
	}

	public double getDisk_usable() {
		return disk_usable;
	}

	public void setDisk_usable(double disk_usable) {
		this.disk_usable = disk_usable;
	}

	public double getDisk_used_ratio() {
		return disk_used_ratio;
	}

	public void setDisk_used_ratio(double disk_used_ratio) {
		this.disk_used_ratio = disk_used_ratio;
	}

	public String getDisk_mount_point() {
		return disk_mount_point;
	}

	public void setDisk_mount_point(String disk_mount_point) {
		this.disk_mount_point = disk_mount_point;
	}

	@Override
	public String toString() {
		return "DiskInfo [disk_filesysl=" + disk_filesysl + ", disk_total=" + disk_total + ", disk_used=" + disk_used
				+ ", disk_usable=" + disk_usable + ", disk_used_ratio=" + disk_used_ratio + ", disk_mount_point="
				+ disk_mount_point + "]";
	}
	
}
