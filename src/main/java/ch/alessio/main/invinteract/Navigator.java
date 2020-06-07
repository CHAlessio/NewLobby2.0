package ch.alessio.main.invinteract;

import ch.alessio.main.Main;
import ch.alessio.main.loc.Loc;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.swing.plaf.synth.ColorType;
import java.util.List;

public class Navigator implements Listener {


    public static Inventory inv;


    @EventHandler
    public void navi(PlayerInteractEvent e){
        if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.KItemname)) {
            if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
                inv = Bukkit.createInventory(null, InventoryType.CHEST, Main.KItemname);


                ItemStack spawn = new ItemStack(Material.BEACON);
                ItemMeta spawnme = spawn.getItemMeta();
                spawnme.setDisplayName(Main.warpspawn);
                spawn.setItemMeta(spawnme);

                ItemStack a = new ItemStack(Material.BED);
                ItemMeta am = a.getItemMeta();
                am.setDisplayName(Main.name1);
                a.setItemMeta(am);

                ItemStack b = new ItemStack(Material.SKULL_ITEM);
                ItemMeta bm = b.getItemMeta();
                bm.setDisplayName(Main.name2);
                b.setItemMeta(bm);

                ItemStack c = new ItemStack(Material.BLAZE_ROD);
                ItemMeta cm = c.getItemMeta();
                cm.setDisplayName(Main.name3);
                c.setItemMeta(cm);

                ItemStack d = new ItemStack(Material.WORKBENCH);
                ItemMeta dm = d.getItemMeta();
                dm.setDisplayName(Main.name4);
                d.setItemMeta(dm);

                ItemStack ee = new ItemStack(Material.GLASS);
                ItemMeta ef = ee.getItemMeta();
                ef.setDisplayName(Main.name5);
                ee.setItemMeta(ef);

                ItemStack f = new ItemStack(Material.APPLE);
                ItemMeta fm = f.getItemMeta();
                fm.setDisplayName(Main.name6);
                f.setItemMeta(fm);

                ItemStack g = new ItemStack(Material.CHAINMAIL_HELMET);
                ItemMeta gm = g.getItemMeta();
                gm.setDisplayName(Main.name7);
                g.setItemMeta(gm);

                ItemStack h = new ItemStack(Material.TNT);
                ItemMeta hm = h.getItemMeta();
                hm.setDisplayName(Main.name8);
                h.setItemMeta(hm);

                inv.setItem(0, a);
                inv.setItem(1, b);
                inv.setItem(2, c);
                inv.setItem(3, d);
                inv.setItem(4, ee);
                inv.setItem(5, f);
                inv.setItem(6, g);
                inv.setItem(7, h);
                inv.setItem(8, spawn);
                e.getPlayer().openInventory(inv);
            }
        }else{
            e.setCancelled(true);
        }
    }


    @EventHandler
    public void hendle(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if (e.getInventory().getName().equalsIgnoreCase(Main.KItemname)){
            e.setCancelled(true);
            if (e.getCurrentItem().getType() == Material.BEACON){
                Loc.teleportplayertoconfig(p, Main.warpspawn);
                p.closeInventory();
            }else if (e.getCurrentItem().getType() == Material.BED){
                Loc.teleportplayertoconfig(p.getPlayer(), Main.warp1);
                p.closeInventory();
            }else if (e.getCurrentItem().getType() == Material.SKULL_ITEM){
                Loc.teleportplayertoconfig(p.getPlayer(), Main.warp2);
                p.closeInventory();
            }else if (e.getCurrentItem().getType() == Material.BLAZE_ROD){
                Loc.teleportplayertoconfig(p, Main.warp3);
                p.closeInventory();
            }else if (e.getCurrentItem().getType() == Material.WORKBENCH){
                Loc.teleportplayertoconfig(p, Main.warp4);
                p.closeInventory();
            }else if (e.getCurrentItem().getType() == Material.GLASS){
                Loc.teleportplayertoconfig(p, Main.warp5);
                p.closeInventory();
            }else if (e.getCurrentItem().getType() == Material.APPLE){
                Loc.teleportplayertoconfig(p, Main.warp6);
                p.closeInventory();
            }else if (e.getCurrentItem().getType() == Material.CHAINMAIL_HELMET){
                Loc.teleportplayertoconfig(p, Main.warp7);
                p.closeInventory();
            }else if (e.getCurrentItem().getType() == Material.TNT){
                Loc.teleportplayertoconfig(p, Main.warp8);
                p.closeInventory();
            }
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void nodrop(PlayerDropItemEvent e){
        Player p = e.getPlayer();
        if (p.getWorld().getName().equalsIgnoreCase(Main.world)){
            e.setCancelled(true);
        }else{
            e.setCancelled(false);
        }
    }
}
