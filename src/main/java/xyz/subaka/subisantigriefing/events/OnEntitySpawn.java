package xyz.subaka.subisantigriefing.events;

import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import xyz.subaka.subisantigriefing.SubisAntiGriefing;

public class OnEntitySpawn implements Listener {

    private final SubisAntiGriefing plugin;

    public OnEntitySpawn(SubisAntiGriefing plugin) {
        this.plugin = plugin;
    }

    // Event handler for when mobs spawn
    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        if (plugin.preventDoorBreak) {
            EntityType entityType = event.getEntityType();
            if (plugin.doorBreakingMobs.contains(entityType.toString())) {
                LivingEntity entity = (LivingEntity) event.getEntity();
                if (entity instanceof Zombie && entityType == EntityType.ZOMBIE && plugin.doorBreakingMobs.contains("ZOMBIE")) {
                    ((Zombie) entity).setCanBreakDoors(false);
                }
                else if (entity instanceof ZombieVillager && entityType == EntityType.ZOMBIE_VILLAGER && plugin.doorBreakingMobs.contains("ZOMBIE_VILLAGER")) {
                    ((ZombieVillager) entity).setCanBreakDoors(false);
                }
                else if (entity instanceof Drowned && entityType == EntityType.DROWNED && plugin.doorBreakingMobs.contains("DROWNED")) {
                    ((Drowned) entity).setCanBreakDoors(false);
                }
                else if (entity instanceof Husk && entityType == EntityType.HUSK && plugin.doorBreakingMobs.contains("HUSK")) {
                    ((Husk) entity).setCanBreakDoors(false);
                }
            }
        }
    }
}
