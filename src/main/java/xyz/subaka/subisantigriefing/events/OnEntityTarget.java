package xyz.subaka.subisantigriefing.events;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import xyz.subaka.subisantigriefing.SubisAntiGriefing;

public class OnEntityTarget implements Listener {

    private final SubisAntiGriefing plugin;

    public OnEntityTarget(SubisAntiGriefing plugin) {
        this.plugin = plugin;
    }

    //Entity Targeting
    @EventHandler
    public void onEntityTarget(EntityTargetLivingEntityEvent event) {
        // Ghasts Targeting
        if (plugin.cancelGhastFireball && event.getEntityType() == EntityType.GHAST) {
            event.setCancelled(true);
        }
    }
}
