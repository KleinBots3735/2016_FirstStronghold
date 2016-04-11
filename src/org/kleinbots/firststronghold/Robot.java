
package org.kleinbots.firststronghold;

import org.kleinbots.firststronghold.commands.AUTO_DelayedCross;
import org.kleinbots.firststronghold.commands.AUTO_DoNothing;
import org.kleinbots.firststronghold.commands.AUTO_Cross;
import org.kleinbots.firststronghold.commands.AUTO_LowBar;
import org.kleinbots.firststronghold.commands.AUTO_Reach;
import org.kleinbots.firststronghold.subsystems.*;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	//initialize all subsystems and OI
	public static OI oi;
	public static Drive drive;
	public static Intake intake;
	public static Shooter shooter;
	public static Scaler scaler;
	
    Command autonomousCommand;
    SendableChooser chooser;
    public static CameraServer camServer;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	//instantiate all subystems and OI passing necessary hardware from HA
		drive = new Drive(HA.front_left_drive, HA.rear_left_drive, HA.front_right_drive, HA.rear_right_drive);
		intake = new Intake(HA.intake_pivot, HA.intake_roller, HA.intakePot);
		shooter = new Shooter(HA.shooter_pivot, HA.left_shooter_wheel,HA.right_shooter_wheel, 
							  HA.shooterPot, 
							  HA.shooter_sole, 
							  HA.shooter_lim);
		scaler = new Scaler(HA.winch_1, HA.winch_2, HA.latch_sole);
		oi = new OI(HA.mainJoy,HA.coJoy);	
        chooser = new SendableChooser();
        chooser.addDefault("AUTO_DoNothing", new AUTO_DoNothing());
        chooser.addDefault("AUTO_Reach", new AUTO_Reach());
        chooser.addObject("AUTO_Cross", new AUTO_Cross());
        chooser.addObject("AUTO_LowBar", new AUTO_LowBar());    
        chooser.addObject("AUTO_DelayedCross", new AUTO_DelayedCross());
        SmartDashboard.putData("Auto mode", chooser);
        camServer = CameraServer.getInstance();
        camServer.setQuality(50);
        //the camera name (ex "camera") can be found through the roborio web interface
        camServer.startAutomaticCapture("cam1");
        
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
    	//Selects which auton to use
    	//autonomousCommand = new AUTO_DoNothing();
        autonomousCommand = (Command) chooser.getSelected();
//		String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
//		switch(autoSelected) {
//		case "auto":
//			autonomousCommand = new AUTO_DriveStraight();
//			break;
//		case "Default Auto":
//		default:
//			autonomousCommand = new AUTO_DriveStraight();
//			break;
//		}
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        log();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    //retrieves logs from subsystems and is called in autonomous and teleop periodic
    protected void log(){
    	SmartDashboard.putNumber("Shooter Potentiometer", HA.shooterPot.get());
    	SmartDashboard.putNumber("Intake Potentiometer", HA.intakePot.get());
//    	SmartDashboard.putNumber("Rangefinder", HA.sonar.getRangeInches());
    }
}
