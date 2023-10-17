package org.firstinspires.ftc.teamcode.CommandSystem;

import java.util.ArrayList;

public class CommandScheduler {
    private static CommandScheduler instance = null;
    private ArrayList<Command> commands;

    private ArrayList<Trigger> triggers;

    public CommandScheduler() {
        commands = new ArrayList<>();
    }

    public void addTrigger(Trigger trigger) {
        triggers.add(trigger);
    }
    public void run() {
        for (Trigger trigger : triggers) {
            if (trigger.fired()) {
                trigger.onTrue.state = Command.State.INITIALIZED;
            }
        }
        for (Command command : commands) {
            if (command.isFinished(false)) {
                command.state = Command.State.QUEUED;
            }
            switch(command.state) {
                case SCHEDULED:
                    command.execute();
                    break;
                case INITIALIZED:
                    command.initialize();
                    command.state = Command.State.SCHEDULED;
                    break;
            }
        }
    }

    public static CommandScheduler getInstance() {
        if (instance == null) {
            instance = new CommandScheduler();
        }
        return instance;
    }
}
