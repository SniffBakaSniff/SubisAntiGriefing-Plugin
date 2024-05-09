package xyz.subaka.subisantigriefing;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.subaka.subisantigriefing.commands.Reload;
import xyz.subaka.subisantigriefing.commands.ReloadTabCompleter;
import xyz.subaka.subisantigriefing.events.*;

import java.util.List;

public final class SubisAntiGriefing extends JavaPlugin implements Listener {
    public boolean cancelCreeperGrief;
    public boolean cancelCreeperExplode;
    public boolean cancelCreeperDamage;
    public boolean cancelCreeperDamageItem;

    public boolean cancelEnderCrystalGrief;
    public boolean cancelEnderCrystalExplode;
    public boolean cancelEnderCrystalDamage;
    public boolean cancelEnderCrystalDamageItem;
    public boolean cancelTnTGrief;
    public boolean cancelTnTExplode;
    public boolean cancelTnTDamage;
    public boolean cancelTnTDamageItem;
    public boolean cancelTnTMinecartGrief;
    public boolean cancelTnTMinecartExplode;
    public boolean cancelTnTMinecartDamage;
    public boolean cancelTnTMinecartDamageItem;
    public boolean cancelNetherExplosionGrief;
    public boolean cancelNetherExplosion;
    public boolean cancelNetherExplosionDamage;
    public boolean cancelNetherExplosionDamageItems;
    public boolean cancelRespawnAnchorExplosionGrief;
    public boolean cancelRespawnAnchorExplosion;
    public boolean cancelRespawnAnchorExplosionDamage;
    public boolean cancelRespawnAnchorExplosionDamageItems;
    public boolean cancelEndermanGrief;
    public boolean cancelRavagerGrief;
    public boolean cancelGhastFireballGrief;
    public boolean cancelGhastFireball;
    public boolean cancelGhastFireballDamage;
    public boolean cancelGhastFireballDamageItem;
    public boolean preventDoorBreak; // Option to prevent door breaking
    public List<String> doorBreakingMobs;
    public boolean cancelCropTrampling;
    public boolean cancelEntityTurtleEggSquishing;
    public boolean cancelPlayerTurtleEggSquishing;

    @Override
    public void onEnable() {


        getLogger().info("                                                               \n" +
                "           _     _                 _   _            _       __ \n" +
                "          | |   (_)               | | (_)          (_)     / _|\n" +
                " ___ _   _| |__  _ ___  __ _ _ __ | |_ _  __ _ _ __ _  ___| |_ \n" +
                "/ __| | | | '_ \\| / __|/ _` | '_ \\| __| |/ _` | '__| |/ _ \\  _|\n" +
                "\\__ \\ |_| | |_) | \\__ \\ (_| | | | | |_| | (_| | |  | |  __/ |  \n" +
                "|___/\\__,_|_.__/|_|___/\\__,_|_| |_|\\__|_|\\__, |_|  |_|\\___|_|  \n" +
                "                                          __/ |                \n" +
                "                                         |___/                 ");
        getLogger().info("Initilizing AntiGrief Protocols.");
        getLogger().info("Initilizing UwU Protocols.");
        getLogger().info("Initilizing BoyKisser Protocols.");
        getLogger().info("Initilizing Furry Protocols.");

        saveDefaultConfig();

        cancelCreeperGrief = getConfig().getBoolean("Creeper.cancelCreeperGrief", false);
        cancelCreeperExplode = getConfig().getBoolean("Creeper.cancelCreeperExplode", false);
        cancelCreeperDamage = getConfig().getBoolean("Creeper.cancelCreeperDamage", false);
        cancelCreeperDamageItem = getConfig().getBoolean("Creeper.cancelCreeperDamageItem", false);

        cancelEnderCrystalGrief = getConfig().getBoolean("EnderCrystal.cancelEnderCrystalGrief", false);
        cancelEnderCrystalExplode = getConfig().getBoolean("EnderCrystal.cancelEnderCrystalExplode", false);
        cancelEnderCrystalDamage = getConfig().getBoolean("EnderCrystal.cancelEnderCrystalDamage", false);
        cancelEnderCrystalDamageItem = getConfig().getBoolean("EnderCrystal.cancelEnderCrystalDamageItem", false);

        cancelTnTGrief = getConfig().getBoolean("TnT.cancelTnTGrief", false);
        cancelTnTExplode = getConfig().getBoolean("TnT.cancelTnTExplode", false);
        cancelTnTDamage = getConfig().getBoolean("TnT.cancelTnTDamage", false);
        cancelTnTDamageItem = getConfig().getBoolean("TnT.cancelTnTDamageItem", false);

        cancelTnTMinecartGrief = getConfig().getBoolean("TnTMinecart.cancelTnTMinecartGrief", false);
        cancelTnTMinecartExplode = getConfig().getBoolean("TnTMinecart.cancelTnTMinecartExplode", false);
        cancelTnTMinecartDamage = getConfig().getBoolean("TnTMinecart.cancelTnTMinecartDamage", false);
        cancelTnTMinecartDamageItem = getConfig().getBoolean("TnTMinecart.cancelTnTMinecartDamageItem", false);

        cancelNetherExplosionGrief = getConfig().getBoolean("Beds.cancelNetherExplosionGrief", false);
        cancelNetherExplosion = getConfig().getBoolean("Beds.cancelNetherExplosion", false);
        cancelNetherExplosionDamage = getConfig().getBoolean("Beds.cancelNetherExplosionDamage", false);
        cancelNetherExplosionDamageItems = getConfig().getBoolean("Beds.cancelNetherExplosionDamageItems", false);

        cancelRespawnAnchorExplosionGrief = getConfig().getBoolean("RespawnAnchor.cancelRespawnAnchorExplosionGrief", false);
        cancelRespawnAnchorExplosion = getConfig().getBoolean("RespawnAnchor.cancelRespawnAnchorExplosion", false);
        cancelRespawnAnchorExplosionDamage = getConfig().getBoolean("RespawnAnchor.cancelRespawnAnchorExplosionDamage", false);
        cancelRespawnAnchorExplosionDamageItems = getConfig().getBoolean("RespawnAnchor.cancelRespawnAnchorExplosionDamageItems", false);

        cancelEndermanGrief = getConfig().getBoolean("Enderman.cancelEndermanGrief", false);

        cancelRavagerGrief = getConfig().getBoolean("Ravager.cancelRavagerGrief", false);

        cancelGhastFireballGrief = getConfig().getBoolean("Ghast.cancelGhastFireballGrief", false);
        cancelGhastFireball = getConfig().getBoolean("Ghast.cancelGhastFireball", false);
        cancelGhastFireballDamage = getConfig().getBoolean("Ghast.cancelGhastFireballDamage", false);
        cancelGhastFireballDamageItem = getConfig().getBoolean("Ghast.cancelGhastFireballDamageItem", false);

        preventDoorBreak = getConfig().getBoolean("preventDoorBreak", false);
        doorBreakingMobs = getConfig().getStringList("doorBreakingMobs");

        cancelCropTrampling = getConfig().getBoolean("MISC.cancelCropTrampling", false);
        cancelEntityTurtleEggSquishing = getConfig().getBoolean("MISC.cancelEntityTurtleEggSquishing", false);
        cancelPlayerTurtleEggSquishing = getConfig().getBoolean("MISC.cancelPlayerTurtleEggSquishing", false);

        // Register events
        getServer().getPluginManager().registerEvents(new OnEntityExplode(this), this);
        getServer().getPluginManager().registerEvents(new OnBlockExplode(this), this);
        getServer().getPluginManager().registerEvents(new OnEntityDamage(this), this);
        getServer().getPluginManager().registerEvents(new OnEntityChangeBlock(this), this);
        getServer().getPluginManager().registerEvents(new OnPlayerInteract(this), this);
        getServer().getPluginManager().registerEvents(new OnEntityInteract(this), this);
        getServer().getPluginManager().registerEvents(new OnEntityTarget(this), this);
        getServer().getPluginManager().registerEvents(new OnEntitySpawn(this), this);

        //Register Commands
        getCommand("SubisAntiGriefing").setExecutor(new Reload(this));
        this.getCommand("subisantigriefing").setTabCompleter(new ReloadTabCompleter());

    }
    @Override
    public void onDisable() {
    }

}

