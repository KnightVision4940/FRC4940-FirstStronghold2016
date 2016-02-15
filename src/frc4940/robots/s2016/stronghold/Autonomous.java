package frc4940.robots.s2016.stronghold;

import edu.wpi.first.wpilibj.Timer;
import frc4940.robots.s2016.stronghold.Map.Auto;

public class Autonomous {

	static TankWheels chasis = new TankWheels();
	static Arm arm = new Arm();
	
	public static void Run(int mode){
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
		if (mode == Auto.Portcullis){    //Not completed 
			chasis._driveRobot(0.5, 0);
			Timer.delay(3);
			chasis._driveRobot(0, 0);
			arm.SetArm(0.5);
			Timer.delay(3.5);
			arm.SetArm(0);
			chasis._driveRobot(0.4, 0);
			Timer.delay(3);
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
		
	}

}
