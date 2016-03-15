package org.kleinbots.firststronghold.subsystems;

import org.kleinbots.firststronghold.HA;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Scaler extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private static CANTalon topMotor, bottomMotor;
	public static boolean sole_extend;
	private static Solenoid solenoid;
	private static CANTalon top, bottom;

	public Scaler(){
		topMotor = HA.winch_1;
		bottomMotor = HA.winch_2;
		sole_extend = false;
		solenoid = HA.latch_sole;
	}	

	public Scaler(CANTalon topMotor, CANTalon bottomMotor, Solenoid latchSolenoid){
		top = topMotor;
		bottom = bottomMotor;
		sole_extend = false;
		solenoid = latchSolenoid;
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
    
    public void latchScaler(){
    	solenoid.set(sole_extend);
    	sole_extend = !sole_extend;
    }
}

