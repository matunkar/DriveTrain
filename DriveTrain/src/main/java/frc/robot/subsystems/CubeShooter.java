package frc.robot.subsystems;

import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.CubeShooterConstants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class CubeShooter extends SubsystemBase {

    private CANSparkMax shooterMotor = new CANSparkMax(0, MotorType.kBrushless);
    private CANSparkMax feederMotor = new CANSparkMax(0, MotorType.kBrushless);

    private relativeEncoder shooterEncoder = shooterMotor.getEncoder();
    private relativeEncoder feederEncoder = feederMotor.getEncoder();

    private double shooterSpeed = CubeShooterConstants.kDefaultShooterSpeed;
    private double feederSpeed = CubeShooterConstants.kFeederMotorSpeed;

    private static CubeShooter instance;

    public static CubeShooter getInstance() {
        if(instance == null) {
            instance = new CubeShooter();
        }
        return instance;
    }

    private CubeShooter() {
        shooterMotor.restoreFactoryDefaults();
        feederMotor.restoreFactoryDefaults();
        shooterMotor.burnFlash();
        feederMotor.burnFlash();

    }

    public void run() {
        shooterMotor.set(shooterSpeed);
    }
    public void feedIn() {
        feederMotor.set(-feederSpeed);
    }
    public void stop() {
        shooterMotor.set(0);
        feederMotor.set(0);
    }
}

