package VO;

public class MyOrderVO {

	private int order_id;
	private int prouct_id;
	private int manufacturer_id;
	private int order_number;
	private String order_date;
	private String isStocked;
	
	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getProuct_id() {
		return prouct_id;
	}

	public void setProuct_id(int prouct_id) {
		this.prouct_id = prouct_id;
	}

	public int getManufacturer_id() {
		return manufacturer_id;
	}

	public void setManufacturer_id(int manufacturer_id) {
		this.manufacturer_id = manufacturer_id;
	}

	public int getOrder_number() {
		return order_number;
	}

	public void setOrder_number(int order_number) {
		this.order_number = order_number;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public String getIsStocked() {
		return isStocked;
	}

	public void setIsStocked(String isStocked) {
		this.isStocked = isStocked;
	}

	public MyOrderVO(int order_id, int prouct_id, int manufacturer_id,
			int order_number, String order_date, String isStocked) {
		super();
		this.order_id = order_id;
		this.prouct_id = prouct_id;
		this.manufacturer_id = manufacturer_id;
		this.order_number = order_number;
		this.order_date = order_date;
		this.isStocked = isStocked;
	}

	@Override
	public String toString() {
		return "MyOrderVO [order_id=" + order_id + ", prouct_id=" + prouct_id
				+ ", manufacturer_id=" + manufacturer_id + ", order_number="
				+ order_number + ", order_date=" + order_date + "]";
	}

	public MyOrderVO(int order_id, int prouct_id, int manufacturer_id,
			int order_number, String order_date) {
		super();
		this.order_id = order_id;
		this.prouct_id = prouct_id;
		this.manufacturer_id = manufacturer_id;
		this.order_number = order_number;
		this.order_date = order_date;
	}
	
	
	public MyOrderVO(){}
}
//13¹öÀü