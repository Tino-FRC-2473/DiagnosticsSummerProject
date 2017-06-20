package org.usfirst.frc.team2473.robot.subsystems;

import org.usfirst.frc.team2473.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

    CANTalon talonOne;
    CANTalon talonTwo;

    public DriveTrain(){
    	talonOne = new CANTalon(RobotMap.TALON_ONE);
    	talonTwo = new CANTalon(RobotMap.TALON_TWO);
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

