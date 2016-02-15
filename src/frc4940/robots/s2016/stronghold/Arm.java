package frc4940.robots.s2016.stronghold;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;

public class Arm {
		
	CANTalon __Arm = new CANTalon(Map.CAN.ARM_);
	Encoder armEnc = new Encoder(1, 2, true, EncodingType.k4X);
	
	private int encCount;
	private double encRate;
	
	public void initEncoder(){
		__Arm.setEncPosition(0);
	}
	
	
	public int getCount(){
		encCount = armEnc.get();
		System.out.print("C/" + encCount + " ");
		return encCount;
	}
	
	public double getRate(){
		encRate = armEnc.getRate();
		System.out.print("R/" + encRate + " ");
		return encRate;
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
