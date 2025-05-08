package dev.prkprime.f1telemetry.f122.session;

import dev.prkprime.f1telemetry.f122.utils.ByteUtils;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Weather forecast sample data
 */
@Getter
@Builder
@ToString
public class WeatherForecastSample {

    /**
     * Size of the weather forecast sample data in bytes
     */
    public static final int SIZE = 8;

    /**
     * 0 = unknown, 1 = P1, 2 = P2, 3 = P3, 4 = Short P, 5 = Q1
     * 6 = Q2, 7 = Q3, 8 = Short Q, 9 = OSQ, 10 = R, 11 = R2
     * 12 = R3, 13 = Time Trial
     */
    private final SessionType sessionType;

    /**
     * Time in minutes the forecast is for
     */
    private final byte timeOffset;

    /**
     * Weather - 0 = clear, 1 = light cloud, 2 = overcast
     * 3 = light rain, 4 = heavy rain, 5 = storm
     */
    private final Weather weather;

    /**
     * Track temp. in degrees Celsius
     */
    private final byte trackTemperature;

    /**
     * Track temp. change – 0 = up, 1 = down, 2 = no change
     */
    private final byte trackTemperatureChange;

    /**
     * Air temp. in degrees Celsius
     */
    private final byte airTemperature;

    /**
     * Air temp. change – 0 = up, 1 = down, 2 = no change
     */
    private final byte airTemperatureChange;

    /**
     * Rain percentage (0-100)
     */
    private final byte rainPercentage;

    /**
     * Parse a byte array into a WeatherForecastSample object
     *
     * @param data   byte array containing the data
     * @param offset starting position in the array
     * @return parsed WeatherForecastSample
     */
    public static WeatherForecastSample fromBytes(byte[] data, int offset) {
        return WeatherForecastSample.builder()
                .sessionType(SessionType.fromId(ByteUtils.toInt8(data, offset)))
                .timeOffset(ByteUtils.toInt8(data, offset + 1))
                .weather(Weather.fromId(ByteUtils.toInt8(data, offset + 2)))
                .trackTemperature(ByteUtils.toInt8(data, offset + 3))
                .trackTemperatureChange(ByteUtils.toInt8(data, offset + 4))
                .airTemperature(ByteUtils.toInt8(data, offset + 5))
                .airTemperatureChange(ByteUtils.toInt8(data, offset + 6))
                .rainPercentage(ByteUtils.toInt8(data, offset + 7))
                .build();
    }
}