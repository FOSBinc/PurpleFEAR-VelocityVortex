package com.qualcomm.ftcrobotcontroller.opmodes;


import com.qualcomm.robotcore.hardware.DcMotor;

import java.lang.Override;

public class FrancisTeleop extends MVTeleOpTelemetry {
    DcMotor leftback_motor;     //identify all of the motors
    DcMotor rightback_motor;
    DcMotor leftfront_motor;
    DcMotor rightfront_motor;
    //DcMotor shooterleft;
    //DcMotor shooterright;
    DcMotor tumbler;

    @Override
    public void init() {
        leftback_motor = hardwareMap.dcMotor.get("leftback_motor");     //link each motor to each
        leftfront_motor = hardwareMap.dcMotor.get("leftfront_motor");   //of the motors in the
        rightback_motor = hardwareMap.dcMotor.get("rightback_motor");   //configure file on the
        rightfront_motor = hardwareMap.dcMotor.get("rightfront_motor"); //phone
        //shooterright = hardwareMap.dcMotor.get("shooter_right");
        //shooterleft = hardwareMap.dcMotor.get("shooter_left");
        tumbler = hardwareMap.dcMotor.get("tumpler");

    }

    @Override
    public void loop() {

        float rightY = gamepad1.right_stick_y;  //create a float based off of the y axis of the left
        float leftY = -gamepad1.left_stick_y;   //and right joysticks

        telemetry.addData("RightY", rightY);    //print out the current y axis of both joysticks
        telemetry.addData("LeftY", leftY);

        leftY = (float) scaleInput(leftY);      //use the scaleInput function on the power to scale
        rightY = (float) scaleInput(rightY);    //it

        /*if(gamepad.somethingelse) {
            shooterleft.setPower(0,1)           //this aint finished
        }*/

        if(gamepad.left_trigger) {
            tumbler.setPower(1)
        }
        if(gamepad.right_trigger) {
            tumbler.setPower(-1)
        }
    }
}