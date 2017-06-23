package org.usfirst.frc.team2473.robot.commands;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PreRoundDiagnostics extends CommandGroup{
	public PreRoundDiagnostics() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("Robot.txt"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String in = st.nextToken();
			switch (in) {
				case "talon" :
					addSequential(new DriveTrainTest());
					break;
				case "servo" :
					addSequential(new ServoTest());
					break;
				case "gyro" :
					addSequential(new GyroTest());
					break;
				case "light" :
					addSequential(new LightTest());
					break;
				case "breakbeam" :
					addSequential(new BreakBeamTest());
					break;
				default:
					System.out.println("The following part was not found: " + in + "!");
			}
		}
	}
}
