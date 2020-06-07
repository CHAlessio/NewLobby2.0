package ch.alessio.main.invinteract;

import ch.alessio.main.Main;
import ch.alessio.main.listener.Inv;
import ch.alessio.main.loc.Loc;
import net.minecraft.server.v1_8_R3.Items;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.BrewerInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class Profile implements Listener {

    @EventHandler
    public void interact(PlayerInteractEvent e){
        Player p = e.getPlayer();
        try {
            if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.Profile)){
                Inventory inv = Bukkit.createInventory(null, InventoryType.BREWING, Main.Profile);


                ItemStack einstellungen = new ItemStack(Material.CHAINMAIL_HELMET);
                ItemMeta einst = einstellungen.getItemMeta();
                einst.setDisplayName(Main.Einstellungen);
                einstellungen.setItemMeta(einst);

                inv.setItem(1, einstellungen);
                p.openInventory(inv);
            }
        }catch (Exception el){
            el.printStackTrace();
        }
    }

    @EventHandler
    public void onclick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        try {
            if (e.getInventory().getName().equalsIgnoreCase(Main.Profile)){
                e.setCancelled(true);
                if (e.getCurrentItem().getType() == Material.CHAINMAIL_HELMET){
                    Inventory einstellungen = Bukkit.createInventory(null, 9, Main.Einstellungen);

                    ItemStack t1 = new ItemStack(Material.FEATHER);
                    ItemMeta t1m = t1.getItemMeta();
                    t1m.setDisplayName(Main.Flugmodus);
                    t1.setItemMeta(t1m);

                    ItemStack t2 = new ItemStack(Material.BLAZE_ROD);
                    ItemMeta t2m = t2.getItemMeta();
                    t2m.setDisplayName("§e Spieler Verstecken");
                    t2.setItemMeta(t2m);



                    einstellungen.setItem(2, t1);
                    einstellungen.setItem(3, t2);
                   p.openInventory(einstellungen);
                }
            }
            if (e.getCurrentItem().getType() == Material.FEATHER) {
                if (p.getAllowFlight()) {
                    p.setAllowFlight(false);
                    p.sendMessage(Main.Prefix + "Du kannst nicht mehr Fliegen!");
                } else {
                    p.setAllowFlight(true);
                    p.sendMessage(Main.Prefix + "Du kannst nun Fliegen!");
                }
            }
        }catch (Exception el){
            el.printStackTrace();
        }

    }

    @EventHandler
    public void onclick2(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        try {
            if (e.getInventory().getName().equalsIgnoreCase(Main.Einstellungen)){
                e.setCancelled(true);
                if (e.getCurrentItem().getType() == Material.BLAZE_ROD){
                    Inventory e2 = Bukkit.createInventory(null, 9, "§e Spieler Verstecken");

                    ItemStack t1 = new ItemStack(Material.BLAZE_ROD);
                    ItemMeta t1m = t1.getItemMeta();
                    t1m.setDisplayName(Main.An);
                    t1.setItemMeta(t1m);

                    ItemStack t2 = new ItemStack(Material.BLAZE_ROD);
                    ItemMeta t2m = t2.getItemMeta();
                    t2m.setDisplayName(Main.Aus);
                    t2.setItemMeta(t2m);



                    e2.setItem(2, t1);
                    e2.setItem(6, t2);
                    p.openInventory(e2);
                }
            }
            if (e.getInventory().getName().equals("§e Spieler Verstecken")){
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Main.Aus)){
                    e.setCancelled(true);
                    for (Player all : Bukkit.getOnlinePlayers()){
                        p.hidePlayer(all);
                        p.sendMessage(Main.Prefix + "Sie Spieler sind nun Unsichtbar");
                        p.closeInventory();
                        return;
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Main.An)){
                    e.setCancelled(true);
                    for (Player all : Bukkit.getOnlinePlayers()){
                        p.showPlayer(all);
                        p.sendMessage(Main.Prefix + "Sie Spieler sind nun Sichtbar");
                        p.closeInventory();
                        return;
                    }
                }
            }
        }catch (Exception el){
            el.printStackTrace();
        }

    }
}
