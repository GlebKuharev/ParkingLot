package bean;

public class Vehicle {
	
	private Type type;
	private String regNo;
	
	public Vehicle (Type type, String regNo) {
		super();
		this.type = type;
		this.regNo = regNo;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	@Override
	public String toString() {
		return "Vehicle [type=" + type + ", regNo=" + regNo + "]";
	}

}
