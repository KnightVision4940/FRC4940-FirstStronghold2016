package frc4940.robots.s2016.stronghold;

import frc4940.robots.s2016.stronghold.Map.Encoder;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Timer;

public class TeleOp{
	
	//controls the drive train
	TankWheels chassis = new TankWheels(); 
	//controls the arm
	Arm backarm = new Arm(Map.CAN.ARM_);		//Primary, base arm
	Arm forearm = new Arm(Map.CAN.SECOND_ARM);	//Secondary arm, stores winch
	//BallscrewArmEncoder Testing
	CANTalon ballscrew = new CANTalon(2);
	
	
	//Method is run once when TeleOp is first created.
	public void init(){
		//backarm.initEncoder();
	}
	
	//throwaway method used to test the encoder if it resets after 360 degrees
	public void testEnc(){
		ballscrew.set(0.5);
		System.out.println(ballscrew.getEncPosition());
	}
	
	//Method is run every 30ms during TeleOp period
	public void run(){
		
		/**
		 * Drives the robot
		 * Right Trigger drives forwards
		 * Left Trigger drives backwards
		 * Left Stick (X-Axis) turns
		 * 
		 * Driving inputs are squared so to reduce overly sensitive driving.
		 */
		chassis._driveRobotSQ(-IO.getXboxTrig(), -IO.getXboxLeftX());
		
		
		
		/**
		 * TEMPORARY CODE
		 * Controls movement of new arm
		 */
		if(IO.getArmUpperLimit() && IO.getXboxRightY() < 0){
			backarm.SetArm(0);
		} else {
			backarm.SetArm(0.92*IO.getXboxRightY());
		}
			
		
		/**
		 * The following is the teleop Arm movement code.
		 * The arm has two limiting restrictions:
		 * It cannot pass limit switches, and it should slow down as it approaches the limit switch.
		 * A series of IF statments controls this.
		 * 
		 * First, the code checks if the limit has been pressed or if the encoder says the arm has traveled too far,
		 * If this is the case, it then checks if the joystick is commanding the arm to continue downwards.
		 * If both of these conditions are met, the code then knows for sure that the arm is trying to go too far,
		 * and it stops it from moving (sets speed to 0)
		 * 
		 * It then checks if it is within 0-100 units of the Limit Switch, and slows
		 * the arm's speed within the range. The arm's speed is also lowered to a lesser degree if it is within 100-200 units of the limit switch.
		 * 
		 * If NONE of the above restrictions are detected, the arm may freely move in both directions.
		 * 
		 *********************************************
		 *
		 * Similar code is used to restrict the arm from moving back too much
		 * this is done via the encoder's readout
		 * 
		 * *******************************************
		 * 
		 * The code is temporarily disabled as of Feb. 18
		 * before we can get the encoder set up for the new, upgraded arm.
		 */
		/*
		//Arm Control
		if((IO.getArmUpperLimit() || backarm.getArmPosition() == Map.Encoder.ENC_LIMIT_SWITCH) && IO.getXboxRightY() > 0 ){
			backarm.SetArm(0);
		}else if(backarm.getArmPosition() <= (Map.Encoder.ENC_LIMIT_SWITCH + 100) && IO.getXboxRightY() > 0){
			backarm.SetArm(0.38*IO.getXboxRightY());
		}else if(backarm.getArmPosition() <= (Map.Encoder.ENC_LIMIT_SWITCH + 200) && IO.getXboxRightY() > 0){
			backarm.SetArm(0.67*IO.getXboxRightY());
		}else {
			backarm.SetArm(0.92*IO.getXboxRightY());
		} 
		
		if(backarm.getArmPosition() >= Map.Encoder.ENC_SCALE && IO.getXboxRightY() < 0){
			backarm.SetArm(0);
		}
		
		*/
		
		/**
		 * DEBUG CODE
		 * Prints the status of the limit switch to the driver station
		 * Prints the position of the arm's position
		 */
		if(IO.getArmUpperLimit())
			System.out.print("||ON||");
		else
			System.out.print("//OFF//");
		System.out.println("ARM=" + backarm.getArmPosition());
		
		if(IO.getXboxAButton()){
			forearm.SetArm(1); //out
		} else if (IO.getXboxBButton()){
			forearm.SetArm(-1);
		} else {
			forearm.SetArm(0);
		}
		
		if(IO.getXboxStart()){
			backarm.initEncoder();
		}
		
		
	}
	
	/**
	 * Method is run when test mode is enabled
	 * Used to calibrate the arm's encoder, and move it to the correct starting position
	 * NEEDS REWRITING
	 */
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
