package dev.prkprime.f1telemetry.f122.event;

import dev.prkprime.f1telemetry.f122.Packet;
import dev.prkprime.f1telemetry.f122.PacketHeader;
import dev.prkprime.f1telemetry.f122.utils.ByteUtils;
import lombok.Getter;
import lombok.ToString;

/**
 * Event Packet
 * This packet gives details of events that happen during the course of a session.
 */
@Getter
@ToString(callSuper = true)
public class EventPacket extends Packet {

    /**
     * Event string code, see {@link EventCode}
     */
    private final EventCode eventCode;

    /**
     * Event details - depends on the event code
     */
    private final EventDetails eventDetails;

    /**
     * Constructor
     *
     * @param header       packet header
     * @param eventCode    event code
     * @param eventDetails event details
     */
    public EventPacket(PacketHeader header, EventCode eventCode, EventDetails eventDetails) {
        super(header);
        this.eventCode = eventCode;
        this.eventDetails = eventDetails;
    }

    /**
     * Parse a byte array into an EventPacket
     *
     * @param data   byte array containing the packet data
     * @param header packet header
     * @return parsed EventPacket
     */
    public static EventPacket fromBytes(byte[] data, PacketHeader header) {
        int offset = PacketHeader.SIZE;

        // Event string code is 4 bytes
        String eventCodeStr = ByteUtils.toString(data, offset, 4);
        EventCode eventCode = EventCode.fromCode(eventCodeStr);
        offset += 4;

        // Parse event details based on event code
        EventDetails eventDetails = switch (eventCode) {
            case FASTEST_LAP -> FastestLapData.fromBytes(data, offset);
            case RETIREMENT -> RetirementData.fromBytes(data, offset);
            case TEAM_MATE_IN_PITS -> TeamMateInPitsData.fromBytes(data, offset);
            case RACE_WINNER -> RaceWinnerData.fromBytes(data, offset);
            case PENALTY_ISSUED -> PenaltyData.fromBytes(data, offset);
            case SPEED_TRAP_TRIGGERED -> SpeedTrapData.fromBytes(data, offset);
            case START_LIGHTS -> StartLightsData.fromBytes(data, offset);
            case BUTTON_STATUS -> ButtonStatusData.fromBytes(data, offset);
            case FLASHBACK -> FlashbackData.fromBytes(data, offset);
            // For events without additional data
            default -> new EmptyEventDetails(eventCode);
        };

        return new EventPacket(header, eventCode, eventDetails);
    }
}