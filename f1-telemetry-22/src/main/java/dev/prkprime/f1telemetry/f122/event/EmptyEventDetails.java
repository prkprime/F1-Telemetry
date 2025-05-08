package dev.prkprime.f1telemetry.f122.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Empty event details for events that don't have additional data
 */
@Getter
@ToString
@AllArgsConstructor
public class EmptyEventDetails implements EventDetails {
    /**
     * Event code
     */
    private final EventCode eventCode;
}