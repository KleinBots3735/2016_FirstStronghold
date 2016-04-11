package org.kleinbots.firststronghold.subsystems;

import org.kleinbots.firststronghold.HA;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.RobotBase;
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
	private DigitalInput limit;
	private static boolean isOn;	//is Shooter on?
	private Solenoid solenoid;
	private AnalogPotentiometer pot;
	private static boolean sole_extend; //what you want the solenoid state to be
//	PIDController pidController;
//	final double setPoints[] = {120, 140};
//	final double pGain = 8.0, iGain =0.5, dGain = 3.0;
	
	public Shooter(CANTalon pivotMotor, CANTalon leftShooterMotor, CANTalon rightShooterMotor, AnalogPotentiometer potentiometer, 
					Solenoid shooterSolenoid, DigitalInput pivotLimit){
		//Passes P,I,D values to super
		super(1, 1, 1);
		
		pivot = pivotMotor;
		left_wheel = leftShooterMotor;
		right_wheel = rightShooterMotor;
		pot = potentiometer;
		limit = pivotLimit;
		isOn = false;		//default is OFF
		solenoid = shooterSolenoid;
//		pidController = new PIDController(pGain, iGain, dGain, pot, pivot);
	}
	
//	public void shooterPID() {
//		pidController.setInputRange(0, 5); //0 to 5V 
//		pidController.setSetpoint(setPoints[0]); //set to first setpoint
//		
//		int index = 0;
//		boolean currentValue;
//		boolean previousValue = false;
//		
//		pidController.enable(); //begin PID control
//        
//        //when the button is pressed once, the selected elevator setpoint is incremented 
//        currentValue = HA.mainJoy.getRawButton(11);
//        if(currentValue && !previousValue){
//    	pidController.setSetpoint(setPoints[index]);
//    	index = (index + 1) % setPoints.length; //index of elevator setpoint wraps around
//        }   
//        previousValue = currentValue;
//	}        
	
	//sends any important information to smartdashboard. Called in Robot.java
	public void log(){
		LiveWindow.addActuator("Shooter", "Shooter Pivot Motor", pivot);
		LiveWindow.addSensor("Shooter", "Potentiometer", pot);
//		LiveWindow.addActuator("pidController", "Shooter PID", pidController);
		
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
    
    public boolean getLimit(){
    	return limit.get();
    }
    
    public double getPosition(){
    	return pot.get();
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
		solenoid.set(sole_extend);	//sets to desired solenoid state
		sole_extend = !sole_extend;	//flips solenoid state to all for toggling
	}
}

