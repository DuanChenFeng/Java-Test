package com.sitech.entity;

/**
*@author 段道博
*@date 2019年12月13日上午11:02:02
*
*/
public class TaskInfo {
	private int id;
	
	private int task_total;
	
	private int task_run;
	
	private int task_sleep;
	
	private int task_stopped;
	
	private int task_zombie;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTask_total() {
		return task_total;
	}

	public void setTask_total(int task_total) {
		this.task_total = task_total;
	}

	public int getTask_run() {
		return task_run;
	}

	public void setTask_run(int task_run) {
		this.task_run = task_run;
	}

	public int getTask_sleep() {
		return task_sleep;
	}

	public void setTask_sleep(int task_sleep) {
		this.task_sleep = task_sleep;
	}

	public int getTask_stopped() {
		return task_stopped;
	}

	public void setTask_stopped(int task_stopped) {
		this.task_stopped = task_stopped;
	}

	public int getTask_zombie() {
		return task_zombie;
	}

	public void setTask_zombie(int task_zombie) {
		this.task_zombie = task_zombie;
	}

	@Override
	public String toString() {
		return "TaskInfo [task_total=" + task_total + ", task_run=" + task_run + ", task_sleep=" + task_sleep
				+ ", task_stopped=" + task_stopped + ", task_zombie=" + task_zombie + "]";
	}
	
	

}
