package dev.prkprime.f1telemetry.f122;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Base class for all F1 22 UDP packets
 */
@Getter
@ToString
@RequiredArgsConstructor
public abstract class Packet {

    /**
     * Header common to all packets
     */
    private final PacketHeader header;

    /**
     * Parse a byte array into a specific packet type
     *
     * @param data byte array containing the packet data
     * @return parsed packet
     */
    public static Packet fromBytes(byte[] data) {
        PacketHeader header = PacketHeader.fromBytes(data, 0);

        return switch (header.getPacketId()) {
            case MOTION -> dev.prkprime.f1telemetry.f122.motion.MotionPacket.fromBytes(data, header);
            case SESSION -> dev.prkprime.f1telemetry.f122.session.SessionPacket.fromBytes(data, header);
            case LAP_DATA -> dev.prkprime.f1telemetry.f122.lapdata.LapDataPacket.fromBytes(data, header);
            case EVENT -> dev.prkprime.f1telemetry.f122.event.EventPacket.fromBytes(data, header);
            case PARTICIPANTS -> dev.prkprime.f1telemetry.f122.participants.ParticipantsPacket.fromBytes(data, header);
            case CAR_SETUPS -> dev.prkprime.f1telemetry.f122.carsetups.CarSetupsPacket.fromBytes(data, header);
            case CAR_TELEMETRY -> dev.prkprime.f1telemetry.f122.cartelemetry.CarTelemetryPacket.fromBytes(data, header);
            case CAR_STATUS -> null;
            case FINAL_CLASSIFICATION -> null;
            case LOBBY_INFO -> null;
            case CAR_DAMAGE -> null;
            case SESSION_HISTORY -> null;
        };
    }
}
