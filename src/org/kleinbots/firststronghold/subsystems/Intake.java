package org.kleinbots.firststronghold.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private CANTalon pivot, roller;
	public static boolean isOn;
	
	/*
	 * @param (CANTalon Pivot, CANTalon roller)
	 */
	public Intake(CANTalon p, CANTalon r){
		pivot = p;
		roller = r;
		isOn = false;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    //actions
    public void setPivotSPD(double SPD){
    	pivot.set(SPD);
    }
    
    public void setRollerSPD(double SPD){
    	roller.set(SPD);
    }
    
    public boolean getIntakeOn(){
    	return isOn;
    }
    
    public void setIntakeOn(boolean b){
    	isOn = b;
    }
}

