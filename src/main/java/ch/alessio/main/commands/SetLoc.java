package ch.alessio.main.commands;

import ch.alessio.main.Main;
import ch.alessio.main.loc.Loc;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetLoc implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player p = (Player) sender;
        if (sender instanceof Player){
            if (args[0].equalsIgnoreCase(Main.warpspawn)){
                Loc.setLocation(p, Main.warpspawn);
                p.sendMessage(Main.Prefix + "Du hast den" +Main.warpspawn+" erfolgreich gesetzt");
            }else if (args[0].equalsIgnoreCase(Main.warp2)){
                Loc.setLocation(p, Main.warp2);
                p.sendMessage(Main.Prefix + "Du hast den"+ Main.warp2+ "erfolgreich gesetzt");
            }else if (args[0].equalsIgnoreCase(Main.warp3)){
                Loc.setLocation(p, Main.warp3);
                p.sendMessage(Main.Prefix + "Du hast den"+ Main.warp3 + "erfolgreich gesetzt");
            }else if (args[0].equalsIgnoreCase(Main.warp4)){
                Loc.setLocation(p, Main.warp4);
                p.sendMessage(Main.Prefix + "Du hast den"+ Main.warp4 + "erfolgreich gesetzt");
            }else if (args[0].equalsIgnoreCase(Main.warp5)){
                Loc.setLocation(p, Main.warp5);
                p.sendMessage(Main.Prefix + "Du hast den"+ Main.warp5 + "erfolgreich gesetzt");
            }else if (args[0].equalsIgnoreCase(Main.warp6)){
                Loc.setLocation(p, Main.warp6);
                p.sendMessage(Main.Prefix + "Du hast den"+ Main.warp6 + "erfolgreich gesetzt");
            }else if (args[0].equalsIgnoreCase(Main.warp7)){
                Loc.setLocation(p, Main.warp7);
                p.sendMessage(Main.Prefix + "Du hast den"+ Main.warp7 + "erfolgreich gesetzt");
            }else if (args[0].equalsIgnoreCase(Main.warp8)){
                Loc.setLocation(p, Main.warp8);
                p.sendMessage(Main.Prefix + "Du hast den"+ Main.warp8 + "erfolgreich gesetzt");
            }else if (args[0].equalsIgnoreCase(Main.warp1)){
                Loc.setLocation(p, Main.warp1);
                p.sendMessage(Main.Prefix + "Du hast den"+ Main.warp1 + "erfolgreich gesetzt");
            }
            else{
                p.sendMessage(Main.Prefix + "Benutze /setloc [WarpID (Config)]");
            }
        }
        return false;
    }
}
