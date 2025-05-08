package dev.prkprime.f1telemetry.f122.motion;

import dev.prkprime.f1telemetry.f122.utils.ByteUtils;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Additional motion data for the player's car only
 */
@Getter
@Builder
@ToString
public class PlayerCarData {

    /**
     * Size of the player car data in bytes
     */
    public static final int SIZE = 120;

    /**
     * Suspension position for each wheel [RL, RR, FL, FR]
     */
    private final float[] suspensionPosition;

    /**
     * Suspension velocity for each wheel [RL, RR, FL, FR]
     */
    private final float[] suspensionVelocity;

    /**
     * Suspension acceleration for each wheel [RL, RR, FL, FR]
     */
    private final float[] suspensionAcceleration;

    /**
     * Wheel speed for each wheel [RL, RR, FL, FR]
     */
    private final float[] wheelSpeed;

    /**
     * Slip ratio for each wheel [RL, RR, FL, FR]
     */
    private final float[] wheelSlip;

    /**
     * Velocity in local space (X = right, Y = up, Z = forward)
     */
    private final float localVelocityX;

    /**
     * Velocity in local space (X = right, Y = up, Z = forward)
     */
    private final float localVelocityY;

    /**
     * Velocity in local space (X = right, Y = up, Z = forward)
     */
    private final float localVelocityZ;

    /**
     * Angular velocity x-component
     */
    private final float angularVelocityX;

    /**
     * Angular velocity y-component
     */
    private final float angularVelocityY;

    /**
     * Angular velocity z-component
     */
    private final float angularVelocityZ;

    /**
     * Angular acceleration x-component
     */
    private final float angularAccelerationX;

    /**
     * Angular acceleration y-component
     */
    private final float angularAccelerationY;

    /**
     * Angular acceleration z-component
     */
    private final float angularAccelerationZ;

    /**
     * Current front wheels angle in radians
     */
    private final float frontWheelsAngle;

    /**
     * Parse a byte array into a PlayerCarData object
     *
     * @param data   byte array containing the data
     * @param offset starting position in the array
     * @return parsed PlayerCarData
     */
    public static PlayerCarData fromBytes(byte[] data, int offset) {
        // Parse suspension position for each wheel
        float[] suspensionPosition = new float[4];
        for (int i = 0; i < 4; i++) {
            suspensionPosition[i] = ByteUtils.toFloat(data, offset + (i * 4));
        }
        offset += 16;

        // Parse suspension velocity for each wheel
        float[] suspensionVelocity = new float[4];
        for (int i = 0; i < 4; i++) {
            suspensionVelocity[i] = ByteUtils.toFloat(data, offset + (i * 4));
        }
        offset += 16;

        // Parse suspension acceleration for each wheel
        float[] suspensionAcceleration = new float[4];
        for (int i = 0; i < 4; i++) {
            suspensionAcceleration[i] = ByteUtils.toFloat(data, offset + (i * 4));
        }
        offset += 16;

        // Parse wheel speed for each wheel
        float[] wheelSpeed = new float[4];
        for (int i = 0; i < 4; i++) {
            wheelSpeed[i] = ByteUtils.toFloat(data, offset + (i * 4));
        }
        offset += 16;

        // Parse wheel slip for each wheel
        float[] wheelSlip = new float[4];
        for (int i = 0; i < 4; i++) {
            wheelSlip[i] = ByteUtils.toFloat(data, offset + (i * 4));
        }
        offset += 16;

        return PlayerCarData.builder()
                .suspensionPosition(suspensionPosition)
                .suspensionVelocity(suspensionVelocity)
                .suspensionAcceleration(suspensionAcceleration)
                .wheelSpeed(wheelSpeed)
                .wheelSlip(wheelSlip)
                .localVelocityX(ByteUtils.toFloat(data, offset))
                .localVelocityY(ByteUtils.toFloat(data, offset + 4))
                .localVelocityZ(ByteUtils.toFloat(data, offset + 8))
                .angularVelocityX(ByteUtils.toFloat(data, offset + 12))
                .angularVelocityY(ByteUtils.toFloat(data, offset + 16))
                .angularVelocityZ(ByteUtils.toFloat(data, offset + 20))
                .angularAccelerationX(ByteUtils.toFloat(data, offset + 24))
                .angularAccelerationY(ByteUtils.toFloat(data, offset + 28))
                .angularAccelerationZ(ByteUtils.toFloat(data, offset + 32))
                .frontWheelsAngle(ByteUtils.toFloat(data, offset + 36))
                .build();
    }
}