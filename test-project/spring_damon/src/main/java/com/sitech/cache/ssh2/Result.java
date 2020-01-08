package com.sitech.cache.ssh2;

/**
*@author 段道博
*@date 2019年12月11日下午2:28:33
*@Description	对结果进行封装
*/
public class Result {
	private boolean success;
	
	private String result;
	
	private Exception excetion;
	
	public Result(boolean success) {
		this.success = success;
	}
	
	public Result(boolean success, String result) {
		this.success = success;
		this.result = result;
	}
	
	@Override
	public String toString() {
		return "Result [success=" + success + ", result=" + result + ", excetion=" + excetion + "]";
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Exception getExcetion() {
		return excetion;
	}

	public void setExcetion(Exception excetion) {
		this.excetion = excetion;
	}

	public Result(Exception excetion) {
		this.success = false;
		this.excetion = excetion;
	}
	

}
