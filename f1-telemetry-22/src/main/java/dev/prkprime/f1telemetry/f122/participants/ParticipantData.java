package dev.prkprime.f1telemetry.f122.participants;

import dev.prkprime.f1telemetry.f122.utils.ByteUtils;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Participant data for a single driver
 */
@Getter
@Builder
@ToString
public class ParticipantData {

    /**
     * Size of the participant data in bytes
     */
    public static final int SIZE = 56;

    /**
     * Whether the vehicle is AI (1) or Human (0) controlled
     */
    private final boolean aiControlled;

    /**
     * Driver ID
     */
    private final DriverId driverId;

    /**
     * Network ID – unique identifier for network players
     */
    private final byte networkId;

    /**
     * Team ID
     */
    private final TeamId teamId;

    /**
     * My team flag – 1 = My Team, 0 = otherwise
     */
    private final boolean myTeam;

    /**
     * Race number of the car
     */
    private final byte raceNumber;

    /**
     * Nationality of the driver
     */
    private final Nationality nationality;

    /**
     * Name of participant in UTF-8 format – null terminated
     * Will be truncated with ... (U+2026) if too long
     */
    private final String name;

    /**
     * The player's UDP setting, 0 = restricted, 1 = public
     */
    private final boolean telemetryEnabled;

    /**
     * Parse a byte array into a ParticipantData object
     *
     * @param data   byte array containing the data
     * @param offset starting position in the array
     * @return parsed ParticipantData
     */
    public static ParticipantData fromBytes(byte[] data, int offset) {
        boolean aiControlled = ByteUtils.toInt8(data, offset) == 1;
        offset += 1;

        DriverId driverId = DriverId.fromId(ByteUtils.toInt8(data, offset));
        offset += 1;

        byte networkId = ByteUtils.toInt8(data, offset);
        offset += 1;

        TeamId teamId = TeamId.fromId(ByteUtils.toInt8(data, offset));
        offset += 1;

        boolean myTeam = ByteUtils.toInt8(data, offset) == 1;
        offset += 1;

        byte raceNumber = ByteUtils.toInt8(data, offset);
        offset += 1;

        Nationality nationality = Nationality.fromId(ByteUtils.toInt8(data, offset));
        offset += 1;

        String name = ByteUtils.toString(data, offset, 48);
        offset += 48;

        boolean telemetryEnabled = ByteUtils.toInt8(data, offset) == 1;

        return ParticipantData.builder()
                .aiControlled(aiControlled)
                .driverId(driverId)
                .networkId(networkId)
                .teamId(teamId)
                .myTeam(myTeam)
                .raceNumber(raceNumber)
                .nationality(nationality)
                .name(name)
                .telemetryEnabled(telemetryEnabled)
                .build();
    }
}