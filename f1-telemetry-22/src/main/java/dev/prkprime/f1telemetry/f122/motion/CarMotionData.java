package dev.prkprime.f1telemetry.f122.motion;

import dev.prkprime.f1telemetry.f122.utils.ByteUtils;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Motion data for a single car
 */
@Getter
@Builder
@ToString
public class CarMotionData {

    /**
     * Size of the car motion data in bytes
     */
    public static final int SIZE = 60;

    /**
     * World space X position (meters)
     */
    private final float worldPositionX;

    /**
     * World space Y position (meters)
     */
    private final float worldPositionY;

    /**
     * World space Z position (meters)
     */
    private final float worldPositionZ;

    /**
     * Velocity in world space X (meters/s)
     */
    private final float worldVelocityX;

    /**
     * Velocity in world space Y (meters/s)
     */
    private final float worldVelocityY;

    /**
     * Velocity in world space Z (meters/s)
     */
    private final float worldVelocityZ;

    /**
     * World space forward X direction (normalized)
     */
    private final short worldForwardDirX;

    /**
     * World space forward Y direction (normalized)
     */
    private final short worldForwardDirY;

    /**
     * World space forward Z direction (normalized)
     */
    private final short worldForwardDirZ;

    /**
     * World space right X direction (normalized)
     */
    private final short worldRightDirX;

    /**
     * World space right Y direction (normalized)
     */
    private final short worldRightDirY;

    /**
     * World space right Z direction (normalized)
     */
    private final short worldRightDirZ;

    /**
     * Lateral G-Force component
     */
    private final float gForceLateral;

    /**
     * Longitudinal G-Force component
     */
    private final float gForceLongitudinal;

    /**
     * Vertical G-Force component
     */
    private final float gForceVertical;

    /**
     * Yaw angle in radians
     */
    private final float yaw;

    /**
     * Pitch angle in radians
     */
    private final float pitch;

    /**
     * Roll angle in radians
     */
    private final float roll;

    /**
     * Parse a byte array into a CarMotionData object
     *
     * @param data   byte array containing the data
     * @param offset starting position in the array
     * @return parsed CarMotionData
     */
    public static CarMotionData fromBytes(byte[] data, int offset) {
        return CarMotionData.builder()
                .worldPositionX(ByteUtils.toFloat(data, offset))
                .worldPositionY(ByteUtils.toFloat(data, offset + 4))
                .worldPositionZ(ByteUtils.toFloat(data, offset + 8))
                .worldVelocityX(ByteUtils.toFloat(data, offset + 12))
                .worldVelocityY(ByteUtils.toFloat(data, offset + 16))
                .worldVelocityZ(ByteUtils.toFloat(data, offset + 20))
                .worldForwardDirX(ByteUtils.toInt16(data, offset + 24))
                .worldForwardDirY(ByteUtils.toInt16(data, offset + 26))
                .worldForwardDirZ(ByteUtils.toInt16(data, offset + 28))
                .worldRightDirX(ByteUtils.toInt16(data, offset + 30))
                .worldRightDirY(ByteUtils.toInt16(data, offset + 32))
                .worldRightDirZ(ByteUtils.toInt16(data, offset + 34))
                .gForceLateral(ByteUtils.toFloat(data, offset + 36))
                .gForceLongitudinal(ByteUtils.toFloat(data, offset + 40))
                .gForceVertical(ByteUtils.toFloat(data, offset + 44))
                .yaw(ByteUtils.toFloat(data, offset + 48))
                .pitch(ByteUtils.toFloat(data, offset + 52))
                .roll(ByteUtils.toFloat(data, offset + 56))
                .build();
    }
}