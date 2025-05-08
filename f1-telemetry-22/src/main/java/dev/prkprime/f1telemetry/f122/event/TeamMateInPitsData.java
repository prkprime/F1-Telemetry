package dev.prkprime.f1telemetry.f122.event;

import dev.prkprime.f1telemetry.f122.utils.ByteUtils;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Team mate in pits event details
 */
@Getter
@Builder
@ToString
public class TeamMateInPitsData implements EventDetails {

    /**
     * Vehicle index of the team mate
     */
    private final byte vehicleIdx;

    @Override
    public EventCode getEventCode() {
        return EventCode.TEAM_MATE_IN_PITS;
    }

    /**
     * Parse a byte array into a TeamMateInPitsData object
     *
     * @param data   byte array containing the data
     * @param offset starting position in the array
     * @return parsed TeamMateInPitsData
     */
    public static TeamMateInPitsData fromBytes(byte[] data, int offset) {
        return TeamMateInPitsData.builder()
                .vehicleIdx(ByteUtils.toInt8(data, offset))
                .build();
    }
}