package ch.alessio.main.loc;

import ch.alessio.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class Loc {

    public static void setLocation(Player p, String path){

        double X = p.getLocation().getX();
        double Y = p.getLocation().getY();
        double Z = p.getLocation().getZ();

        float Yaw = p.getLocation().getYaw(),
                Pitch = p.getLocation().getPitch();
        String world = p.getLocation().getWorld().getName();

        Main.fc.set("lobby." + path + ".X" ,X);
        Main.fc.set("lobby." + path + ".Y" ,Y);
        Main.fc.set("lobby." + path + ".Z" ,Z);
        Main.fc.set("lobby." + path + ".Yaw" ,Yaw);
        Main.fc.set("lobby." + path + ".Pitch" ,Pitch);
        Main.fc.set("lobby." + path + ".World" ,world);

        try {
            Main.fc.save(Main.f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void teleportplayertoconfig(Player p,String path){

        double X = Main.fc.getDouble("lobby." + path + ".X");
        double Y = Main.fc.getDouble("lobby." + path + ".Y");
        double Z = Main.fc.getDouble("lobby." + path + ".Z");
        float Yaw = (float) Main.fc.getDouble("lobby." + path + ".Yaw");
        float Pitch = (float) Main.fc.getDouble("lobby." + path + ".Ptich");

        World World = Bukkit.getWorld(Main.fc.getString("lobby." + path + ".World"));

        Location loc = new Location(World, X, Y, Z, Yaw, Pitch);
        if (loc == null){
            p.sendMessage("§c ERROR #Loc");
            System.out.println("ERROR Loc");
        }else {
            p.teleport(loc);
        }
    }
}
