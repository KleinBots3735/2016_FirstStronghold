package org.kleinbots.firststronghold.subsystems;

import org.kleinbots.firststronghold.HA;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Scaler extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private static CANTalon top, bottom;
	
	public Scaler(CANTalon topMotor, CANTalon bottomMotor){
		top = topMotor;
		bottom = bottomMotor;
	}
	
	//sends any important information to smartdashboard. Called in Robot.java
	public void log(){
			
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setSPD(double SPD){
    	top.set(SPD);
    	bottom.set(SPD);
    }
}

