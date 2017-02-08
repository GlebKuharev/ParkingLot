package controller;

import java.util.HashMap;
import java.util.Map;

import controller.command.Command;
import controller.command.CommandName;
import controller.command.impl.AddSlot;
import controller.command.impl.RegisterVehicle;
import controller.command.impl.Exit;
import controller.command.impl.FindFreeSlot;
import controller.command.impl.FreeSlotReservation;
import controller.command.impl.GetCurrentSlotReservation;
import controller.command.impl.GetSlotsStatistics;
import controller.command.impl.GetVehicle;
import controller.command.impl.Occupy;
import controller.command.impl.WrongRequest;

public class CommandProvider {

	private final Map<CommandName, Command> repository = new HashMap<>();
	
	CommandProvider() { 
		repository.put(CommandName.GET_VEHICLE, new GetVehicle()); 
		repository.put(CommandName.REGISTER_VEHICLE, new RegisterVehicle()); 
		repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
		repository.put(CommandName.ADD_SLOT, new AddSlot());
		repository.put(CommandName.FIND_FREE_SLOT, new FindFreeSlot());
		repository.put(CommandName.OCCUPY_SLOT, new Occupy());
		repository.put(CommandName.GET_SLOTS_STATISTICS, new GetSlotsStatistics());
		repository.put(CommandName.GET_CURRENT_SLOT_RESERVATION, new GetCurrentSlotReservation());
		repository.put(CommandName.FREE_SLOT_RESERVATION, new FreeSlotReservation());
		repository.put(CommandName.EXIT, new Exit());
	}

	Command getCommand(String name){ 
		CommandName commandName = null; 
		Command command = null;
		try{
			commandName = CommandName.valueOf(name.toUpperCase()); 
			command = repository.get(commandName); 
		}catch(IllegalArgumentException | NullPointerException e){ 
			command = repository.get(CommandName.WRONG_REQUEST);
		}
		return command;
	}

}
