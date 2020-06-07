package ch.alessio.main.commands;

import ch.alessio.main.Main;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Build implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player){
            Player p = (Player)sender;
            if (p.hasPermission(Main.PermissionBuild)){
                if (args.length == 0){
                    if (Main.build.contains(p)){
                        Main.build.remove(p);
                        p.setGameMode(GameMode.ADVENTURE);
                        p.sendMessage(Main.Prefix + Main.BuildLeaveMessage);
                    }else{
                        Main.build.add(p);
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(Main.Prefix + Main.BuildJoinMessage);
                    }
                }
            }
        }
        return false;
    }
}
