package main;

import quest.QuestManager;
import util.Config;

public class QS {
	
	private final Main main;
	
	public QuestManager questManager;
	
	public Config questsYML;
	
	public Config playersYML;
	
	public static QS get;
	
	public QS(Main main) {
		this.main = main;
		QS.get = main.qs;
	}
	
	public Main getMain() {
		return main;
	}

	public void onEnable() {
		questManager = new QuestManager();
		
		questsYML = new Config("quests.yml");
		playersYML = new Config("players.yml");
		
		questManager.load();
	}

	public void onDisable() {
		
	}

	public void onLoad() {
		
	}

}
