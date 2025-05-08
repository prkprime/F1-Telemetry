package dev.prkprime.f1telemetry.f122.event;

import dev.prkprime.f1telemetry.f122.utils.ByteUtils;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Retirement event details
 */
@Getter
@Builder
@ToString
public class RetirementData implements EventDetails {

    /**
     * Vehicle index of the car retiring
     */
    private final byte vehicleIdx;

    @Override
    public EventCode getEventCode() {
        return EventCode.RETIREMENT;
    }

    /**
     * Parse a byte array into a RetirementData object
     *
     * @param data   byte array containing the data
     * @param offset starting position in the array
     * @return parsed RetirementData
     */
    public static RetirementData fromBytes(byte[] data, int offset) {
        return RetirementData.builder()
                .vehicleIdx(ByteUtils.toInt8(data, offset))
                .build();
    }
}