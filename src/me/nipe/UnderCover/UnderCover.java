package me.nipe.UnderCover;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Mads og Thomas on 23/04/2016.
 */
public class UnderCover extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("UnderCover plugin has been enabled");

    }

    @Override
    public void onDisable() {
        getLogger().info("UnderCover plugin has been disabled");

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String comandLabel, String [] args) {
        if ((cmd.getName().equalsIgnoreCase("uc") || cmd.getName().equalsIgnoreCase("undercover")) && sender instanceof Player && sender.isOp()) {
            Player player = (Player) sender;
            player.setPlayerListName("Undercover");
            return true;
        } else if ((cmd.getName().equalsIgnoreCase("unuc") || cmd.getName().equalsIgnoreCase("unundercover")) && sender instanceof Player && sender.isOp()) {
            Player player = (Player) sender;
            player.setPlayerListName(player.getName());
            return true;
        } else if (cmd.getName().equalsIgnoreCase("nick") && sender instanceof Player && sender.isOp()) {
            if (args.length != 1) {
                sender.sendMessage("Du skal skrive et navn");
                return false;
            }
            Player player = (Player) sender;
            player.setPlayerListName(args[0]);
            return true;
        }
        return false;
    }
}
