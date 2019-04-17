package www.web1.javaBean;

import java.sql.Date;

public class Draft {
	private int pid;
	private int ID;
	private Date date;
	private String headline;
	private String content;
	
	public Draft() {
		super();
	}

	public Draft(int pid, int iD, String headline, String content) {
		super();
		this.pid = pid;
		ID = iD;
		this.headline = headline;
		this.content = content;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Draft [pid=" + pid + ", ID=" + ID + ", headline=" + headline + ", content=" + content + "]";
	}
	
}
