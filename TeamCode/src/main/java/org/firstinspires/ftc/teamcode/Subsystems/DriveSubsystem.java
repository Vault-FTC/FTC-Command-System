package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.CommandSystem.Subsystem;

public class DriveSubsystem extends Subsystem {
    HardwareMap hardwareMap;
    DcMotor lf;
    DcMotor rf;
    DcMotor lb;
    DcMotor rb;

    public DriveSubsystem(HardwareMap hardwareMap) {
        this.hardwareMap = hardwareMap;
        lf = hardwareMap.get(DcMotor.class, "left front");
        rf = hardwareMap.get(DcMotor.class, "right front");
        lb = hardwareMap.get(DcMotor.class, "left back");
        rb = hardwareMap.get(DcMotor.class, "right back");
    }

    public void simpleMecanDrive(double drive, double strafe, double turn) {
        lf.setPower(drive - strafe - turn);
        rf.setPower(drive + strafe + turn);
        lb.setPower(drive + strafe - turn);
        rb.setPower(drive - strafe + turn);
    }

    @Override
    public void periodic() {
        
    }
}
