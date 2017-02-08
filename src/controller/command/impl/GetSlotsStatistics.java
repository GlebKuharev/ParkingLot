package controller.command.impl;


import controller.command.Command;
import service.SlotService;
import service.factory.ServiceFactory;

public class GetSlotsStatistics implements Command {
	@Override
	public String execute(String request) {

		ServiceFactory serviceFactory = ServiceFactory.getInstance(); 
		
		SlotService slotService = serviceFactory.getSlotService();
		String response = slotService.getSlotsStatistics();
		
		return response;
	} 
	

}
