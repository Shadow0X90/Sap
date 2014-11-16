package shadow.vg.sap;

import org.bukkit.plugin.java.JavaPlugin;


public class SapMain extends JavaPlugin {
    @Override
    public void onEnable() {
    	getLogger().info("### SAP has been enabled ###");
    }
 
    @Override
    public void onDisable() {
    	getLogger().info("### SAP has been disabled ###");
    }
}
