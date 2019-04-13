package www.web1.javaBean;

public class Comment {
	private int pid;//评论pid
	private int essayPid;//被评论文章ID
	private int ID;//评论者id
	private String content;//评论内容
	
	public Comment() {
		super();
	}

	public Comment(int pid, int essayPid, int iD, String content) {
		super();
		this.pid = pid;
		this.essayPid = essayPid;
		ID = iD;
		this.content = content;
	}
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getEssayPid() {
		return essayPid;
	}
	public void setEssayPid(int essayPid) {
		this.essayPid = essayPid;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Comment [pid=" + pid + ", essayPid=" + essayPid + ", ID=" + ID + ", content=" + content + "]";
	}
	
}
