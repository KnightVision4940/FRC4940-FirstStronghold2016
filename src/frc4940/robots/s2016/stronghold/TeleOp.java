package frc4940.robots.s2016.stronghold;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TeleOp{
	int _zone;
	
	TeleOp(){
		_zone = 0;
	}
	
	//throwaway method used to test the encoder if it resets after 360 degrees
	public void testEnc(){
		IO.ballscrew.SetArm(0.5);
		System.out.println(IO.ballscrew.getArmPosition());
	}
	
	//Method is run every 30ms during TeleOp period
	public void run(){
		
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
		 * Controls movement of new arm
		 */
		if(IO.getArmUpperLimit() && IO.getXboxRightY() < 0){
			IO.arm.SetArm(0);
		} else {
			IO.arm.SetArm(0.92*IO.getXboxRightY());
			//runArm_BoundBox();
		}
		
		/**
		 * Controls manual movement of the arm
		 */
		if(IO.getXboxBButton()){
			if(!IO.getInnerBallscrewLimit()){
				IO.ballscrew.SetArm(0);
			} else {
				IO.ballscrew.SetArm(-1);
			}
		} else if(IO.getXboxAButton()){
			IO.ballscrew.SetArm(1);
		} else {
			IO.ballscrew.SetArm(0);
		}
		
		/**
		 * DEBUG CODE
		 * Prints the status of the limit switch to the driver station
		 * Prints the position of the arm's position
		 */
		System.out.println("0 | " + IO.getArmUpperLimit());
		System.out.println("1 | " + IO.getInnerBallscrewLimit());
		SmartDashboard.putNumber("ARM LENGTH", getArmAngle());
		SmartDashboard.putBoolean("ARM LIMIT", IO.getArmUpperLimit());
		SmartDashboard.putBoolean("BALLSCREW LIMIT", IO.getArmUpperLimit());
		//System.out.print("ARM=" + backarm.getArmPosition());
		//System.out.println(" | SCREW = " + ballscrew.getArmPosition());
		
	}
	
	/**
	 * Method is run when test mode is enabled
	 * Used to calibrate the arm's encoder, and move it to the correct starting position
	 * NEEDS REWRITING
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
		
		if(IO.getInnerBallscrewLimit()){
			IO.ballscrew.SetArm(-.3);
		} else {
			IO.ballscrew.SetArm(0);
		}
	}
	
	/**
	 * ARM MAX LIMIT ALGORITHMS
	 * [aka BoundBox]
	 * The following methods are used in the algorithm
	 * to prevent the arm from exceeding the game rules' outer limits.
	 */
	public void runArm_BoundBox(){
		/**
		 * 1. Get the Angle
		 * 2. Calculate Maximum possible arm length at current angle
		 * 3. Check if angle is above or below the bounding box' diagonal
		 * 4. Restrict movement if arm is too close to Maximum possible arm length
		 */
		
		/**
		 * ZONE 1
		 */
		if(getZone() == 1){
			if(IO.getXboxRightY() < 0){ //moving down [retract]
				//extends the arm
				if (IO.getInnerBallscrewLimit()){
					IO.ballscrew.SetArm(0);
				} else if (getArmLength() > getMaxLength(getArmAngle() - 0.05) - 1){
					if (IO.getXboxRightY() < -0.8){
						IO.ballscrew.SetArm(-1);
					} else {
						IO.ballscrew.SetArm(IO.getXboxRightY() * -1.0625);
					}
				} else {
					IO.ballscrew.SetArm(0);
				}
			} else if(IO.getXboxRightY() > 0){ //moving up [extend]
				//retracts the arm 
				if (IO.getInnerBallscrewLimit()){
					IO.ballscrew.SetArm(0);
				} else if (getArmLength() > getMaxLength(getArmAngle() + 0.05) - 1){
					if (IO.getXboxRightY() > 0.8){
						IO.ballscrew.SetArm(1);
					} else {
						IO.ballscrew.SetArm(IO.getXboxRightY() * 1.0625);
					}
				} else {
					IO.ballscrew.SetArm(0);
				}
			} 
		}
		/**
		 * ZONE 2
		 */
		else if(getZone() == 2){
			if(IO.getXboxRightY() < 0){ //moving down [extend]
				//extends the arm
				if (IO.getInnerBallscrewLimit()){
					IO.ballscrew.SetArm(0);
				} else if (getArmLength() < getMaxLength(getArmAngle() - 0.05) - 1){
					if (IO.getXboxRightY() < 0.8){
						IO.ballscrew.SetArm(1);
					} else {
						IO.ballscrew.SetArm(IO.getXboxRightY() * 1.0625);
					}
				} else {
					IO.ballscrew.SetArm(0);
				}
			} else if(IO.getXboxRightY() > 0){ //moving up [retract]
				//retracts the arm 
				if (IO.getInnerBallscrewLimit()){
					IO.ballscrew.SetArm(0);
				} else if (getArmLength() > getMaxLength(getArmAngle() + 0.05) - 1){
					if (IO.getXboxRightY() > 0.8){
						IO.ballscrew.SetArm(-1);
					} else {
						IO.ballscrew.SetArm(IO.getXboxRightY() * -1.0625);
					}
				} else {
					IO.ballscrew.SetArm(0);
				}
			} 
		}
		/**
		 * ZONE 3
		 */
		else if (getZone() == 3){
			if (IO.getInnerBallscrewLimit()){
				IO.ballscrew.SetArm(0);
			} else if (getArmLength() > (getMaxLength(Map.BoundBox.ANGLE_ALPHA) - 1)){
				IO.ballscrew.SetArm(-1);
			} else {
				IO.ballscrew.SetArm(0);
			}
		}
		/**
		 * ZONE 4
		 */
		else if(getZone() == 4){
			IO.ballscrew.SetArm(0);
		}
	}
	
	public double getArmAngle(){
		/**
		 * Converts encoder readout to angles.
		 * Make sure arm's encoder is calibrated.
		 * Accurate to within 0.25 degrees of the actual reading (0.27% error)
		 */
		return (((int)(IO.arm.getArmPosition()/1000.0 +.5) * 1000) - 12000) / 1755.56; //EXAMPLE CODE; PLEASE UPDATE
	}
	
	public double getMaxLength(double _angle){
		/**
		 * Gets the Maximum possible length for the arm at the current angle.
		 */
		double max1 = Map.BoundBox.MAX_DISTANCE/Math.cos((_angle * (2* Map.BoundBox.PI)/360));
		double max2 = Map.BoundBox.MAX_HEIGHT/Math.sin((_angle * (2* Map.BoundBox.PI)/360));
		return Math.min(max1, max2);
	}
	
	public double getArmLength(){
		/**
		 * Get Length for the arm
		 * Measured in Inches
		 * REMEMBER TO CHANGE ONCE ARM IS CUT
		 */
		return (IO.ballscrew.getArmPosition()/6875) + 48;
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
		 * In this zone, there is no movement of the ballscre
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
