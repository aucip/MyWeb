package www.web1.javaBean;

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
	private boolean actived;  //是否激活
    // 随机码(激活帐户与生成重设密码链接时使用)  
    private String randomCode;  

    
    public User() {
		super();
	}

	public User(int iD, String nickname, String password, int age, String profession, String tele, String email,
			String habby, String autograph, String pathOfBg, String pathOfHead) {
		super();
		ID = iD;
		this.nickname = nickname;
		this.password = password;
		this.age = age;
		this.profession = profession;
		this.tele = tele;
		this.email = email;
		this.habby = habby;
		this.autograph = autograph;
		PathOfBg = pathOfBg;
		PathOfHead = pathOfHead;
		this.actived = false;
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

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}

	public String getRandomCode() {
		return randomCode;
	}

	public void setRandomCode(String randomCode) {
		this.randomCode = randomCode;
	}

	public String randomUUID(){
    	int a = (int)(Math.random()*100000);
    	this.randomCode = String.valueOf(a);
    	return String.valueOf(a);
    }
}
