package frc.robot;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.Trigger;

import frc.robot.libraries.XboxController1038;


import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.CubeShooter;
import frc.robot.commands.EjectCubeCommand;
import frc.robot.commands.CubeAcquisitionCommand;
import frc.robot.commands.ShootCubeCommand;


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

        ShootCubeCommand shootCubeCommand = new ShootCubeCommand();
        CubeAcquisitionCommand feedCubeCommand = new CubeAcquisitionCommand();
        EjectCubeCommand ejectCubeCommand = new EjectCubeCommand();

        yButton
            .whileTrue(shootCubeCommand);
        xButton 
            .onTrue(feedCubeCommand);
        bButton 
            .whileTrue(ejectCubeCommand);


    }
}
