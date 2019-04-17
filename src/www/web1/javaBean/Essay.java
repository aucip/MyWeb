package www.web1.javaBean;

import java.sql.Date;

public class Essay {
	private int pid;
	private int ID;
	private String headline;
	private String type;//{"小说","随笔","散文","作文","日记","知识"}
	private String content;
	private Date date;
	private int skim;//浏览
	private int thump;//点赞
	
	public Essay() {
		super();
	}

	public Essay(Draft draft, String type){
		this.pid = draft.getPid();
		this.ID = draft.getID();
		this.headline = draft.getHeadline();
		this.type = type;
		this.content = draft.getContent();
		this.skim = 0;
		this.thump = 0;
	}
	
	public Essay(int pid, int iD, String headline, String type, String content, int skim, int thump) {
		super();
		this.pid = pid;
		ID = iD;
		this.headline = headline;
		this.type = type;
		this.content = content;
		this.skim = skim;
		this.thump = thump;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getSkim() {
		return skim;
	}

	public void setSkim(int skim) {
		this.skim = skim;
	}

	public int getThump() {
		return thump;
	}

	public void setThump(int thump) {
		this.thump = thump;
	}

	@Override
	public String toString() {
		return "Essay [pid=" + pid + ", ID=" + ID + ", headline=" + headline + ", type=" + type + ", content=" + content
				+ ", skim=" + skim + ", thump=" + thump + "]";
	}
	
}
