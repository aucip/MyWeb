package www.web1.javaBean;

public class Comment {
	private String ID;//被评论者ID
	private String Headline;//被评论文章题目
	private String CommenterID;//评论者id
	private String content;//评论内容
	public Comment() {
		super();
	}
	public Comment(String iD, String headline, String commenterID, String content) {
		super();
		ID = iD;
		Headline = headline;
		CommenterID = commenterID;
		this.content = content;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getHeadline() {
		return Headline;
	}
	public void setHeadline(String headline) {
		Headline = headline;
	}
	public String getCommenterID() {
		return CommenterID;
	}
	public void setCommenterID(String commenterID) {
		CommenterID = commenterID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
