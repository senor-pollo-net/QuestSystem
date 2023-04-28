package command;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.Arrays;
import java.util.List;

public abstract class Command implements CommandExecutor, TabCompleter {
	
	private final String name;
	private final List<String> aliases;
	
	public Command(String name, String...aliases) {
		super();
		this.name = name;
		this.aliases = Arrays.asList(aliases);
	}

	public String getName() {
		return name;
	}

	public List<String> getAliases() {
		return aliases;
	}

	public abstract List<String> tabComplete(CommandSender s, String[] args);
	
	public abstract void onCommand(CommandSender s, String[] args);
	
	@Override
	public List<String> onTabComplete(CommandSender s, org.bukkit.command.Command cmd, String label, String[] args) {
		return tabComplete(s, args);
	}

	@Override
	public boolean onCommand(CommandSender s, org.bukkit.command.Command cmd, String label, String[] args) {
		onCommand(s, args);
		return true;
	}
}
