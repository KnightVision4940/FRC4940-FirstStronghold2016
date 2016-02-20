package frc4940.robots.s2016.stronghold;

public class BoundBox {
	
	Arm rotArm = new Arm(1);
	Arm ballscrew = new Arm(2);
	
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
		 * 4. Restrict movement if arm is too close to Maximum possilbe arm length
		 */
		if(getZone() == 1){
			if(IO.getXboxRightY() == 0){
				rotArm.SetArm(0);
				ballscrew.SetArm(0);
			} else if(IO.getXboxRightY() < 0){ //moving down
				rotArm.SetArm(0.92 * IO.getXboxRightY());
			} else if(IO.getXboxRightY() > 0){ //moving up [restricted]
				rotArm.SetArm(0.92 * IO.getXboxRightY());
				//retracts the arm 
				if (rotArm.GetArm() > 0.8){
					ballscrew.SetArm(-1);
				} else {
					ballscrew.SetArm(rotArm.GetArm() * -1.25);
				}
			}
		}
	}
	
	private double getArmAngle(){
		/**
		 * Converts encoder readout to angles.
		 * Make sure arm's encoder is calibrated.
		 * Accurate to within 0.25 degrees of the actual reading (0.27% error)
		 */
		return (((int)(rotArm.getArmPosition()/1000.0 +.5) * 1000) - 12000) / 1755.56; //EXAMPLE CODE; PLEASE UPDATE
	}
	
	private double getMaxLength(){
		/**
		 * Gets the Maximum possible length for the arm at the current angle.
		 */
		double max1 = Map.BoundBox.MAX_DISTANCE/Math.cos((getArmAngle() * (2* Map.BoundBox.PI)/360));
		double max2 = Map.BoundBox.MAX_HEIGHT/Math.sin((getArmAngle() * (2* Map.BoundBox.PI)/360));
		return Math.min(max1, max2);
	}
	
	private int getZone(){
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
		 */
		int _zone = 0;
		if (getArmAngle() < Map.BoundBox.ANGLE_ALPHA - 1.5){
			_zone = 1;
		} else if (getArmAngle() > Map.BoundBox.ANGLE_ALPHA + 1.5){
			_zone = 2;
		} else if (getArmAngle() >= Map.BoundBox.ANGLE_ALPHA - 1.5 && getArmAngle() <= Map.BoundBox.ANGLE_ALPHA + 1.5){
			_zone = 3;
		}
		return _zone;
	}
}
