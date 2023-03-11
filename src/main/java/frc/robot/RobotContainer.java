// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PS4Controller; //Remember we may want to switch to gamepad instead of ps4
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
//import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriveArcade;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.EncoderDrive;
import frc.robot.commands.GyroTurn;
import frc.robot.commands.AutoTest;
import frc.robot.commands.fixit;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static final Drivetrain m_drivetrain = new Drivetrain();
  public static PS4Controller driverController = new PS4Controller(Constants.DRIVER_CONTROLLER);
  public static final EncoderDrive encoderDrive = new EncoderDrive(0,0);
  public static final GyroTurn gyroTurn = new GyroTurn(0,0);
  public static final AutoTest autoTest = new AutoTest(m_drivetrain);

  public static SendableChooser<Command> chooser = new SendableChooser<>();
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
     //setting options for auto paths
     chooser.setDefaultOption("First Auto Path", autoTest);
     SmartDashboard.putData(chooser);
    //set default commands on subsystem
    //m_drivetrain.setDefaultCommand(new DriveArcade());
    m_drivetrain.setDefaultCommand(new fixit(m_drivetrain, () -> driverController.getLeftY(), () -> -driverController.getRightX()));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

  // public Joystick driverController = new Joystick(Constants.DRIVER_CONTROLLER);
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public static Command getAutonomousCommand() {
   //  An ExampleCommand will run in autonomous
   return chooser.getSelected();
  }
}
