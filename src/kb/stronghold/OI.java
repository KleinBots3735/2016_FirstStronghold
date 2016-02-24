package kb.stronghold;

import kb.stronghold.commands.*;
import kb.stronghold.commands.DriveCOM.*;
import kb.stronghold.commands.IntakeCOM.*;
import kb.stronghold.commands.ScalerCOM.*;
import kb.stronghold.commands.ShooterCOM.*;
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
		
		//Button Mapping for joystick
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
		
//Command Mapping
		
	//INTAKE COMMANDS		
			//Move intake arm up
		lb.whileHeld(new setIntakePivot(0.3));
		lb.whenReleased(new setIntakePivot(0)); //stops pivot
		
			//Move intake arm down
		lt.whileHeld(new setIntakePivot(-0.3));
		lt.whenReleased(new setIntakePivot(0)); //stops pivot
		
		
			//Toggle Roller On/Off
		x.whenPressed(new toggleIntakeRoller(0.5));
		
	//SHOOTER COMMANDS		
		
			//Pivot shooter up
		rb.whileHeld(new setShooterPivot(0.3));
		rb.whenReleased(new setShooterPivot(0));
		
			//Pivot shooter down
		rt.whileHeld(new setShooterPivot(-0.3));
		rt.whenReleased(new setShooterPivot(0));
		
			//Toggle Shooter On/Off
		a.whenPressed(new toggleShooter(1.00));
	}
	
	
}

