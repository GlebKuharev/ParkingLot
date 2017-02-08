package dao.impl;

import java.util.ArrayList;
import java.util.List;

import bean.Vehicle;
import dao.VehicleDAO;

public class CollectionVehicleDAO implements VehicleDAO{
	
	private static final List<Vehicle> vehicleList = new ArrayList<Vehicle>(); 

	@Override
	public Vehicle getVehicle(String regNo) {
		Vehicle vehicle = null;
		for (Vehicle v: vehicleList) {
			if (v.getRegNo().equals(regNo)) {
				vehicle = v;
				break;
			}
		}
		return vehicle;
	}

	@Override
	public String addVehicle(Vehicle vehicle) {
		for (Vehicle v: vehicleList) {
			if (v.getRegNo().equals(vehicle.getRegNo()))
			return "vehicle with this regNo is already registered";
		}
		vehicleList.add(vehicle);
		
		return "vehicle added";
		
	}

	@Override
	public List<Vehicle> getVehicleCollection() {
		return vehicleList;
	}
	
	

}
