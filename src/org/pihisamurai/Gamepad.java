/*
 * Gamepad class to encapsulate FRC 1076 PiHiSamuari's Logitech Gamepads
 * Adopted from FRC 830 Rat Packs C++ Version
 * 
 */

package org.pihisamurai;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DriverStation;

/**
 *
 * @author PiHi Samurai 1076
 */

/*
 * Emily is testing commit
 * Avery's Note 1/14/14
 * 
 * I recommend re-writing it to contain a joystick rather
 * then extend one as to
 * make it easier to use
 * 
 * http://first.wpi.edu/FRC/roborio/release/docs/java/
 * classedu_1_1wpi_1_1first_1_1wpilibj_1_1Joystick.html
 * 
 * It should contain a function to get every button, get the
 * x/y of the sticks,
 * get values of throttles, and get directional pad
 * direction
 * 
 * Right now it uses constants and a get button function,
 * lets change those
 * constants to be private and have a specific function for
 * each button
 * 
 * It should add the rumble functionality
 */

public class Gamepad {

	private static final byte	BUTTON_A				= 1;
	private static final byte	BUTTON_B				= 2;
	private static final byte	BUTTON_X				= 3;
	private static final byte	BUTTON_Y				= 4;
	private static final byte	BUTTON_LB				= 5;
	private static final byte	BUTTON_RB				= 6;
	private static final byte	BUTTON_BACK				= 7;
	private static final byte	BUTTON_START			= 8;
	private static final byte	BUTTON_LEFT_STICK_PUSH	= 7;
	private static final byte	BUTTON_RIGHT_STICK_PUSH	= 8;

	private static final byte	AXIS_LEFT_X				= 0;
	private static final byte	AXIS_LEFT_Y				= 1;	// Corrected
																// these.
	private static final byte	AXIS_LEFT_TRIGGER		= 2;
	private static final byte	AXIS_RIGHT_TRIGGER		= 3;
	private static final byte	AXIS_RIGHT_Y			= 5;
	private static final byte	AXIS_RIGHT_X			= 4;

	int							port;
	DriverStation				driverStation;

	Gamepad(int port) {
		this.port = port;
		driverStation = DriverStation.getInstance();
	}

	double getPOV() {
		return driverStation.getStickPOV(port, 0);
	}

	double getLeftX() {
		return getRawAxis(AXIS_LEFT_X);
	}

	double getLeftY() {
		return getRawAxis(AXIS_LEFT_Y);
	}

	double getRightX() {
		return getRawAxis(AXIS_RIGHT_X);
	}

	double getRightY() {
		return getRawAxis(AXIS_RIGHT_Y);
	}

	double getRightTrigger() {
		return getRawAxis(AXIS_RIGHT_TRIGGER);
	}

	double getLeftTrigger() {
		return getRawAxis(AXIS_LEFT_TRIGGER);
	}

	public double getRawAxis(int axis) {
		return driverStation.getStickAxis(port, axis);
	}

	// No idea why this is needed with getRawButton() which
	// is part of joystick
	boolean getNumberedButton(byte button) {
		return driverStation.getStickButton(port, button);
	}

	public boolean getButtonA() {
		return getNumberedButton(BUTTON_A);
	}

	public boolean getButtonB() {
		return getNumberedButton(BUTTON_B);
	}

	public boolean getButtonX() {
		return getNumberedButton(BUTTON_X);
	}

	public boolean getButtonY() {
		return getNumberedButton(BUTTON_Y);
	}

	public boolean getButtonBack() {
		return getNumberedButton(BUTTON_BACK);
	}

	public boolean getButtonStart() {
		return getNumberedButton(BUTTON_START);
	}

	public boolean getButtonLeftBack() {
		return getNumberedButton(BUTTON_LB);
	}

	public boolean getButtonRightBack() {
		return getNumberedButton(BUTTON_RB);
	}

}