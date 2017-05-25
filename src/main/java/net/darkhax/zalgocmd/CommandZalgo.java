package net.darkhax.zalgocmd;

import java.util.Collections;
import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

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
                
                for (String command : ZalgosCommand.getCommands(args[index])) {
                    
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