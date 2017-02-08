package dao;

import java.util.Map;

import bean.Size;
import bean.Slot;

public interface SlotDAO {
	String addSlot(Slot slot);
	Slot findSlot(Size size, boolean isCovered);
	void removeSlot(Slot slot);
	Slot getSlot(int slotNumber);
	Map<Integer, Slot> getSlotCollection();

}
