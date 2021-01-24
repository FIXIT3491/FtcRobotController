package org.firstinspires.ftc.teamcode.gamecode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import org.firstinspires.ftc.teamcode.opmodesupport.AutoOpMode;
import org.firstinspires.ftc.teamcode.Robots.Beyonce;
@Autonomous
public class TestEncoder extends AutoOpMode {
    Beyonce beyonce = new Beyonce();

    @Override
    public void runOp() {
        beyonce.Shooter.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        beyonce.Shooter.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        waitForStart();
        addTimer();
        beyonce.Shooter.setPower(1);
        int velocity = 0;
        int tics1 = 0;
        int tics2 = 0;
        while (opModeIsActive()) {
            if (getSeconds() == 0) {
                tics1 = beyonce.Shooter.getPosition();
            }
            if(getSeconds() == 5) {
                tics2 = beyonce.Shooter.getPosition();
                velocity = tics2 - tics1;
                clearTimer();
            }
            telemetry.addData("Velocity: ", velocity);
            telemetry.update();
//            beyonce.Shooter.setPower(0.5);

        }
    }
}