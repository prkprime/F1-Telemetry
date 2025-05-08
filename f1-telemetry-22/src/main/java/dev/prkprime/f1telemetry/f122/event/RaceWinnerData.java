package dev.prkprime.f1telemetry.f122.event;

import dev.prkprime.f1telemetry.f122.utils.ByteUtils;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Race winner event details
 */
@Getter
@Builder
@ToString
public class RaceWinnerData implements EventDetails {

    /**
     * Vehicle index of the race winner
     */
    private final byte vehicleIdx;

    @Override
    public EventCode getEventCode() {
        return EventCode.RACE_WINNER;
    }

    /**
     * Parse a byte array into a RaceWinnerData object
     *
     * @param data   byte array containing the data
     * @param offset starting position in the array
     * @return parsed RaceWinnerData
     */
    public static RaceWinnerData fromBytes(byte[] data, int offset) {
        return RaceWinnerData.builder()
                .vehicleIdx(ByteUtils.toInt8(data, offset))
                .build();
    }
}