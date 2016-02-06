package frc4940.robots.s2016.stronghold;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoChooser {
	 //String storing the name of the selected autonomous mode.
    String selectedAuto;
    //Object allowing the option of choosing autonomous in the SmartDashboard
    SendableChooser chooser;
    
    public void ChooserInit(){
       	//Constructs chooser object
        chooser = new SendableChooser();
        //Adds the defualt Autonomous mode
        chooser.addDefault("Default Auto", Map.Auto.defaultAuto);
        //Adds another autonomous mode to be potentially chosen
        chooser.addObject("My Auto", Map.Auto.customAuto);
        chooser.addObject("Second Auto", Map.Auto.customAuto2);
        //lmao idk what this is for yet
        SmartDashboard.putData("Auto choices", chooser);
    }
    
    public void AutoInit(){
    	//gets the selected button from the SmartDashboard, and selects the associated autonomous
    	selectedAuto = (String) chooser.getSelected();
    	//Prints selected autonomous to dashboard
		System.out.println("Auto selected: " + selectedAuto);
    }
    
    public void run(){
    	/**
    	 * A switch-case tree is just a fancier if/else tree.
    	 * It is used when comparing all the possible values of a single variable.
    	 * You can use this, or just use if/else statements; switch is nicer, but if/else is familiar
    	 * //////////////////////////////////////////////////////////////////////////////////////
    	 * The below selects the correct autonomous mode based on what the selected autonomous is.
    	**/
    	switch(selectedAuto) {
	    	case Map.Auto.customAuto:
	    		//Put custom auto code here   
	            break;
	    	case Map.Auto.defaultAuto:
	    		default:
	    			//Put default auto code here
	            break;
    	}
    }
    
}
