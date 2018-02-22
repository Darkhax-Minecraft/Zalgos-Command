package net.darkhax.zalgocmd.crt;

import crafttweaker.IAction;
import net.darkhax.zalgocmd.ZalgosCommand;

public class ActionAddCommand implements IAction {

    private final String commandGroup;
    private final String command;

    public ActionAddCommand (String commandGroup, String command) {

        this.commandGroup = commandGroup;
        this.command = command;
    }

    @Override
    public void apply () {

        ZalgosCommand.addCommand(this.commandGroup, this.command);
    }

    @Override
    public String describe () {

        return String.format("Added to %s, %s", this.commandGroup, this.command);
    }
}