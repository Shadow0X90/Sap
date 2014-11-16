package shadow.vg.sap.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import shadow.vg.sap.SapMain;

public class SAPCommandExecutor implements CommandExecutor{
	private final SapMain plugin;
	String pluginName = ChatColor.BLUE + "[SAP] ";
	ChatColor green = ChatColor.GREEN;
	public SAPCommandExecutor(SapMain plugin) {
		this.plugin = plugin;
	}
	//TODO: fix this command below.
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("give")) {
			if (args.length < 2) {
				sender.sendMessage(pluginName + green + "Usage: /give [target] [item] [ammount]");
				return true;
			}else if (args.length == 1) {
				Player player = Bukkit.getPlayerExact(args[0]);
				if (player != null) {
				Material item = Material.matchMaterial(args[1]);
					if (item != null) {
						ItemStack giveitem = new ItemStack(item, 1);
						player.getInventory().addItem(giveitem);
						player.updateInventory();
						sender.sendMessage(pluginName + green + player + " given 1 " + item + ".");
						return true;
					} else {
						sender.sendMessage(pluginName + green + item + " is not a valid item.");
					}
				} else {
					sender.sendMessage(pluginName + green + player + " is not online.");
				}
			} else if (args.length == 2) {
				Player player = Bukkit.getPlayerExact(args[0]);
				if (player != null) {
				Material item = Material.matchMaterial(args[1]);
					if (item != null) {
						int ammount = Integer.parseInt(args[2]);
						ItemStack giveitem = new ItemStack(item, ammount);
						player.getInventory().addItem(giveitem);
						player.updateInventory();
						sender.sendMessage(pluginName + green + player.getDisplayName() + " given " + ammount + " " + item + ".");
						return true;
					} else {
						sender.sendMessage(pluginName + green + item + " is not a valid item.");
					}
				} else {
					sender.sendMessage(pluginName + green + player + " is not online.");
				}
				}
			}
		return false; 
	}
}