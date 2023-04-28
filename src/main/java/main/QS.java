package main;

import util.Config;

public class QS {

	public Config playersYML;
	public Config questsYML;
	public static QS get;
	private final Main main;

	public QS(Main main) {
		this.main = main;
		QS.get = main.qs;
	}
	
	public Main getMain() {
		return main;
	}

	public void onEnable() {
		questsYML = new Config("quests.yml");
		playersYML = new Config("players.yml");
	}

	public void onDisable() {
		
	}

	public void onLoad() {
		
	}
}
