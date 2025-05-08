package dev.prkprime.f1telemetry.f122.carsetups;

import dev.prkprime.f1telemetry.f122.utils.ByteUtils;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Car setup data for a single car
 */
@Getter
@Builder
@ToString
public class CarSetupData {

    /**
     * Size of the car setup data in bytes
     */
    public static final int SIZE = 49;

    /**
     * Front wing aero
     */
    private final byte frontWing;

    /**
     * Rear wing aero
     */
    private final byte rearWing;

    /**
     * Differential adjustment on throttle (percentage)
     */
    private final byte onThrottle;

    /**
     * Differential adjustment off throttle (percentage)
     */
    private final byte offThrottle;

    /**
     * Front camber angle (suspension geometry)
     */
    private final float frontCamber;

    /**
     * Rear camber angle (suspension geometry)
     */
    private final float rearCamber;

    /**
     * Front toe angle (suspension geometry)
     */
    private final float frontToe;

    /**
     * Rear toe angle (suspension geometry)
     */
    private final float rearToe;

    /**
     * Front suspension
     */
    private final byte frontSuspension;

    /**
     * Rear suspension
     */
    private final byte rearSuspension;

    /**
     * Front anti-roll bar
     */
    private final byte frontAntiRollBar;

    /**
     * Rear anti-roll bar
     */
    private final byte rearAntiRollBar;

    /**
     * Front suspension height
     */
    private final byte frontSuspensionHeight;

    /**
     * Rear suspension height
     */
    private final byte rearSuspensionHeight;

    /**
     * Brake pressure (percentage)
     */
    private final byte brakePressure;

    /**
     * Brake bias (percentage)
     */
    private final byte brakeBias;

    /**
     * Rear left tyre pressure (PSI)
     */
    private final float rearLeftTyrePressure;

    /**
     * Rear right tyre pressure (PSI)
     */
    private final float rearRightTyrePressure;

    /**
     * Front left tyre pressure (PSI)
     */
    private final float frontLeftTyrePressure;

    /**
     * Front right tyre pressure (PSI)
     */
    private final float frontRightTyrePressure;

    /**
     * Ballast
     */
    private final byte ballast;

    /**
     * Fuel load
     */
    private final float fuelLoad;

    /**
     * Parse a byte array into a CarSetupData object
     *
     * @param data   byte array containing the data
     * @param offset starting position in the array
     * @return parsed CarSetupData
     */
    public static CarSetupData fromBytes(byte[] data, int offset) {
        return CarSetupData.builder()
                .frontWing(ByteUtils.toInt8(data, offset))
                .rearWing(ByteUtils.toInt8(data, offset + 1))
                .onThrottle(ByteUtils.toInt8(data, offset + 2))
                .offThrottle(ByteUtils.toInt8(data, offset + 3))
                .frontCamber(ByteUtils.toFloat(data, offset + 4))
                .rearCamber(ByteUtils.toFloat(data, offset + 8))
                .frontToe(ByteUtils.toFloat(data, offset + 12))
                .rearToe(ByteUtils.toFloat(data, offset + 16))
                .frontSuspension(ByteUtils.toInt8(data, offset + 20))
                .rearSuspension(ByteUtils.toInt8(data, offset + 21))
                .frontAntiRollBar(ByteUtils.toInt8(data, offset + 22))
                .rearAntiRollBar(ByteUtils.toInt8(data, offset + 23))
                .frontSuspensionHeight(ByteUtils.toInt8(data, offset + 24))
                .rearSuspensionHeight(ByteUtils.toInt8(data, offset + 25))
                .brakePressure(ByteUtils.toInt8(data, offset + 26))
                .brakeBias(ByteUtils.toInt8(data, offset + 27))
                .rearLeftTyrePressure(ByteUtils.toFloat(data, offset + 28))
                .rearRightTyrePressure(ByteUtils.toFloat(data, offset + 32))
                .frontLeftTyrePressure(ByteUtils.toFloat(data, offset + 36))
                .frontRightTyrePressure(ByteUtils.toFloat(data, offset + 40))
                .ballast(ByteUtils.toInt8(data, offset + 44))
                .fuelLoad(ByteUtils.toFloat(data, offset + 45))
                .build();
    }
}