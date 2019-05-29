package www.web1.javaBean;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class NewsCon {
	int id;
	String content;
	Date date;
	public NewsCon(int id, String content, Date date) {
		super();
		this.id = id;
		this.content = content;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDateString(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy 'at' hh:mm:ss a zzz");
		return dateFormat.format(date);
	}
	
}
