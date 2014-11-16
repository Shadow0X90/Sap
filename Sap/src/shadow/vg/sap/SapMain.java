package shadow.vg.sap;

import org.bukkit.plugin.java.JavaPlugin;

import shadow.vg.sap.listener.SAPCommandExecutor;


public class SapMain extends JavaPlugin {
    @Override
    public void onEnable() {
    	getLogger().info("### SAP has been enabled ###");
    	this.getCommand("give").setExecutor(new SAPCommandExecutor(this));
    }
 
    @Override
    public void onDisable() {
    	getLogger().info("### SAP has been disabled ###");
    }
}
