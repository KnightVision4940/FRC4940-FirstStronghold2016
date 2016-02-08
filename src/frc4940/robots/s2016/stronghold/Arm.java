package frc4940.robots.s2016.stronghold;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Encoder;

public class Arm {
	
	
	
	VictorSP LowerArm = new VictorSP(Map.LOWERARM);
	
	public double GetLowerArm(){
		return LowerArm.get();
	}

	public void SetLowerArm(double _Speed){
		LowerArm.set(_Speed);
	}
	
	VictorSP UpperArm = new VictorSP(Map.UPPERARM);
	public double GetUpperArm(){
		return UpperArm.get();
	}

	public void SetUpperArm(double _Speed){
		UpperArm.set(_Speed);
	}
	
	Encoder Enc = new Encoder(0,1,false,Encoder.EncodingType.k4X);
	
	public int getEncoder(){
		return Enc.get();
	}
	
}
