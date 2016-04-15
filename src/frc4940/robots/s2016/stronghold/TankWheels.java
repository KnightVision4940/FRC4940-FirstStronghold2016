///////////////////////////////////////////////////////
// TankWheels.java
// FRC 4940
//
// Subsystem class running the chassis
// Robot uses AndyMark Rhino Tracks
///////////////////////////////////////////////////////
package frc4940.robots.s2016.stronghold;
import edu.wpi.first.wpilibj.RobotDrive;

public class TankWheels {
	//Initiates RobotDrive Object
	RobotDrive Wheels = new RobotDrive(Map.PWM.LEFTBACKWHEEL,Map.PWM.LEFTFRONTWHEEL,Map.PWM.RIGHTBACKWHEEL,Map.PWM.RIGHTFRONTWHEEL);
	
	//Method used to drive robot.
	//Recommended for use in autonomous
	public void _driveRobot(double _Speed, double _Turn){
		Wheels.drive(_Speed, _Turn);
	}
	
	//Method used to drive robot based on **SQUARED** inputs
	//Recommended for use in teleop
	public void _driveRobotSQ(double _Speed, double _Turn){
		if(_Speed >= 0){
			Wheels.drive(Math.pow(_Speed, 2), _Turn);
		} else if (_Speed <=0){
			Wheels.drive(-Math.pow(_Speed, 2), _Turn);
		} else {
			Wheels.drive(0, 0);
		}
	}
}
