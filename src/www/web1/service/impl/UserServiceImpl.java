package www.web1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.web1.javaBean.User;
import www.web1.mapper.UserMapper;
import www.web1.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper um;
	
	@Override
	public int register(User user) {//检查邮箱和昵称是否已经占用0,1表示已经占用，2表示未占用
		// TODO Auto-generated method stub
		User u = um.getByEmail(user.getEmail());
		if(u == null) return 0;
		u = um.getByNickname(user.getNickname());
		if(u == null) return 1;
		um.addUser(user);
		return 2;
	}

	@Override
	public User checklogin(String email, String password) {
		// TODO Auto-generated method stub
		User user = um.getByEmail(email);
		if(user == null || !user.getPassword().equals(password)){
			return null;
		}else{
			return user;
		}
	}

}
