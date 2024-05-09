package xyz.subaka.subisantigriefing.events;

import org.bukkit.block.BlockState;
import org.bukkit.block.data.type.*;
import org.bukkit.entity.*;
import org.bukkit.entity.minecart.ExplosiveMinecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import xyz.subaka.subisantigriefing.SubisAntiGriefing;

public class OnEntityDamage implements Listener {
    private final SubisAntiGriefing plugin;

    public OnEntityDamage(SubisAntiGriefing plugin) {
        this.plugin = plugin;
    }

    // Entity Damage
    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        // Creeper Explosion Damage
        if (plugin.cancelCreeperDamage && event instanceof EntityDamageByEntityEvent) {
            EntityDamageByEntityEvent damageEvent = (EntityDamageByEntityEvent) event;
            if (damageEvent.getDamager() instanceof Creeper && event.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) {
                event.setCancelled(true);
                return;
            }
        }

        // Creeper Item Damage
        if (plugin.cancelCreeperDamageItem && event instanceof EntityDamageByEntityEvent) {
            EntityDamageByEntityEvent damageEvent = (EntityDamageByEntityEvent) event;
            Entity damager = damageEvent.getDamager();
            Entity entity = event.getEntity();
            if (damager instanceof Creeper && event.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION && (entity.getType() == EntityType.ITEM)) {
                event.setCancelled(true);
                return;
            }
        }

        // End_Crystal Explosion Damage
        if (plugin.cancelEnderCrystalDamage && event instanceof EntityDamageByEntityEvent) {
            EntityDamageByEntityEvent damageEvent = (EntityDamageByEntityEvent) event;
            if (damageEvent.getDamager() instanceof EnderCrystal && event.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) {
                event.setCancelled(true);
                return;
            }
        }

        // End_Crystal Item Damage
        if (plugin.cancelEnderCrystalDamageItem && event instanceof EntityDamageByEntityEvent) {
            EntityDamageByEntityEvent damageEvent = (EntityDamageByEntityEvent) event;
            Entity damager = damageEvent.getDamager();
            Entity entity = event.getEntity();
            if (damager instanceof EnderCrystal && event.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION && (entity.getType() == EntityType.ITEM)) {
                event.setCancelled(true);
                return;
            }
        }

        // TnT Explosion Damage
        if (plugin.cancelTnTDamage && event instanceof EntityDamageByEntityEvent) {
            EntityDamageByEntityEvent damageEvent = (EntityDamageByEntityEvent) event;
            if (damageEvent.getDamager() instanceof TNTPrimed && event.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {
                event.setCancelled(true);
                return;
            }
        }

        // TnT Item Damage
        if (plugin.cancelTnTDamageItem && event instanceof EntityDamageByEntityEvent) {
            EntityDamageByEntityEvent damageEvent = (EntityDamageByEntityEvent) event;
            Entity damager = damageEvent.getDamager();
            Entity entity = event.getEntity();
            if (damager instanceof TNTPrimed && event.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION && (entity.getType() == EntityType.ITEM)) {
                event.setCancelled(true);
                return;
            }
        }

        // TnTMinecart Explosion Damage
        if (plugin.cancelTnTMinecartDamage && event instanceof EntityDamageByEntityEvent) {
            EntityDamageByEntityEvent damageEvent = (EntityDamageByEntityEvent) event;
            if (damageEvent.getDamager() instanceof ExplosiveMinecart && event.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) {
                event.setCancelled(true);
                return;
            }
        }

        // TnTMinecart Item Damage
        if (plugin.cancelTnTMinecartDamageItem && event instanceof EntityDamageByEntityEvent) {
            EntityDamageByEntityEvent damageEvent = (EntityDamageByEntityEvent) event;
            Entity damager = damageEvent.getDamager();
            Entity entity = event.getEntity();
            if (damager instanceof ExplosiveMinecart && event.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION && (entity.getType() == EntityType.ITEM)) {
                event.setCancelled(true);
                return;
            }
        }

        // Ghast Explosion Damage
        if (plugin.cancelGhastFireballDamage && event instanceof EntityDamageByEntityEvent) {
            EntityDamageByEntityEvent damageEvent = (EntityDamageByEntityEvent) event;
            if (damageEvent.getDamager() instanceof Fireball && event.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) {
                event.setCancelled(true);
                return;
            }
            if (damageEvent.getDamager() instanceof Fireball && event.getCause() == EntityDamageEvent.DamageCause.PROJECTILE) {
                event.setCancelled(true);
                return;
            }

        }

        // Ghast Item Damage
        if (plugin.cancelGhastFireballDamageItem && event instanceof EntityDamageByEntityEvent) {
            EntityDamageByEntityEvent damageEvent = (EntityDamageByEntityEvent) event;
            Entity damager = damageEvent.getDamager();
            Entity entity = event.getEntity();
            if (damager instanceof Fireball && event.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION && (entity.getType() == EntityType.ITEM)) {
                event.setCancelled(true);
                return;
            }
        }

        // Respawn Anchor Explosion Damage Cancellation
        if (plugin.cancelRespawnAnchorExplosionDamage && event instanceof EntityDamageEvent) {
            BlockState blockState = OnBlockExplode.onBlockExplodeInstance.explodedBlockState;
            Entity entity = event.getEntity();
            if (blockState != null && blockState.getBlockData() instanceof RespawnAnchor && event.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {
                event.setCancelled(true);
                return;
            }
        }
        // Respawn Anchor Explosion Damage Item Cancellation
        if (plugin.cancelRespawnAnchorExplosionDamageItems && event instanceof EntityDamageEvent) {
            BlockState blockState = OnBlockExplode.onBlockExplodeInstance.explodedBlockState;
            Entity entity = event.getEntity();
            if (blockState != null && blockState.getBlockData() instanceof RespawnAnchor && event.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION && (entity.getType() == EntityType.ITEM)) {
                event.setCancelled(true);
                return;
            }
        }


        // Bed Explosion Damage Cancellation
        if (plugin.cancelNetherExplosionDamage && event instanceof EntityDamageEvent) {
            BlockState blockState = OnBlockExplode.onBlockExplodeInstance.explodedBlockState;
            Entity entity = event.getEntity();
            if (blockState != null && blockState.getBlockData() instanceof Bed && event.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {
                event.setCancelled(true);
                return;
            }

        }
        // Bed Explosion Damage Item Cancellation
        if (plugin.cancelNetherExplosionDamageItems && event instanceof EntityDamageEvent) {
            BlockState blockState = OnBlockExplode.onBlockExplodeInstance.explodedBlockState;
            Entity entity = event.getEntity();
            if (blockState != null && blockState.getBlockData() instanceof Bed && event.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION && (entity.getType() == EntityType.ITEM)) {
                event.setCancelled(true);
                return;
            }
        }
    }
}
