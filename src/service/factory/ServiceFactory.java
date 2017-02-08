package service.factory;

import service.CostService;
import service.SlotService;
import service.VehicleService;
import service.impl.CostServiceImpl;
import service.impl.SlotServiceImpl;
import service.impl.VehicleServiceImpl;

public class ServiceFactory {
	private static ServiceFactory factory = new ServiceFactory();

	private final CostService costService = new CostServiceImpl();
	private final SlotService slotService = new SlotServiceImpl();
	private final VehicleService vehicleService = new VehicleServiceImpl();

	
	private ServiceFactory(){}
	
	public static ServiceFactory getInstance(){
		return factory;
	}

	public CostService getCostService() {
		return costService;
	}

	public SlotService getSlotService() {
		return slotService;
	}

	public VehicleService getVehicleService() {
		return vehicleService;
	}
	

	
	
}
