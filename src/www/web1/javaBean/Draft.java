package www.web1.javaBean;

public class Draft {
	private String ID;
	private String headline;
	private String content;
	public Draft(){
		ID = null;
		this.headline = null;
		this.content = null;
	}
	public Draft(String ID, String headline, String content){
		this.ID = ID;
		this.headline = headline;
		this.content = content;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
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
	
}
