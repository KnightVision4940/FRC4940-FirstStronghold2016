package frc4940.robots.s2016.stronghold;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;

public class Arm {
		
	CANTalon __Arm = new CANTalon(Map.CAN.ARM_);				//Motor used to move arm
	Encoder armEnc = new Encoder(1, 2, true, EncodingType.k4X); //Encoder used to measure arm position
	
	//returns current velocity of arm motor
	public double GetArm(){
		return __Arm.get();
	}
	
	//sets a velocty for the arm
	public void SetArm(double _Speed){
		__Arm.set(_Speed);
	}
	
	//gets the current position of the arm from the encoder
	public int getArmPosition(){
		return __Arm.getEncPosition();
	}
}
