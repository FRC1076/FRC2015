package org.pihisamurai;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutonomousForward {

	Robot robot;

	double time;

	AutonomousForward(Robot robot) {
		this.robot = robot;
	}

	public void run() {
		if ((System.nanoTime() / 1000000000) - time > 5){
			robot.drivetrain.setAll(0);
		} else {
			robot.drivetrain.setAll(-0.5);
		}
		// robot.drivetrain.update();
	}

	public void init() {
		time = System.nanoTime() / 1000000000;
		// robot.drivetrain.goDistPrimary(1, -0.5);
	}

}
