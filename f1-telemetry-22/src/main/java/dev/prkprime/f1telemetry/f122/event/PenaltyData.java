package dev.prkprime.f1telemetry.f122.event;

import dev.prkprime.f1telemetry.f122.utils.ByteUtils;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Penalty issued event details
 */
@Getter
@Builder
@ToString
public class PenaltyData implements EventDetails {

    /**
     * Penalty type
     */
    private final PenaltyType penaltyType;

    /**
     * Infringement type
     */
    private final InfringementType infringementType;

    /**
     * Vehicle index of the car the penalty is applied to
     */
    private final byte vehicleIdx;

    /**
     * Vehicle index of the other car involved
     */
    private final byte otherVehicleIdx;

    /**
     * Time gained, or time spent doing action in seconds
     */
    private final byte time;

    /**
     * Lap the penalty occurred on
     */
    private final byte lapNum;

    /**
     * Number of places gained by this
     */
    private final byte placesGained;

    @Override
    public EventCode getEventCode() {
        return EventCode.PENALTY_ISSUED;
    }

    /**
     * Parse a byte array into a PenaltyData object
     *
     * @param data   byte array containing the data
     * @param offset starting position in the array
     * @return parsed PenaltyData
     */
    public static PenaltyData fromBytes(byte[] data, int offset) {
        return PenaltyData.builder()
                .penaltyType(PenaltyType.fromId(ByteUtils.toInt8(data, offset)))
                .infringementType(InfringementType.fromId(ByteUtils.toInt8(data, offset + 1)))
                .vehicleIdx(ByteUtils.toInt8(data, offset + 2))
                .otherVehicleIdx(ByteUtils.toInt8(data, offset + 3))
                .time(ByteUtils.toInt8(data, offset + 4))
                .lapNum(ByteUtils.toInt8(data, offset + 5))
                .placesGained(ByteUtils.toInt8(data, offset + 6))
                .build();
    }
}