package ch.alessio.main;

import ch.alessio.main.Gagdgets.ItemInteract;
import ch.alessio.main.commands.Build;
import ch.alessio.main.commands.SetLoc;
import ch.alessio.main.invinteract.Navigator;
import ch.alessio.main.invinteract.SilentLobby;
import ch.alessio.main.invinteract.Profile;
import ch.alessio.main.listener.Join;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Difficulty;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;

public class Main extends JavaPlugin {


    public static File f = new File("plugins/Lobby", "Locations.yml");
    public static FileConfiguration fc = new YamlConfiguration().loadConfiguration(f);

    public static String Prefix;
    public static String PermissionBuild;
    public static String PermissionChatColor;
    public static String PermissionSilentLobby;

    public static String Score1;
    public static String Score2;
    public static String Score3;
    public static String Score4;
    public static String Score5;
    public static String Score10;
    public static String ScoreTitel;
    public static String Score6;
    public static String Score7;
    public static String Score8;
    public static String Score9;


    public static String BuildLeaveMessage;
    public static String BuildJoinMessage;

    public static String KItemname;
    public static String Profile;
    public static String Silent;

    public static String Einstellungen;
    public static String Spawn;


    public static String warp1;
    public static String warp2;
    public static String warp3;
    public static String warp4;
    public static String warp5;
    public static String warp6;
    public static String warp7;
    public static String warp8;
    public static String warpspawn;
    public static String Flugmodus;


    public static String name1;
    public static String name2;
    public static String name3;
    public static String name4;
    public static String name5;
    public static String name6;
    public static String name7;
    public static String name8;
    public static String An;
    public static String Aus;

    public static ArrayList<Player> build = new ArrayList<Player>();
    public static ArrayList<Player> Hide = new ArrayList<Player>();
    public static ArrayList<Player> Fly = new ArrayList<Player>();


    public static String Boots;
    public static String ItemBoots;
    public static String LB;
    public static String FB;
    public static String world;



    public static String Silentmsgan;
    public static String Silentmsgaus;
    public static String Silentan;
    public static String Silentaus;

    @Override
    public void onEnable() {
        config();
        registerchatcolor();
        registerevents();
        registercommands();
        if (getConfig() == null){
            config();
        }
        Bukkit.getWorld("world").setDifficulty(Difficulty.PEACEFUL);

    }

    @Override
    public void onDisable() {
    saveDefaultConfig();
    }

    public void config(){
        getConfig().options().copyDefaults(true);
    }

    public void registerchatcolor(){
        Prefix = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Prefix"));
        PermissionBuild = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Permissions.Build"));
        PermissionChatColor = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Permissions.ChatColor"));
        BuildLeaveMessage = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Messages.Build.Leave"));
        BuildJoinMessage = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Messages.Build.Join"));
        PermissionSilentLobby = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Permissions.Silentlobby"));

        Score1 = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Scoreboard.Line1"));
        Score2 = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Scoreboard.Line2"));
        Score3 = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Scoreboard.Line3"));
        Score4 = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Scoreboard.Line4"));
        Score5 = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Scoreboard.Line5"));
        Score6 = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Scoreboard.Line6"));
        Score7 = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Scoreboard.Line7"));
        Score8 = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Scoreboard.Line8"));
        Score9 = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Scoreboard.Line9"));
        Score10 = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Scoreboard.Line10"));
        ScoreTitel = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Scoreboard.Titel"));

        Profile = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Items.Profile.Name"));

        Silent = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Items.Silenthub.Name"));
        Silentan = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Items.Silenthub.An"));
        Silentaus = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Items.Silenthub.Aus"));
        Silentmsgan = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Items.Silenthub.AnMsg"));
        Silentmsgaus = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Items.Silenthub.AusMsg"));

        world = ChatColor.translateAlternateColorCodes('&', getConfig().getString("LobbyWorldName"));


        Einstellungen = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Items.Profile.Einstellungen"));
        KItemname = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Items.Navigator.Name"));


        Spawn = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Items.Navigator.Item.Spawn.WarpSpawn"));
        name1 = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Items.Navigator.Item.1.WarpSpawn"));
        name2 = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Items.Navigator.Item.2.WarpSpawn"));
        name3 = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Items.Navigator.Item.3.WarpSpawn"));
        name4 = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Items.Navigator.Item.4.WarpSpawn"));
        name5 = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Items.Navigator.Item.5.WarpSpawn"));
        name6 = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Items.Navigator.Item.6.WarpSpawn"));
        name7 = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Items.Navigator.Item.7.WarpSpawn"));
        name8 = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Items.Navigator.Item.8.WarpSpawn"));


        Flugmodus = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Items.Profile.Flugmodus"));
        An = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Items.Profile.Playerhider.An"));
        Aus = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Items.Profile.Playerhider.Aus"));


        Boots = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Items.Gadgets.Items.Boots.Name"));
        ItemBoots = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Items.Gadgets.Name"));
        LB = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Items.Gadgets.Items.Boots.LoveBoots"));
        FB = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Items.Gadgets.Items.Boots.FireBoots"));


        warpspawn = getConfig().getString("Items.Navigator.Item.Spawn.WarpID");
        warp1 = getConfig().getString("Items.Navigator.Item.1.WarpID");
        warp2 = getConfig().getString("Items.Navigator.Item.2.WarpID");
        warp3 = getConfig().getString("Items.Navigator.Item.3.WarpID");
        warp4 = getConfig().getString("Items.Navigator.Item.4.WarpID");
        warp5 = getConfig().getString("Items.Navigator.Item.5.WarpID");
        warp6 = getConfig().getString("Items.Navigator.Item.6.WarpID");
        warp7 = getConfig().getString("Items.Navigator.Item.7.WarpID");
        warp8 = getConfig().getString("Items.Navigator.Item.8.WarpID");




    }

    public void registerevents(){
        Bukkit.getPluginManager().registerEvents(new Join(), this);
        Bukkit.getPluginManager().registerEvents(new ch.alessio.main.listener.Build(), this);
        Bukkit.getPluginManager().registerEvents(new Profile(), this);
        Bukkit.getPluginManager().registerEvents(new Navigator(), this);
        Bukkit.getPluginManager().registerEvents(new SilentLobby(), this);
        Bukkit.getPluginManager().registerEvents(new ItemInteract(), this);



    }
    public void registercommands(){

        getCommand("build").setExecutor(new Build());
        getCommand("setloc").setExecutor(new SetLoc());
    }
}
