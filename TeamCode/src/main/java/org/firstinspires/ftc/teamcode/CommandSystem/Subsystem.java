package org.firstinspires.ftc.teamcode.CommandSystem;

import java.util.ArrayList;

public abstract class Subsystem {

    ArrayList<Command> requirements;

    Command defaultCommand = null;

    public Subsystem() {
        CommandScheduler.getInstance().subsystems.add(this);
        requirements = new ArrayList<>();
    }

    final void cancelConflictingCommands() {
        Command toRun = null;
        int priority;
        for (Command requirement : requirements) {
            if (requirement.state == Command.State.QUEUED || requirement.state == Command.State.SCHEDULED) {
                if (toRun == null)
                    priority = -1;
                else
                    priority = toRun.type.ordinal();

                if (requirement.type.ordinal() > priority) {
                    toRun = requirement;
                } else {
                    requirement.cancel();
                }
            }
        }
    }

    public final void setDefaultCommand(Command command) {
        command.type = Command.Type.DEFAULT_COMMAND;
        defaultCommand.type = Command.Type.NORMAL;
        defaultCommand = command;
    }

    public void periodic() {
    }
}
