package org.firstinspires.ftc.teamcode.gamecode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robots.Beyonce;
import org.firstinspires.ftc.teamcode.opmodesupport.TeleOpMode;


@TeleOp
public class JanuaryBeyonceTeleOpTestV2 extends TeleOpMode {
    Beyonce beyonce;

    public void initialize() {
        //Create object of beyonce
        beyonce = new Beyonce();
        beyonce.FrontLeft.setReverse(true);
        beyonce.BackLeft.setReverse(true);

        //Indicate that the program is running
        telemetry.addData("Status", "Initialized");
        telemetry.update();
    }

    //Gives user 2 drive control options
    boolean leftHanded = true;

    //Declaring drive variables
    double horizontal;
    double vertical;
    double pivot;

    public void loopOpMode() {
        //Drive control option one
        if (leftHanded) {
            if (gamepad1.left_bumper) {
                pivot = gamepad1.left_stick_x / 5;
                horizontal = -gamepad1.right_stick_x / 5;
                vertical = gamepad1.right_stick_y / 5;
                telemetry.addData("s", "slow");
            } else {
                pivot = gamepad1.left_stick_x;
                horizontal = -gamepad1.right_stick_x;
                vertical = gamepad1.right_stick_y;
                telemetry.addData("s", "fast");

            }
            if (gamepad1.dpad_right) {
                leftHanded = false;
            }

        //Drive control option two
        } else {
            if (gamepad1.right_trigger > 0) {
                pivot = gamepad1.right_stick_x / 5;
                horizontal = -gamepad1.left_stick_x / 5;
                vertical = gamepad1.left_stick_y /5;
                telemetry.addData("s", "slow");

            } else {
                pivot = gamepad1.right_stick_x;
                horizontal = -gamepad1.left_stick_x;
                vertical = gamepad1.left_stick_y;
                telemetry.addData("s", "fast");

            }
            if (gamepad1.dpad_left) {
                leftHanded = true;
            }
/*nice*/}

        //Drive calculations
        beyonce.FrontLeft.setPower(pivot + (vertical + horizontal));
        beyonce.FrontRight.setPower(-pivot + (vertical - horizontal));
        beyonce.BackLeft.setPower(pivot + (vertical - horizontal));
        beyonce.BackRight.setPower(-pivot + (vertical + horizontal));

        //Wobble grabber Arm
        beyonce.Arm.setPower(gamepad2.right_stick_y / 4);

        //Wobble grabber Claw
        if (gamepad2.x) {
            beyonce.ClawClose();
        } else if (gamepad2.b){
            beyonce.ClawOpen();
        }

        if (gamepad2.y) {
            beyonce.Led.setPower(0);
        }
        beyonce.Led.setPower(1);

        //Ring pusher
        if (gamepad2.right_trigger > 0) {
            beyonce.RingPusherExtend();
        } else {
            beyonce.RingPusherRetract();
        }

        //Shooter ramp
        beyonce.moveRamp(gamepad1.left_stick_y);

        //Shooter
        if (gamepad2.dpad_right) {
            beyonce.ShooterOn();
        }
        if (gamepad2.dpad_left) {
            beyonce.ShooterOff();
        }

        //Keeps user updated
        telemetry.addData("Motors", "horizontal (%.2f), vertical (%.2f), pivot (%.2f)\nslow button: (%.2f)", horizontal, vertical, pivot, gamepad1.right_trigger);
        telemetry.update();

    }
}