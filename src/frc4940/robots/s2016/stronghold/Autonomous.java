///////////////////////////////////////////////////////
// Autonomous.java
// FRC 4940
//
// Class for the autonomous modes.
// Sendable choosers on the SmartDashboard are used to select auto.
// In theory, there is one auto mode for every defence,
// but not all routines were tested, and some do not have a routine as a result.
///////////////////////////////////////////////////////
package frc4940.robots.s2016.stronghold;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Autonomous {
	//Int storing the selector that determines the auto mode
    int selectedAuto;
    //used in individual aauto modes to determine stages; starts at 0
    int autoStage;
    //Object allowing the option of choosing autonomous in the SmartDashboard
    SendableChooser chooser;
	
	/**
	 * Constructor & Initiator
	 */
	Autonomous(){
    	//Constructs chooser object
        chooser = new SendableChooser();
        //Adds multiple modes to be selected
        chooser.addDefault("Low Bar", Map.Auto.LOW_BAR);
        chooser.addObject("*Portcullis", Map.Auto.PORTCULLIS);
        chooser.addObject("*Cheval de Frise", Map.Auto.CHEVAL_DE_FRISE);
        chooser.addObject("Ramparts", Map.Auto.RAMPARTS);
        chooser.addObject("Moat", Map.Auto.MOAT);
        chooser.addObject("*Drawbridge", Map.Auto.DRAWBRIDGE);
        chooser.addObject("*Sally Port", Map.Auto.SALLY_PORT);
        chooser.addObject("*Rock Wall", Map.Auto.ROCK_WALL);
        chooser.addObject("Rough Terrain", Map.Auto.ROUGH_TERRAIN);
        //I'm pretty sure this is a wrapper for the whole chooser UI in the dashboard
        SmartDashboard.putData("Auto choices", chooser);
        //resets the auto stage
        autoStage = 0;
	}
	
	void init(){
		//gets the selected button from the SmartDashboard, and selects the associated autonomous
    	selectedAuto = (int)chooser.getSelected();
    	IO.chassis.Wheels.setSafetyEnabled(false); //This ensures chassis continously runs. Reenabled at end of autonomous
	}
	
	// Run statement, so whatever mode is chosen by name or number, then the robot will use that autonomous 
	void Run(){
		/**
    	 * The below selects the correct autonomous mode based on what the selected autonomous is.
    	**/
		switch(selectedAuto) {
	    	case Map.Auto.LOW_BAR:
		    	default:
		    		while (!IO.getArmUpperLimit() || IO.arm.getArmPosition() < -15000){
		    			IO.arm.SetArm(-1.0);
		    		}
		    		IO.arm.SetArm(0);
		    		IO.chassis._driveRobot(-0.75, 0);
					Timer.delay(3);
					IO.chassis._driveRobot(0, 0);
		            break;
	    	
	    	case Map.Auto.PORTCULLIS:
	    		//No routine currently availible
				break;
	    	
	    	case Map.Auto.CHEVAL_DE_FRISE:
	    		//No routine currently availible
    			break;
	    	
	    	case Map.Auto.RAMPARTS:
	    		IO.arm.SetArm(0);
	    		IO.chassis._driveRobot(-0.75, 0);
				Timer.delay(3);
				IO.chassis._driveRobot(0, 0);
    			break;
	    	
	    	case Map.Auto.MOAT: 
	    		IO.arm.SetArm(0);
	    		IO.chassis._driveRobot(-0.75, 0);
				Timer.delay(3);
				IO.chassis._driveRobot(0, 0);
   				break;
	
	    	case Map.Auto.DRAWBRIDGE:
	    		//No routine currently availible
	   			break;
	    	
	    	case Map.Auto.SALLY_PORT:
	    		//No routine currently availible
    			break;
	    	
	    	case Map.Auto.ROCK_WALL: 
	    		//No routine currently availible
				break;
	    	
	    	case Map.Auto.ROUGH_TERRAIN: //Wont equal 130
	    		IO.arm.SetArm(0);
	    		IO.chassis._driveRobot(-0.75, 0);
				Timer.delay(3);
				IO.chassis._driveRobot(0, 0);
            break;
		}
	}
}
