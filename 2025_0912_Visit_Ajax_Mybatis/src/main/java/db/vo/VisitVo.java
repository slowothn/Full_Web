package db.vo;

//VO(Value Object)
//DB Column == VO property == Form Parameter
public class VisitVo {

	int idx;
	String name;
	String content;
	String pwd;
	String ip;
	String regdate;
	
	
	
	public VisitVo() {
		// TODO Auto-generated constructor stub
	}


	//overload 생성자를 만들면 기본 생성자도 만들어야 함
	//insert
	public VisitVo(String name, String content, String pwd, String ip) {
		super();
		this.name = name;
		this.content = content;
		this.pwd = pwd;
		this.ip = ip;
	}
	
	//update
	public VisitVo(int idx, String name, String content, String pwd, String ip) {
		super();
		this.idx = idx;
		this.name = name;
		this.content = content;
		this.pwd = pwd;
		this.ip = ip;
	}
	
	
	
	//Alt+Shift+s 로 getter,setter 생성
	
	public int getIdx() {
		return idx;
	}


	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getRegdate() {
		return regdate;
		/* return regdate.substring(0, 16); */
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
	
}
