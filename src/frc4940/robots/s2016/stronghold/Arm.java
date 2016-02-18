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
}
