package dao;

import java.util.List;

import bean.SlotReservation;
import bean.Vehicle;

public interface SlotReservationDAO {
	SlotReservation getCurrentSlotReservation(Vehicle vehicle);
	String addSlotReservation(SlotReservation sr);
	List<SlotReservation> getSlotReservationCollection();

}
