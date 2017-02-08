package service.impl;

import bean.Vehicle;
import dao.VehicleDAO;
import dao.impl.DAOFactory;
import service.VehicleService;

public class VehicleServiceImpl implements VehicleService {

	@Override
	public Vehicle getVehicle(String regNo) {
		DAOFactory daoObjectFactory = DAOFactory.getInstance(); 
		VehicleDAO vehicleDAO = daoObjectFactory.getVehicleDAO(); 
		Vehicle vehicle = vehicleDAO.getVehicle(regNo);
		return vehicle;
	}

	@Override
	public String createVehicle(Vehicle vehicle) {
		DAOFactory daoObjectFactory = DAOFactory.getInstance(); 
		VehicleDAO vehicleDAO = daoObjectFactory.getVehicleDAO(); 	
		return vehicleDAO.addVehicle(vehicle);
		
	}
	
	

}
