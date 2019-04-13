package www.web1.javaBean;

public class Eassy {
	private String ID;
	private String headline;
	private String type;
	private String content;
	private int skim;//浏览
	private int thump;//点赞
	public Eassy(){
		ID = null;
		this.headline = null;
		this.type = null;
		this.content = null;
		this.skim = 0;
		this.thump = 0;
	}
	public Eassy(String ID, String headline, String type, 
			String content, int skim, int thump){
		this.ID = ID;
		this.headline = headline;
		this.type = type;
		this.content = content;
		this.skim = skim;
		this.thump = thump;
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
	
}
