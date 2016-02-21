package frc4940.robots.s2016.stronghold;

/**
 * Imported Packages
 */
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.*;
import frc4940.robots.s2016.stronghold.Map.Auto;

/**
 * Main Robot Class
 */
public class Robot extends IterativeRobot { 
	TeleOp teleop;
	Autonomous auto;
	
    /**
     * Initiation Code
     */
    public void robotInit() {
    	teleop = new TeleOp();
    	auto = new Autonomous();
    }
    
	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString line to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the switch structure below with additional strings.
	 * If using the SendableChooser make sure to add them to the chooser code above as well.
	 */
    public void autonomousInit() {
    	auto.init();
    	/**		
		int armPosi = __arm__.getArmPosition();	
		while (!IO.getArmUpperLimit() && __arm__.getArmPosition() > armPosi-525){
			__arm__.SetArm(0.45);
		}
		__arm__.SetArm(0);

		time.start();
		
		while (time.get() < 2){
			teleop.chassis._driveRobot(-0.5, 0);
		}
		teleop.chassis._driveRobot(0.0, 0);
		//Autonomous.Run(Map.Auto.TEST_AUTO);
		 * 
		 */
		
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	auto.Run();
    }

    /**
     * TeleOp Initialization Code
     */
    public void teleopInit() {
    	//There seems to be nothing here . . . 
    }
    /**
     * TeleOp Code
     */
    public void teleopPeriodic() {
        teleop.run();
    	//teleop.testEnc();
    }
    
    /**
     * Test Code
     * Currently used to calibrate the arm's position
     */
    public void testInit() {
    	teleop.calibrateArmPosition();
    }
    public void testPeriodic(){
    	teleop.getArmAngle();
    }
    
}
