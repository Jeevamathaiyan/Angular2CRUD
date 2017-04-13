/**
 * 
 */
package com.angular.util;

/**
 * @author samy
 *
 */
public class Response {

	private Integer userId;
	
	private String msg = "";
	
	private boolean status = false;
	
	private Object data;
	
	public Response() {
	}

	public Response(Integer userId, String msg, boolean status, Object data) {
		super();
		this.userId = userId;
		this.msg = msg;
		this.status = status;
		this.data = data;
	}

	public Response(String msg, boolean status, Object data) {
		super();
		this.msg = msg;
		this.status = status;
		this.data = data;
	}

	public Response(boolean status, Object data) {
		super();
		this.status = status;
		this.data = data;
	}
	
	
	public Response(boolean status , Integer userId) {
		super();
		this.userId = userId;
		this.status = status;
	}

	public Response(boolean status) {
		super();
		this.status = status;
	}
	
	public Response(String msg, boolean status) {
		super();
		this.msg = msg;
		this.status = status;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Response [userId=" + userId + ", msg=" + msg + ", status="
				+ status + ", data=" + data + "]";
	}
}
