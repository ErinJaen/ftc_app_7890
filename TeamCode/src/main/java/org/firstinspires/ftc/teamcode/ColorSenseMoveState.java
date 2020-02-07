package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.StateMachine.State;

import java.util.ArrayList;

public class ColorSenseMoveState implements State {
    DcMotor leftFront;
    DcMotor rightFront;
    DcMotor leftBack;
    DcMotor rightBack;
    String cval;
    State NextState;
    ColorSensor cs1;
    String dir;
    double pow;
    int red;
    public ColorSenseMoveState(ArrayList<DcMotor> motor, ColorSensor colorSensor, String color, double power, String direction){
        leftFront = motor.get(0);
        rightFront = motor.get(1);
        leftBack = motor.get(2);
        rightBack = motor.get(3);
        cs1 = colorSensor;
        cval = color;
        pow = power;
        dir = direction;
        //red = cs1.red();
    }

    public void setNextState(State state) {
        NextState = state;
    }

    public State update(){

        if(cval.equals("red")){
            if(dir.equals("forward")){
                leftBack.setPower(-pow);
                leftFront.setPower(-pow);
                rightBack.setPower(-pow);
                rightFront.setPower(-pow);
            }
            else if(dir.equals("backward")){
                leftBack.setPower(pow);
                leftFront.setPower(pow);
                rightBack.setPower(pow);
                rightFront.setPower(pow);
            }
            else if (dir.equals("right")) {//robot strafes right
                leftFront.setPower(pow);
                rightFront.setPower(-pow);
                leftBack.setPower(-pow);
                rightBack.setPower(pow);
            }
            else if(dir.equals("left")) {
                leftFront.setPower(-pow);
                rightFront.setPower(pow);
                leftBack.setPower(pow);
                rightBack.setPower(-pow);
            }

            if(/*cs1.red()> 1000 && */!(cs1.red()>cs1.blue() && cs1.red()>cs1.green())){
                leftBack.setPower(0);
                leftFront.setPower(0);
                rightBack.setPower(0);
                rightFront.setPower(0);
                return NextState;
            }

            return this;
        }
        else if(cval.equals("blue")){
            if(dir.equals("forward")){
                leftBack.setPower(-pow);
                leftFront.setPower(-pow);
                rightBack.setPower(-pow);
                rightFront.setPower(-pow);
            }
            else if(dir.equals("backward")){
                leftBack.setPower(pow);
                leftFront.setPower(pow);
                rightBack.setPower(pow);
                rightFront.setPower(pow);
            }
            else if (dir.equals("right")) {//robot strafes right
                leftFront.setPower(pow);
                rightFront.setPower(-pow);
                leftBack.setPower(-pow);
                rightBack.setPower(pow);
            }
            else if(dir.equals("left")) {
                leftFront.setPower(-pow);
                rightFront.setPower(pow);
                leftBack.setPower(pow);
                rightBack.setPower(-pow);
            }

            if(/*cs1.blue()> 1000 &&*/ !(cs1.blue()>cs1.red() && cs1.blue()>cs1.green())){
                leftBack.setPower(0);
                leftFront.setPower(0);
                rightBack.setPower(0);
                rightFront.setPower(0);
                return NextState;
            }


            return this;
        }
        else if(cval.equals("yellow")){
            if(dir.equals("forward")){
                leftBack.setPower(-pow);
                leftFront.setPower(-pow);
                rightBack.setPower(-pow);
                rightFront.setPower(-pow);
            }
            else if(dir.equals("backward")){
                leftBack.setPower(pow);
                leftFront.setPower(pow);
                rightBack.setPower(pow);
                rightFront.setPower(pow);
            }
            else if (dir.equals("right")) {//robot strafes right
                leftFront.setPower(pow);
                rightFront.setPower(-pow);
                leftBack.setPower(-pow);
                rightBack.setPower(pow);
            }
            else if(dir.equals("left")) {
                leftFront.setPower(-pow);
                rightFront.setPower(pow);
                leftBack.setPower(pow);
                rightBack.setPower(-pow);
            }

            if(/*cs1.blue()> 1000 &&*/ !(cs1.blue()<cs1.red() && cs1.blue()<cs1.green())){
                //wait(100); //hardcode for now while waiting sensors to come
                leftBack.setPower(0);
                leftFront.setPower(0);
                rightBack.setPower(0);
                rightFront.setPower(0);
                return NextState;
            }


            return this;
        }
        else if(cval.equals("black")){
            if(dir.equals("forward")){
                leftBack.setPower(-pow);
                leftFront.setPower(-pow);
                rightBack.setPower(-pow);
                rightFront.setPower(-pow);
            }
            else if(dir.equals("backward")){
                leftBack.setPower(pow);
                leftFront.setPower(pow);
                rightBack.setPower(pow);
                rightFront.setPower(pow);
            }
            else if (dir.equals("right")) {//robot strafes right
                leftFront.setPower(pow);
                rightFront.setPower(-pow);
                leftBack.setPower(-pow);
                rightBack.setPower(pow);
            }
            else if(dir.equals("left")) {
                leftFront.setPower(-pow);
                rightFront.setPower(pow);
                leftBack.setPower(pow);
                rightBack.setPower(-pow);
            }

            if(/*cs1.blue()> 1000 &&*/ !(cs1.blue()<100 && cs1.green()<100 && cs1.red()<100)){
                leftBack.setPower(0);
                leftFront.setPower(0);
                rightBack.setPower(0);
                rightFront.setPower(0);
                return NextState;
            }


            return this;
        }
        else if(cval.equals("black and yellow")){
            if(dir.equals("forward")){
                leftBack.setPower(-pow);
                leftFront.setPower(-pow);
                rightBack.setPower(-pow);
                rightFront.setPower(-pow);
            }
            else if(dir.equals("backward")){
                leftBack.setPower(pow);
                leftFront.setPower(pow);
                rightBack.setPower(pow);
                rightFront.setPower(pow);
            }
            else if (dir.equals("right")) {//robot strafes right
                leftFront.setPower(pow);
                rightFront.setPower(-pow);
                leftBack.setPower(-pow);
                rightBack.setPower(pow);
            }
            else if(dir.equals("left")) {
                leftFront.setPower(-pow);
                rightFront.setPower(pow);
                leftBack.setPower(pow);
                rightBack.setPower(-pow);
            }

            if(!((cs1.blue()<cs1.red() && cs1.blue()<cs1.green()) || (cs1.blue()>50 && cs1.green()>50 && cs1.red()>50))){
                leftBack.setPower(0);
                leftFront.setPower(0);
                rightBack.setPower(0);
                rightFront.setPower(0);
                return NextState;
            }


            return this;
        }

        return this;
    }

    public int getColor(){

        return cs1.red();

    }

    @Override
    public void start() {

    }

    public void wait(int time) {
        try {
            Thread.sleep(time);//milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}