package runner;

import java.util.Scanner;

import controller.Controller;

public class Runner {
	public static void main(String[] args) {

		Controller controller = new Controller();

		addPredefinedSlots(controller);
		showCommandList();
		
		while (true) {
			System.out.println("Please enter command: ");
			Scanner input = new Scanner(System.in);
			String command = input.nextLine();
			String response = controller.executeTask(command);
			System.out.println(response);
		}
	}
	
	public static void addPredefinedSlots(Controller controller) {
		
	String command = "add_slot 1 regular true";
	String response = controller.executeTask(command);
	System.out.println(response);
	
	command = "add_slot 2 regular true";
	response = controller.executeTask(command);
	System.out.println(response);
	
	command = "add_slot 3 regular false";
	response = controller.executeTask(command);
	System.out.println(response);
	
	command = "add_slot 4 small true";
	response = controller.executeTask(command);
	System.out.println(response);
	
	command = "add_slot 5 small false";
	response = controller.executeTask(command);
	System.out.println(response);
	
	}
	
	public static void showCommandList() {
		StringBuilder sb = new StringBuilder();
		sb.append("List of available commands and their parameters:\n");
		sb.append("add_slot (int)number (type)regular/small (isCovered)true/false \n");
		sb.append("find_free_slot (type)car/motorcycle (isCovered)true/false \n");
		sb.append("free_slot_reservation (string)vehicleRegistrationNumber \n");
		sb.append("get_current_slot_reservation (string)vehicleRegistrationNumber \n");
		sb.append("get_slots_statistics \n");
		sb.append("get_vehicle (string)vehicleRegistrationNumber \n");
		sb.append("occupy_slot (int)slotNumber (string)vehicleRegistrationNumber \n");
		sb.append("register_vehicle (type)car/motorcycle (string)registrationNumber \n");
		sb.append("exit\n");
		System.out.println(sb);

	}


}