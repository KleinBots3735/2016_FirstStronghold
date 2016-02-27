package org.kleinbots.firststronghold.subsystems;

import org.kleinbots.firststronghold.HA;
import org.kleinbots.firststronghold.commands.DriveCOM.ArcadeDrive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private CANTalon frontLeft, rearLeft, frontRight, rearRight;
	private RobotDrive drivetrain;
	
	private int direction;
	
	public Drive(CANTalon frontLeftMotor, CANTalon rearLeftMotor, CANTalon frontRightMotor, CANTalon rearRightMotor){
		frontLeft = frontLeftMotor;
		frontRight = frontRightMotor;
		rearLeft = rearLeftMotor;
		rearRight = rearRightMotor;
		
		//instantiate RobotDrive. NOTE: Correct order of motors is very critical
		drivetrain = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
		
		//Set default direction modifier to 1. This is changed with the changeDirection command
		direction = 1;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ArcadeDrive());
    }
    
    public void move(){
    	drivetrain.arcadeDrive(HA.mainJoy.getY()*direction, 		//gets up and down of the left joystick
    						   HA.mainJoy.getTwist()*direction);	//gets left and right of the right joystick
    }
    
    public void changeDirection(int i){
    	direction = i;
    }
    
    public int getDirection(){
    	return direction;
    }
}

