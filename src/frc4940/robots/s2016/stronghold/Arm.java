package frc4940.robots.s2016.stronghold;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;

public class Arm {
	CANTalon __Arm;
	Arm(int CANPort){
		  __Arm = new CANTalon(CANPort);
	}
	
	private int encCount;
	private double encRate;
	
	public void initEncoder(){
		__Arm.setEncPosition(0);
	}

	public double GetArm(){
		return __Arm.get();
	}
	
	//sets a velocity for the arm
	public void SetArm(double _Speed){
		//__Arm.set(_Speed);
		/**
		 * Squares the inputs;
		 * this allows for lower sensitivities at lower speeds,
		 * but still allows for maximum speed to be reached.
		 */
		if (_Speed >= 0){
			__Arm.set(_Speed * _Speed);
		} else if (_Speed < 0){
			__Arm.set(-(_Speed * _Speed));
		} else {
			__Arm.set(0);
		}
	}
	
	//gets the current position of the arm from the encoder
	public int getArmPosition(){
		return __Arm.getEncPosition();
	}
	
	/**
	 * ARM MAX LIMIT ALGORITHMS
	 * The following methods are used in the algorithm
	 * to prevent the arm from exceeding the game rules' outer limits.
	 */
	public void boundingBoxAlg(){
		/**
		 * 1. Get the Angle
		 * 2. Calculate Maximum possible arm length at current angle
		 * 3. Check if angle is above or below the bounding box' diagonal
		 * 4. Restrict movement if arm is too close to Maximum possilbe arm length
		 */
		if (getArmAngle() > Map.Misc.MAX_DIST_ANGLE){
			if(getArmLength() > getMaxLength() - 10){
				//only rotate down
			}
		} else if (getArmAngle() < Map.Misc.MAX_DIST_ANGLE){
			if(getArmLength() > getMaxLength() - 10){
				//only rotate up
			}
		} else if (getArmAngle() < Map.Misc.MAX_DIST_ANGLE*0.99 && getArmAngle() > Map.Misc.MAX_DIST_ANGLE*1.01){
			if(getArmLength() > getMaxLength() - 10){
				//Do not rotate until the arm is retracted 
			}
		}
	}
	
	private double getArmAngle(){
		/**
		 * Insert code for converting encoder readout to angles.
		 * Must be tested to find rate of units/degree.
		 * Also make sure arm's encoder is calibrated.
		 */
		return getArmPosition() / 322.0; //EXAMPLE CODE; PLEASE UPDATE
	}
	
	private double getMaxLength(){
		double max1 = Map.Misc.MAX_LENGTH/Math.cos((getArmAngle() * (2* Map.Misc.PI)/360));
		double max2 = Map.Misc.MAX_HEIGHT/Math.sin((getArmAngle() * (2* Map.Misc.PI)/360));
		return Math.min(max1, max2);
	}
	
}
