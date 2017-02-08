package service;

import bean.SlotReservation;
import bean.Type;
import bean.Vehicle;
import bean.Slot;

public interface SlotService {
	String addSlot(Slot slot);
	Slot findFreeSlot(Type type, boolean isCovered);
	String occupy(Vehicle vehicle, Slot slot);
	String getSlotsStatistics();
	SlotReservation getCurrentSlotReservation(Vehicle vehicle);
	SlotReservation freeSlotReservation(SlotReservation sr);
	Slot getSlot(int slotNumber);

}
