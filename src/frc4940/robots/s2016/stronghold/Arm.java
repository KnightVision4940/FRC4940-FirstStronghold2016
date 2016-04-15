///////////////////////////////////////////////////////
// Arm.java
// FRC 4940
//
// Class for the arm subsystem.
// Two objects are created of this class in IO.java:
// One for the main arm moving up and down
// One for the inner ballscrew extending and retracting the arm length
///////////////////////////////////////////////////////
package frc4940.robots.s2016.stronghold;
import edu.wpi.first.wpilibj.CANTalon;

public class Arm {
	CANTalon __Arm;
	Arm(int _CANPort){
		  __Arm = new CANTalon(_CANPort);
	}
	
	//sets a velocity for the arm
	public void SetArm(double _Speed){
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
	
	//gets the current readout from the encoder
	// Main arm requires offset, which is applied in TeleOp.java
	public int getArmPosition(){
		return __Arm.getEncPosition();
	}
}
