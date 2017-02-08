package controller.command.impl;

import java.util.StringTokenizer;

import bean.Slot;
import bean.Type;
import controller.command.Command;
import service.SlotService;
import service.factory.ServiceFactory;

public class FindFreeSlot implements Command {

	@Override
	public String execute(String request) {

		StringTokenizer tokens = new StringTokenizer(request, " ");
		Type type = Type.valueOf(tokens.nextToken().toUpperCase());
		String cover = tokens.nextToken().toUpperCase();
		Boolean isCovered;
		if (cover.equals("TRUE"))
			isCovered = true;
		else if (cover.equals("FALSE"))
			isCovered = false;
		else return "wrong isCovered parameter input";

		ServiceFactory serviceFactory = ServiceFactory.getInstance(); 
		SlotService slotService = serviceFactory.getSlotService();

		Slot slot = slotService.findFreeSlot(type, isCovered); 

		if (slot != null)
			return "Free slot: \n" + slot;
		else
			return "Sorry, there are no such slots available";
	}

}
