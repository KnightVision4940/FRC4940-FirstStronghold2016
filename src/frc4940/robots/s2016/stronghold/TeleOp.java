package frc4940.robots.s2016.stronghold;

public class TeleOp {
	
	//controls the drive train
	TankWheels chassis = new TankWheels(); 
	//controls the Arm
	Arm arm = new Arm();
	
	//Method is run every 30ms during TeleOp period
	public void run(){
		
		chassis.DriveRobot(-IO.getXboxTrig(), IO.getXboxLeftX());
		
		
	}
	
}
