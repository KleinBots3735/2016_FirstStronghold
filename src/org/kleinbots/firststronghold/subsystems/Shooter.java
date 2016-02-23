package org.kleinbots.firststronghold.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends PIDSubsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private CANTalon pivot, left_wheel, right_wheel;
	
	public Shooter(CANTalon pivot, CANTalon left_shooter, CANTalon right_shooter){
		super(1, 1, 1);
		this.pivot = pivot;
		this.left_wheel = left_shooter;
		this.right_wheel = right_shooter;
		left_wheel.setControlMode(4);	//set to voltage mode
		right_wheel.setControlMode(4);	//set to voltage mode
	}
	
	//sends any important information to smartdashboard. Called in Robot.java
	public void log(){
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setShooter(double left_voltage, double right_voltage){
    	left_wheel.set(left_voltage);
    	right_wheel.set(right_voltage);
    }
    
    public void setShooterPivot(double speed){
    	pivot.set(speed);
    }

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		
	}
}

