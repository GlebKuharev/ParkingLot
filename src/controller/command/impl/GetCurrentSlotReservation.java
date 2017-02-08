package controller.command.impl;

import java.util.StringTokenizer;

import bean.SlotReservation;
import bean.Vehicle;
import controller.command.Command;
import service.SlotService;
import service.VehicleService;
import service.factory.ServiceFactory;

public class GetCurrentSlotReservation implements Command {

	@Override
	public String execute(String request) {

		StringTokenizer tokens = new StringTokenizer(request, " ");
		String regNo = tokens.nextToken().toUpperCase();
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance(); 
		
		VehicleService vehicleService = serviceFactory.getVehicleService();
		Vehicle vehicle = vehicleService.getVehicle(regNo);
		SlotService slotService = serviceFactory.getSlotService();
		
		
		SlotReservation sr = slotService.getCurrentSlotReservation(vehicle);
		
		if (sr != null)
			return "Current slot reservation: \n" + sr.toString();
		else
			return "There's no current reservation for this vehicle";
	}
}
