package dev.prkprime.f1telemetry.f122;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum for F1 22 packet types
 */
@Getter
@RequiredArgsConstructor
public enum PacketId {

    MOTION(0),
    SESSION(1),
    LAP_DATA(2),
    EVENT(3),
    PARTICIPANTS(4),
    CAR_SETUPS(5),
    CAR_TELEMETRY(6),
    CAR_STATUS(7),
    FINAL_CLASSIFICATION(8),
    LOBBY_INFO(9),
    CAR_DAMAGE(10),
    SESSION_HISTORY(11);

    private final int id;

    /**
     * Get a PacketId from its numeric value
     *
     * @param id numeric identifier
     * @return corresponding PacketId
     * @throws IllegalArgumentException if id is not valid
     */
    public static PacketId fromId(byte id) {
        for (PacketId packetId : values()) {
            if (packetId.id == id) {
                return packetId;
            }
        }
        throw new IllegalArgumentException("Invalid packet ID: " + id);
    }
}