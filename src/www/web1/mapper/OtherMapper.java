package www.web1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import www.web1.javaBean.Comment;
import www.web1.javaBean.NewsCon;
import www.web1.javaBean.User;

public interface OtherMapper {
	public List<Comment> getByEssayPid(int essayPid);
	public void insertComment(Comment comment);
	public List<User> getNewsList(int id);
	public List<NewsCon> getUsersNews(@Param("usera_id")int usera_id, @Param("userb_id")int userb_id);
	public void addNews(@Param("usera_id")int usera_id, @Param("userb_id")int userb_id, @Param("content")String content);
}
