package kb.stronghold;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;

/*
 * This class is used to easily manage all hardware on the robot
 */

public class HA {	
	//Joystick 
	public static Joystick mainJoy = new Joystick(0);
	
	//Motor Controllers
	public static CANTalon front_left_drive = new CANTalon(1);
	public static CANTalon rear_left_drive = new CANTalon(2);
	public static CANTalon front_right_drive = new CANTalon(3);
	public static CANTalon rear_right_drive = new CANTalon(4);
	public static CANTalon intake_pivot = new CANTalon(6); //30amp
	public static CANTalon intake_roller = new CANTalon(5); //30amp
	public static CANTalon shooter_pivot = new CANTalon(7); //30amp
	public static CANTalon left_shooter_wheel = new CANTalon(8);
	public static CANTalon right_shooter_wheel = new CANTalon(9);
	public static CANTalon winch_1 = new CANTalon(10);
	public static CANTalon winch_2 = new CANTalon(11);
		
	//Solenoids
	public static Solenoid shooter_sole = new Solenoid(0);
	public static Solenoid latch_sole = new Solenoid(1);
		
	//Sensors
	public static AnalogInput ai = new AnalogInput(0);
	public static AnalogPotentiometer pot = new AnalogPotentiometer(ai,360,30);
	
	//Limit Switches
	public static DigitalInput shooter_lim = new DigitalInput(0);
	public static DigitalInput intake_lim = new DigitalInput(1);
}
