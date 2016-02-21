package frc4940.robots.s2016.stronghold;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc4940.robots.s2016.stronghold.Map.Auto;

public class Autonomous {
	
	//Used to keep track of time ;)
	static Timer time;
	//Int storing the selector that determines the auto mode
    int selectedAuto;
    //Object allowing the option of choosing autonomous in the SmartDashboard
    SendableChooser chooser;
	
	/**
	 * Constructor & Initiator
	 */
	Autonomous(){
		time = new Timer();
    	//Constructs chooser object
        chooser = new SendableChooser();
        //Adds multiple modes to be selected
        chooser.addDefault("Low Bar", Map.Auto.LOW_BAR);
        chooser.addObject("Portcullis", Map.Auto.PORTCULLIS);
        chooser.addObject("Cheval de Frise", Map.Auto.CHEVAL_DE_FRISE);
        chooser.addObject("Ramparts", Map.Auto.RAMPARTS);
        chooser.addObject("Moat", Map.Auto.MOAT);
        chooser.addObject("Drawbridge", Map.Auto.DRAWBRIDGE);
        chooser.addObject("Sally Port", Map.Auto.SALLY_PORT);
        chooser.addObject("Rock Wall", Map.Auto.ROCK_WALL);
        chooser.addObject("Rough Terrain", Map.Auto.ROUGH_TERRAIN);
        //I'm pretty sure this is a wrapper for the whole chooser UI in the dashboard
        SmartDashboard.putData("Auto choices", chooser);
	}
	
	void init(){
		time.reset();
		//gets the selected button from the SmartDashboard, and selects the associated autonomous
    	selectedAuto = (int)chooser.getSelected();
	}
	
	// Run statement, so whatever mode is chosen by name or number, then the robot will use that autonomous 
	void Run(){
		/**
    	 * A switch-case tree is just a fancier if/else tree.
    	 * It is used when comparing all the possible values of a single variable.
    	 * You can use this, or just use if/else statements; switch is nicer, but if/else is familiar
    	 * //////////////////////////////////////////////////////////////////////////////////////
    	 * The below selects the correct autonomous mode based on what the selected autonomous is.
    	**/
		switch(selectedAuto) {
	    	case Map.Auto.LOW_BAR:
		    	default:
		    		IO.chassis._driveRobot(0.6, 0);
					Timer.delay(5);
					IO.chassis._driveRobot(0, 0);
		            break;
	    	case Map.Auto.PORTCULLIS:
	    		IO.chassis._driveRobot(0.7, 0);
				Timer.delay(2);
				IO.chassis._driveRobot(0, 0);
				
				IO.arm.SetArm(-0.9);
				Timer.delay(2);
				IO.arm.SetArm(0);
				
				IO.chassis._driveRobot(0.7, 0);
				Timer.delay(4);
				IO.chassis._driveRobot(0, 0);
	            break;
	    	case Map.Auto.CHEVAL_DE_FRISE:
	    		IO.arm.SetArm(0.9); //move arms up
				IO.chassis._driveRobot(0.6, 0);
				Timer.delay(0.75);
				IO.arm.SetArm(0);
				Timer.delay(2.25);
				IO.chassis._driveRobot(0, 0);
				while(!IO.getArmUpperLimit()){
					IO.arm.SetArm(-0.6);
				}
				IO.arm.SetArm(0);
				Timer.delay(1);
				IO.arm.SetArm(1);
				Timer.delay(1.8);
				IO.arm.SetArm(0);
				IO.chassis._driveRobot(0.8, 0);
				Timer.delay(5);
				IO.chassis._driveRobot(0, 0);
    			break;
	    	case Map.Auto.RAMPARTS:
	    		IO.chassis._driveRobot(0.75, 0);
				Timer.delay(4.5);
				IO.chassis._driveRobot(0, 0);
				Timer.delay(0.1);
				IO.chassis._driveRobot(-0.5, 0);
				Timer.delay(2);
				IO.chassis._driveRobot(0, 0);
    			break;
	    	case Map.Auto.MOAT:
	    		IO.chassis._driveRobot(0.8, 0);
				Timer.delay(4);
				IO.chassis._driveRobot(0, 0);
    			
				break;
	    	case Map.Auto.DRAWBRIDGE:
	    		
    			System.out.println("Draw me a bridge");
    			break;
	    	case Map.Auto.SALLY_PORT:
	    		
    			System.out.println("Sassy Sally");
    			break;
	    	case Map.Auto.ROCK_WALL:
				IO.chassis._driveRobot(0.5, 0);
				Timer.delay(5);
				IO.chassis._driveRobot(0,0);
				break;
	    	case Map.Auto.ROUGH_TERRAIN:
	    		IO.chassis._driveRobot(0.8, 0);
				Timer.delay(4);
				IO.chassis._driveRobot(0, 0);
            break;
		}
	}
}
