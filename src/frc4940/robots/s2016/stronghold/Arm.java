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

	public void SetArm(double _Speed){
		__Arm.set(_Speed);
	}
	
	public int getArmPosition(){
		System.out.print(__Arm.getEncPosition());
		System.out.print("\n");
		return __Arm.getEncPosition();
	}
	
	public void test(){
		
	}
}
