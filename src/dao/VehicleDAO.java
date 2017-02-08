package dao;

import java.util.List;

import bean.Vehicle;

public interface VehicleDAO {
	
	public Vehicle getVehicle(String regNo);
	public String addVehicle(Vehicle vehicle);
	List<Vehicle> getVehicleCollection();
}
