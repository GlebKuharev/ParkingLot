package controller;

import java.util.Scanner;

import controller.command.Command;

public class Controller {

	private final CommandProvider provider = new CommandProvider(); 
	private final char paramDelimeter = ' '; 

	public String executeTask(String request) { 
		String commandName; 
		Command executionCommand;
		
		Scanner sc = new Scanner(request);

		commandName = sc.next();
		
		executionCommand = provider.getCommand(commandName);
		
		String response = null; 
		try {
			response = executionCommand.execute(request.substring(request.indexOf(paramDelimeter)+1).toUpperCase());
		} catch (Exception e) {
			response = "parse error, please review command and parameter input";
		}

		return response;

	}
}