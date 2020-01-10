package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.StateMachine.State;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import java.util.ArrayList;

/*
7890 Space Lions 2019 "DISTANCEMOVESTATE"
author: 7890 Software (TEAM MEMBERS)
GOALS: (GOALS)
DESCRIPTION: This code is a distance move state, used to simplify our autonomous code.
It simply moves the robot according to the directions in our autonomous.
 */
public class revDistanceMoveState implements State{
    DcMotor leftFront;
    DcMotor rightFront;
    DcMotor leftBack;
    DcMotor rightBack;
    double targetDistance;
    State NextState;
    DistanceSensor distSensor;
    String turn = "null";
    boolean isMoved = false;
    double power;

    public revDistanceMoveState(ArrayList<DcMotor> motor, DistanceSensor distSense, double dist, double speed){
        leftFront = motor.get(0);
        rightFront = motor.get(1);
        leftBack = motor.get(2);
        rightBack = motor.get(3);
        distSensor = distSense;
        targetDistance = dist;
        power  = speed;


    }
    public void setNextState(State state) {
        NextState  = state;

    }
    public void start(){

    }

    public String getTurn() {
        return turn;
    }

    public State update(){
        move("forward", 0.3);
        wait(3);

        if (distSensor.getDistance(DistanceUnit.INCH) > targetDistance && !isMoved){
            move("forward", power);
            return this;
        } else if (distSensor.getDistance(DistanceUnit.INCH) <= targetDistance && !isMoved){
            isMoved = true;
            stop(leftFront, leftBack, rightFront, rightBack);
            return this;
        } else if (isMoved){
            return NextState;
        } else{
            return this;
        }

    }

    public void stop(DcMotor motorlf, DcMotor motorrf, DcMotor motorlb, DcMotor motorrb) {
        //robot stops moving
        motorlf.setPower(0.0);
        motorrf.setPower(0.0);
        motorlb.setPower(0.0);
        motorrb.setPower(0.0);
    }

    public void move(String direction, double speed) {
        switch (direction) {
            case "forward":
                //robot moves backwards
                leftFront.setPower(-speed);
                rightFront.setPower(-speed);
                leftBack.setPower(-speed);
                rightBack.setPower(-speed);
                break;
            case "backward":
                //robot moves forwards
                leftFront.setPower(speed);
                rightFront.setPower(speed);
                leftBack.setPower(speed);
                rightBack.setPower(speed);
                break;
            case "right":
                //robot strafes right
                leftFront.setPower(-speed);
                rightFront.setPower(speed);
                leftBack.setPower(-speed);
                rightBack.setPower(speed);
                break;
            case "left":
                //robot strafes left
                leftFront.setPower(speed);
                rightFront.setPower(-speed);
                leftBack.setPower(speed);
                rightBack.setPower(-speed);
                break;
            case "ccw":
                //robot turns clockwise(to the right)
                leftFront.setPower(speed);
                rightFront.setPower(-speed);
                leftBack.setPower(speed);
                rightBack.setPower(-speed);
                break;
            case "cw":
                //robot turns counterclockwise(to the left)
                leftFront.setPower(-speed);
                rightFront.setPower(speed);
                leftBack.setPower(-speed);
                rightBack.setPower(speed);
                break;
        }
    }

    public void wait(int time) {
        try {
            Thread.sleep(time * 1000);//milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
