package net.darkhax.zalgocmd.crt;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenClass("mods.ZalgoCMD")
public class ZalgosCommandTweaker {

    @ZenMethod
    public static void addCommand (String commandGroup, String command) {

        CraftTweakerAPI.apply(new ActionAddCommand(commandGroup, command));
    }
}
