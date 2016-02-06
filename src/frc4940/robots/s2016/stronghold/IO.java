package frc4940.robots.s2016.stronghold;
import edu.wpi.first.wpilibj.DigitalInput;

public class IO {

	DigitalInput LowerArm = new DigitalInput(Map.LOWERARM);
	DigitalInput UpperArm = new DigitalInput(Map.UPPERARM);
	
	public static boolean GetLowerArm(){
		return LowerArm.get();
	}
	
	public static boolean GetUpperArm(){
		return UpperArm.get();
	}
	
	public static double getXboxLeftX(){
		return xbox.getRawAxis(0);
	}
	
	public static double getXboxLeftY(){
		return xbox.getRawAxis(1);
	}
	
	
	
}

