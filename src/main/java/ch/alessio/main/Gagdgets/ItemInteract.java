package ch.alessio.main.Gagdgets;

import ch.alessio.main.Main;
import ch.alessio.main.listener.Inv;
import ch.alessio.main.loc.Loc;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.List;

public class ItemInteract implements Listener {

    public Inventory inv;
    public ItemStack spawn;
    public ItemStack boots2;

    @EventHandler
    public void navi(PlayerInteractEvent e){
        if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(Main.ItemBoots)) {
            if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
                inv = Bukkit.createInventory(null, 9, Main.ItemBoots);


                ItemStack spawn = new ItemStack(Material.DIAMOND_BOOTS);
                ItemMeta spawnme = spawn.getItemMeta();
                spawnme.setDisplayName(Main.Boots);
                spawn.setItemMeta(spawnme);


                ItemStack nog = new ItemStack(Material.BARRIER);
                ItemMeta n = nog.getItemMeta();
                n.setDisplayName("§cEntferne Gagdets");
                nog.setItemMeta(n);

                inv.setItem(6, spawn);
                inv.setItem(8, nog);
                e.getPlayer().openInventory(inv);
            }
        }else{
            e.setCancelled(true);
        }
    }


    @EventHandler
    public void hendle(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if (e.getInventory().getName().equalsIgnoreCase(Main.ItemBoots)){
            e.setCancelled(true);
            if (e.getCurrentItem().getType() == Material.DIAMOND_BOOTS){
                Inventory inv2 = Bukkit.createInventory(null, 9, Main.Boots);

                spawn = new ItemStack(Material.DIAMOND_BOOTS);
                ItemMeta spawnme = spawn.getItemMeta();
                spawnme.setDisplayName(Main.LB);
                spawn.setItemMeta(spawnme);

                boots2 = new ItemStack(Material.GOLD_BOOTS);
                ItemMeta boots2m = boots2.getItemMeta();
                boots2m.setDisplayName(Main.FB);
                boots2.setItemMeta(boots2m);


                inv2.setItem(3, spawn);
                inv2.setItem(1, boots2);
                p.openInventory(inv2);
            }
            e.setCancelled(true);
        }
        if (e.getInventory().getName().equalsIgnoreCase(Main.Boots)){
            e.setCancelled(true);
            if (e.getCurrentItem().getType() == Material.DIAMOND_BOOTS){

                if (p.getInventory().getBoots() != null){
                    p.getInventory().setBoots(spawn);
                }else{
                    p.getInventory().clear();
                    new Inv(p.getPlayer());
                    p.getInventory().setBoots(spawn);
                }
            }
            if (e.getCurrentItem().getType() == Material.GOLD_BOOTS){
                if (p.getInventory().getBoots() != null){
                    p.getInventory().setBoots(boots2);
                }else{
                    p.getInventory().clear();
                    new Inv(p.getPlayer());
                    p.getInventory().setBoots(boots2);
                }
            }
            e.setCancelled(true);
        }
        if (e.getInventory().getName().equalsIgnoreCase(Main.ItemBoots)) {
            e.setCancelled(true);
            if (e.getCurrentItem().getType() == Material.BARRIER) {
                if (p.getInventory().getBoots() != null){
                    p.getInventory().setBoots(null);
                    new Inv(p.getPlayer());
                }
                p.closeInventory();
            }
        }
    }

    @EventHandler
    public void move(PlayerMoveEvent e){
        Player p = (Player) e.getPlayer();
        if (p.getInventory().getBoots().getItemMeta().getDisplayName().equalsIgnoreCase(Main.LB)){
            p.getWorld().playEffect(p.getLocation().add(0, 1, 0), Effect.HEART, 1);

        }else{

        }
        if (p.getInventory().getBoots().getItemMeta().getDisplayName().equalsIgnoreCase(Main.FB)){
            p.getWorld().playEffect(p.getLocation().add(0, 1, 0), Effect.FIREWORKS_SPARK, 1);

        }else{

        }
    }
}
