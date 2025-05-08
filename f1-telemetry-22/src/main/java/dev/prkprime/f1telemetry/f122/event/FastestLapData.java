package dev.prkprime.f1telemetry.f122.event;

import dev.prkprime.f1telemetry.f122.utils.ByteUtils;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Fastest lap event details
 */
@Getter
@Builder
@ToString
public class FastestLapData implements EventDetails {

    /**
     * Vehicle index of the car achieving the fastest lap
     */
    private final byte vehicleIdx;

    /**
     * Lap time in seconds
     */
    private final float lapTime;

    @Override
    public EventCode getEventCode() {
        return EventCode.FASTEST_LAP;
    }

    /**
     * Parse a byte array into a FastestLapData object
     *
     * @param data   byte array containing the data
     * @param offset starting position in the array
     * @return parsed FastestLapData
     */
    public static FastestLapData fromBytes(byte[] data, int offset) {
        return FastestLapData.builder()
                .vehicleIdx(ByteUtils.toInt8(data, offset))
                .lapTime(ByteUtils.toFloat(data, offset + 1))
                .build();
    }
}