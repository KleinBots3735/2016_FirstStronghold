package org.kleinbots.firststronghold;

import org.kleinbots.firststronghold.commands.DriveCOM.*;
import org.kleinbots.firststronghold.commands.IntakeCOM.*;
import org.kleinbots.firststronghold.commands.ScalerCOM.*;
import org.kleinbots.firststronghold.commands.ShooterCOM.*;

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
	private Joystick joy, coJoy;
	
	public OI(Joystick j1, Joystick j2) {
		joy = j1; //sets joystick from Hardware adapter
		coJoy = j2;
		
		//Button Mapping for driver joystick
		Button x = new JoystickButton(joy,1);
		Button a = new JoystickButton(joy,2);
		Button b = new JoystickButton(joy,3);
		Button y = new JoystickButton(joy,4);
		Button lb = new JoystickButton(joy,5);
		Button rb = new JoystickButton(joy,6);
		Button lt = new JoystickButton(joy,7);
		Button rt = new JoystickButton(joy,8);
		Button back = new JoystickButton(joy,9);
		Button start = new JoystickButton(joy,10);
		Button ls = new JoystickButton(joy,11);
		Button rs = new JoystickButton(joy,12);
		
		//Button Mapping for codriver joystick
		Button cX = new JoystickButton(coJoy,1);
		Button cA = new JoystickButton(coJoy,2);
		Button cB = new JoystickButton(coJoy,3);
		Button cY = new JoystickButton(coJoy,4);
		Button cLB = new JoystickButton(coJoy,5);
		Button cRB = new JoystickButton(coJoy,6);
		Button cLT = new JoystickButton(coJoy,7);
		Button cRT = new JoystickButton(coJoy,8);
		Button cBack = new JoystickButton(coJoy,9);
		Button cStart = new JoystickButton(coJoy,10);
		Button cLS = new JoystickButton(coJoy,11);
		Button cRS = new JoystickButton(coJoy,12);			
		
//Command Mapping
		
	//DRIVE COMMANDS
			//Reverse driving controls
		start.whenPressed(new changeDirection());
		
	//INTAKE COMMANDS		
			//Move intake arm up
		lb.whileHeld(new setIntakePivot(-0.5));
		lb.whenReleased(new setIntakePivot(0)); //stops pivot
		cLB.whileHeld(new setIntakePivot(-0.5));
		cLB.whenReleased(new setIntakePivot(0)); //stops pivot
		
			//Move intake arm down
		lt.whileHeld(new setIntakePivot(0.3));
		lt.whenReleased(new setIntakePivot(0)); //stops pivot
		cLT.whileHeld(new setIntakePivot(0.3));
		cLT.whenReleased(new setIntakePivot(0)); //stops pivot
		
		
			//Toggle Roller On/Off
		x.whenPressed(new toggleIntakeRoller(1.0));
		cX.whenPressed(new toggleIntakeRoller(1.0));

		
	//SHOOTER COMMANDS		
		
			//Pivot shooter up
		rb.whileHeld(new setShooterPivot(-0.3));
		rb.whenReleased(new setShooterPivot(0.0));	//stops pivot
		cRB.whileHeld(new setShooterPivot(-0.3));
		cRB.whenReleased(new setShooterPivot(0.0));	//stops pivot
		
			//Pivot shooter down
		rt.whileHeld(new setShooterPivot(0.2));
		rt.whenReleased(new setShooterPivot(0.0));	//stops pivot
		cRT.whileHeld(new setShooterPivot(0.2));
		cRT.whenReleased(new setShooterPivot(0.0));	//stops pivot
		
			//Toggle Shooter On/Off
		a.whenPressed(new toggleShooter(-0.75));
		cA.whenPressed(new toggleShooter(-0.75));
		//a.whenPressed(new setShooter(-1));
		
		//back.whenPressed(new setShooter(0));
		
			//Toggle Shooter Solenoid
		b.whenPressed(new shootSolenoid());
		cB.whenPressed(new shootSolenoid());
		
	//SCALER COMMANDS
			
			//crank winch forward
		ls.whileHeld(new setScaler(1));
		ls.whenReleased(new setScaler(0));	//stop winch
		cLS.whileHeld(new setScaler(1));
		cLS.whenReleased(new setScaler(0));	//stop winch
			
			//crank winch forward
		rs.whileHeld(new setScaler(-1));
		cRS.whileHeld(new setScaler(-1));
		rs.whenReleased(new setScaler(0)); //stop winch
		cRS.whenReleased(new setScaler(0)); //stop winch
		
		y.whenPressed(new latchScaler());
		cY.whenPressed(new latchScaler());
		
	}
	
}

