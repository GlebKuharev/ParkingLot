package controller.command.impl;

import controller.command.Command;

public class WrongRequest implements Command {

	@Override
	public String execute(String request) {
		
		String response = "command not recognized";
		return response;
	}

}
