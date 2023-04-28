package util;

import main.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

public class Config {

	private FileConfiguration fileConfiguration;
	private final File file;
	private final String name;

	public Config(String name) {
		this.name = name;
	    file = new File(Main.instance.getDataFolder() + "/" + name);
	}

	public void reloadConfig() {
		fileConfiguration = YamlConfiguration.loadConfiguration(file);
		InputStream defConfigStream = Main.instance.getResource(name);
		if (defConfigStream != null)
		{
			copyInputStreamToFile(defConfigStream, file);
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(file);
			fileConfiguration.setDefaults(defConfig);
		}
	}
	  
	private static void copyInputStreamToFile(InputStream inputStream, File file) {
		try (FileOutputStream outputStream = new FileOutputStream(file, false)) {
			int read;
			byte[] bytes = new byte[8192];
			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	  
	public FileConfiguration getConfig() {
		if(fileConfiguration == null)
			reloadConfig(); 
		return fileConfiguration;
	}
	
	public void set(String path, Object value) {
		getConfig().set(path, value);
		saveConfig();
	}
	
	public List<?> getList(String path) {
		return getConfig().getList(path);
	}
	
	public List<String> getStringList(String path) {
		return getConfig().getStringList(path);
	}
	
	public List<Integer> getIntList(String path) {
		return getConfig().getIntegerList(path);
	}
	
	public List<Float> getFloatList(String path) {
		List<Float> floats = new ArrayList<>();
		for(double d : getConfig().getDoubleList(path)) {
			floats.add((float) d);
		}
		return floats;
	}
	
	public List<Double> getDoubleList(String path) {
		return getConfig().getDoubleList(path);
	}
	
	public List<Long> getLongList(String path) {
		return getConfig().getLongList(path);
	}
	
	public Object get(String path) {
		return getConfig().get(path);
	}
	
	public String getString(String path) {
		return getConfig().getString(path);
	}
	
	public int getInt(String path) {
		return getConfig().getInt(path);
	}
	
	public float getFloat(String path) {
		return (float) getConfig().getDouble(path);
	}
	
	public double getDouble(String path) {
		return getConfig().getDouble(path);
	}
	
	public long getLong(String path) {
		return getConfig().getLong(path);
	}
	
	public void save() {
		saveConfig();
	}
	
	public void saveConfig() {
		if (fileConfiguration == null || file == null)
			return; 
		try {
			getConfig().save(file);
		} catch (IOException ex) {
			Main.instance.getLogger().log(Level.SEVERE, "Could not save config to " + file, ex);
		} 
	}
	
	public void saveDefaultConfig() {
		if (!file.exists())
			Main.instance.saveResource(name, false);
	}
	
	public void load() {
		loadConfig();
	}
	  
	public void loadConfig() {
		fileConfiguration = getConfig();
		fileConfiguration.options().copyDefaults(true);
		if ((new File(Main.instance.getDataFolder() + "/config.yml")).exists()) {
			System.out.println("[" + Main.instance + "]" + "config.yml geladen.");
		} else {
			saveDefaultConfig();
			System.out.println("[" + Main.instance + "]" + "config.yml erstellt und geladen.");
		} 
	}

	public boolean contains(String path) {
		return getConfig().contains(path);
	}

	public Set<String> getKeys(boolean deep) {
		return getConfig().getKeys(deep);
	}

	public ItemStack getItemStack(String path) {
		return getConfig().getItemStack(path);
	}
}
