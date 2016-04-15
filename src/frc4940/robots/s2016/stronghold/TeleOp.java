///////////////////////////////////////////////////////
// TeleOp.java
// FRC 4940
//
// TeleOp class
// Contains all code to be run during teleop
// Also contains code ensuring arm does not extend too far, preventing any penalties
///////////////////////////////////////////////////////
package frc4940.robots.s2016.stronghold;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TeleOp{
	/**Variables**/
	int _zone; //stores which "zone" the main arm is in. Used to prevent over-extension
	
	int armEncoder;
	
	/**Constructor**/
	TeleOp(){
		_zone = 0;
		armEncoder = 0;
	}
	
	/**Initation Method**/
	public void init(){
		IO.time.reset();
	}
	
	/**TeleOp code; runs every 30ms during TeleOp period**/
	public void run(){
		//if(drawbridgePreset)
			//runDrawbridgePreset();
		//else
		armEncoder = IO.arm.getArmPosition() - Map.Encoder.ENC_ARM_OFFSET;
		/**
		 * Drives the robot
		 * Right Trigger drives forwards
		 * Left Trigger drives backwards
		 * Left Stick (X-Axis) turns
		 * 
		 * Driving inputs are squared so to reduce overly sensitive driving.
		 */
		IO.chassis._driveRobotSQ(-IO.getXboxTrig(), -IO.getXboxLeftX());
		
		/**
		 * Controls movement of arm (up or down)
		 * Prevents over-extension, and rumbles if driver attempts to go over the length and height limits
		 * These limits are disabled past 85 degrees from the ground, so to allow scaling of the tower
		 */
		if(IO.getArmUpperLimit() && IO.getXboxRightY() < 0){
			IO.arm.SetArm(0);
			IO.setXboxRumble(1);
		} else {
			if (getArmLength() > getMaxLength(getArmAngle())-0.25){
				if(getZone() == 3){
					IO.arm.SetArm(0);
					if (IO.getXboxRightY() != 0)
						IO.setXboxRumble(1);
				} else if (getZone() == 1){
					if (IO.getXboxRightY() > 0){
						IO.setXboxRumble(0);
						IO.arm.SetArm(0.92*IO.getXboxRightY());
					}else{
						IO.setXboxRumble(1);
						IO.arm.SetArm(0);
					}
				} else if (getZone() == 2){
					if (IO.getXboxRightY() < 0){
						IO.setXboxRumble(0);
						IO.arm.SetArm(0.92*IO.getXboxRightY());
					}
					else{
						IO.setXboxRumble(1);
						IO.arm.SetArm(0);
					}
				}
			} else {
				IO.setXboxRumble(0);
				IO.arm.SetArm(0.92*IO.getXboxRightY());
			}
		}
		
		/**
		 * Controls manual movement of the ballscrew (arm length)
		 */
		if(IO.getXboxBButton()){
			if(!IO.getInnerBallscrewLimit()){
				IO.ballscrew.SetArm(0);
				IO.setXboxRumble(1);
			} else {
				IO.ballscrew.SetArm(-1);
				IO.setXboxRumble(0);
			}
		} else if(IO.getXboxAButton()){
			if(!IO.getOuterBallscrewLimit() || getArmLength() > getMaxLength(getArmAngle())-0.25){
				IO.ballscrew.SetArm(0);
				IO.setXboxRumble(1);
			} else {
				IO.ballscrew.SetArm(1);
				IO.setXboxRumble(0);
			}
		} else {
			IO.ballscrew.SetArm(0);
			IO.setXboxRumble(0);
		}
		
		/**
		 * DEBUG CODE
		 * Prints the Arm Angle
		 * Prints the Arm Lengthb
		 */
		SmartDashboard.putNumber("ARM ANGLE", getArmAngle());
		SmartDashboard.putNumber("ARM LENGTH", getArmLength());
		SmartDashboard.putNumber("MAX LENGTH", getMaxLength(getArmAngle()));
		SmartDashboard.putNumber("ZONE", getZone());
	}
	
	/**
	 * Method is run when test mode is enabled
	 * Used to calibrate the arm's encoder, and move it to the correct starting position
	 */
	public void calibrateArmPosition(){
		
		//sets the arm to the limit switch
		while(!IO.getArmUpperLimit()){
			IO.arm.SetArm(-.85);
		}
		IO.arm.SetArm(0);

		int _armPos = IO.arm.getArmPosition();
		
		//sets the arm to standard position
		while(IO.arm.getArmPosition() > _armPos - 105000){
			IO.arm.SetArm(0.92);
			System.out.println(_armPos + " | " + IO.arm.getArmPosition());
		}
		IO.arm.SetArm(0);
	}
	
	/**
	 * ARM MAX LIMIT ALGORITHMS
	 * [aka BoundBox Algorithm]
	 * The following methods are used in the algorithm
	 * to prevent the arm from exceeding the game rules' outer limits.
	 */
	
	public double getArmAngle(){
		/**
		 * Converts encoder readout to angles.
		 * Make sure arm's encoder is calibrated.
		 * Accurate to within 0.25 degrees of the actual reading (0.27% error)
		 */
		return -((armEncoder + 10000)/1722.2);
		//return (((int)(IO.arm.getArmPosition()/1000.0 +.5) * 1000) - 12000) / 1755.56; //EXAMPLE CODE; PLEASE UPDATE
	}
	
	public double getMaxLength(double _angle){
		/**
		 * Gets the Maximum possible length for the arm at the current angle.
		 */
		double max1 = Map.BoundBox.MAX_DISTANCE/Math.cos(Math.toRadians(_angle));
		double max2 = Map.BoundBox.MAX_HEIGHT/Math.sin(Math.toRadians(_angle));
		if(getArmAngle() > 80)
			return 420.69;
		else if (max1 < 0 && max2 < 0)
			return -1;
		else if(max1 < 0)
			return max2;
		else if(max2 < 0)
			return max1;
		else
			return Math.min(max1, max2);
	}
	
	public double getArmLength(){
		/**
		 * Get Length for the arm
		 * Measured in Inches
		 * REMEMBER TO CHANGE ONCE ARM IS CUT
		 */
		return (-IO.ballscrew.getArmPosition()/6600) + 42;
	}
	
	public int getZone(){
		/**
		 * Gets the current zone of the robot. 
		 * Zones are based on the relation of the arm's angle to ANGLE ALPHA (~41.44 degrees)
		 * 
		 * Zone 0 does not exist
		 * If zone 0 is returned, an error has occurred
		 *  
		 * Zone 1 is less than ANGLE ALPHA
		 * In this zone, the arm will retract moving down, and extend moving up.
		 * 
		 * Zone 2 is greater than ANGLE ALPHA
		 * In this zone, the arm will retract moving up, and extend moving down.
		 * 
		 * Zone 3 is around ANGLE ALPHA
		 * In this zone, the arm will be extended to its maximum length (about 62 inches)
		 * 
		 * Zone 4 is torwards the limit switch
		 * In this zone, there is no movement of the ballscrew
		 */
		if (getArmAngle() < Map.BoundBox.ANGLE_ALPHA - 1.5){
			_zone = 1;
		} else if (getArmAngle() > Map.BoundBox.ANGLE_ALPHA + 1.5){
			_zone = 2;
		} else if (getArmAngle() >= Map.BoundBox.ANGLE_ALPHA - 1.5 && getArmAngle() <= Map.BoundBox.ANGLE_ALPHA + 1.5){
			_zone = 3;
		} else if (getArmAngle() < 0){
			_zone = 4;
		}
		return _zone;
	} 
}
