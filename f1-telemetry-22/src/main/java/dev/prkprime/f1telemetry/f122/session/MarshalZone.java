package dev.prkprime.f1telemetry.f122.session;

import dev.prkprime.f1telemetry.f122.utils.ByteUtils;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Marshal zone data
 */
@Getter
@Builder
@ToString
public class MarshalZone {
    /**
     * Size of the marshal zone data in bytes
     */
    public static final int SIZE = 5;

    /**
     * Fraction (0..1) of way through the lap the marshal zone starts
     */
    private final float zoneStart;

    /**
     * -1 = invalid/unknown, 0 = none, 1 = green, 2 = blue, 3 = yellow, 4 = red
     */
    private final int zoneFlag;

    /**
     * Parse a byte array into a MarshalZone object
     *
     * @param data   byte array containing the data
     * @param offset starting position in the array
     * @return parsed MarshalZone
     */
    public static MarshalZone fromBytes(byte[] data, int offset) {
        return MarshalZone.builder()
                .zoneStart(ByteUtils.toFloat(data, offset))
                .zoneFlag(ByteUtils.toInt8(data, offset + 4))
                .build();
    }
}