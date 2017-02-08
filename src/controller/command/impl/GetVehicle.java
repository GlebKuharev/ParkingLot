package controller.command.impl;

import java.util.StringTokenizer;

import bean.Vehicle;
import controller.command.Command;
import service.VehicleService;
import service.factory.ServiceFactory;

public class GetVehicle implements Command {
	
	public String execute (String request) {

		StringTokenizer tokens = new StringTokenizer(request, " ");
		String regNo = tokens.nextToken();

		ServiceFactory serviceFactory = ServiceFactory.getInstance(); 
		VehicleService vehicleService = serviceFactory.getVehicleService();
		Vehicle vehicle = vehicleService.getVehicle(regNo); 
		
		if (vehicle == null)
			return "there is no such vehicle in the system";
		
		return vehicle.toString();

	}
}
