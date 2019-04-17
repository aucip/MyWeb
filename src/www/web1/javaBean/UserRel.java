package www.web1.javaBean;

public class UserRel {
	private int ID;
	private int fanID;
	
	public UserRel() {
		super();
	}

	public UserRel(int iD, int fanID) {
		super();
		ID = iD;
		this.fanID = fanID;
	}

	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public int getFanID() {
		return fanID;
	}

	public void setFanID(int fanID) {
		this.fanID = fanID;
	}

	@Override
	public String toString() {
		return "UserRel [ID=" + ID + ", fanID=" + fanID + "]";
	}
	
}
