///////////////////////////////////////////////////////
// IO.java
// FRC 4940
//
// Class for all Input/Output modules.
// This includes controllers, limit switches, and subsystems
///////////////////////////////////////////////////////
package frc4940.robots.s2016.stronghold;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;

public class IO {
	/**
	 * Subsystems
	 */
	static Arm arm = new Arm(Map.CAN.ARM_);
	static Arm ballscrew = new Arm(Map.CAN.SECOND_ARM);
	static TankWheels chassis = new TankWheels();
	static Timer time = new Timer();
	
	/**
	 * Xbox Controller
	 */
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
	
	public static boolean getXboxLBumper(){
		return xbox.getRawButton(5);
	}
	
	public static boolean getXboxRBumper(){
		return xbox.getRawButton(6);
	}
	
	public static boolean getXboxStart(){
		return xbox.getRawButton(7);
	}
	
	public static boolean getXboxSelect(){
		return xbox.getRawButton(8);
	}
	
	public static void setXboxRumble(float _rumble){
		xbox.setRumble(Joystick.RumbleType.kLeftRumble, _rumble);
	}
	
	/**
	 * Limit Switches
	 */
	static DigitalInput upperArmLimit = new DigitalInput(Map.Limit.UPPERARMLIMIT);
	static DigitalInput ballscrewInner = new DigitalInput(Map.Limit.BALLSCREW_INNER_LIMIT);
	static DigitalInput ballscrewOuter = new DigitalInput(Map.Limit.BALLSCREW_MAX);
	
	//**BOTTOM** limit switch so the arm doesn't bottom out
	public static boolean getArmUpperLimit(){
		return upperArmLimit.get();
	}
	
	//Prevents ballscrew from retracting too far
	public static boolean getInnerBallscrewLimit(){
		return ballscrewInner.get();
	}
	
	//Prevents ballscrew from extending too far
	public static boolean getOuterBallscrewLimit(){
		return ballscrewOuter.get();
	}
}

