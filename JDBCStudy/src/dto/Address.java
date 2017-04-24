package dto;

public class Address extends Tableid {
	private String address;
	private String testjdbc_name;
	@Override
	public String toString() {
		return "Address [address=" + address + ", testjdbc_name=" + testjdbc_name + ", id=" + id + "]";
	}

}
