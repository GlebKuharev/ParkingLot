package service.impl;

import bean.SlotReservation;
import bean.Type;
import service.CostService;

public class CostServiceImpl implements CostService {

	@Override
	public Double getOccupationCost(SlotReservation sr) {

		int shortDuration = 4;
		int dayDuration = 24;
		
		double shortDurationRate = 1.5,
		dayDurationRate = 1.2,
		longDurationRate = 1,
		basePrice = 0.5,
		motorCycleRate = 0.7,
		carRate = 1,
		isCoveredRate = 1.2,
		isOpenRate = 1.0,
		durationRate,
		coverRate,
		typeRate;
		
		double time = (sr.getEndTime()- sr.getStartTime()) / (double) 3600000;
		
		if (time < shortDuration)
			durationRate = shortDurationRate;
		else if (time < dayDuration)
			durationRate = dayDurationRate;
		else 
			durationRate = longDurationRate;
		
		if (sr.getSlot().isCovered()) 
			coverRate = isCoveredRate;
		else
			coverRate = isOpenRate;
		
		if (sr.getVehicle().getType().equals(Type.CAR))
			typeRate = carRate;
		else
			typeRate = motorCycleRate;
		
		double cost = durationRate * coverRate * typeRate * time * basePrice;
		
		return cost;
	}

}
