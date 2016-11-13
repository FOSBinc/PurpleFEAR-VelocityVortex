package org.firstinspires.ftc.robotcontroller.external.samples;


import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Practice TeleOp", group="K9bot")
@Disabled
public class Test_TeleOp_Aakarsh extends LinearOpMode {

    double          armPosition;
    double          clawPosition;
    final double    ARM_SPEED       = 0.01 ;
    final double    CLAW_SPEED       = 0.01 ;

    @Override
    public void runOpMode() {
        double front;
        double back;


        //robot.init(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {

            front = -gamepad1.left_stick_y;
            back = -gamepad1.right_stick_y;
            //robot.leftMotor.setPower(front);
            //robot.rightMotor.setPower(back);


            if (gamepad1.a)
                armPosition += ARM_SPEED;
            else if (gamepad1.y)
                armPosition -= ARM_SPEED;

            if (gamepad1.x)
                clawPosition += CLAW_SPEED;
            else if (gamepad1.b)
                clawPosition -= CLAW_SPEED;

        }


    }

    }