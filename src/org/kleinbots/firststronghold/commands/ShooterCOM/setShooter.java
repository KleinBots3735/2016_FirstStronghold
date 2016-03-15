package org.kleinbots.firststronghold.commands.ShooterCOM;

import org.kleinbots.firststronghold.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class setShooter extends Command {
	
	double voltage;
	
    public setShooter(double v) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter);
    	voltage = v;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooter.setShooter(voltage, -voltage);

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	Robot.shooter.setShooter(voltage, -voltage);
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
