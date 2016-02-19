package frc4940.robots.s2016.stronghold;

import edu.wpi.first.wpilibj.Timer;
import frc4940.robots.s2016.stronghold.Map.Auto;

public class Autonomous {

	static TankWheels chasis = new TankWheels();
	static Arm arm = new Arm(Map.CAN.ARM_);
	static Timer time_ = new Timer();
	
	static void init(){
		time_.reset();
	}
	
	static void Run(int mode){
		if (mode == Auto.DRIVE_STRAIGHT){
			chasis._driveRobot(0.5, 0);
			Timer.delay(4.5);
			chasis._driveRobot(0, 0);
		} 
		if (mode == Auto.LOW_BAR){
			chasis._driveRobot(0.6, 0);
			Timer.delay(5);
			chasis._driveRobot(0, 0);
		}
		if (mode == Auto.PORTCULLIS){    //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
			
			chasis._driveRobot(0.7, 0);
			Timer.delay(2);
			chasis._driveRobot(0, 0);
			
			time_.start();
			
			while((time_.get() < 3.5 && !IO.getArmUpperLimit()) || arm.getArmPosition() < 4){
				arm.SetArm(-0.9);
			}
			arm.SetArm(0);
			
			time_.stop();
			time_.reset();
			
			chasis._driveRobot(0.7, 0);
			Timer.delay(4);
			chasis._driveRobot(0, 0);
		}
		if (mode == Auto.MOAT){
			chasis._driveRobot(0.8, 0);
			Timer.delay(4);
			chasis._driveRobot(0.5, 0);
			Timer.delay(4);
		}
		if (mode == Auto.RAMPARTS){
			chasis._driveRobot(0.9, 0);
			Timer.delay(3);
			chasis._driveRobot(0, 0);
			Timer.delay(0.1);
			chasis._driveRobot(0.5, 0);
			Timer.delay(2);
			chasis._driveRobot(0, 0);
		}
		if (mode == Auto.ROCK_WALL){
			chasis._driveRobot(0.8, 0);
			Timer.delay(3);
			chasis._driveRobot(0.5, 0);
			Timer.delay(4);
			chasis._driveRobot(0,0);
		}
		if (mode == Auto.ROUGH_TERRAIN){
			chasis._driveRobot(0.8, 0);
			Timer.delay(3);
			chasis._driveRobot(0.5, 0);
			Timer.delay(4);
			chasis._driveRobot(0,0);		
		}
		if (mode == Auto.SALLY_PORT){
			
		}
		if (mode == Auto.DRAWBRIDGE){
			
		}
		if (mode == Auto.CHEVAL_DE_FRISE){
			arm.SetArm(0.9); //move arms up
			chasis._driveRobot(0.6, 0);
			Timer.delay(0.75);
			arm.SetArm(0);
			Timer.delay(2.25);
			chasis._driveRobot(0, 0);
			while(!IO.getArmUpperLimit()){
				arm.SetArm(-0.6);
			}
			arm.SetArm(0);
			Timer.delay(1);
			arm.SetArm(1);
			Timer.delay(1.8);
			arm.SetArm(0);
			chasis._driveRobot(0.8, 0);
			Timer.delay(5);
			chasis._driveRobot(0, 0);
			
		}
		if (mode == Auto.TEST_AUTO){
			if (!IO.getArmUpperLimit()){
				arm.SetArm(0.45);
			} else {
				arm.SetArm(0);
			}
		}
	}

}
