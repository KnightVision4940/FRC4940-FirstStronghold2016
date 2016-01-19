package frc4940.robots.s2016.stronghold;
import edu.wpi.first.wpilibj.DigitalInput;

public class IO {

	DigitalInput LowerArm = new DigitalInput(Map.LOWERARM);
	DigitalInput UpperArm = new DigitalInput(Map.UPPERARM);
	
	public boolean GetLowerArm(){
		return LowerArm.get();
	}
	
	public boolean GetUpperArm(){
		return UpperArm.get();
	}
	
	
	
	
	
	
}

