package dev.prkprime.f1telemetry.f122.cartelemetry;

import dev.prkprime.f1telemetry.f122.utils.ByteUtils;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Car telemetry data for a single car
 */
@Getter
@Builder
@ToString
public class CarTelemetryData {

    /**
     * Size of the car telemetry data in bytes
     */
    public static final int SIZE = 60;

    /**
     * Speed of car in kilometers per hour
     */
    private final int speed;

    /**
     * Amount of throttle applied (0.0 to 1.0)
     */
    private final float throttle;

    /**
     * Steering (-1.0 (full lock left) to 1.0 (full lock right))
     */
    private final float steer;

    /**
     * Amount of brake applied (0.0 to 1.0)
     */
    private final float brake;

    /**
     * Amount of clutch applied (0 to 100)
     */
    private final byte clutch;

    /**
     * Gear selected (1-8, N=0, R=-1)
     */
    private final byte gear;

    /**
     * Engine RPM
     */
    private final int engineRPM;

    /**
     * 0 = off, 1 = on
     */
    private final boolean drs;

    /**
     * Rev lights indicator (percentage)
     */
    private final byte revLightsPercent;

    /**
     * Rev lights (bit 0 = leftmost LED, bit 14 = rightmost LED)
     */
    private final int revLightsBitValue;

    /**
     * Brakes temperature (celsius) [RL, RR, FL, FR]
     */
    private final int[] brakesTemperature;

    /**
     * Tyres surface temperature (celsius) [RL, RR, FL, FR]
     */
    private final byte[] tyresSurfaceTemperature;

    /**
     * Tyres inner temperature (celsius) [RL, RR, FL, FR]
     */
    private final byte[] tyresInnerTemperature;

    /**
     * Engine temperature (celsius)
     */
    private final int engineTemperature;

    /**
     * Tyres pressure (PSI) [RL, RR, FL, FR]
     */
    private final float[] tyresPressure;

    /**
     * Driving surface type for each wheel [RL, RR, FL, FR]
     */
    private final SurfaceType[] surfaceType;

    /**
     * Parse a byte array into a CarTelemetryData object
     *
     * @param data   byte array containing the data
     * @param offset starting position in the array
     * @return parsed CarTelemetryData
     */
    public static CarTelemetryData fromBytes(byte[] data, int offset) {
        int speed = ByteUtils.toUInt16(data, offset);
        offset += 2;

        float throttle = ByteUtils.toFloat(data, offset);
        offset += 4;

        float steer = ByteUtils.toFloat(data, offset);
        offset += 4;

        float brake = ByteUtils.toFloat(data, offset);
        offset += 4;

        byte clutch = ByteUtils.toInt8(data, offset);
        offset += 1;

        byte gear = ByteUtils.toInt8(data, offset);
        offset += 1;

        int engineRPM = ByteUtils.toUInt16(data, offset);
        offset += 2;

        boolean drs = ByteUtils.toInt8(data, offset) == 1;
        offset += 1;

        byte revLightsPercent = ByteUtils.toInt8(data, offset);
        offset += 1;

        int revLightsBitValue = ByteUtils.toUInt16(data, offset);
        offset += 2;

        // Brakes temperature
        int[] brakesTemperature = new int[4];
        for (int i = 0; i < 4; i++) {
            brakesTemperature[i] = ByteUtils.toUInt16(data, offset);
            offset += 2;
        }

        // Tyres surface temperature
        byte[] tyresSurfaceTemperature = new byte[4];
        for (int i = 0; i < 4; i++) {
            tyresSurfaceTemperature[i] = ByteUtils.toInt8(data, offset);
            offset += 1;
        }

        // Tyres inner temperature
        byte[] tyresInnerTemperature = new byte[4];
        for (int i = 0; i < 4; i++) {
            tyresInnerTemperature[i] = ByteUtils.toInt8(data, offset);
            offset += 1;
        }

        int engineTemperature = ByteUtils.toUInt16(data, offset);
        offset += 2;

        // Tyres pressure
        float[] tyresPressure = new float[4];
        for (int i = 0; i < 4; i++) {
            tyresPressure[i] = ByteUtils.toFloat(data, offset);
            offset += 4;
        }

        // Surface type
        SurfaceType[] surfaceType = new SurfaceType[4];
        for (int i = 0; i < 4; i++) {
            surfaceType[i] = SurfaceType.fromId(ByteUtils.toInt8(data, offset));
            offset += 1;
        }

        return CarTelemetryData.builder()
                .speed(speed)
                .throttle(throttle)
                .steer(steer)
                .brake(brake)
                .clutch(clutch)
                .gear(gear)
                .engineRPM(engineRPM)
                .drs(drs)
                .revLightsPercent(revLightsPercent)
                .revLightsBitValue(revLightsBitValue)
                .brakesTemperature(brakesTemperature)
                .tyresSurfaceTemperature(tyresSurfaceTemperature)
                .tyresInnerTemperature(tyresInnerTemperature)
                .engineTemperature(engineTemperature)
                .tyresPressure(tyresPressure)
                .surfaceType(surfaceType)
                .build();
    }
}