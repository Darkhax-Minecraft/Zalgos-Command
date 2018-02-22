package net.darkhax.zalgocmd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;

import net.darkhax.zalgocmd.commands.CommandZalgo;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = "zalgoscommand", name = "Zalgo's Command", version = "@VERSION@", dependencies = "after:crafttweaker", certificateFingerprint = "@FINGERPRINT@")
public class ZalgosCommand {

    public static final Map<String, List<String>> COMMANDS = new HashMap<>();
    public static Logger logger;

    @EventHandler
    public void preInit (FMLPreInitializationEvent event) {

        logger = event.getModLog();
        new ConfigurationHandler(event.getSuggestedConfigurationFile());
    }

    @EventHandler
    public void serverStarting (FMLServerStartingEvent event) {

        event.registerServerCommand(new CommandZalgo());
    }

    public static boolean hasCommands (String id) {

        return COMMANDS.containsKey(id);
    }

    public static List<String> getCommands (String id) {

        if (!COMMANDS.containsKey(id)) {

            COMMANDS.put(id, new ArrayList<String>());
        }

        return COMMANDS.get(id);
    }

    public static void addCommand (String id, String command) {

        if (!COMMANDS.containsKey(id)) {

            COMMANDS.put(id, new ArrayList<String>());
        }

        COMMANDS.get(id).add(command);
    }

    public static void removeCommand (String id, String command) {

        if (!COMMANDS.containsKey(id)) {

            COMMANDS.put(id, new ArrayList<String>());
        }

        COMMANDS.get(id).remove(command);
    }
}