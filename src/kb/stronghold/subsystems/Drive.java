package kb.stronghold.subsystems;

import kb.stronghold.HA;
import kb.stronghold.commands.ArcadeDrive;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private CANTalon frontLeft, rearLeft, frontRight, rearRight;
	private RobotDrive drivetrain;
	
	private int direction;
	
	public Drive(CANTalon fl, CANTalon rl, CANTalon fr, CANTalon rr){
		frontLeft = fl;
		frontRight = fr;
		rearLeft = rl;
		rearRight = rr;
		drivetrain = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
		direction = 1;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ArcadeDrive());
    }
    
    public void move(){
    	drivetrain.arcadeDrive(HA.mainJoy.getY()*direction, HA.mainJoy.getTwist()*direction);
    }
    
    public void changeDirection(int i){
    	direction = i;
    }
    
    public int getDirection(){
    	return direction;
    }
}

