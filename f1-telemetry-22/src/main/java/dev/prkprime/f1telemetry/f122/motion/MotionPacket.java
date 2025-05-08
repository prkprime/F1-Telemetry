package dev.prkprime.f1telemetry.f122.motion;

import dev.prkprime.f1telemetry.f122.Packet;
import dev.prkprime.f1telemetry.f122.PacketHeader;
import lombok.Getter;
import lombok.ToString;

/**
 * Motion packet
 * The motion packet gives physics data for all the cars being driven.
 * There is additional data for the car being driven with the goal of being able to drive a motion platform setup.
 */
@Getter
@ToString(callSuper = true)
public class MotionPacket extends Packet {

    /**
     * Data for all cars on track
     * [0, 21]
     */
    private final CarMotionData[] carMotionData;

    /**
     * Additional data for player's car only
     */
    private final PlayerCarData playerCarData;

    /**
     * Maximum number of cars
     */
    public static final int CAR_COUNT = 22;

    /**
     * Constructor
     *
     * @param header        packet header
     * @param carMotionData array of car motion data
     * @param playerCarData player car data
     */
    public MotionPacket(PacketHeader header, CarMotionData[] carMotionData, PlayerCarData playerCarData) {
        super(header);
        this.carMotionData = carMotionData;
        this.playerCarData = playerCarData;
    }

    /**
     * Parse a byte array into a MotionPacket
     *
     * @param data   byte array containing the packet data
     * @param header packet header
     * @return parsed MotionPacket
     */
    public static MotionPacket fromBytes(byte[] data, PacketHeader header) {
        int offset = PacketHeader.SIZE;

        // Parse car motion data for all cars
        CarMotionData[] carMotionData = new CarMotionData[CAR_COUNT];
        for (int i = 0; i < CAR_COUNT; i++) {
            carMotionData[i] = CarMotionData.fromBytes(data, offset);
            offset += CarMotionData.SIZE;
        }

        // Parse player car data
        PlayerCarData playerCarData = PlayerCarData.fromBytes(data, offset);

        return new MotionPacket(header, carMotionData, playerCarData);
    }
}