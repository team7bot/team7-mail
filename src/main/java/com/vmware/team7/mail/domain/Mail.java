package com.vmware.team7.mail.domain;

public class Mail {
	private long id;

	private String from;
	private String to;
	private String cc;
	private String subject;
	private String body;
	private String bodyFormat = "string";

	public String getBody() {
		return body;
	}

	public String getBodyFormat() {
		return bodyFormat;
	}

	public String getCc() {
		return cc;
	}

	public String getFrom() {
		return from;
	}

	public long getId() {
		return id;
	}

	public String getSubject() {
		return subject;
	}

	public String getTo() {
		return to;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setBodyFormat(String bodyFormat) {
		this.bodyFormat = bodyFormat;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return "Mail [id=" + id + ", from=" + from + ", to=" + to
				+ ", subject=" + subject + ", bodyFormat=" + bodyFormat + "]";
	}

}
