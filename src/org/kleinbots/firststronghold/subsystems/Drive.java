package org.kleinbots.firststronghold.subsystems;

import org.kleinbots.firststronghold.HA;
import org.kleinbots.firststronghold.commands.ArcadeDrive;

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
	
	public Drive(CANTalon fl, CANTalon fr, CANTalon rl, CANTalon rr){
		frontLeft = fl;
		frontRight = fr;
		rearLeft = rl;
		rearRight = rr;
		drivetrain = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ArcadeDrive());
    }
    
    public void move(){
    	drivetrain.arcadeDrive(HA.mainJoy.getY(), HA.mainJoy.getThrottle());
    }
}

