///////////////////////////////////////////////////////
// Map.java
// FRC 4940
//
// Class that stores all constants.
// There are various subclasses for subsystems and specific uses
///////////////////////////////////////////////////////
package frc4940.robots.s2016.stronghold;

public class Map {
	
	//DIO port numbers. Used for limit switches
	public class Limit{
		public static final int UPPERARMLIMIT = 0;
		public static final int BALLSCREW_INNER_LIMIT = 1;
		public static final int BALLSCREW_MAX = 2;
	}
	
	//PWM port numbers. Used for drivetrain
	public class PWM{		
		public static final int LEFTFRONTWHEEL = 0;
		public static final int RIGHTFRONTWHEEL = 1;
		public static final int LEFTBACKWHEEL =3;
		public static final int RIGHTBACKWHEEL = 2;
	}
	
	//CAN device IDs. Used for the arm
	public class CAN{
		public static final int ARM_ = 1;
		public static final int SECOND_ARM = 2;
	}
	
	//IDs for each auto
	//Used to select autonomous mode on the dashboard
	public class Auto{  
		public static final int LOW_BAR = 1;
		public static final int PORTCULLIS = 2; //No Routine Availible
		public static final int MOAT = 3;
		public static final int RAMPARTS = 4;
		public static final int ROCK_WALL = 5; //No Routine Availible
		public static final int ROUGH_TERRAIN = 6;
		public static final int SALLY_PORT = 7; //No Routine Availible
		public static final int DRAWBRIDGE = 8; //No Routine Availible
		public static final int CHEVAL_DE_FRISE = 9; //No Routine Availible
	}
	
	//Constants for encoder
	//Used to remember specific positions
	public class Encoder{
		public static final int ENC_ARM_OFFSET = 107820;
	}
	
	//Stores constants for use in ensuring arm doesn't extend too far.
	public class BoundBox{
		public static final double PI = 3.14159265359;
		public static final double MAX_DISTANCE = 48.5;	//maximum length of arm (inches) at 0 degrees
		public static final double MAX_HEIGHT = 44.5;	//maximum length of arm (inches) at 90 degrees
		public static final double ANGLE_ALPHA = 43.07; //Angle at which the arm is at its maximum possible length
		public static final double MAX_LENGTH = 67;  //Maximum possible length of the arm
	}
	
}
