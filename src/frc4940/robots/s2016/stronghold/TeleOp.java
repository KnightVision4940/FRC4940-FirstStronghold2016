package frc4940.robots.s2016.stronghold;

import frc4940.robots.s2016.stronghold.Map.Encoder;

public class TeleOp{
	
	//controls the drive train
	TankWheels chassis = new TankWheels(); 
	//controls the arm
	Arm backarm = new Arm(Map.CAN.ARM_); 
	Arm forearm = new Arm(Map.CAN.SECOND_ARM);
	//Servo Motor Testing
	ServoMotor serv = new ServoMotor();
	//Stores current arm position
	private int currentArmPos;
	
	//Method is run once when TeleOp is first created.
	public void init(){
		//backarm.initEncoder();
	}
	
	//Method is run every 30ms during TeleOp period
	public void run(){
		
		chassis._driveRobot(-IO.getXboxTrig(), -IO.getXboxLeftX());
		
		//Arm Control
		if((IO.getArmUpperLimit() || backarm.getArmPosition() == Map.Encoder.ENC_LIMIT_SWITCH) && IO.getXboxRightY() > 0 ){
			backarm.SetArm(0);
		}else if(backarm.getArmPosition() <= (Map.Encoder.ENC_LIMIT_SWITCH + 100) && IO.getXboxRightY() > 0){
			backarm.SetArm(0.15*IO.getXboxRightY());
		}else if(backarm.getArmPosition() <= (Map.Encoder.ENC_LIMIT_SWITCH + 200) && IO.getXboxRightY() > 0){
			backarm.SetArm(0.45*IO.getXboxRightY());
		}else {
			backarm.SetArm(0.85*IO.getXboxRightY());
		} 
		
		if(backarm.getArmPosition() >= Map.Encoder.ENC_SCALE && IO.getXboxRightY() < 0){
			backarm.SetArm(0);
		}
		
		if(IO.getArmUpperLimit())
			System.out.print("||ON||");
		else
			System.out.print("//OFF//");
		
		System.out.println("ARM=" + backarm.getArmPosition());
		
		//Test code for the small HiRes Servo motor
		//A and B button
		if(IO.getXboxAButton()){
			serv.run(0);
		} else if (IO.getXboxBButton()){
			serv.run(1);
		}
		
	}
	
	public void calibrateArmPosition(){
		//sets the arm to the limit switch
		while(!IO.getArmUpperLimit()){
			backarm.SetArm(0.5);
		}
		backarm.SetArm(0);
		
		//resets encoder at limit switch to 0
		backarm.initEncoder();
		//sets the limit switch constant to current value (SHOULD be 0)
		Map.set(Encoder.ENC_LIMIT_SWITCH, backarm.getArmPosition());
		
		//moves the arm to 600 units above the limit switch(default auto position)
		while(backarm.getArmPosition() < Encoder.ENC_LIMIT_SWITCH+600){
			backarm.SetArm(-0.3);
		}
		System.out.println("ARM POSITION SUCCESSFULLY RESET | " + backarm.getArmPosition());
		backarm.SetArm(0);
	}
	
}
