package xyz.subaka.subisantigriefing.events;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import xyz.subaka.subisantigriefing.SubisAntiGriefing;

public class OnEntityChangeBlock implements Listener {

    private final SubisAntiGriefing plugin;

    public OnEntityChangeBlock(SubisAntiGriefing plugin) {
        this.plugin = plugin;
    }

    // Entity Block Changing
    @EventHandler
    public void onEntityChangeBlock(EntityChangeBlockEvent event) {
        //Enderman Grief
        if (plugin.cancelEndermanGrief && event.getEntity().getType() == EntityType.ENDERMAN) {
            event.setCancelled(true);
        }
        if (plugin.cancelRavagerGrief && event.getEntity().getType() == EntityType.RAVAGER) {
            event.setCancelled(true);
        }
    }
}
