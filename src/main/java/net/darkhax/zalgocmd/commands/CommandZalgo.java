package net.darkhax.zalgocmd.commands;

import net.darkhax.zalgocmd.ZalgosCommand;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

public class CommandZalgo extends CommandBase {

    @Override
    public String getName () {

        return "zalgo";
    }

    @Override
    public int getRequiredPermissionLevel () {

        return 2;
    }

    @Override
    public String getUsage (ICommandSender sender) {

        return "commands.zalgo.usage";
    }

    @Override
    public void execute (final MinecraftServer server, final ICommandSender sender, String[] args) throws CommandException {

        if (args.length >= 2) {

            final EntityPlayer player = getPlayer(server, sender, args[0]);

            if (player == null) {

                throw new CommandException("commands.zalgo.badplayer");
            }

            for (int index = 1; index < args.length; index++) {

                if (!ZalgosCommand.hasCommands(args[index])) {

                    throw new CommandException("commands.zalgo.unknown", args[index]);
                }

                for (final String command : ZalgosCommand.getCommands(args[index])) {

                    sender.getServer().getCommandManager().executeCommand(sender.getServer(), command.replace("@p", player.getDisplayNameString()));
                }
            }
        }

        else {

            throw new CommandException("commands.zalgo.badargs");
        }
    }

    @Override
    public boolean isUsernameIndex (String[] args, int index) {

        return index == 0;
    }
}