package mao.soft.web.dateuti;


public class UserDate {
	private String uname;//uname
	private String pic;//pic
	private String birth;//birth
	private String sex;//sex
	private String uphone;//uphone
	private String mail;//mail
	private String setadd;//setadd
	private String aid;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getSetadd() {
		return setadd;
	}
	public void setSetadd(String setadd) {
		this.setadd = setadd;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	@Override
	public String toString() {
		return "UserDate [uname=" + uname + ", pic=" + pic + ", birth=" + birth
				+ ", sex=" + sex + ", uphone=" + uphone + ", mail=" + mail
				+ ", setadd=" + setadd + ", aid=" + aid + "]";
	}
	
}
