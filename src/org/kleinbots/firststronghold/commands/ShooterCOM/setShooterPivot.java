package org.kleinbots.firststronghold.commands.ShooterCOM;

import org.kleinbots.firststronghold.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class setShooterPivot extends Command {
	
	double speed;
	
    public setShooterPivot(double s) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter);
    	speed = s;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooter.setShooterPivot(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.shooter.limit.get();
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
