package dev.prkprime.f1telemetry.f122.event;

import dev.prkprime.f1telemetry.f122.utils.ByteUtils;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Flashback event details
 */
@Getter
@Builder
@ToString
public class FlashbackData implements EventDetails {

    /**
     * Frame identifier flashed back to
     */
    private final long flashbackFrameIdentifier;

    /**
     * Session time flashed back to
     */
    private final float flashbackSessionTime;

    @Override
    public EventCode getEventCode() {
        return EventCode.FLASHBACK;
    }

    /**
     * Parse a byte array into a FlashbackData object
     *
     * @param data   byte array containing the data
     * @param offset starting position in the array
     * @return parsed FlashbackData
     */
    public static FlashbackData fromBytes(byte[] data, int offset) {
        return FlashbackData.builder()
                .flashbackFrameIdentifier(ByteUtils.toUInt32(data, offset))
                .flashbackSessionTime(ByteUtils.toFloat(data, offset + 4))
                .build();
    }
}