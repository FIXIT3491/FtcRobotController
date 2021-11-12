package org.firstinspires.ftc.teamcode.Competition.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Season_Setup.Ducky;


@Autonomous(name="Ramming through Barrier - P1, Blue")

public class RammingThroughBarrier_P1_Blue extends LinearOpMode {

    // Initializing Robot Class
    Ducky ducky = new Ducky();

    @Override
    public void runOpMode() throws InterruptedException{

        // Initialize all motors/ servos
        ducky.init(hardwareMap, telemetry);

        // Wait for the game to begin
        telemetry.addData(">", "Press Play to start op mode");
        telemetry.update();

        // Waiting for the program to start
        waitForStart();

        // Autonomous Pathing
        ducky.DriveForward_Power(1,1000);
        Thread.sleep(500);
        ducky.TurnLeft_Power(1,400);
        Thread.sleep(500);
        ducky.DriveForward_Power(1,2000);
    }
}
