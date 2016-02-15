package frc4940.robots.s2016.stronghold;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;

public class Arm {
		
	CANTalon __Arm = new CANTalon(Map.CAN.ARM_);
	
	public double GetArm(){
		return __Arm.get();
	}

	public void SetArm(double _Speed){
		__Arm.set(_Speed);
	}
	
	public int getArmPosition(){
		System.out.println(__Arm.getEncPosition());
		System.out.println("\n");
		return __Arm.getEncPosition();
	}
	
	public void initArmPosition(){
		__Arm.setEncPosition(0);
	}
	
}
