package dao.impl;

import java.util.HashMap;
import java.util.Map;

import bean.Size;
import bean.Slot;
import dao.SlotDAO;

public class CollectionSlotDAO implements SlotDAO {

	private static final Map<Integer, Slot> slotMap = new HashMap<Integer, Slot>(); 

	@Override
	public String addSlot(Slot slot) {
		
		int number = slot.getNumber();
		boolean flag = true;
		for (Map.Entry<Integer, Slot> entry : slotMap.entrySet()) {
			int key = entry.getKey(); 
			if (number == key)
				flag = false;
		}

		if (flag) {
			slotMap.put(slot.getNumber(), slot);
			return "slot added:\n" + slot + "\n";
		}
		else
			return "slot with such no. already exists";
	}

	@Override
	public Slot findSlot(Size size, boolean isCovered) {
		Slot slot = null;
		for (Map.Entry<Integer, Slot> entry : slotMap.entrySet()) {
			if (entry != null && entry.getValue().getSize().equals(size) && entry.getValue().isCovered()) {
				slot = entry.getValue();
				return slot;
			}
		}
		return slot;
	}

	@Override
	public void removeSlot(Slot slot) {
		slotMap.remove(slot.getNumber());
		
	}

	@Override
	public Slot getSlot(int slotNumber) {
		return slotMap.get(slotNumber);
	}

	@Override
	public Map<Integer, Slot> getSlotCollection() {
		
		return slotMap;
	}



}
