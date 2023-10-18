package org.firstinspires.ftc.teamcode.CommandSystem;

import java.util.function.BooleanSupplier;

public class Trigger implements BooleanSupplier {
    private BooleanSupplier condition;
    private boolean lastState = false;

    public Trigger(BooleanSupplier condition) {
        this.condition = condition;
    }

    public Trigger() {
        this(() -> false);
    }

    public Trigger whileTrue(Command command) {
        command.triggers.add(this);
        return this;
    }

    public Trigger onTrue(Command command) {
        command.triggers.add(new Trigger(() -> !lastState && getAsBoolean()));
        return this;
    }

    public Trigger onFalse(Command command) {
        command.triggers.add(new Trigger(() -> lastState && !getAsBoolean()));
        return this;
    }

    @Override
    public boolean getAsBoolean() {
        lastState = condition.getAsBoolean();
        return lastState;
    }
}
