package bean;

public class Slot {
	private int number;
	private boolean isCovered;
	private Size size;
	
	public Slot(int number, Size size, boolean isCovered) {
		super();
		this.number = number;
		this.isCovered = isCovered;
		this.size = size;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isCovered() {
		return isCovered;
	}

	public void setCovered(boolean isCovered) {
		this.isCovered = isCovered;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Slot [number=" + number + ", isCovered=" + isCovered + ", size=" + size + "]";
	}
	
	
}
