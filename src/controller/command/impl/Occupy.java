package controller.command.impl;

import java.util.StringTokenizer;

import bean.Slot;
import bean.Vehicle;
import controller.command.Command;
import service.SlotService;
import service.VehicleService;
import service.factory.ServiceFactory;

public class Occupy implements Command {


	@Override
	public String execute(String request) {

		StringTokenizer tokens = new StringTokenizer(request, " ");
		int slotNumber = Integer.valueOf(tokens.nextToken());
		String regNo = tokens.nextToken().toUpperCase();

		ServiceFactory serviceFactory = ServiceFactory.getInstance(); 

		VehicleService vs = serviceFactory.getVehicleService();
		Vehicle vehicle = vs.getVehicle(regNo);

		SlotService slotService = serviceFactory.getSlotService();
		Slot slot = slotService.getSlot(slotNumber);

		String response = slotService.occupy(vehicle, slot);
		return response;
	} 


}
