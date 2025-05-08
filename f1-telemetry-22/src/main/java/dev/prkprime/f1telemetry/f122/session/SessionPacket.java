package dev.prkprime.f1telemetry.f122.session;

import dev.prkprime.f1telemetry.f122.Packet;
import dev.prkprime.f1telemetry.f122.PacketHeader;
import dev.prkprime.f1telemetry.f122.utils.ByteUtils;
import lombok.Getter;
import lombok.ToString;

/**
 * Session packet
 * The session packet includes details about the current session in progress.
 */
@Getter
@ToString(callSuper = true)
public class SessionPacket extends Packet {

    /**
     * Weather - 0 = clear, 1 = light cloud, 2 = overcast
     * 3 = light rain, 4 = heavy rain, 5 = storm
     */
    private final Weather weather;

    /**
     * Track temp. in degrees Celsius
     */
    private final byte trackTemperature;

    /**
     * Air temp. in degrees Celsius
     */
    private final byte airTemperature;

    /**
     * Total number of laps in this race
     */
    private final byte totalLaps;

    /**
     * Track length in meters
     */
    private final int trackLength;

    /**
     * 0 = unknown, 1 = P1, 2 = P2, 3 = P3, 4 = Short P
     * 5 = Q1, 6 = Q2, 7 = Q3, 8 = Short Q, 9 = OSQ
     * 10 = R, 11 = R2, 12 = R3, 13 = Time Trial
     */
    private final SessionType sessionType;

    /**
     * -1 for unknown, 0-21 for tracks, see appendix
     */
    private final TrackId trackId;

    /**
     * Formula, 0 = F1 Modern, 1 = F1 Classic, 2 = F2,
     * 3 = F1 Generic
     */
    private final Formula formula;

    /**
     * Time left in session in seconds
     */
    private final int sessionTimeLeft;

    /**
     * Session duration in seconds
     */
    private final int sessionDuration;

    /**
     * Pit speed limit in kilometers per hour
     */
    private final byte pitSpeedLimit;

    /**
     * Whether the game is paused
     */
    private final boolean gamePaused;

    /**
     * Whether the player is spectating
     */
    private final boolean isSpectating;

    /**
     * Index of car being spectated
     */
    private final byte spectatorCarIndex;

    /**
     * SLI Pro support, 0 = inactive, 1 = active
     */
    private final boolean sliProNativeSupport;

    /**
     * Number of marshal zones to follow
     */
    private final byte numMarshalZones;

    /**
     * List of marshal zones – max 21
     */
    private final MarshalZone[] marshalZones;

    /**
     * 0 = no safety car, 1 = full safety car
     * 2 = virtual safety car, 3 = formation lap
     */
    private final SafetyCarStatus safetyCarStatus;

    /**
     * 0 = offline, 1 = online
     */
    private final boolean networkGame;

    /**
     * Number of weather forecast samples to follow
     */
    private final byte numWeatherForecastSamples;

    /**
     * Array of weather forecast samples
     */
    private final WeatherForecastSample[] weatherForecastSamples;

    /**
     * Maximum number of marshal zones
     */
    public static final int MAX_MARSHAL_ZONES = 21;

    /**
     * Maximum number of weather forecast samples
     */
    public static final int MAX_WEATHER_FORECAST_SAMPLES = 56;

    /**
     * Constructor
     */
    public SessionPacket(PacketHeader header, Weather weather, byte trackTemperature, byte airTemperature,
                         byte totalLaps, int trackLength, SessionType sessionType, TrackId trackId,
                         Formula formula, int sessionTimeLeft, int sessionDuration, byte pitSpeedLimit,
                         boolean gamePaused, boolean isSpectating, byte spectatorCarIndex,
                         boolean sliProNativeSupport, byte numMarshalZones, MarshalZone[] marshalZones,
                         SafetyCarStatus safetyCarStatus, boolean networkGame,
                         byte numWeatherForecastSamples, WeatherForecastSample[] weatherForecastSamples) {
        super(header);
        this.weather = weather;
        this.trackTemperature = trackTemperature;
        this.airTemperature = airTemperature;
        this.totalLaps = totalLaps;
        this.trackLength = trackLength;
        this.sessionType = sessionType;
        this.trackId = trackId;
        this.formula = formula;
        this.sessionTimeLeft = sessionTimeLeft;
        this.sessionDuration = sessionDuration;
        this.pitSpeedLimit = pitSpeedLimit;
        this.gamePaused = gamePaused;
        this.isSpectating = isSpectating;
        this.spectatorCarIndex = spectatorCarIndex;
        this.sliProNativeSupport = sliProNativeSupport;
        this.numMarshalZones = numMarshalZones;
        this.marshalZones = marshalZones;
        this.safetyCarStatus = safetyCarStatus;
        this.networkGame = networkGame;
        this.numWeatherForecastSamples = numWeatherForecastSamples;
        this.weatherForecastSamples = weatherForecastSamples;
    }

    /**
     * Parse a byte array into a SessionPacket
     *
     * @param data   byte array containing the packet data
     * @param header packet header
     * @return parsed SessionPacket
     */
    public static SessionPacket fromBytes(byte[] data, PacketHeader header) {
        int offset = PacketHeader.SIZE;

        Weather weather = Weather.fromId(ByteUtils.toInt8(data, offset));
        offset += 1;

        byte trackTemperature = ByteUtils.toInt8(data, offset);
        offset += 1;

        byte airTemperature = ByteUtils.toInt8(data, offset);
        offset += 1;

        byte totalLaps = ByteUtils.toInt8(data, offset);
        offset += 1;

        int trackLength = ByteUtils.toUInt16(data, offset);
        offset += 2;

        SessionType sessionType = SessionType.fromId(ByteUtils.toInt8(data, offset));
        offset += 1;

        TrackId trackId = TrackId.fromId(ByteUtils.toInt8(data, offset));
        offset += 1;

        Formula formula = Formula.fromId(ByteUtils.toInt8(data, offset));
        offset += 1;

        int sessionTimeLeft = ByteUtils.toUInt16(data, offset);
        offset += 2;

        int sessionDuration = ByteUtils.toUInt16(data, offset);
        offset += 2;

        byte pitSpeedLimit = ByteUtils.toInt8(data, offset);
        offset += 1;

        boolean gamePaused = ByteUtils.toInt8(data, offset) == 1;
        offset += 1;

        boolean isSpectating = ByteUtils.toInt8(data, offset) == 1;
        offset += 1;

        byte spectatorCarIndex = ByteUtils.toInt8(data, offset);
        offset += 1;

        boolean sliProNativeSupport = ByteUtils.toInt8(data, offset) == 1;
        offset += 1;

        byte numMarshalZones = ByteUtils.toInt8(data, offset);
        offset += 1;

        MarshalZone[] marshalZones = new MarshalZone[MAX_MARSHAL_ZONES];
        for (int i = 0; i < MAX_MARSHAL_ZONES; i++) {
            marshalZones[i] = MarshalZone.fromBytes(data, offset);
            offset += MarshalZone.SIZE;
        }

        SafetyCarStatus safetyCarStatus = SafetyCarStatus.fromId(ByteUtils.toInt8(data, offset));
        offset += 1;

        boolean networkGame = ByteUtils.toInt8(data, offset) == 1;
        offset += 1;

        byte numWeatherForecastSamples = ByteUtils.toInt8(data, offset);
        offset += 1;

        WeatherForecastSample[] weatherForecastSamples = new WeatherForecastSample[MAX_WEATHER_FORECAST_SAMPLES];
        for (int i = 0; i < MAX_WEATHER_FORECAST_SAMPLES; i++) {
            weatherForecastSamples[i] = WeatherForecastSample.fromBytes(data, offset);
            offset += WeatherForecastSample.SIZE;
        }

        return new SessionPacket(
                header, weather, trackTemperature, airTemperature, totalLaps, trackLength,
                sessionType, trackId, formula, sessionTimeLeft, sessionDuration, pitSpeedLimit,
                gamePaused, isSpectating, spectatorCarIndex, sliProNativeSupport, numMarshalZones,
                marshalZones, safetyCarStatus, networkGame, numWeatherForecastSamples, weatherForecastSamples
        );
    }
}