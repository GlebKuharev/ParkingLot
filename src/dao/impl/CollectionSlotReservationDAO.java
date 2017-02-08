package dao.impl;

import java.util.ArrayList;
import java.util.List;

import bean.SlotReservation;
import bean.Vehicle;
import dao.SlotReservationDAO;

public class CollectionSlotReservationDAO implements SlotReservationDAO {
	
	private static final List<SlotReservation> slotReservationList = new ArrayList<>(); 
	
	@Override
	public SlotReservation getCurrentSlotReservation(Vehicle vehicle) {
		SlotReservation slotReservation = null;
		for (SlotReservation sr: slotReservationList) {
			if (sr.getVehicle() == vehicle && sr.getEndTime() == 0) {
				slotReservation = sr;
				break;
			}
		}
		return slotReservation;
	}

	@Override
	public String addSlotReservation(SlotReservation sr) {
		for (SlotReservation slotReservation: slotReservationList) {
			if (slotReservation.getVehicle() == sr.getVehicle() && slotReservation.getEndTime() == 0) {
				return "you already have active reservation: slot " + slotReservation.getSlot().getNumber();
			}
		}
		slotReservationList.add(sr);
		return "SlotReservation added";
		
	}

	@Override
	public List<SlotReservation> getSlotReservationCollection() {
		return slotReservationList;
	}

}
