package service.impl;

import bean.SlotReservation;
import bean.Type;
import bean.Vehicle;
import dao.SlotDAO;
import dao.SlotReservationDAO;
import dao.impl.DAOFactory;

import java.util.Date;
import java.util.List;
import java.util.Map;

import bean.Size;
import bean.Slot;
import service.SlotService;

public class SlotServiceImpl implements SlotService {

	@Override
	public String addSlot(Slot slot) {
		DAOFactory daoObjectFactory = DAOFactory.getInstance(); 
		SlotDAO slotDAO = daoObjectFactory.getSlotDAO(); 
		return slotDAO.addSlot(slot);
	}

	@Override
	public Slot findFreeSlot(Type type, boolean isCovered) {

		DAOFactory daoObjectFactory = DAOFactory.getInstance(); 
		SlotDAO slotDAO = daoObjectFactory.getSlotDAO(); 
		SlotReservationDAO slotReservationDAO = daoObjectFactory.getSlotReservationDAO(); 

		Size size;
		if (type.equals(Type.CAR))
			size = Size.REGULAR;
		else 
			size= Size.SMALL;

		Map<Integer, Slot> slotMap = slotDAO.getSlotCollection();
		List<SlotReservation> slotReservationList = slotReservationDAO.getSlotReservationCollection();

		Slot slot = null;

		for (Map.Entry<Integer, Slot> entry : slotMap.entrySet()) {
			Slot sl = entry.getValue();

			boolean isReserved = false;
			if (sl.isCovered() == isCovered && sl.getSize().equals(size)) {
				for (SlotReservation sr: slotReservationList) {
					if (sl == sr.getSlot()) {
						isReserved = true;
						break;
					}
				}
				if (!isReserved) {
					return sl;
				}

			}
		}
		return slot;
	}

	@Override
	public String occupy(Vehicle vehicle, Slot slot) {

		SlotReservation sr = new SlotReservation(slot, vehicle, new Date().getTime());

		DAOFactory daoObjectFactory = DAOFactory.getInstance(); 

		if (vehicle == null)
			return "this vehicle is not registered in the system, please register it first";

		if (slot == null)
			return "there is no such slot in the parking lot";

		if (!vehicle.getType().equals(Type.CAR)&&slot.getSize().equals(Size.REGULAR) || 
				!vehicle.getType().equals(Type.MOTORCYCLE)&&slot.getSize().equals(Size.SMALL))
			return "you have chosen incorrect slot size";

		SlotReservationDAO slotReservationDAO = daoObjectFactory.getSlotReservationDAO(); 
		String response = slotReservationDAO.addSlotReservation(sr);
		return response;
	}

	@Override
	public String getSlotsStatistics() {

		DAOFactory daoObjectFactory = DAOFactory.getInstance(); 

		SlotDAO slotDAO = daoObjectFactory.getSlotDAO(); 
		Map<Integer, Slot> slotMap = slotDAO.getSlotCollection();

		int totalSlots = slotMap.size();
		int regularSlots = 0;

		for (Map.Entry<Integer, Slot> entry : slotMap.entrySet()) {
			if (entry.getValue().getSize().equals(Size.REGULAR))
				regularSlots++;
		}
		int smallSlots = totalSlots - regularSlots;

		SlotReservationDAO slotReservationDAO = daoObjectFactory.getSlotReservationDAO(); 
		List<SlotReservation> slotReservationList = slotReservationDAO.getSlotReservationCollection();

		int occupiedSlots = slotReservationList.size(); 
		int occupiedRegularSlots = 0;

		for (SlotReservation sr: slotReservationList) {
			if (sr.getSlot().getSize().equals(Size.REGULAR))
				occupiedRegularSlots++;
		}
		int occupiedSmallSlots = occupiedSlots - occupiedRegularSlots;
		StringBuilder response = new StringBuilder();
		response.append("Total slots: " + totalSlots + "\n");
		response.append("Total occupied slots: " + occupiedSlots + "\n");
		response.append("Total regular slots: " + (regularSlots) + "\n");
		response.append("Occupied regular slots: " + occupiedRegularSlots + "\n");
		response.append("Total small slots: " + (smallSlots) + "\n");
		response.append("Occupied small slots: " + occupiedSmallSlots + "\n");
		return response.toString();
	}

	@Override
	public SlotReservation getCurrentSlotReservation(Vehicle vehicle) {
		DAOFactory daoObjectFactory = DAOFactory.getInstance(); 
		SlotReservationDAO slotReservationDAO = daoObjectFactory.getSlotReservationDAO(); 
		SlotReservation sr = slotReservationDAO.getCurrentSlotReservation(vehicle);

		return sr;
	}

	@Override
	public SlotReservation freeSlotReservation(SlotReservation sr) {
		if (sr.getEndTime() == 0)
		{
			sr.setEndTime(new Date().getTime());
		}
		return sr;
	}

	@Override
	public Slot getSlot(int slotNumber) {
		DAOFactory daoObjectFactory = DAOFactory.getInstance(); 
		SlotDAO slotDAO = daoObjectFactory.getSlotDAO(); 
		return slotDAO.getSlot(slotNumber);
	}


}
