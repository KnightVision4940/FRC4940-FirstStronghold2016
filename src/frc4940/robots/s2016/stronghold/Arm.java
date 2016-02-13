package frc4940.robots.s2016.stronghold;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Encoder;

public class Arm {
		
	VictorSP Arm = new VictorSP(Map.PWM.ARM_);
	
	public double GetArm(){
		return Arm.get();
	}

	public void SetArm(double _Speed){
		Arm.set(_Speed);
	}
	



	
	Encoder Enc = new Encoder(0,1,false,Encoder.EncodingType.k4X);
	
	public int getEncoder(){
		return Enc.get();
	}
	
}
