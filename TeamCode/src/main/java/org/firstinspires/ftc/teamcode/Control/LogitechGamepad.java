package org.firstinspires.ftc.teamcode.Control;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.CommandSystem.Trigger;

public class LogitechGamepad {
    private Gamepad gamepad;
    public Trigger a;
    public Trigger b;
    public Trigger x;
    public Trigger y;

    public LogitechGamepad(Gamepad gamepad) {
        this.gamepad = gamepad;
        a = new Trigger(() -> gamepad.a);
        b = new Trigger(() -> gamepad.b);
        x = new Trigger(() -> gamepad.x);
        y = new Trigger(() -> gamepad.y);
    }
}
