package org.kleinbots.firststronghold.subsystems;

import org.kleinbots.firststronghold.HA;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Shooter extends PIDSubsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private CANTalon pivot, left_wheel, right_wheel;
	public DigitalInput limit;
	public static boolean isOn;
	public Solenoid solenoid;
	AnalogPotentiometer pot;
	public static boolean sole_extend;
	
	public Shooter(CANTalon pivot, CANTalon left_shooter, CANTalon right_shooter, AnalogPotentiometer potentiometer){
		super(1, 1, 1);
		this.pivot = pivot;
		this.left_wheel = left_shooter;
		this.right_wheel = right_shooter;
		pot = potentiometer;
		limit = HA.shooter_lim;
		isOn = false;
		solenoid = HA.shooter_sole;
//		left_wheel.setControlMode(4);	//set to voltage mode
//		right_wheel.setControlMode(4);	//set to voltage mode
	}
	
	//sends any important information to smartdashboard. Called in Robot.java
	public void log(){
		LiveWindow.addActuator("Shooter", "Shooter Pivot Motor", pivot);
		LiveWindow.addSensor("Shooter", "Potentiometer", pot);
		SmartDashboard.putBoolean("Shooter Limit", limit.get());
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
    
    public boolean getIsOn(){
    	return isOn;
    }
    
    public void setIsOn(boolean b){
    	isOn = b;
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
	
	public void shootSolenoid(){
		solenoid.set(sole_extend);
		sole_extend = !sole_extend;
	}
}

