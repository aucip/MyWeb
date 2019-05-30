package www.web1.test;

import www.web1.javaBean.User;
import www.web1.utils.EmailUtils;

public class Test {
	static User user = new User(1, "nick", "123", 18, "教授", "18766445544", "876475897@qq.com", "篮球", "签名", "", "");
	
	public static void main(String[] args) {
		//EmailUtils.sendAccountActivateEmail(user);
		System.out.println(user.randomUUID());
	}
}
