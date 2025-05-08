package dev.prkprime.f1telemetry.f122.event;

import dev.prkprime.f1telemetry.f122.utils.ByteUtils;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Speed trap triggered event details
 */
@Getter
@Builder
@ToString
public class SpeedTrapData implements EventDetails {

    /**
     * Vehicle index of the vehicle triggering speed trap
     */
    private final byte vehicleIdx;

    /**
     * Top speed achieved in kilometres per hour
     */
    private final float speed;

    /**
     * Overall fastest in session (1 = yes, 0 = no)
     */
    private final boolean isOverallFastestInSession;

    /**
     * Fastest in driver's personal session (1 = yes, 0 = no)
     */
    private final boolean isDriverFastestInSession;

    @Override
    public EventCode getEventCode() {
        return EventCode.SPEED_TRAP_TRIGGERED;
    }

    /**
     * Parse a byte array into a SpeedTrapData object
     *
     * @param data   byte array containing the data
     * @param offset starting position in the array
     * @return parsed SpeedTrapData
     */
    public static SpeedTrapData fromBytes(byte[] data, int offset) {
        return SpeedTrapData.builder()
                .vehicleIdx(ByteUtils.toInt8(data, offset))
                .speed(ByteUtils.toFloat(data, offset + 1))
                .isOverallFastestInSession(ByteUtils.toInt8(data, offset + 5) == 1)
                .isDriverFastestInSession(ByteUtils.toInt8(data, offset + 6) == 1)
                .build();
    }
}