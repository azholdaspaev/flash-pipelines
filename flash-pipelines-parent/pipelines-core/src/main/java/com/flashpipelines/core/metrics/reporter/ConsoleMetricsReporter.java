package com.flashpipelines.core.metrics.reporter;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;

import java.util.concurrent.TimeUnit;

/**
 * Console metrics reporter based on {@link ConsoleReporter}.
 */
public class ConsoleMetricsReporter {

    public ConsoleMetricsReporter(MetricRegistry metricRegistry) {
        ConsoleReporter consoleReporter = ConsoleReporter.forRegistry(metricRegistry)
            .convertRatesTo(TimeUnit.SECONDS)
            .convertDurationsTo(TimeUnit.MILLISECONDS)
            .build();

        consoleReporter.start(10, TimeUnit.SECONDS);
    }
}
