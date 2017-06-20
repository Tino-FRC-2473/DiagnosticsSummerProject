package org.usfirst.frc.team2473.robot.commands;

import org.usfirst.frc.team2473.robot.ConstantMap;
import org.usfirst.frc.team2473.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTrainTest extends Command {

    public DriveTrainTest() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("Testing drive train, watch test rig");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.resetEncoders();
    	Robot.driveTrain.setPower(0.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(Robot.driveTrain.getTalonOne()> ConstantMap.testToValueEnc || Robot.driveTrain.getTalonTwo() > ConstantMap.testToValueEnc){
        	return true;
        }
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	if(Math.abs(Robot.driveTrain.getTalonOne()-Robot.driveTrain.getTalonTwo()) > ConstantMap.acceptableEncDifference){
    		if(Robot.driveTrain.getTalonOne()>Robot.driveTrain.getTalonTwo()){
    			System.out.println("Talon One running faster than the acceptable difference");
    		}else{
    			System.out.println("Talon Two running faster than the acceptable difference");
    		}
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
