package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.CommandSystem.Command;
import org.firstinspires.ftc.teamcode.CommandSystem.InstantCommand;
import org.firstinspires.ftc.teamcode.CommandSystem.Trigger;
import org.firstinspires.ftc.teamcode.Control.LogitechGamepad;

public class RobotContainer {
    public Command driveCommand;
    Trigger testTrigger = new Trigger();
    HardwareMap hardwareMap;
    LogitechGamepad gamepad1;
    LogitechGamepad gamepad2;

    public RobotContainer(HardwareMap hardwareMap, Gamepad gamepad1, Gamepad gamepad2) {
        this.hardwareMap = hardwareMap;
        this.gamepad1 = new LogitechGamepad(gamepad1);
        this.gamepad2 = new LogitechGamepad(gamepad2);
        this.gamepad1.a.whileTrue(new InstantCommand());
    }
}
