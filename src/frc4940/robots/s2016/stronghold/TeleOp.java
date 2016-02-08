package frc4940.robots.s2016.stronghold;

public class TeleOp {

	TankWheels chassis = new TankWheels(); 
	
	public void run(){
		
		chassis.DriveRobot(IO.getXboxLeftY(), IO.getXboxLeftX());
		
		
	}
	
}
