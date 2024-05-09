package xyz.subaka.subisantigriefing.events;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.entity.minecart.ExplosiveMinecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import xyz.subaka.subisantigriefing.SubisAntiGriefing;


public class OnEntityExplode implements Listener {
    private final SubisAntiGriefing plugin;

    public OnEntityExplode(SubisAntiGriefing plugin) {
        this.plugin = plugin;
    }

    // Block damage
    @EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {
        //Creeper Explosion
        if (plugin.cancelCreeperGrief && event.getEntity() instanceof Creeper) {
            event.blockList().clear();
        }
        if (plugin.cancelCreeperExplode && event.getEntity() instanceof Creeper) {
            event.setCancelled(true);
        }
        //End_Crystal Explosion
        if(plugin.cancelEnderCrystalGrief && event.getEntity() instanceof EnderCrystal){
            event.blockList().clear();
        }
        if (plugin.cancelEnderCrystalExplode && event.getEntity() instanceof EnderCrystal) {
            event.setCancelled(true);
        }
        //TnT Explosion
        if(plugin.cancelTnTGrief && event.getEntity() instanceof TNTPrimed){
            event.blockList().clear();
        }
        if (plugin.cancelTnTExplode && event.getEntity() instanceof TNTPrimed) {
            event.setCancelled(true);
        }
        //TnT Minecart Explosion
        if(plugin.cancelTnTMinecartGrief && event.getEntity() instanceof ExplosiveMinecart){
            event.blockList().clear();
        }
        if (plugin.cancelTnTMinecartExplode && event.getEntity() instanceof ExplosiveMinecart) {
            event.setCancelled(true);
        }
        //Ghast Fireball Explosion
        if(plugin.cancelGhastFireballGrief && event.getEntity() instanceof Fireball){
            event.blockList().clear();
        }

    }


}
