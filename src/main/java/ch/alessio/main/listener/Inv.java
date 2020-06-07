package ch.alessio.main.listener;

import ch.alessio.main.Main;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;

public class Inv {

    public Inv (Player p){

        ItemStack item = new ItemStack(Material.COMPASS);
        ItemMeta comme = item.getItemMeta();
        comme.setDisplayName(Main.KItemname);
        item.setItemMeta(comme);

        ItemStack profile = new ItemStack(Material.BREWING_STAND_ITEM);
        ItemMeta pfm = profile.getItemMeta();
        pfm.setDisplayName(Main.Profile);
        profile.setItemMeta(pfm);

        ItemStack playerh = new ItemStack(Material.CHEST);
        ItemMeta phm = playerh.getItemMeta();
        phm.setDisplayName(Main.ItemBoots);
        playerh.setItemMeta(phm);

        ItemStack silent = new ItemStack(Material.TNT);
        ItemMeta slm = silent.getItemMeta();
        slm.setDisplayName(Main.Silent);
        silent.setItemMeta(slm);



        p.getInventory().setItem(0, item);
        p.getInventory().setItem(1, playerh);
        if (p.hasPermission(Main.PermissionSilentLobby)){
            p.getInventory().setItem(4, silent);
        }
        p.getInventory().setItem(8, profile);
    }
}

