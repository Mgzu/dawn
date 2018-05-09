package org.dawn.dto;

/**
 * json 返回数据封装类
 */
public class RestDto {

	private boolean success;
	private int strutsCode;
	private Object data;
	private String msg;

	/**
	 * 成功
	 */
	public RestDto() {
		super();
		this.success = true;
		this.strutsCode = 200;
		this.msg = "成功！";
	}

	/**
	 * 成功（有数据）
	 */
	public RestDto(Object data) {
		super();
		this.success = true;
		this.strutsCode = 200;
		this.data = data;
		this.msg = "成功！";
	}

	/**
	 * 失败
	 */
	public RestDto(int strutsCode, String msg) {
		super();
		this.success = false;
		this.strutsCode = strutsCode;
		this.msg = msg;
	}

	public RestDto(int strutsCode, boolean success, Object data, String msg) {
		super();
		this.success = success;
		this.strutsCode = strutsCode;
		this.data = data;
		this.msg = msg;
	}

	public int getStrutsCode() {
		return strutsCode;
	}

	public void setStrutsCode(int strutsCode) {
		this.strutsCode = strutsCode;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
