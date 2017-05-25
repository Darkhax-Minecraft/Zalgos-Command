package net.darkhax.zalgocmd.crt;

import minetweaker.MineTweakerAPI;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.ZalgoCMD")
public class ZalgosCommandTweaker {

    @ZenMethod
    public static void addCommand (String commandGroup, String command) {

        MineTweakerAPI.apply(new ActionAddCommand(commandGroup, command));
    }

}
