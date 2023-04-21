package command;

import command.commands.Quests;
import main.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CommandManager {
	
	private final List<Command> commands = new ArrayList<>();
	
	public void load() {
		commands.add(new Quests());
		for(Command c : commands) {
			Objects.requireNonNull(Main.instance.getCommand(c.getName())).setExecutor(c);
			if(c.getAliases().isEmpty())
				return;
			
			Objects.requireNonNull(Main.instance.getCommand(c.getName())).setAliases(c.getAliases());
		}
	}

}
