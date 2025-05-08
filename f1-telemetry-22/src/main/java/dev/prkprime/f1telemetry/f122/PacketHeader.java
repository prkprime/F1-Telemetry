package dev.prkprime.f1telemetry.f122;

import dev.prkprime.f1telemetry.f122.utils.ByteUtils;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Header for all F1 22 UDP packets
 */
@Getter
@Builder
@ToString
public class PacketHeader {

    /**
     * Size of the header in bytes
     */
    public static final int SIZE = 24;

    /**
     * 2022
     */
    private final int packetFormat;

    /**
     * Game major version - "X.00"
     */
    private final byte gameMajorVersion;

    /**
     * Game minor version - "1.XX"
     */
    private final byte gameMinorVersion;

    /**
     * Version of this packet type, all start from 1
     */
    private final byte packetVersion;

    /**
     * Identifier for the packet type
     */
    private final PacketId packetId;

    /**
     * Unique identifier for the session
     */
    private final long sessionUID;

    /**
     * Session timestamp
     */
    private final float sessionTime;

    /**
     * Identifier for the frame the data was retrieved on
     */
    private final long frameIdentifier;

    /**
     * Index of player's car in the array
     */
    private final byte playerCarIndex;

    /**
     * Index of secondary player's car in the array (splitscreen)
     * 255 if no second player
     */
    private final byte secondaryPlayerCarIndex;

    /**
     * Parse a byte array into a PacketHeader
     *
     * @param data   byte array containing the packet data
     * @param offset starting position in the array
     * @return parsed PacketHeader
     */
    public static PacketHeader fromBytes(byte[] data, int offset) {
        return PacketHeader.builder()
                .packetFormat(ByteUtils.toUInt16(data, offset))
                .gameMajorVersion(ByteUtils.toInt8(data, offset + 2))
                .gameMinorVersion(ByteUtils.toInt8(data, offset + 3))
                .packetVersion(ByteUtils.toInt8(data, offset + 4))
                .packetId(PacketId.fromId(ByteUtils.toInt8(data, offset + 5)))
                .sessionUID(ByteUtils.toUInt32(data, offset + 6))
                .sessionTime(ByteUtils.toFloat(data, offset + 10))
                .frameIdentifier(ByteUtils.toUInt32(data, offset + 14))
                .playerCarIndex(ByteUtils.toInt8(data, offset + 18))
                .secondaryPlayerCarIndex(ByteUtils.toInt8(data, offset + 19))
                .build();
    }
}
