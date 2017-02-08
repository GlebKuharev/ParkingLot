package controller.command.impl;

import java.util.StringTokenizer;

import bean.Size;
import bean.Slot;
import controller.command.Command;
import service.SlotService;
import service.factory.ServiceFactory;

public class AddSlot implements Command {
	public String execute (String request) {

		String response = null;

			StringTokenizer tokens = new StringTokenizer(request, " ");
			int number = Integer.valueOf(tokens.nextToken());
			Size size = Size.valueOf(tokens.nextToken().toUpperCase());
			String cover = tokens.nextToken().toUpperCase();
			Boolean isCovered;
			if (cover.equals("TRUE"))
				isCovered = true;
			else if (cover.equals("FALSE"))
				isCovered = false;
			else return "wrong isCovered parameter input";
			
			Slot slot = new Slot(number, size, isCovered);

			ServiceFactory serviceFactory = ServiceFactory.getInstance(); 
			SlotService slotService = serviceFactory.getSlotService();
			response = slotService.addSlot(slot); 
			return response;

	}
}
