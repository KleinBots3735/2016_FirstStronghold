package org.kleinbots.firststronghold.commands.DriveCOM;

import org.kleinbots.firststronghold.HA;
import org.kleinbots.firststronghold.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class accDrive extends Command {
	/************************************/
	/* Constants						*/
	/************************************/	
	private static final double K_FILTERCOEF_Y 		= 8.0;  /* Range is 1 to 50 , 1 is like old code, 3 or 6, 8 is recommended */ 
	private static final double K_FILTERCOEF_Z 		= 4.0; 
	
	private static final double K_MAX_MTR_Y 		= 1.00;  /* This is Max Motor Speed when Jy Stick Max */
	private static final double K_MAX_MTR_Z 		= 1.00; 
	
	/************************************/
	/* Variables						*/
	/************************************/	
	
	private double YDriveStick;
	private double ZDriveStick;
		
	private double YDriveMotor;
	private double ZDriveMotor;
	
	private double YDriveMotorPrevious;
	private double ZDriveMotorPrevious;
	
	private double yInput;
	private double zInput;
	private boolean isThereInput;
	
	/************************************/
	/* Code								*/
	/************************************/
    public accDrive() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.drive);
    	isThereInput = false;
    }
    
    public accDrive(double yMovement, double zMovement){
    	yInput = yMovement;
    	zInput = zMovement;
    	isThereInput = true;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		YDriveStick			= 0.0;
		ZDriveStick			= 0.0;
		YDriveMotor			= 0.0;
		ZDriveMotor			= 0.0;
		YDriveMotorPrevious = 0.0;
		ZDriveMotorPrevious = 0.0;
	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/************************************/
		/* Lets Get the New Joy Stick Values*/
		/************************************/
    	if(isThereInput){
    		YDriveStick = yInput;
    		ZDriveStick = zInput;
    	}
    	else{
    		YDriveStick = HA.mainJoy.getY() * Robot.drive.getDirection();
			ZDriveStick = HA.mainJoy.getTwist() * -Robot.drive.getDirection();
    	}
			/*********************************/
			/* Lets Filter the Motor Outputs */
			/*********************************/
			/* Note We use the Saved Past Motor Drive Values to Make Calculations */
			YDriveMotor = (YDriveStick  / K_FILTERCOEF_Y ) + (YDriveMotorPrevious*(K_FILTERCOEF_Y - 1 )/ K_FILTERCOEF_Y);
			ZDriveMotor = (ZDriveStick  / K_FILTERCOEF_Z ) + (ZDriveMotorPrevious*(K_FILTERCOEF_Z - 1 )/ K_FILTERCOEF_Z);
			
			/****************************************/
			/* Let Save the Motor Y and Z so we     */
			/* Use the Value for future Calculations*/
			/****************************************/
			YDriveMotorPrevious = YDriveMotor; 
			ZDriveMotorPrevious = ZDriveMotor;
						
			/**************************************/
			/* Let Update the Drive Train Y and Z */
			/**************************************/
			Robot.drive.move(YDriveMotor * K_MAX_MTR_Y , -ZDriveMotor * K_MAX_MTR_Z);	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Robot.drive.move(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
