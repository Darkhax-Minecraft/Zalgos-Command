package net.darkhax.zalgocmd.crt;

import minetweaker.IUndoableAction;
import net.darkhax.zalgocmd.ZalgosCommand;

public class ActionAddCommand implements IUndoableAction {

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

    @Override
    public void undo () {

        ZalgosCommand.removeCommand(this.commandGroup, this.command);
    }

    @Override
    public String describeUndo () {

        return String.format("Removed from %s, %s", this.commandGroup, this.command);
    }

    @Override
    public Object getOverrideKey () {

        return null;
    }

    @Override
    public boolean canUndo () {

        return true;
    }
}