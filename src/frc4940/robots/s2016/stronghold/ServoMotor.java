package frc4940.robots.s2016.stronghold;
import edu.wpi.first.wpilibj.Servo;

public class ServoMotor {
	Servo sMotor = new Servo(5);
	public void run(double _degrees){
		sMotor.set(_degrees);
	}
}
