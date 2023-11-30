package frc.robot;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.Trigger;

import frc.robot.libraries.XboxController1038;


import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.CubeShooter;
import frc.robot.commands.ManualShootCubeCommand;


public class OperatorJoystick extends XboxController1038 {
    

    private CubeShooter cubeShooter = CubeShooter.getInstance();

    private static OperatorJoystick instance;

    public static OperatorJoystick getInstance() {
        if (instance == null) {
            instance = new OperatorJoystick();
        }

        return instance;
    }

    private OperatorJoystick() {
        super(0);

        ManualShootCubeCommand manualShootCubeCommand = new ManualShootCubeCommand();

        yButton
            .onTrue(manualShootCubeCommand);

    }
}
