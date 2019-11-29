package pojo;

public class AddTab {
	private String aid;
	private String add1;
	private Integer tid;
	public String getAid() {
		return aid;
	}
	public String getAdd1() {
		return add1;
	}
	public void setAdd1(String add1) {
		this.add1 = add1;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	@Override
	public String toString() {
		return "AddTab [aid=" + aid + ", add1=" + add1 + ", tid=" + tid + "]";
	}

}
