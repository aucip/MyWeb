package www.web1.javaBean;

import java.util.List;

public class News {
	int usera_id;
	int userb_id;
	List <NewsCon> newsCons;
	
	public News(int usera_id, int userb_id, List<NewsCon> newsCons) {
		super();
		this.usera_id = usera_id;
		this.userb_id = userb_id;
		this.newsCons = newsCons;
	}
	
	public int getUsera_id() {
		return usera_id;
	}
	
	public void setUsera_id(int usera_id) {
		this.usera_id = usera_id;
	}
	
	public int getUserb_id() {
		return userb_id;
	}
	
	public void setUserb_id(int userb_id) {
		this.userb_id = userb_id;
	}
	
	public List<NewsCon> getNewsCons() {
		return newsCons;
	}
	
	public void setNewsCons(List<NewsCon> newsCons) {
		this.newsCons = newsCons;
	}
	
}
