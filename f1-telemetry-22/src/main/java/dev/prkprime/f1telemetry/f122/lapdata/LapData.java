package dev.prkprime.f1telemetry.f122.lapdata;

import dev.prkprime.f1telemetry.f122.utils.ByteUtils;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Lap data for a single car
 */
@Getter
@Builder
@ToString
public class LapData {

    /**
     * Size of the lap data in bytes
     */
    public static final int SIZE = 43;

    /**
     * Last lap time in milliseconds
     */
    private final long lastLapTimeInMS;

    /**
     * Current time around the lap in milliseconds
     */
    private final long currentLapTimeInMS;

    /**
     * Sector 1 time in milliseconds
     */
    private final int sector1TimeInMS;

    /**
     * Sector 2 time in milliseconds
     */
    private final int sector2TimeInMS;

    /**
     * Distance vehicle is around current lap in meters – could be negative if line hasn't been crossed yet
     */
    private final float lapDistance;

    /**
     * Total distance travelled in session in meters – could be negative if line hasn't been crossed yet
     */
    private final float totalDistance;

    /**
     * Delta in seconds for safety car
     */
    private final float safetyCarDelta;

    /**
     * Car race position
     */
    private final int carPosition;

    /**
     * Current lap number
     */
    private final int currentLapNum;

    /**
     * 0 = none, 1 = pitting, 2 = in pit area
     */
    private final PitStatus pitStatus;

    /**
     * Number of pit stops taken in this race
     */
    private final int numPitStops;

    /**
     * 0 = sector1, 1 = sector2, 2 = sector3
     */
    private final Sector sector;

    /**
     * Current lap invalid - 0 = valid, 1 = invalid
     */
    private final boolean currentLapInvalid;

    /**
     * Accumulated time penalties in seconds to be added
     */
    private final int penalties;

    /**
     * Accumulated number of warnings issued
     */
    private final int warnings;

    /**
     * Num drive through penalties left to serve
     */
    private final int numUnservedDriveThroughPens;

    /**
     * Num stop go penalties left to serve
     */
    private final int numUnservedStopGoPens;

    /**
     * Grid position the vehicle started the race in
     */
    private final int gridPosition;

    /**
     * Status of driver - 0 = in garage, 1 = flying lap, 2 = in lap, 3 = out lap, 4 = on track
     */
    private final DriverStatus driverStatus;

    /**
     * Result status - 0 = invalid, 1 = inactive, 2 = active, 3 = finished, 4 = did not finish, 5 = disqualified
     * 6 = not classified, 7 = retired
     */
    private final ResultStatus resultStatus;

    /**
     * Pit lane timing, 0 = inactive, 1 = active
     */
    private final boolean pitLaneTimerActive;

    /**
     * If active, the current time spent in the pit lane in ms
     */
    private final int pitLaneTimeInLaneInMS;

    /**
     * Time of the actual pit stop in ms
     */
    private final int pitStopTimerInMS;

    /**
     * Whether the car should serve a penalty at this pit stop
     */
    private final boolean pitStopShouldServePen;

    /**
     * Parse a byte array into a LapData object
     *
     * @param data   byte array containing the data
     * @param offset starting position in the array
     * @return parsed LapData
     */
    public static LapData fromBytes(byte[] data, int offset) {
        return LapData.builder()
                .lastLapTimeInMS(ByteUtils.toUInt32(data, offset))
                .currentLapTimeInMS(ByteUtils.toUInt32(data, offset + 4))
                .sector1TimeInMS(ByteUtils.toUInt16(data, offset + 8))
                .sector2TimeInMS(ByteUtils.toUInt16(data, offset + 10))
                .lapDistance(ByteUtils.toFloat(data, offset + 12))
                .totalDistance(ByteUtils.toFloat(data, offset + 16))
                .safetyCarDelta(ByteUtils.toFloat(data, offset + 20))
                .carPosition(ByteUtils.toInt8(data, offset + 24))
                .currentLapNum(ByteUtils.toInt8(data, offset + 25))
                .pitStatus(PitStatus.fromId(ByteUtils.toInt8(data, offset + 26)))
                .numPitStops(ByteUtils.toInt8(data, offset + 27))
                .sector(Sector.fromId(ByteUtils.toInt8(data, offset + 28)))
                .currentLapInvalid(ByteUtils.toInt8(data, offset + 29) == 1)
                .penalties(ByteUtils.toInt8(data, offset + 30))
                .warnings(ByteUtils.toInt8(data, offset + 31))
                .numUnservedDriveThroughPens(ByteUtils.toInt8(data, offset + 32))
                .numUnservedStopGoPens(ByteUtils.toInt8(data, offset + 33))
                .gridPosition(ByteUtils.toInt8(data, offset + 34))
                .driverStatus(DriverStatus.fromId(ByteUtils.toInt8(data, offset + 35)))
                .resultStatus(ResultStatus.fromId(ByteUtils.toInt8(data, offset + 36)))
                .pitLaneTimerActive(ByteUtils.toInt8(data, offset + 37) == 1)
                .pitLaneTimeInLaneInMS(ByteUtils.toUInt16(data, offset + 38))
                .pitStopTimerInMS(ByteUtils.toUInt16(data, offset + 40))
                .pitStopShouldServePen(ByteUtils.toInt8(data, offset + 42) == 1)
                .build();
    }
}
