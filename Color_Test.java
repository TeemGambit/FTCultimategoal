package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;

@TeleOp(name="color testing")
public class Color_Test extends LinearOpMode{
    @Override
    public void runOpMode() throws InterruptedException{
        ColorSensor sense = hardwareMap.get(ColorSensor.class,"test");
        waitForStart();
        double redness;
        double blueness;
        String type;
        while (opModeIsActive()){
            telemetry.addData("R", sense.red());
            telemetry.addData("G", sense.green());
            telemetry.addData("B", sense.blue());
            redness = (0.0+sense.red())/sense.green();
            blueness= (0.0+sense.blue())/sense.green();
            telemetry.addData("R/G",redness);
            telemetry.addData("B/G",blueness);
            type = "Purple!";
            if (blueness < 1.0)
                type = "Purple?";
            if (blueness < 0.9)
                type = "Green?";
            if (blueness < 0.8) {
                type = "Green!";
                if (redness > 0.6)
                    type = "Green?";
                if (redness > 0.65)
                    type = "Orange?";
                if (redness > 0.7)
                    type = "Orange!";
            }
            telemetry.addData("Filter",type);
            telemetry.speak("Alive", null, null);
            telemetry.update();
        }
    }
}
