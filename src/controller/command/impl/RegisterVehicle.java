package controller.command.impl;

import java.util.StringTokenizer;

import bean.Type;
import bean.Vehicle;
import controller.command.Command;
import service.VehicleService;
import service.factory.ServiceFactory;

public class RegisterVehicle implements Command {

	public String execute (String request) {

		String response = null;

		StringTokenizer tokens = new StringTokenizer(request, " ");
		Type type = Type.valueOf(tokens.nextToken().toUpperCase());
		String regNo = tokens.nextToken().toUpperCase();
		Vehicle vehicle = new Vehicle(type, regNo);

		ServiceFactory serviceFactory = ServiceFactory.getInstance(); 
		VehicleService vehicleService = serviceFactory.getVehicleService();
		response = vehicleService.createVehicle(vehicle); 
		
		return response;

	}
}
