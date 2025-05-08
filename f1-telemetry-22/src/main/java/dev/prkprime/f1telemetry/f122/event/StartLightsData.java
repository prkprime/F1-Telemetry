package dev.prkprime.f1telemetry.f122.event;

import dev.prkprime.f1telemetry.f122.utils.ByteUtils;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Start lights event details
 */
@Getter
@Builder
@ToString
public class StartLightsData implements EventDetails {

    /**
     * Number of lights showing
     */
    private final byte numLights;

    @Override
    public EventCode getEventCode() {
        return EventCode.START_LIGHTS;
    }

    /**
     * Parse a byte array into a StartLightsData object
     *
     * @param data   byte array containing the data
     * @param offset starting position in the array
     * @return parsed StartLightsData
     */
    public static StartLightsData fromBytes(byte[] data, int offset) {
        return StartLightsData.builder()
                .numLights(ByteUtils.toInt8(data, offset))
                .build();
    }
}