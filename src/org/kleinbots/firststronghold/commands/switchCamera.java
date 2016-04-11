package org.kleinbots.firststronghold.commands;

import org.kleinbots.firststronghold.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class switchCamera extends Command {
	
	String cameraName;
	Boolean firstCamera;
	
    public switchCamera() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    	firstCamera = true;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(firstCamera){
    		cameraName = "cam1";
    	}
    	else if(!firstCamera){
    		cameraName = "cam0";
    	}
    	
		firstCamera = !firstCamera;
		
//    	Robot.camServer.startAutomaticCapture(cameraName);

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
