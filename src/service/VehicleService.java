package service;

import bean.Vehicle;

public interface VehicleService {
	Vehicle getVehicle(String regNo);
	String createVehicle(Vehicle vehicle);

}
