package frc.robot.subsystems;

import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.CubeShooterConstants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class CubeShooter extends SubsystemBase {

    private CANSparkMax leftShooterMotor = new CANSparkMax(0, MotorType.kBrushless);
    private CANSparkMax rightShooterMotor = new CANSparkMax(0, MotorType.kBrushless);
    private CANSparkMax feederMotor = new CANSparkMax(0, MotorType.kBrushless);



    private double shooterSpeed = CubeShooterConstants.kDefaultShooterSpeed;

    private static CubeShooter instance;

    public static CubeShooter getInstance() {
        if(instance == null) {
            instance = new CubeShooter();
        }
        return instance;
    }

    private CubeShooter() {
        leftShooterMotor.restoreFactoryDefaults();
        rightShooterMotor.restoreFactoryDefaults();
        feederMotor.restoreFactoryDefaults();
        leftShooterMotor.burnFlash();
        rightShooterMotor.burnFlash();
        feederMotor.burnFlash();

        rightShooterMotor.follow(leftShooterMotor, true);

    }

    public void run() {
        leftShooterMotor.set(shooterSpeed);
    }
    public void feedIn() {
        feederMotor.set(-CubeShooterConstants.kFeederMotorSpeed);
    }
    public void stop() {
        leftShooterMotor.set(0);
        feederMotor.set(0);
    }
}
