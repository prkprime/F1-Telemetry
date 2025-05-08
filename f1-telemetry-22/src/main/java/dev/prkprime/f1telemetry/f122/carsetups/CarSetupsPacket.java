package dev.prkprime.f1telemetry.f122.carsetups;

import dev.prkprime.f1telemetry.f122.Packet;
import dev.prkprime.f1telemetry.f122.PacketHeader;
import lombok.Getter;
import lombok.ToString;

/**
 * Car Setups Packet
 * This packet details the car setups for each vehicle in the session.
 */
@Getter
@ToString(callSuper = true)
public class CarSetupsPacket extends Packet {

    /**
     * Car setup data for all cars
     * [0, 21]
     */
    private final CarSetupData[] carSetups;

    /**
     * Maximum number of cars
     */
    public static final int CAR_COUNT = 22;

    /**
     * Constructor
     *
     * @param header    packet header
     * @param carSetups array of car setup data
     */
    public CarSetupsPacket(PacketHeader header, CarSetupData[] carSetups) {
        super(header);
        this.carSetups = carSetups;
    }

    /**
     * Parse a byte array into a CarSetupsPacket
     *
     * @param data   byte array containing the packet data
     * @param header packet header
     * @return parsed CarSetupsPacket
     */
    public static CarSetupsPacket fromBytes(byte[] data, PacketHeader header) {
        int offset = PacketHeader.SIZE;

        CarSetupData[] carSetups = new CarSetupData[CAR_COUNT];
        for (int i = 0; i < CAR_COUNT; i++) {
            carSetups[i] = CarSetupData.fromBytes(data, offset);
            offset += CarSetupData.SIZE;
        }

        return new CarSetupsPacket(header, carSetups);
    }
}