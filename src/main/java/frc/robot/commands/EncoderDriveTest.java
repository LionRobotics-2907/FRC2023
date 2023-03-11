// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.RobotContainer;


public class EncoderDriveTest extends CommandBase {
  private final Drivetrain drivetrain;
  private final double distanceInches;
  private final double speed;
  /** Creates a new EncoderDriveTest. */
  public EncoderDriveTest(double distance, double speed, Drivetrain drive) {
    // Use addRequirements() here to declare subsystem dependencies.
    distanceInches = distance;
    this.speed = speed;
    drivetrain = drive;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  RobotContainer.m_drivetrain.RFdriveEncoder.setPosition(0.0);  
  RobotContainer.m_drivetrain.arcadeDrive(speed,0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.m_drivetrain.arcadeDrive(speed,0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_drivetrain.arcadeDrive(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(RobotContainer.m_drivetrain.RFdriveEncoder.getPosition()) >= distanceInches;//rememebr this is simply poistion not actually distance
   } 

  }