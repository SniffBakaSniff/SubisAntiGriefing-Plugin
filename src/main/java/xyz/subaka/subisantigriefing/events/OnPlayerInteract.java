package xyz.subaka.subisantigriefing.events;


import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.RespawnAnchor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import xyz.subaka.subisantigriefing.SubisAntiGriefing;

public class OnPlayerInteract implements Listener {
    private final SubisAntiGriefing plugin;

    public OnPlayerInteract(SubisAntiGriefing plugin) {
        this.plugin = plugin;
    }

    // Crop Trampling
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {

        Block clickedBlock = event.getClickedBlock();

        if (plugin.cancelCropTrampling && event.getAction() == Action.PHYSICAL && event.getClickedBlock() != null &&
                event.getClickedBlock().getType() == Material.FARMLAND) {
            event.setCancelled(true);
        }
        //Turtle Egg Squishing
        if (plugin.cancelPlayerTurtleEggSquishing && event.getAction() == Action.PHYSICAL && event.getClickedBlock() != null &&
                event.getClickedBlock().getType() == Material.TURTLE_EGG) {
            event.setCancelled(true);
        }
        if (plugin.cancelRespawnAnchorExplosion && clickedBlock != null && clickedBlock.getType() == Material.RESPAWN_ANCHOR) {
            if (clickedBlock.getBlockData() instanceof RespawnAnchor) {
                RespawnAnchor respawnAnchor = (RespawnAnchor) clickedBlock.getBlockData();
                int charges = respawnAnchor.getCharges();
                if (charges == respawnAnchor.getMaximumCharges()) {
                    event.setCancelled(true);
                    Player player = event.getPlayer();
                    //player.sendMessage(ChatColor.YELLOW + "Warning: Your respawn anchor is fully charged!");
                }
            }
        }
    }
}



