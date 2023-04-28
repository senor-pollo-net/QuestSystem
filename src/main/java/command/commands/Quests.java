package command.commands;

import command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public class Quests extends Command {

	public Quests() {
		super("quests", "qs");
	}

	@Override
	public List<String> tabComplete(CommandSender s, String[] args) {
		return null;
	}

	@Override
	public void onCommand(CommandSender s, String[] args) {
		
	}
}
