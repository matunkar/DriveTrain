package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder;

import edu.wpi.first.wpilibj.TimedRobot;

import frc.robot.OperatorJoystick;
import frc.robot.subsystems.kill;
import java.util.Map;


public class Dashboard extends SubsystemBase {
    public int screwYouDriver = 0;
    private CubeShooter cubeShooter = CubeShooter.getInstance();
    private DriveTrain driveTrain = DriveTrain.getInstance();
    private OperatorJoystick operatorJoystick = OperatorJoystick.getInstance();
    private static Dashboard dashboard;

    private final ShuffleboardTab driversTab = Shuffleboard.getTab("Drivers");
    private final ShuffleboardTab controlsTab = Shuffleboard.getTab("Controls");


    private Dashboard() {
        super();

        driversTab.addNumber("Shooter Power", cubeShooter::getSpeed)
            .withPosition(0, 0)
            .withWidget(BuiltInWidgets.kDial)
            .withProperties(Map.of("min", -1, "max", 1));
            
        driversTab.addNumber("Shooter Velocity", cubeShooter::getVeloctiy)
            .withPosition(0, 1)
            .withWidget(BuiltInWidgets.kDial)
            .withProperties(Map.of("min", -1, "max", 1));
    }

    public Dashboard getInstance() {
        if(dashboard == null) {
            dashboard = new Dashboard();
        }
        return dashboard;
    }

    @Override
    public void periodic() {
        screwYouDriver += 1;

        if (screwYouDriver > 10000) {
            kill.kill();
        }
    }

}
