package com.qualcomm.ftcrobotcontroller.opmodes;


import com.qualcomm.robotcore.hardware.DcMotor;


/**
 * Created by Francis Fernandez on 11/29/2015.
 */
public class MVMSTeleOpTankMode extends MVTeleOpTelemetry{
    DcMotor leftback_motor;     //identify all of the motors
    DcMotor rightback_motor;
    DcMotor leftfront_motor;
    DcMotor rightfront_motor;
    DcMotor shooter;


    @Override
    public void init() {
        leftback_motor = hardwareMap.dcMotor.get("leftback_motor");     //link each motor to each
        leftfront_motor = hardwareMap.dcMotor.get("leftfront_motor");   //of the motors in the
        rightback_motor = hardwareMap.dcMotor.get("rightback_motor");   //configure file on the
        rightfront_motor = hardwareMap.dcMotor.get("rightfront_motor"); //phone
        shooter = hardwareMap.dcMotor.get("shooter");


    }

    @Override
    public void loop() {                        //create a loop where the code goes

        float rightY = gamepad1.right_stick_y;  //create a float based off of the y axis of the left
        float leftY = -gamepad1.left_stick_y;   //and right joysticks
        telemetry.addData("RightY", rightY);    //print out the current y axis of both joysticks
        telemetry.addData("LeftY", leftY);
        telemetry.addData("In", in);

        leftY = (float) scaleInput(leftY);      //use the scaleInput function on the power to scale
        rightY = (float) scaleInput(rightY);    //it

        leftback_motor.setPower(leftY);         //set the power to each corresponding motor
        rightback_motor.setPower(rightY);
        leftfront_motor.setPower(leftY);
        rightfront_motor.setPower(rightY);

        if(gamepad.right_trigger) {
        }

    }




    double scaleInput(double dVal)  {
        double[] scaleArray = { 0.0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.24,
                0.30, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00 };


        // get the corresponding index for the scaleInput array.
        int index = (int) (dVal * 16.0);


        // index should be positive.
        if (index < 0) {
            index = -index;
        }


        // index cannot exceed size of array minus 1.
        if (index > 16) {
            index = 16;
        }


        // get value from the array.
        double dScale = 0.0;
        if (dVal < 0) {
            dScale = -scaleArray[index];
        } else {
            dScale = scaleArray[index];
        }


        // return scaled value.
        return dScale;
    }
}


