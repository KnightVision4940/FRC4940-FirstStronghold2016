package frc4940.robots.s2016.stronghold;

public class TeleOp{
	
	//controls the drive train
	TankWheels chassis = new TankWheels(); 
	//controls the arm
	Arm _arm = new Arm();
	
	public void init(){
		_arm.initArmPosition();
	}
	
	//Method is run every 30ms during TeleOp period
	public void run(){
		
		chassis._driveRobot(IO.getXboxTrig(), IO.getXboxLeftX());
		
		//limit
		if(IO.getArmUpperLimit() && IO.getXboxRightY() > 0){
			_arm.SetArm(0);
		}else{
			_arm.SetArm(IO.getXboxRightY());
		}
		
		_arm.getArmPosition();
	}
	
}
