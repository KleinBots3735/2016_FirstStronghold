package org.kleinbots.firststronghold;

import org.kleinbots.firststronghold.commands.setIntakePivot;
import org.kleinbots.firststronghold.commands.setIntakeRoller;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	private Joystick joy;
	
	public OI(Joystick j) {
		joy = j; //sets joystick from Hardware adapter
		
		//Buttons
		Button x = new JoystickButton(joy,1);
		Button a = new JoystickButton(joy,2);
		Button b = new JoystickButton(joy,3);
		Button y = new JoystickButton(joy,4);
		Button l1 = new JoystickButton(joy,5);
		Button r1 = new JoystickButton(joy,6);
		Button l2 = new JoystickButton(joy,7);
		Button r2 = new JoystickButton(joy,8);
		
		//Command Mapping
		
			//Move intake arm up
		l1.whileHeld(new setIntakePivot(0.3));
		l1.whenReleased(new setIntakePivot(0));
		
			//Move intake arm down
		l1.whileHeld(new setIntakePivot(-0.3));
		l1.whenReleased(new setIntakePivot(0));
		
			//Intake normal direction
		r1.whileHeld(new setIntakeRoller(1));
		r1.whenReleased(new setIntakeRoller(0));
		
			//Reverses intake roller
		r2.whileHeld(new setIntakeRoller(-1));
		r2.whenReleased(new setIntakeRoller(0));
	}
	
	
}

