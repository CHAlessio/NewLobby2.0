package ch.alessio.main.listener;

import ch.alessio.main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.List;

public class Build  implements Listener {

    @EventHandler
    public void blockplace(BlockPlaceEvent e){
        if (!Main.build.contains(e.getPlayer())){
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void blockbreak(BlockBreakEvent e){
        if (!Main.build.contains(e.getPlayer())){
            e.setCancelled(true);
        }
    }
}
