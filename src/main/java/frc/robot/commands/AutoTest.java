// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
 
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
public class AutoTest extends SequentialCommandGroup {
  
  public AutoTest(Drivetrain drive) {//Auto is never being executed
    addCommands(
    
    new EncoderDriveTest(100.0, .5, drive)
      //new EncoderDrive(20,0.5),
      //new WaitCommand(0.5)
      //new GyroTurn(90,0.5)
      
    );
    // Use addRequirements() here to declare subsystem dependencies.

  }

}
