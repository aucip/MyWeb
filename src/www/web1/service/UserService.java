package www.web1.service;

import org.springframework.stereotype.Service;

import www.web1.javaBean.User;
public interface UserService {
	public int register(User user);
	public User checklogin(String email, String password);
}
