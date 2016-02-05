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
	public static CANTalon talon_1 = new CANTalon(1);
	public static CANTalon talon_2 = new CANTalon(2);
	public static CANTalon talon_3 = new CANTalon(3);
	public static CANTalon talon_4 = new CANTalon(4);
	public static CANTalon talon_5 = new CANTalon(5);
	public static CANTalon talon_6 = new CANTalon(6);
	public static CANTalon talon_7 = new CANTalon(7);
	public static CANTalon talon_8 = new CANTalon(8);
	
	
}
