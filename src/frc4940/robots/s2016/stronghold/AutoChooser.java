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
    
    
}
