package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.CRServo;

//To do list:
//Map out autonomous
//Set positions for servos
//Create custom cover for signal
//Think about team element

@TeleOp(name="Everyone")
public class Here_we_GOOOOO extends LinearOpMode{
    @Override
    public void runOpMode() throws InterruptedException { //Initialize
        DcMotor motor1 = hardwareMap.get(DcMotor.class,"leftBack");
        DcMotor motor2 = hardwareMap.get(DcMotor.class,"rightBack");
        DcMotor motor3 = hardwareMap.get(DcMotor.class,"leftUp");
        DcMotor motor4 = hardwareMap.get(DcMotor.class,"rightUp");
        DcMotorEx motor5 = hardwareMap.get(DcMotorEx.class,"arm");
        motor5.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        CRServo ser1 = hardwareMap.get(CRServo.class,"ser1");
        double sped=-0.4;
        double arm=400;
        double ser=0.5;
        waitForStart();
        while (opModeIsActive()) { //Movement
            if (gamepad1.right_stick_x != 0) {  //To turn the robot
                motor1.setPower(1*sped * (gamepad1.right_stick_x));
                motor2.setPower(1*sped * (gamepad1.right_stick_x));
                motor3.setPower(1*sped * (gamepad1.right_stick_x));
                motor4.setPower(1*sped * (gamepad1.right_stick_x));
            }
            else {
                motor1.setPower(sped * (gamepad1.left_stick_x - gamepad1.left_stick_y));
                motor2.setPower(sped * (gamepad1.left_stick_x + gamepad1.left_stick_y));
                motor3.setPower(sped * (-gamepad1.left_stick_x - gamepad1.left_stick_y));
                motor4.setPower(sped * (-gamepad1.left_stick_x + gamepad1.left_stick_y));
            }
            // arm and such
            if (gamepad2.left_stick_y>0.1)
                motor5.setVelocity(arm);
            else {
                if (gamepad2.left_stick_y<-0.1)
                    motor5.setVelocity(-arm);
                else
                    motor5.setVelocity(0);
            }
            if (gamepad2.a || gamepad2.left_bumper)
                ser1.setPower(-ser);
            else {
                if (gamepad2.x || gamepad2.right_bumper)
                    ser1.setPower(ser);
                else
                    ser1.setPower(0);
            }
        }
    }
}