package org.usfirst.frc.team2473.robot.subsystems;

import org.usfirst.frc.team2473.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

    CANTalon frontLeftTalon = new CANTalon(RobotMap.FRONT_LEFT);
    CANTalon backLeftTalon = new CANTalon(RobotMap.BACK_LEFT);
    CANTalon frontRightTalon = new CANTalon(RobotMap.FRONT_RIGHT);
    CANTalon backRightTalon = new CANTalon(RobotMap.BACK_RIGHT);

    public DriveTrain(){
    	
    }
    
    public void initDefaultCommand() {
    }
    
    public void resetEncoders(){
    	frontRightTalon.changeControlMode(TalonControlMode.Position);
    	frontLeftTalon.changeControlMode(TalonControlMode.Position);
    	frontRightTalon.setPosition(0);
    	frontLeftTalon.setPosition(0);
    	frontRightTalon.changeControlMode(TalonControlMode.PercentVbus);
    	frontLeftTalon.changeControlMode(TalonControlMode.PercentVbus);
    }
    
    public void setPower(double pow){
    	frontRightTalon.set(pow);
    	frontLeftTalon.set(pow);
    	backRightTalon.set(pow);
    	backLeftTalon.set(pow);
    }
    
    public double getRightEnc(){
    	return frontRightTalon.getPosition();
    }
    
    public double getLeftEnc(){
    	return frontLeftTalon.getPosition();
    }
}

