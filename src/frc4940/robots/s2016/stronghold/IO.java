package frc4940.robots.s2016.stronghold;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;

public class IO {
	
	static Joystick xbox = new Joystick(0);
	
	public static double getXboxLeftX(){
		return xbox.getRawAxis(0);
	}
	
	public static double getXboxLeftY(){
		return -xbox.getRawAxis(1);
	}
	
	public static double getXboxRightX(){
		return xbox.getRawAxis(4);
	}
	
	public static double getXboxRightY(){
		return -xbox.getRawAxis(5);
	}
	
	public static double getXboxTrig(){
		return (xbox.getRawAxis(3)-xbox.getRawAxis(2));
	}
	
	public static boolean getXboxAButton(){
		return xbox.getRawButton(1);
	}		
	
	public static boolean getXboxBButton(){
		return xbox.getRawButton(2);
	}
	
	public static boolean getXboxXButton(){
		return xbox.getRawButton(3);
	}
	
	public static boolean getXboxYButton(){
		return xbox.getRawButton(4);
	}
	
	static DigitalInput upperArmLimit = new DigitalInput(Map.Limit.UPPERARMLIMIT);
	
	public static boolean getArmUpperLimit(){
		return upperArmLimit.get();
	}
}

