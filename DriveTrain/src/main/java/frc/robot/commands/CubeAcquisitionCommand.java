package frc.robot.commands;
import frc.robot.subsystems.CubeShooter;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.AcquisitionConstants;

import edu.wpi.first.wpilibj.Timer;


public class CubeAcquisitionCommand extends CommandBase {
    private CubeShooter cubeShooter = CubeShooter.getInstance();
    private Timer timer = new Timer();

    public CubeAcquisitionCommand() {
        this.addRequirements(cubeShooter);
    }

    @Override
    public void initialize() {
        timer.reset();
    }

    @Override
    public void execute() {
        cubeShooter.feedIn();
    }

    @Override 
    public boolean isFinished() {
        return timer.get() >= AcquisitionConstants.acquisitionTime;
    }

    @Override
    public void end(boolean interrupted) {
        cubeShooter.stop();
        timer.stop();
    }
}
