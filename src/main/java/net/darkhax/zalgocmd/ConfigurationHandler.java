package net.darkhax.zalgocmd;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigurationHandler {

    public static Configuration config;

    public ConfigurationHandler (File file) {

        config = new Configuration(file);

        final String[] entries = config.getStringList("commands", Configuration.CATEGORY_GENERAL, new String[] { "example1", "example2", "example3" }, "A list of commands to execute together. Use @SPLIT@ to seperate the command group from the command.");

        for (final String entry : entries) {

            final String[] parts = entry.split("@SPLIT@");

            if (parts.length == 2) {

                ZalgosCommand.addCommand(parts[0], parts[1]);
            }

            else {

                ZalgosCommand.logger.warn("Incorrect command entry! Not 2 parameters! " + entry);
            }
        }

        if (config.hasChanged()) {
            config.save();
        }
    }
}