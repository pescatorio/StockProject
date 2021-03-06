package VO;

public class ManufacturerVO {

	private int manufacturer_id;
	private String manufacturer_phonenumber;
	private String manufacturer_name;

	public int getManufacturer_id() {
		return manufacturer_id;
	}

	public void setManufacturer_id(int manufacturer_id) {
		this.manufacturer_id = manufacturer_id;
	}

	public String getManufacturer_phonenumber() {
		return manufacturer_phonenumber;
	}

	public void setManufacturer_phonenumber(String manufacturer_phonenumber) {
		this.manufacturer_phonenumber = manufacturer_phonenumber;
	}

	public String getManufacturer_name() {
		return manufacturer_name;
	}

	public void setManufacturer_name(String manufacturer_name) {
		this.manufacturer_name = manufacturer_name;
	}

	@Override
	public String toString() {
		return "ManufacturerVO [manufacturer_id=" + manufacturer_id
				+ ", manufacturer_phonenumber=" + manufacturer_phonenumber
				+ ", manufacturer_name=" + manufacturer_name + "]";
	}

	public ManufacturerVO(int manufacturer_id, String manufacturer_phonenumber,
			String manufacturer_name) {
		super();
		this.manufacturer_id = manufacturer_id;
		this.manufacturer_phonenumber = manufacturer_phonenumber;
		this.manufacturer_name = manufacturer_name;
	}

	public ManufacturerVO(){}
}
//13????