package frc4940.robots.s2016.stronghold;
import edu.wpi.first.wpilibj.VictorSP;

public class Arm {

	private final int LOWERARM = 5;
	private final int UPPERARM = 6;
	
	VictorSP LowerArm = new VictorSP(LOWERARM);
	
	public double GetLowerArm(){
		return LowerArm.get();
	}

	public void SetLowerArm(double _Speed){
		LowerArm.set(_Speed);
	}
	
	VictorSP UpperArm = new VictorSP(UPPERARM);
	
	public double GetUpperArm(){
		return UpperArm.get();
	}

	public void SetUpperArm(double _Speed){
		UpperArm.set(_Speed);
	}
	
}
