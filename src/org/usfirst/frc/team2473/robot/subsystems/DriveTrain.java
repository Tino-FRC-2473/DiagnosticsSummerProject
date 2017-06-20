package org.usfirst.frc.team2473.robot.subsystems;

import org.usfirst.frc.team2473.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

    CANTalon talonOne = new CANTalon(RobotMap.TALON_ONE);
    CANTalon talonTwo = new CANTalon(RobotMap.TALON_TWO);

    public DriveTrain(){
    	
    }
    
    public void initDefaultCommand() {
    }
    
    public void resetEncoders(){
    	talonTwo.changeControlMode(TalonControlMode.Position);
    	talonOne.changeControlMode(TalonControlMode.Position);
    	talonTwo.setPosition(0);
    	talonOne.setPosition(0);
    	talonTwo.changeControlMode(TalonControlMode.PercentVbus);
    	talonOne.changeControlMode(TalonControlMode.PercentVbus);
    }
    
    public void setPower(double pow){
    	talonTwo.set(pow);
    	talonOne.set(pow);
    }
    
    public double getRightEnc(){
    	return talonTwo.getPosition();
    }
    
    public double getLeftEnc(){
    	return talonOne.getPosition();
    }
}

