package dev.prkprime.f1telemetry.f122.participants;

import dev.prkprime.f1telemetry.f122.Packet;
import dev.prkprime.f1telemetry.f122.PacketHeader;
import dev.prkprime.f1telemetry.f122.utils.ByteUtils;
import lombok.Getter;
import lombok.ToString;

/**
 * Participants Packet
 * This packet gives details about all the participants in the session.
 */
@Getter
@ToString(callSuper = true)
public class ParticipantsPacket extends Packet {

    /**
     * Number of active cars in the data
     */
    private final byte numActiveCars;

    /**
     * Data for all participants
     * [0, 21]
     */
    private final ParticipantData[] participants;

    /**
     * Maximum number of participants
     */
    public static final int MAX_PARTICIPANTS = 22;

    /**
     * Constructor
     *
     * @param header        packet header
     * @param numActiveCars number of active cars
     * @param participants  array of participant data
     */
    public ParticipantsPacket(PacketHeader header, byte numActiveCars, ParticipantData[] participants) {
        super(header);
        this.numActiveCars = numActiveCars;
        this.participants = participants;
    }

    /**
     * Parse a byte array into a ParticipantsPacket
     *
     * @param data   byte array containing the packet data
     * @param header packet header
     * @return parsed ParticipantsPacket
     */
    public static ParticipantsPacket fromBytes(byte[] data, PacketHeader header) {
        int offset = PacketHeader.SIZE;

        byte numActiveCars = ByteUtils.toInt8(data, offset);
        offset += 1;

        ParticipantData[] participants = new ParticipantData[MAX_PARTICIPANTS];
        for (int i = 0; i < MAX_PARTICIPANTS; i++) {
            participants[i] = ParticipantData.fromBytes(data, offset);
            offset += ParticipantData.SIZE;
        }

        return new ParticipantsPacket(header, numActiveCars, participants);
    }
}