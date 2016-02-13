package frc4940.robots.s2016.stronghold;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Encoder;

public class Arm {
		
	VictorSP __Arm = new VictorSP(Map.PWM.ARM_);
	
	public double GetArm(){
		return __Arm.get();
	}

	public void SetArm(double _Speed){
		__Arm.set(_Speed);
	}
	
}
