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
	
	private static CANTalon topMotor, bottomMotor;
	
	public Scaler(){
		topMotor = HA.winch_1;
		bottomMotor = HA.winch_2;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setSPD(double SPD){
    	topMotor.set(SPD);
    	bottomMotor.set(SPD);
    }
}

