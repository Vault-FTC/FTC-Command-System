package org.firstinspires.ftc.teamcode.Commands;

import org.firstinspires.ftc.teamcode.CommandSystem.Command;
import org.firstinspires.ftc.teamcode.Subsystems.DriveSubsystem;

import java.util.function.DoubleSupplier;

public class DriveDefaultCommand extends Command {
    DriveSubsystem subsystem;
    DoubleSupplier drive;
    DoubleSupplier strafe;
    DoubleSupplier turn;

    public DriveDefaultCommand(DriveSubsystem subsystem, DoubleSupplier drive, DoubleSupplier strafe, DoubleSupplier turn) {
        this.subsystem = subsystem;
        this.drive = drive;
        this.strafe = strafe;
        this.turn = turn;
        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        subsystem.simpleMecanDrive(drive.getAsDouble(), strafe.getAsDouble(), turn.getAsDouble());
    }
}
