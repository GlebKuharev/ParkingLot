package dao.impl;

import dao.SlotDAO;
import dao.SlotReservationDAO;
import dao.VehicleDAO;

public final class DAOFactory {
	private static final DAOFactory instance = new DAOFactory(); 

	private final SlotDAO slotDAOImpl = new CollectionSlotDAO();
	private final VehicleDAO vehicleDAOImpl = new CollectionVehicleDAO();
	private final SlotReservationDAO slotReservationDAOImpl = new CollectionSlotReservationDAO();
	
	private DAOFactory(){} 
	
	public static DAOFactory getInstance(){ 
		return instance;
	}

	public SlotDAO getSlotDAO() {
		return slotDAOImpl;
	}

	public VehicleDAO getVehicleDAO() {
		return vehicleDAOImpl;
	}

	public SlotReservationDAO getSlotReservationDAO() {
		return slotReservationDAOImpl;
	}


}
