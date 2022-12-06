package de.aboueldahab.aoc.day06;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SignalProcessorTest {

    private SignalProcessor signalProcessor;

    @BeforeEach
    void setup() {
        signalProcessor = new SignalProcessor();
    }

    @Test
    void startOfPackageMarker_example1() {
        assertThat(signalProcessor.startOfPacketMarker("mjqjpqmgbljsphdztnvjfqwrcgsmlb")).isEqualTo(7);
    }

    @Test
    void startOfPackageMarker_example2() {
        assertThat(signalProcessor.startOfPacketMarker("bvwbjplbgvbhsrlpgdmjqwftvncz")).isEqualTo(5);
    }

    @Test
    void startOfPackageMarker_example3() {
        assertThat(signalProcessor.startOfPacketMarker("nppdvjthqldpwncqszvftbrmjlhg")).isEqualTo(6);
    }

    @Test
    void startOfPackageMarker_example4() {
        assertThat(signalProcessor.startOfPacketMarker("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg")).isEqualTo(10);
    }

    @Test
    void startOfPackageMarker_example5() {
        assertThat(signalProcessor.startOfPacketMarker("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw")).isEqualTo(11);
    }

}