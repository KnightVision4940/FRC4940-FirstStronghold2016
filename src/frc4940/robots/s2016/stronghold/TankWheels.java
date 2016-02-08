package frc4940.robots.s2016.stronghold;
import edu.wpi.first.wpilibj.RobotDrive;

public class TankWheels {
	
	private final int LEFTFRONTWHEEL = 3;
	private final int RIGHTFRONTWHEEL = 6;
	private final int LEFTBACKWHEEL = 1;
	private final int RIGHTBACKWHEEL = 0;
	
	RobotDrive Wheels = new RobotDrive(LEFTBACKWHEEL,LEFTFRONTWHEEL,RIGHTBACKWHEEL,RIGHTFRONTWHEEL);
	
	public void DriveRobot(double _Speed,double _Turn){
		Wheels.drive(_Speed, _Turn);
	}
}

