package VO;

public class ProductVO {

	private int product_id;
	private String product_name;
	private int manufacturer_id;
	private String price_number;
	private String stock;
	private String status;
	
	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getPrice_number() {
		return price_number;
	}

	public void setPrice_number(String price_number) {
		this.price_number = price_number;
	}


	public int getManufacturer_id() {
		return manufacturer_id;
	}

	public void setManufacturer_id(int manufacturer_id) {
		this.manufacturer_id = manufacturer_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	

	public ProductVO(int product_id, String product_name, int manufacturer_id,
			String price_number, String stock) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.manufacturer_id = manufacturer_id;
		this.price_number = price_number;
		this.stock = stock;
	}

	
	
	public ProductVO(int product_id, String product_name, int manufacturer_id,
			String price_number, String stock, String status) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.manufacturer_id = manufacturer_id;
		this.price_number = price_number;
		this.stock = stock;
		this.status = status;
	}

	@Override
	public String toString() {
		return "ProductVO [product_id=" + product_id + ", stock=" + stock + "]";
	}
	
	public ProductVO(){}//기본생성자
// 13 버전입니다.
}
