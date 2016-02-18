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
	 //String storing the name of the selected autonomous mode.
    String selectedAuto;
    //Object allowing the option of choosing autonomous in the SmartDashboard
    SendableChooser chooser;
	TeleOp teleop = new TeleOp();
	Arm __arm__ = new Arm(1);
	Timer time = new Timer();
	
	final String defaultAuto = "Default";
	final String customAuto = "My First Auto";
	
    /**
     * Initiation Code
     */
    public void robotInit() {
    	//Constructs chooser object
        chooser = new SendableChooser();
        //Adds the defualt Autonomous mode
        chooser.addDefault("Default Auto", defaultAuto);
        //Adds another autonomous mode to be potentially chosen
        chooser.addObject("My Auto", customAuto);
        //lmao idk what this is for yet
        SmartDashboard.putData("Auto choices", chooser);
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
    	//Autonomous.init();
    	//gets the selected button from the SmartDashboard, and selects the associated autonomous
    	selectedAuto = (String) chooser.getSelected();
    	//Prints selected autonomous to dashboard
		System.out.println("Auto selected: " + selectedAuto);
		time.reset();
		
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
		
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	/**
    	 * A switch-case tree is just a fancier if/else tree.
    	 * It is used when comparing all the possible values of a single variable.
    	 * You can use this, or just use if/else statements; switch is nicer, but if/else is familiar
    	 * //////////////////////////////////////////////////////////////////////////////////////
    	 * The below selects the correct autonomous mode based on what the selected autonomous is.
    	**/
    	switch(selectedAuto) {
	    	case customAuto:
	    		//Put custom auto code here   
	            break;
	    	case defaultAuto:
	    		default:
	    			//Put default auto code here
	            break;
    	}
    }

    /**
     * TeleOp Initialization Code
     */
    public void teleopInit() {
    	teleop.init();
    }
    /**
     * TeleOp Code
     */
    public void teleopPeriodic() {
        teleop.run();
    }
    
    /**
     * Test Code
     * Enter any throw-away or test code in here
     */
    public void testPeriodic() {
    	teleop.test();
    }
    
}
