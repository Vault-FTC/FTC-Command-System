package org.firstinspires.ftc.teamcode.CommandSystem;

public class Trigger {

    protected Command onTrue;
    public Trigger() {
        CommandScheduler.getInstance().addTrigger(this);
    }

    public void onTrue(Command command) {
        onTrue = command;
    }
    boolean fired() {
        return false;
    }
}
