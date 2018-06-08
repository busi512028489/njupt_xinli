package Model;


public class StudentModel {
	String xh;
	String password;
	String name;
	String sex;
	String tel;
	String academy;
	String grade;
	String quanxian;
	
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAcademy() {
		return academy;
	}
	public void setAcademy(String academy) {
		this.academy = academy;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getQuanxian() {
		return quanxian;
	}
	public void setQuanxian(String quanxian) {
		this.quanxian = quanxian;
	}
	public StudentModel(){}
	public StudentModel(String xh, String name, String sex, String tel,
			String academy, String grade, String password, String quanxian) {
		this.xh = xh;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.tel = tel;
		this.academy = academy;
		this.grade = grade;
		this.quanxian = quanxian;
	}
	
}
