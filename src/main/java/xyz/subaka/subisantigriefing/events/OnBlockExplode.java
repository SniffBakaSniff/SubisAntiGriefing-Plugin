package xyz.subaka.subisantigriefing.events;

import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import xyz.subaka.subisantigriefing.SubisAntiGriefing;

public class OnBlockExplode implements Listener {
    private final SubisAntiGriefing plugin;
    public BlockState explodedBlockState;

    public static OnBlockExplode onBlockExplodeInstance;
    public OnBlockExplode(SubisAntiGriefing plugin) {
        onBlockExplodeInstance = this;
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockExplode(BlockExplodeEvent event) {
        explodedBlockState = event.getExplodedBlockState();
        BlockData blockData = explodedBlockState.getBlockData();
        if (plugin.cancelRespawnAnchorExplosionGrief && blockData instanceof RespawnAnchor) {
            event.blockList().clear();
            if (plugin.cancelRespawnAnchorExplosion) {
                event.setCancelled(true);
                return;
            }
        } else if (plugin.cancelNetherExplosionGrief && blockData instanceof Bed) {
            event.blockList().clear();
            if (plugin.cancelNetherExplosion) {
                event.setCancelled(true);
                return;
            }
        }
    }
}
