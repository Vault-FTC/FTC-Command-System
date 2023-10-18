package org.firstinspires.ftc.teamcode.CommandSystem;

import java.util.ArrayList;

public abstract class Command {
    ArrayList<Trigger> triggers;

    public Command() {
        CommandScheduler.getInstance().commands.add(this);
    }

    enum State {
        UNSCHEDULED,
        QUEUED,
        SCHEDULED,
        ENDING
    }

    enum Type {
        DEFAULT_COMMAND,
        NORMAL
    }

    Type type = Type.NORMAL;

    final boolean triggered() {
        if (type == Type.DEFAULT_COMMAND) return true;
        for (Trigger trigger : triggers) {
            if (trigger.getAsBoolean()) {
                return true;
            }
        }
        return false;
    }

    protected State state = State.UNSCHEDULED;

    public void initialize() {

    }

    public abstract void execute();

    public void end(boolean interrupted) {

    }

    public boolean isFinished() {
        return false;
    }

    public void schedule() {
        state = State.QUEUED;
    }

    public void cancel() {
        state = State.UNSCHEDULED;
        end(true);
    }

    protected void addRequirements(Subsystem... subsystems) {
        for (Subsystem subsystem : subsystems) {
            subsystem.requirements.add(this);
        }
    }
}
