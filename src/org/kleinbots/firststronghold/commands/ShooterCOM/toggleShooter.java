package org.kleinbots.firststronghold.commands.ShooterCOM;

import org.kleinbots.firststronghold.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class toggleShooter extends Command {
	
	double speed;
	
    public toggleShooter(double s) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter);
    	speed = s;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//    	if(Robot.shooter.getIsOn()){
//    		Robot.shooter.setShooter(0, 0);
//        	Robot.shooter.setIsOn(false);
//
//    	}
//    	else if(!Robot.shooter.getIsOn()){
//    		Robot.shooter.setShooter(SPD, -SPD);
//        	Robot.shooter.setIsOn(true);
//
//    	}
    	
    	double SPD = 0;
    	if(Robot.shooter.getIsOn()){
    		SPD = 0;
    		Robot.shooter.setShooter(0, 0);
        	Robot.shooter.setIsOn(!Robot.shooter.getIsOn());

    	}
    	else if(!Robot.shooter.getIsOn()) {
    		SPD = speed;
        	Robot.shooter.setShooter(SPD, -SPD);
        	Robot.shooter.setIsOn(!Robot.shooter.getIsOn());
    	}
    	System.out.println("Toggle Shooter");
    	System.out.println(Robot.shooter.getIsOn());
    	
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
