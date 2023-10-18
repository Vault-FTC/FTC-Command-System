package org.firstinspires.ftc.teamcode.CommandSystem;

public class InstantCommand extends Command {

    Runnable toRun;

    public InstantCommand(Runnable toRun) {
        this.toRun = toRun;
    }

    public InstantCommand() {
        this(() -> {
            
        });
    }

    @Override
    public void execute() {
        toRun.run();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
