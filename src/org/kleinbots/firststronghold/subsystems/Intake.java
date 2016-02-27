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
	public static boolean isOn;		//is Roller On?
	
	/*
	 * @param (CANTalon Pivot, CANTalon roller)
	 */
	public Intake(CANTalon pivotMotor, CANTalon rollerMotor){
		pivot = pivotMotor;
		roller = rollerMotor;
		isOn = false;		//default is false when Robot is first turned on
	}
	
	//sends any important information to smartdashboard. Called in Robot.java
	public void log(){
			
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

