package bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SlotReservation {
	
	Slot slot;
	Vehicle vehicle;
	long startTime;
	long endTime = 0;
	
	public SlotReservation(Slot slot, Vehicle vehicle, long startTime) {
		super();
		this.slot = slot;
		this.vehicle = vehicle;
		this.startTime = startTime;
	}

	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "SlotReservation [slot=" + slot + ", vehicle=" + vehicle + ", startTime= " + new SimpleDateFormat("H:mm:ss MM-dd-yyyy").format(new Date(startTime)) + ", endTime= "
				+ new SimpleDateFormat("H:mm:ss MM-dd-yyyy").format(new Date(endTime)) + "]";
	}
	

}
