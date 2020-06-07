package ch.alessio.main.invinteract;

import ch.alessio.main.Main;
import ch.alessio.main.loc.Loc;
import net.minecraft.server.v1_8_R3.Items;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class SilentLobby implements Listener {

    @EventHandler
    public static void Hide(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getItem().getType() == Material.TNT) {
                e.setCancelled(true);
                Inventory inv2 = Bukkit.createInventory(null, 9, "SilentLobby");

                ItemStack an = new ItemStack(Material.REDSTONE);
                ItemMeta anm = an.getItemMeta();
                anm.setDisplayName(Main.Silentan);
                an.setItemMeta(anm);

                ItemStack aus = new ItemStack(Material.REDSTONE);
                ItemMeta aum = aus.getItemMeta();
                aum.setDisplayName(Main.Silentaus);
                aus.setItemMeta(aum);

                inv2.setItem(2, an);
                inv2.setItem(6, aus);
                p.openInventory(inv2);
            }
        }
    }

    @EventHandler
    public static void setup(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        try {
            if (e.getInventory().getName().equals("SilentLobby")){
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Main.Silentan)){
                    e.setCancelled(true);
                    for (Player all : Bukkit.getOnlinePlayers()){
                       p.hidePlayer(all);
                       p.sendMessage(Main.Prefix + Main.Silentmsgan);
                       return;
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Main.Silentaus)){
                    e.setCancelled(true);

                    for (Player all : Bukkit.getOnlinePlayers()){
                        p.showPlayer(all);
                        p.sendMessage(Main.Prefix + Main.Silentmsgaus);
                        return;
                    }
                }
            }
        }catch (Exception el){
            el.printStackTrace();
        }
    }
}















