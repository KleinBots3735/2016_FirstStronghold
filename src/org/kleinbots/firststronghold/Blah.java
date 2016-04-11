package org.kleinbots.firststronghold;

import edu.wpi.first.wpilibj.AnalogPotentiometer;

public class Blah {

	double setPoint;
	double maxSPD;
	double minSPD;
	double error;
	double k;
	AnalogPotentiometer pot;
	
	public Blah(double setPoint, double maxSPD, double minSPD,  double maxP, AnalogPotentiometer pot) {
		this.setPoint = setPoint;
		this.maxSPD = maxSPD;
		this.minSPD = minSPD;
		this.pot = pot;
		
		k = maxSPD / (this.setPoint - maxP);
	}
	
	public double calculate(double p){
		setPoint = p;
		error = setPoint - pot.get();
		double outputSPD = error * k;
		
		if (outputSPD == 0) {
			return outputSPD;
		}
		
		if(Math.abs(outputSPD) < minSPD){ 
			if(outputSPD < 0){
				outputSPD = -minSPD;
			}
			else {
				outputSPD = minSPD;
			}
		}
		return outputSPD;
	}
	
}
