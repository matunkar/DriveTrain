package frc.robot.subsystems;

import frc.robot.constants.NeoMotorConstants;
import frc.robot.constants.DriveConstants;
import frc.robot.libraries.MAXSwerveModule;
import java.math.*;

public class DriveTrain {


    private final MAXSwerveModule frontLeft = new MAXSwerveModule(DriveConstants.kFrontLeftDrivingCanId, DriveConstants.kFrontLeftTurningCanId, DriveConstants.kFrontLeftChassisAngularOffset);
    private final MAXSwerveModule frontRight = new MAXSwerveModule(DriveConstants.kFrontRightDrivingCanId, DriveConstants.kFrontRightTurningCanId, DriveConstants.kFrontRightChassisAngularOffset);
    private final MAXSwerveModule backLeft = new MAXSwerveModule(DriveConstants.kBackLeftDrivingCanId, DriveConstants.kBackLeftTurningCanId, DriveConstants.kBackLeftChassisAngularOffset);
    private final MAXSwerveModule backRight = new MAXSwerveModule(DriveConstants.kBackRightDrivingCanId, DriveConstants.kBackRightTurningCanId, DriveConstants.kBackRightChassisAngularOffset);

    private static DriveTrain INSTANCE;

    public static DriveTrain getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DriveTrain();
        }
        return INSTANCE;
    }

    public void setModuleStates() {

    }

    public void drive(double xSpeed, double ySpeed, double rotation) {
        xSpeed *= DriveConstants.kMaxSpeedMetersPerSecond;
        ySpeed *= DriveConstants.kMaxSpeedMetersPerSecond;
        rotation *= DriveConstants.kMaxAngularSpeed;

    }
}
