package VO;

public class AdminVO {

	private int id;
	private String password;
    private boolean isAdmin;
	
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean getIsAdmin() {
		return isAdmin;
	}
	
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	@Override
	public String toString() {
		return "AdminVO [id=" + id + ", password=" + password + ", isAdmin="
				+ isAdmin + "]";
	}
	public AdminVO(int id, String password, boolean isAdmin) {
		super();
		this.id = id;
		this.password = password;
		this.isAdmin = isAdmin;
	}
	
	public AdminVO(){} 
}
//13¹öÀü