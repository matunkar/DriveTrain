package frc.robot.subsystems;

import frc.robot.constants.NeoMotorConstants;
import frc.robot.libraries.MAXSwerveModule;

public class DriveTrain {
    private final MAXSwerveModule frontLeft = new MAXSwerveModule(0, 0, 0)
    private final MAXSwerveModule frontRight = new MAXSwerveModule(0, 0, 0)
    private final MAXSwerveModule backLeft = new MAXSwerveModule(0, 0, 0)
    private final MAXSwerveModule backRight = new MAXSwerveModule(0, 0, 0)

    private static DriveTrain INSTANCE;

    public static DriveTrain getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DriveTrain();
        }
        return INSTANCE;
    }
}
