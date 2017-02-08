package controller.command.impl;


import controller.command.Command;

public class Exit implements Command {

	@Override
	public String execute(String request) {
		System.exit(1);
		return "";
	}

}
