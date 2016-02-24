package kb.stronghold.commands.IntakeCOM;

import kb.stronghold.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class toggleIntakeRoller extends Command {
	
	double speed;
	
    public toggleIntakeRoller(double s) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intake);
    	speed = s;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	double SPD = 0;
    	if(Robot.intake.getIntakeOn())
    		SPD = speed;
    	else if(!Robot.intake.getIntakeOn())
    		SPD = 0;
    	
    	Robot.intake.setRollerSPD(SPD);
    	Robot.intake.setIntakeOn(!Robot.intake.getIntakeOn());
    	log();
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
    	end();
    }
    
    protected void log(){
    	System.out.println("Toggle " + Robot.intake.getIntakeOn());
    }
}
