package dev.prkprime.f1telemetry.f122.cartelemetry;

import dev.prkprime.f1telemetry.f122.Packet;
import dev.prkprime.f1telemetry.f122.PacketHeader;
import dev.prkprime.f1telemetry.f122.utils.ByteUtils;
import lombok.Getter;
import lombok.ToString;

/**
 * Car Telemetry Packet
 * This packet details telemetry for all the cars in the race.
 */
@Getter
@ToString(callSuper = true)
public class CarTelemetryPacket extends Packet {

    /**
     * Car telemetry data for all cars
     * [0, 21]
     */
    private final CarTelemetryData[] carTelemetryData;

    /**
     * Index of MFD panel open - 255 = MFD closed
     * Single player, race – 0 = Car setup, 1 = Pits
     * 2 = Damage, 3 = Engine, 4 = Temperatures
     * May vary depending on game mode
     */
    private final MFDPanel mfdPanelIndex;

    /**
     * Secondary player's MFD panel - same values as above
     */
    private final MFDPanel mfdPanelIndexSecondaryPlayer;

    /**
     * Suggested gear for the player (1-8)
     * 0 if no gear suggested
     */
    private final byte suggestedGear;

    /**
     * Maximum number of cars
     */
    public static final int CAR_COUNT = 22;

    /**
     * Constructor
     *
     * @param header                       packet header
     * @param carTelemetryData             array of car telemetry data
     * @param mfdPanelIndex                MFD panel index
     * @param mfdPanelIndexSecondaryPlayer secondary player's MFD panel index
     * @param suggestedGear                suggested gear
     */
    public CarTelemetryPacket(PacketHeader header, CarTelemetryData[] carTelemetryData,
                              MFDPanel mfdPanelIndex, MFDPanel mfdPanelIndexSecondaryPlayer,
                              byte suggestedGear) {
        super(header);
        this.carTelemetryData = carTelemetryData;
        this.mfdPanelIndex = mfdPanelIndex;
        this.mfdPanelIndexSecondaryPlayer = mfdPanelIndexSecondaryPlayer;
        this.suggestedGear = suggestedGear;
    }

    /**
     * Parse a byte array into a CarTelemetryPacket
     *
     * @param data   byte array containing the packet data
     * @param header packet header
     * @return parsed CarTelemetryPacket
     */
    public static CarTelemetryPacket fromBytes(byte[] data, PacketHeader header) {
        int offset = PacketHeader.SIZE;

        CarTelemetryData[] carTelemetryData = new CarTelemetryData[CAR_COUNT];
        for (int i = 0; i < CAR_COUNT; i++) {
            carTelemetryData[i] = CarTelemetryData.fromBytes(data, offset);
            offset += CarTelemetryData.SIZE;
        }

        MFDPanel mfdPanelIndex = MFDPanel.fromId(ByteUtils.toInt8(data, offset));
        offset += 1;

        MFDPanel mfdPanelIndexSecondaryPlayer = MFDPanel.fromId(ByteUtils.toInt8(data, offset));
        offset += 1;

        byte suggestedGear = ByteUtils.toInt8(data, offset);

        return new CarTelemetryPacket(header, carTelemetryData, mfdPanelIndex,
                mfdPanelIndexSecondaryPlayer, suggestedGear);
    }
}