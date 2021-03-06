package org.kleinbots.firststronghold.commands;

import org.kleinbots.firststronghold.Robot;
import org.kleinbots.firststronghold.commands.DriveCOM.accDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class auto extends CommandGroup {
    
    public  auto() {
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
    	
    	addSequential(new accDrive(1.0,0.0),7.0); //drive straight for 5 seconds
    }
}
