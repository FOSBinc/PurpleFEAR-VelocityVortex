package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;

public class EdmundTeleop extends MVTeleOpTelemetry {
    DcMotor leftback_motor;     //identify all of the motors
    DcMotor rightback_motor;
    DcMotor leftfront_motor;
    DcMotor rightfront_motor;
    /* DcMotor shooter_left;
     DcMotor shooter_right;*/
    DcMotor tumbler;


    @Override
    public void init() {
        leftback_motor = hardwareMap.dcMotor.get("leftback_motor");     //link each motor to each
        leftfront_motor = hardwareMap.dcMotor.get("leftfront_motor");   //of the motors in the
        rightback_motor = hardwareMap.dcMotor.get("rightback_motor");   //configure file on the
        rightfront_motor = hardwareMap.dcMotor.get("rightfront_motor"); //phone
        /*shooter = hardwareMap.dcMotor.get("shooter_right");
        shooter = hardwareMap.dcMotor.get("shooter_left");*/
        tumbler = hardwareMap.dcMotor.get("tumbler");


    }

    @Override
    public void loop() {
        float rightY = gamepad1.right_stick_y;  //create a float based off of the y axis of the left
        float leftY = -gamepad1.left_stick_y;   //and right joysticks
        telemetry.addData("RightY", rightY);    //print out the current y axis of both joysticks
        telemetry.addData("LeftY", leftY);
        leftY = (float) scaleInput(leftY);      //use the scaleInput function on the power to scale
        rightY = (float) scaleInput(rightY);    //it

        leftback_motor.setPower(leftY);         //set the power to each corresponding motor
        rightback_motor.setPower(rightY);
        leftfront_motor.setPower(leftY);
        rightfront_motor.setPower(rightY);


        /*if(gamepad.something out){
            shooter_left.setPower(0,1);
        }
        */

        if (gamepad.left_trigger) {

            tumbler.setPower(1)
        }
        if (gamepad.right_trigger) {
            tumbler.setPower(-1)
        }

    }
}
