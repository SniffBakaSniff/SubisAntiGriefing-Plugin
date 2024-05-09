package xyz.subaka.subisantigriefing.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityInteractEvent;
import xyz.subaka.subisantigriefing.SubisAntiGriefing;

public class OnEntityInteract implements Listener {
    private final SubisAntiGriefing plugin;

    public OnEntityInteract(SubisAntiGriefing plugin) {
        this.plugin = plugin;
    }

    // Crop Trampling
    @EventHandler
    public void onEntityInteract(EntityInteractEvent event) {
        if (plugin.cancelCropTrampling) {
            event.getBlock();
            Material blockType = event.getBlock().getType();
            if (blockType == Material.FARMLAND) {
                event.setCancelled(true);
            }
        }
        //Turtle Egg Squishing
        if (plugin.cancelEntityTurtleEggSquishing) {
            event.getBlock();
            Material blockType = event.getBlock().getType();
            if (blockType == Material.TURTLE_EGG) {
                event.setCancelled(true);
            }
        }
    }

}
