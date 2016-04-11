package org.kleinbots.firststronghold.commands;

import org.kleinbots.firststronghold.Robot;
import org.kleinbots.firststronghold.commands.DriveCOM.accDrive;
import org.kleinbots.firststronghold.commands.IntakeCOM.setIntakePivot;
import org.kleinbots.firststronghold.commands.IntakeCOM.setIntakePos;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AUTO_LowBar extends CommandGroup {
    
    public  AUTO_LowBar() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	requires(Robot.drive);
    	requires(Robot.intake);
    	
    	//addSequential(new setIntakePos(150.0));
    	addSequential(new setIntakePivot(0.3),4.0);
    	addSequential(new accDrive(0.7,0.0),3.5);
    }
}
