package www.web1.javaBean;
import java.io.File;

public class User {
	private String ID;//id
	private String nickname;//昵称
	private String password;//密码
	private int age;//年龄
	private String prfession;//职业
	private String tele;//电话
	private String email;//邮箱
	private String habby;//爱好
	private String autograph;//签名
	private File PathOfBg;//背景图片路径
	private File PathOfHead;//头像图片路径
	public User(){
		
	}
	public User(String ID, String nickname, String password, 
		int age, String prfession, String tele, String email
		,String habby, String autograph, File PathOfBg, File PathOfHead
	){
		this.ID = ID;
		this.nickname = nickname;
		this.password = password;
		this.age = age;
		this.prfession = prfession;
		this.tele = tele;
		this.email = email;
		this.habby = habby;
		this.autograph = autograph;
		this.PathOfBg = PathOfBg;
		this.PathOfHead = PathOfHead;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
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
	public String getPrfession() {
		return prfession;
	}
	public void setPrfession(String prfession) {
		this.prfession = prfession;
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
	public File getPathOfBg() {
		return PathOfBg;
	}
	public void setPathOfBg(File pathOfBg) {
		PathOfBg = pathOfBg;
	}
	public File getPathOfHead() {
		return PathOfHead;
	}
	public void setPathOfHead(File pathOfHead) {
		PathOfHead = pathOfHead;
	}

	
}
