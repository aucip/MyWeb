package www.web1.mapper;

import java.util.List;

import www.web1.javaBean.Comment;

public interface OtherMapper {
	public List<Comment> getByEssayPid(int essayPid);
	public void insertComment(Comment comment);
}
