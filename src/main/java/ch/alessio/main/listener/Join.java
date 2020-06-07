package ch.alessio.main.listener;

import ch.alessio.main.Main;
import ch.alessio.main.loc.Loc;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Difficulty;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class Join implements Listener {

    @EventHandler
    public void join(PlayerJoinEvent e){
        Player p = e.getPlayer();
        e.setJoinMessage(null);
        e.getPlayer().setGameMode(GameMode.ADVENTURE);
        setscoreboard(e.getPlayer());
        p.getInventory().clear();
        new Inv(p.getPlayer());
        Loc.teleportplayertoconfig(p, "spawn");
    }
    @EventHandler
    public void leave(PlayerQuitEvent e){

        e.setQuitMessage("");
    }
    @EventHandler
    public void chatcolor(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
       if (p.hasPermission(Main.PermissionChatColor)){
           e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));
       }
    }


    public void setscoreboard(Player p){
        Scoreboard score = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = score.registerNewObjective("abcd", "abcr");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName(Main.ScoreTitel);
        obj.getScore(Main.Score10).setScore(10);
        obj.getScore(Main.Score9).setScore(9);
        obj.getScore(Main.Score8).setScore(8);
        obj.getScore(Main.Score7).setScore(7);
        obj.getScore(Main.Score6).setScore(6);
        obj.getScore(Main.Score5).setScore(5);
        obj.getScore(Main.Score4).setScore(4);
        obj.getScore(Main.Score3).setScore(3);
        obj.getScore(Main.Score2).setScore(2);
        obj.getScore(Main.Score1).setScore(1);
        p.setScoreboard(score);




    }

    @EventHandler
    public void onDamage(EntityDamageEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void onentidy(EntityDamageByBlockEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void noinfmove(InventoryMoveItemEvent e){
    e.setCancelled(true);}

    @EventHandler
    public void nomove(InventoryDragEvent e){

    }


}
