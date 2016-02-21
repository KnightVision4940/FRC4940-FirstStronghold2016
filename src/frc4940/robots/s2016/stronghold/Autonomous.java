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
		    		System.out.println("get low ;p");   
		            break;
	    	case Map.Auto.PORTCULLIS:
	    		
	    			System.out.println("Child-friendly Guillotine");
	            break;
	    	case Map.Auto.CHEVAL_DE_FRISE:
	    		
    			System.out.println("Spade of Potatoes");
            break;
	    	case Map.Auto.RAMPARTS:
	    		
    			System.out.println("Let's please talk about Rampart");
            break;
	    	case Map.Auto.MOAT:
	    		
    			System.out.println("RICK AND MOATY");
            break;
	    	case Map.Auto.DRAWBRIDGE:
	    		
    			System.out.println("Draw me a bridge");
            break;
	    	case Map.Auto.SALLY_PORT:
	    		
    			System.out.println("Sassy Sally");
            break;
	    	case Map.Auto.ROCK_WALL:
	    		
    			System.out.println("I'M ROCK SOLID");
            break;
	    	case Map.Auto.ROUGH_TERRAIN:
	    		
    			System.out.println("rough 'round the edges ;)");
            break;
		}
		/*
		if (mode == Auto.DRIVE_STRAIGHT){
			chasis._driveRobot(0.5, 0);
			Timer.delay(4.5);
			chasis._driveRobot(0, 0);
		} 
		if (mode == Auto.LOW_BAR){
			chasis._driveRobot(0.6, 0);
			Timer.delay(5);
			chasis._driveRobot(0, 0);
		}
		if (mode == Auto.PORTCULLIS){ 
			
			chasis._driveRobot(0.7, 0);
			Timer.delay(2);
			chasis._driveRobot(0, 0);
			
			time_.start();
			
			while((time_.get() < 3.5 && !IO.getArmUpperLimit()) || arm.getArmPosition() < 4){
				arm.SetArm(-0.9);
			}
			arm.SetArm(0);
			
			time_.stop();
			time_.reset();
			
			chasis._driveRobot(0.7, 0);
			Timer.delay(4);
			chasis._driveRobot(0, 0);
		}
		if (mode == Auto.MOAT){
			chasis._driveRobot(0.8, 0);
			Timer.delay(4);
			chasis._driveRobot(0.5, 0);
			Timer.delay(4);
		}
		if (mode == Auto.RAMPARTS){
			chasis._driveRobot(0.9, 0);
			Timer.delay(3);
			chasis._driveRobot(0, 0);
			Timer.delay(0.1);
			chasis._driveRobot(0.5, 0);
			Timer.delay(2);
			chasis._driveRobot(0, 0);
		}
		if (mode == Auto.ROCK_WALL){
			chasis._driveRobot(0.8, 0);
			Timer.delay(3);
			chasis._driveRobot(0.5, 0);
			Timer.delay(4);
			chasis._driveRobot(0,0);
		}
		if (mode == Auto.ROUGH_TERRAIN){
			chasis._driveRobot(0.8, 0);
			Timer.delay(3);
			chasis._driveRobot(0.5, 0);
			Timer.delay(4);
			chasis._driveRobot(0,0);		
		}
		if (mode == Auto.SALLY_PORT){
			
		}
		if (mode == Auto.DRAWBRIDGE){
			
		}
		if (mode == Auto.CHEVAL_DE_FRISE){
			arm.SetArm(0.9); //move arms up
			chasis._driveRobot(0.6, 0);
			Timer.delay(0.75);
			arm.SetArm(0);
			Timer.delay(2.25);
			chasis._driveRobot(0, 0);
			while(!IO.getArmUpperLimit()){
				arm.SetArm(-0.6);
			}
			arm.SetArm(0);
			Timer.delay(1);
			arm.SetArm(1);
			Timer.delay(1.8);
			arm.SetArm(0);
			chasis._driveRobot(0.8, 0);
			Timer.delay(5);
			chasis._driveRobot(0, 0);
			
		}
		if (mode == Auto.TEST_AUTO){
			if (!IO.getArmUpperLimit()){
				arm.SetArm(0.45);
			} else {
				arm.SetArm(0);
			}
		}
		*/
	}
}
