package org.dawn.dto;

public class Greeting {
	private String content;
	private String userNum;

	public Greeting() {
	}

	public Greeting(String content, String userNum) {
		super();
		this.content = content;
		this.userNum = userNum;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserNum() {
		return userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}

}
