package frc4940.robots.s2016.stronghold;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;

public class IO {
	
	static Joystick xbox = new Joystick(0);

	static DigitalInput LowerArm = new DigitalInput(Map.LOWERARM);
	static DigitalInput UpperArm = new DigitalInput(Map.UPPERARM);
	
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

