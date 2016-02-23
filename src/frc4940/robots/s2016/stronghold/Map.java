package frc4940.robots.s2016.stronghold;

public class Map {
	
	public static void set(int _variable, int _value){
		_variable = _value;
	}
	
	public class Limit{
		public static final int UPPERARMLIMIT = 0;
		public static final int BALLSCREW_INNER_LIMIT = 1;
		public static final int BALLSCREW_MAX = 2;
	}
	
	public class PWM{		
		//TankWheels.java
		public static final int LEFTFRONTWHEEL = 0;
		public static final int RIGHTFRONTWHEEL = 1;
		public static final int LEFTBACKWHEEL =3;
		public static final int RIGHTBACKWHEEL = 2;
	}
	
	public class CAN{
		//Arm.java
		public static final int ARM_ = 1;
		public static final int SECOND_ARM = 2;
	}
	
	public class Auto{  
		public static final int DRIVE_STRAIGHT = 0; //Drive Straight.....
		public static final int LOW_BAR = 1;
		public static final int PORTCULLIS = 2;
		public static final int MOAT = 3;
		public static final int RAMPARTS = 4;
		public static final int ROCK_WALL = 5;
		public static final int ROUGH_TERRAIN = 6;
		public static final int SALLY_PORT = 7; //NOT COMPLETED 
		public static final int DRAWBRIDGE = 8; //NOT COMPLETED
		public static final int CHEVAL_DE_FRISE = 9; //NOT COMPLETED
		
		public static final int TEST_AUTO = 999;
	}
	
	public class Encoder{
		public static final int ENC_SCALE = 800;
		public static final int ENC_HEIGHT = 500;
		public static final int ENC_LIMIT_SWITCH = -375;
		public static final int ENC_BALLSCREW_MAX_IN = 0;
	}
	
	public class BoundBox{
		public static final double PI = 3.14159265359;
		public static final double MAX_DISTANCE = 47;	//maximum length of arm (inches) at 0 degrees
		public static final double MAX_HEIGHT = 41.5;	//maximum length of arm (inches) at 90 degrees
		public static final double ANGLE_ALPHA = 41.44; //Angle at which the arm is at its maximum possible length
		public static final double MAX_LENGTH = 62.70;  //Maximum possible length of the arm
	}
	
}
