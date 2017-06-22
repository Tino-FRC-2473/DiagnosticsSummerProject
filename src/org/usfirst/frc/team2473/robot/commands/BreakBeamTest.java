package org.usfirst.frc.team2473.robot.commands;

import org.usfirst.frc.team2473.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BreakBeamTest extends Command {

    public BreakBeamTest() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.beam);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("Testing break beam, place object in front of break beam sensor, watch test rig");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		if(!isFinished()) { //if the command is not yet finished
			System.out.println("Waiting..."); //print waiting
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
		if(Robot.beam.getBreakbeamValue() == 2) { //if the breakbeam sensor returns true
			return true; //the command is complete
		} else {
			return false; //the command continues
		}
    }

    // Called once after isFinished returns true
    protected void end() {
		System.out.println("Breakbeam system operational."); //prints status once test is complete
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("Break beam test was interrupted.");
    }
}
