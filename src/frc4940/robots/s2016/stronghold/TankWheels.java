package frc4940.robots.s2016.stronghold;
import edu.wpi.first.wpilibj.RobotDrive;

public class TankWheels {
	//Initiates RobotDrive Object
	RobotDrive Wheels = new RobotDrive(Map.PWM.LEFTBACKWHEEL,Map.PWM.LEFTFRONTWHEEL,Map.PWM.RIGHTBACKWHEEL,Map.PWM.RIGHTFRONTWHEEL);
	
	//Method used to drive robot.
	public void DriveRobot(double _Speed,double _Turn){
		Wheels.drive(_Speed, _Turn);
	}
}

