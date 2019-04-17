package www.web1.mapper;

import www.web1.javaBean.User;

public interface UserMapper {
	public User getByID(int ID);//通过ID获得user
	public User getByEmail(String email);//通过email获得user
	public User getByNickname(String nickname);//通过nickname获得User
	public void addUser(User user);//添加user
	public void updateUser(User user);
}
