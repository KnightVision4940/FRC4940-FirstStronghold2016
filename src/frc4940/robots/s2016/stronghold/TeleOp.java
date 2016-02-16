package frc4940.robots.s2016.stronghold;

public class TeleOp{
	
	//controls the drive train
	TankWheels chassis = new TankWheels(); 
	//controls the arm
	Arm _arm = new Arm();
	
	//Method is run once when TeleOp is first created.
	public void init(){
		//_arm.initEncoder();
	}
	
	//Method is run every 30ms during TeleOp period
	public void run(){
		
		chassis._driveRobot(-IO.getXboxTrig(), -IO.getXboxLeftX());
		
		//Arm Control
		if((IO.getArmUpperLimit() || _arm.getArmPosition() == Map.Encoder.ENC_LIMIT_SWITCH) && IO.getXboxRightY() > 0 ){
			_arm.SetArm(0);
		}else if(_arm.getArmPosition() <= (Map.Encoder.ENC_LIMIT_SWITCH + 100) && IO.getXboxRightY() > 0){
			_arm.SetArm(0.15*IO.getXboxRightY());
		}else if(_arm.getArmPosition() <= (Map.Encoder.ENC_LIMIT_SWITCH + 200) && IO.getXboxRightY() > 0){
			_arm.SetArm(0.45*IO.getXboxRightY());
		} else {
			_arm.SetArm(0.85*IO.getXboxRightY());
		} 
		
		if(_arm.getArmPosition() >= Map.Encoder.ENC_HEIGHT && IO.getXboxRightY() < 0){
			_arm.SetArm(0);
		}
		
		if(IO.getArmUpperLimit())
			System.out.print("||ON||");
		else
			System.out.print("//OFF//");
		//System.out.println("ARM" + _arm.GetArm());
		_arm.getArmPosition();
		System.out.println("  ");
	}
	
	public void test(){
		/**
		 * Testing a smoother, gradual slow-down of arm as it approaches limit switch
		 */
		if(IO.getArmUpperLimit() && IO.getXboxRightY() > 0){
			_arm.SetArm(0);
		}else if(_arm.getArmPosition() <= (Map.Encoder.ENC_LIMIT_SWITCH + 200) && IO.getXboxRightY() > 0){
			_arm.SetArm(.85*(Math.sqrt(((Math.abs((Map.Encoder.ENC_LIMIT_SWITCH + 200) - Map.Encoder.ENC_LIMIT_SWITCH))/200))));
			/**
			 * y = .85 * sqrt(x/200)
			 */
		}else{
			_arm.SetArm(.85*IO.getXboxRightY());
		}
	}
	
}
