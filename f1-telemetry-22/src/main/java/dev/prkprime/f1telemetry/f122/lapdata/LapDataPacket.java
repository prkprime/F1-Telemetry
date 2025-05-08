package dev.prkprime.f1telemetry.f122.lapdata;

import dev.prkprime.f1telemetry.f122.Packet;
import dev.prkprime.f1telemetry.f122.PacketHeader;
import lombok.Getter;
import lombok.ToString;

/**
 * Lap Data Packet
 * The lap data packet gives details of all the cars in the session.
 */
@Getter
@ToString(callSuper = true)
public class LapDataPacket extends Packet {

    /**
     * Lap data for all cars on track
     * [0, 21]
     */
    private final LapData[] lapData;

    /**
     * Maximum number of cars
     */
    public static final int CAR_COUNT = 22;

    /**
     * Constructor
     *
     * @param header  packet header
     * @param lapData array of lap data for all cars
     */
    public LapDataPacket(PacketHeader header, LapData[] lapData) {
        super(header);
        this.lapData = lapData;
    }

    /**
     * Parse a byte array into a LapDataPacket
     *
     * @param data   byte array containing the packet data
     * @param header packet header
     * @return parsed LapDataPacket
     */
    public static LapDataPacket fromBytes(byte[] data, PacketHeader header) {
        int offset = PacketHeader.SIZE;

        // Parse lap data for all cars
        LapData[] lapData = new LapData[CAR_COUNT];
        for (int i = 0; i < CAR_COUNT; i++) {
            lapData[i] = LapData.fromBytes(data, offset);
            offset += LapData.SIZE;
        }

        return new LapDataPacket(header, lapData);
    }
}