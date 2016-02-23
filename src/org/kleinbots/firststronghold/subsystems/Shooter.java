package org.kleinbots.firststronghold.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private CANTalon pivot, left_wheel, right_wheel;
	
	public Shooter(CANTalon pivot, CANTalon left_shooter, CANTalon right_shooter){
		this.pivot = pivot;
		this.left_wheel = left_shooter;
		this.right_wheel = right_shooter;
		left_wheel.setControlMode(4);	//set to voltage mode
		right_wheel.setControlMode(4);	//set to voltage mode
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setShooter(double leftSPD, double rightSPD){
    	left_wheel.set(leftSPD);
    	right_wheel.set(rightSPD);
    }
    
    public void setShooterPivot(double voltage){
    	pivot.set(voltage);
    }
}

