package www.web1.mapper;

import java.util.List;

import www.web1.javaBean.Draft;
import www.web1.javaBean.Essay;

public interface EssayDraftMapper {
	public Essay eGetByPid(int pid);//获得文章通过pid
	public List<Essay> getEssays();//获得所有文章
	public List<Essay> getEssaysTop6();//获得浏览前六的文章
	public List<Essay> getEssaysTop62();//获得点赞前六的文章
	public List<Essay> getEssayByType(String type);//获得所有该种类型文章
	public List<Essay> getEssayByID(int ID);//通过userID获得文章
	public List<Draft> getDrafts();//获得所有草稿
	public List<Draft> getDraftByID(int ID);//通过userID获得草稿
	public void addDraft(Draft draft);
	public void addEssay(Essay essay);
	public void updateDraft(Draft draft);
	public void updateEssay(Essay essay);
	public void deleteDraft(int pid);
	public List<Essay> getByFanID(int ID);
}
