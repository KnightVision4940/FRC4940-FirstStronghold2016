///////////////////////////////////////////////////////
// Robot.java
// FRC 4940
//
// Main class
// This is run at runtime, but all code is contained in other class files
///////////////////////////////////////////////////////
package frc4940.robots.s2016.stronghold;
/**

// Imported Packages
 */
import edu.wpi.first.wpilibj.IterativeRobot;

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
    
	
    public void autonomousInit() {
    	auto.init();
    	auto.Run();
    	IO.chassis.Wheels.setSafetyEnabled(true);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	System.out.println(""); //This just ensures teleop doesn't malfunction after running auto
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
    	//This just ensures the robot doesn't malfunction after running calibration.
    	System.out.println("");
    }
    
}
