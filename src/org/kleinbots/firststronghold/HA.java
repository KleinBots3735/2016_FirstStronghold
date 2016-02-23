package org.kleinbots.firststronghold;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;

/*
 * This class is used to easily manage all hardware on the robot
 */

public class HA {
	
	//Joystick Controllers
	public static Joystick mainJoy = new Joystick(0);
	
	//Motor Controllers
	public static CANTalon front_left_drive = new CANTalon(1);
	public static CANTalon front_right_drive = new CANTalon(2);
	public static CANTalon rear_left_drive = new CANTalon(3);
	public static CANTalon rear_right_drive = new CANTalon(4);
	public static CANTalon intake_pivot = new CANTalon(5);
	public static CANTalon intake_roller = new CANTalon(6);
	public static CANTalon shooter_pivot = new CANTalon(7);
	public static CANTalon left_shooter_wheel = new CANTalon(8);
	public static CANTalon right_shooter_wheel = new CANTalon(9);
	public static CANTalon winch_1 = new CANTalon(10);
	public static CANTalon winch_2 = new CANTalon(11);
	
	
	
	
}
