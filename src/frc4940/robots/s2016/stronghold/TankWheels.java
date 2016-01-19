package frc4940.robots.s2016.stronghold;
import edu.wpi.first.wpilibj.RobotDrive;

public class TankWheels {

RobotDrive Wheels = new RobotDrive(Map.LEFTBACKWHEEL,Map.LEFTFRONTWHEEL,Map.RIGHTBACKWHEEL,Map.RIGHTFRONTWHEEL);
	
	public void DriveRobot(double _Speed,double _Turn){
		TankWheels.drive(_Speed, _Turn);	
	}
}

