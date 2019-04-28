package www.web1.javaBean;
import java.io.File;

public class User {
	private int ID;//id
	private String nickname;//昵称
	private String password;//密码
	private int age;//年龄
	private String profession;//职业
	private String tele;//电话
	private String email;//邮箱
	private String habby;//爱好
	private String autograph;//签名
	private String PathOfBg;//背景图片路径
	private String PathOfHead;//头像图片路径
	public User(){
		
	}
	public User(int ID, String nickname, String password, 
		int age, String profession, String tele, String email
		,String habby, String autograph, String PathOfBg, String PathOfHead
	){
		this.ID = ID;
		this.nickname = nickname;
		this.password = password;
		this.age = age;
		this.profession = profession;
		this.tele = tele;
		this.email = email;
		this.habby = habby;
		this.autograph = autograph;
		this.PathOfBg = PathOfBg;
		this.PathOfHead = PathOfHead;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHabby() {
		return habby;
	}
	public void setHabby(String habby) {
		this.habby = habby;
	}
	public String getAutograph() {
		return autograph;
	}
	public void setAutograph(String autograph) {
		this.autograph = autograph;
	}
	public String getPathOfBg() {
		return PathOfBg;
	}
	public void setPathOfBg(String pathOfBg) {
		PathOfBg = pathOfBg;
	}
	public String getPathOfHead() {
		return PathOfHead;
	}
	public void setPathOfHead(String pathOfHead) {
		PathOfHead = pathOfHead;
	}
	@Override
	public String toString() {
		return "User [ID=" + ID + ", nickname=" + nickname + ", password=" + password + ", age=" + age + "]";
	}
	
	
	
}
