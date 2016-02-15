package frc4940.robots.s2016.stronghold;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;

public class IO {
	
	static Joystick xbox = new Joystick(0);
	
	public static double getXboxLeftX(){
		if (-xbox.getRawAxis(0) < 0.1 && -xbox.getRawAxis(0) > -0.1)
			return 0;
		else
			return -xbox.getRawAxis(0);
	}
	
	public static double getXboxLeftY(){
		return -xbox.getRawAxis(1);
	}
	
	public static double getXboxRightX(){
		return xbox.getRawAxis(4);
	}
	
	public static double getXboxRightY(){
		if (-xbox.getRawAxis(5) < 0.1 && -xbox.getRawAxis(5) > -0.1)
			return 0;
		else
			return -xbox.getRawAxis(5);
	}
	
	public static double getXboxTrig(){
		return (xbox.getRawAxis(3)-xbox.getRawAxis(2));
	}
	
	public static double getXboxRightTrig(){
		return xbox.getRawAxis(3);
	}
	
	public static double getXboxLeftTrig(){
		return xbox.getRawAxis(2);
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

