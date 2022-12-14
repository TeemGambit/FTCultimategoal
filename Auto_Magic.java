package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;

@Autonomous(name="Lonely Robot")
public class Auto_Magic extends LinearOpMode{
    DcMotor motor1 = hardwareMap.get(DcMotor.class,"leftBack");
    DcMotor motor2 = hardwareMap.get(DcMotor.class,"rightBack");
    DcMotor motor3 = hardwareMap.get(DcMotor.class,"leftUp");
    DcMotor motor4 = hardwareMap.get(DcMotor.class,"rightUp");
    DcMotor motor5 = hardwareMap.get(DcMotor.class,"arm");
    CRServo ser1 = hardwareMap.get(CRServo.class,"ser1");
    public class move{
        private long milliTime;
        public void stop(){
            motor1.setPower(0);
            motor2.setPower(0);
            motor3.setPower(0);
            motor4.setPower(0);
        }
        public void forward(double speed, double wait){
            motor1.setPower(speed);
            motor2.setPower(-speed);
            motor3.setPower(speed);
            motor4.setPower(-speed);
            pause(wait);
            stop();
        }
        public void sideways(double speed, double wait){
            motor1.setPower(speed);
            motor2.setPower(speed);
            motor3.setPower(-speed);
            motor4.setPower(-speed); //right when positive
            pause(wait);
            stop();
        }
        public void spin(double speed, double wait){
            motor1.setPower(speed);
            motor2.setPower(speed);
            motor3.setPower(speed);
            motor4.setPower(speed);
            pause(wait);
            stop();
        }
        public void pause(double wait){
            milliTime = System.currentTimeMillis();
            while(System.currentTimeMillis() < milliTime + wait*1000 && opModeIsActive()){
            }
        }
    }
    public void runOpMode() throws InterruptedException{
        ColorSensor sense = hardwareMap.get(ColorSensor.class,"test");
        move go = new move();
        waitForStart();
        go.forward(0.6, 1.0);
        go.sideways(0.5,0.4);
        motor5.setPower(0.6);
        go.pause(0.7);
        motor5.setPower(0);
        go.forward(0.25,0.5);
        ser1.setPower(0.45);
        go.pause(0.6);
        ser1.setPower(0);
        motor5.setPower(-0.5);
        go.pause(0.7);
        motor5.setPower(0);
        go.stop();
    }
}