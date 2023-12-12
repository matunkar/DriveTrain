package frc.robot.commands;
import frc.robot.subsystems.CubeShooter;
import edu.wpi.first.wpilibj2.command.CommandBase;


public class ShootCubeCommand extends CommandBase {
    private CubeShooter cubeShooter = CubeShooter.getInstance();

    public ShootCubeCommand() {
        this.addRequirements(cubeShooter);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        cubeShooter.run();
    }

    @Override 
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        cubeShooter.stop();
    }
}
