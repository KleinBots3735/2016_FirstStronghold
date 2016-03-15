package org.kleinbots.firststronghold.commands.ShooterCOM;

import org.kleinbots.firststronghold.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class setShooterPivot extends Command {
	
	Double speed;
	Double position;
	
    public setShooterPivot(Double s) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter);
    	speed = s;
    }
    
    public setShooterPivot(Double s, Double p){
    	this(s);
    	position = p;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(position == null)
    		Robot.shooter.setShooterPivot(speed);
    	else {
    		
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.shooter.getLimit();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    protected void log(){

    }
}
