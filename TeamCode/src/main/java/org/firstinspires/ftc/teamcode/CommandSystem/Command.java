package org.firstinspires.ftc.teamcode.CommandSystem;

public abstract class Command {

    protected enum State {
        QUEUED,
        INITIALIZED,
        SCHEDULED
    }

    protected State state = State.QUEUED;

    public abstract void initialize();

    public abstract void execute();

    public abstract void end();
    public abstract boolean isFinished(boolean interrupted);
}
