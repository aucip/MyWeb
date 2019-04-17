package www.web1.mapper;

import java.util.List;

import www.web1.javaBean.User;
import www.web1.javaBean.UserRel;

public interface UserMapper {
	public User getByID(int ID);//通过ID获得user
	public User getByEmail(String email);//通过email获得user
	public User getByNickname(String nickname);//通过nickname获得User
	public void addUser(User user);//添加user
	public void updateUser(User user);
	public List<UserRel> getByFanID(int FanID);//获得关注的人的ID
	public List<UserRel> getFanByID(int ID);//获得所有粉丝ID
	public void deleteUserRel(UserRel ur);
	public void addUserRel(UserRel ur);
}
