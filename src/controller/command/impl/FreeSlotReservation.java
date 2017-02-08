package controller.command.impl;

import java.text.DecimalFormat;
import java.util.StringTokenizer;

import bean.SlotReservation;
import bean.Vehicle;
import controller.command.Command;
import service.CostService;
import service.SlotService;
import service.VehicleService;
import service.factory.ServiceFactory;

public class FreeSlotReservation implements Command {

	@Override
	public String execute(String request) {
		
		StringTokenizer tokens = new StringTokenizer(request, " ");
		String regNo = tokens.nextToken().toUpperCase();

		ServiceFactory serviceFactory = ServiceFactory.getInstance(); 

		VehicleService vehicleService = serviceFactory.getVehicleService();
		Vehicle vehicle = vehicleService.getVehicle(regNo);

		SlotService slotService = serviceFactory.getSlotService();
		SlotReservation sr = slotService.getCurrentSlotReservation(vehicle);
		
		if (sr == null)
			return "there is no such reservation available";
		
		SlotReservation freeSR = slotService.freeSlotReservation(sr);
		
		//now that the slot reservation was freed, we can calculate the costs:
		CostService cs = serviceFactory.getCostService();
		double cost = cs.getOccupationCost(freeSR);
		
		//preparing output
		DecimalFormat df = new DecimalFormat("####0.00$");
		String sCost = df.format(cost);
		StringBuilder sb = new StringBuilder();
		sb.append("Reservation freed: \n");
		sb.append(freeSR + "\n");
		sb.append("Cost: " + sCost);
		String response = sb.toString();

			return response;
	}
	
}
