package frc.robot.subsystems;

import frc.robot.constants.NeoMotorConstants;
import frc.robot.constants.DriveConstants;
import frc.robot.libraries.MAXSwerveModule;
import frc.robot.libraries.Kestrel1038;


import java.math.*;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;

public class DriveTrain {


    private final MAXSwerveModule frontLeft = new MAXSwerveModule(DriveConstants.kFrontLeftDrivingCanId, DriveConstants.kFrontLeftTurningCanId, DriveConstants.kFrontLeftChassisAngularOffset);
    private final MAXSwerveModule frontRight = new MAXSwerveModule(DriveConstants.kFrontRightDrivingCanId, DriveConstants.kFrontRightTurningCanId, DriveConstants.kFrontRightChassisAngularOffset);
    private final MAXSwerveModule backLeft = new MAXSwerveModule(DriveConstants.kBackLeftDrivingCanId, DriveConstants.kBackLeftTurningCanId, DriveConstants.kBackLeftChassisAngularOffset);
    private final MAXSwerveModule backRight = new MAXSwerveModule(DriveConstants.kBackRightDrivingCanId, DriveConstants.kBackRightTurningCanId, DriveConstants.kBackRightChassisAngularOffset);

    private final Kestrel1038 gyro = new Kestrel1038(DriveConstants.kGyroCanId);

    private SwerveDriveOdometry odometry = new SwerveDriveOdometry(
            DriveConstants.kDriveKinematics,
            Rotation2d.fromDegrees(gyro.getAngle()),
            new SwerveModulePosition[] {
                    frontLeft.getPosition(),
                    frontRight.getPosition(),
                    backLeft.getPosition(),
                    backRight.getPosition()
            });

    private static DriveTrain INSTANCE;

    public static DriveTrain getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DriveTrain();
        }
        return INSTANCE;
    }

    public void setModuleStates(SwerveModuleState[] desiredStates) {
        SwerveDriveKinematics.desaturateWheelSpeeds((desiredStates), 
            DriveConstants.kMaxSpeedMetersPerSecond);
        frontLeft.setDesiredState(desiredStates[0]);
        frontRight.setDesiredState(desiredStates[1]);
        backLeft.setDesiredState(desiredStates[2]);
        backRight.setDesiredState(desiredStates[3]);
    }

    public void drive(double xSpeed, double ySpeed, double rotation) {
        xSpeed *= DriveConstants.kMaxSpeedMetersPerSecond;
        ySpeed *= DriveConstants.kMaxSpeedMetersPerSecond;
        rotation *= DriveConstants.kMaxAngularSpeed;

        SwerveModuleState[] swerveModuleStates = DriveConstants.kDriveKinematics.toSwerveModuleStates(ChassisSpeeds.fromFieldRelativeSpeeds(xSpeed, ySpeed, rotation, Rotation2d.fromDegrees(gyro.getAngle())));
        this.setModuleStates(swerveModuleStates);
    }

    public void resetEncoders () {
        frontLeft.resetEncoders();
        backLeft.resetEncoders();
        frontRight.resetEncoders();
        backRight.resetEncoders();
    }
}
