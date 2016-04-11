package org.kleinbots.firststronghold.subsystems;

import org.kleinbots.firststronghold.Blah;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private CANTalon pivot, roller;
	private AnalogPotentiometer pot; 
	private double real;
	private double setpoint;
	public static boolean isOn;		//is Roller On?
	public Blah b;
	
	/*
	 * @param (CANTalon Pivot, CANTalon roller)
	 */
	public Intake(CANTalon pivotMotor, CANTalon rollerMotor, AnalogPotentiometer intakePot){
		pivot = pivotMotor;
		roller = rollerMotor;
		pot = intakePot;
		isOn = false;		//default is false when Robot is first turned on
		b = new Blah(195, 0.8, 0.2, 40, pot);
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
    
    public void setPivotPOS(int POS){
    	setpoint=POS;
    	real=this.getPivotPOS();
    	
    }
    
    public double getPivotPOS(){
    	return pot.get();
    }
    
    public void setIntakeOn(boolean b){
    	isOn = b;
    }
}