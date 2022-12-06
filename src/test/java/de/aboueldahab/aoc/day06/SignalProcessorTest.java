package de.aboueldahab.aoc.day06;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SignalProcessorTest {

    private static final String EXAMPLE_1 = "mjqjpqmgbljsphdztnvjfqwrcgsmlb";
    private static final String EXAMPLE_2 = "bvwbjplbgvbhsrlpgdmjqwftvncz";
    private static final String EXAMPLE_3 = "nppdvjthqldpwncqszvftbrmjlhg";
    private static final String EXAMPLE_4 = "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg";
    private static final String EXAMPLE_5 = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw";


    private SignalProcessor signalProcessor;

    @BeforeEach
    void setup() {
        signalProcessor = new SignalProcessor();
    }

    @Test
    void startOfPackageMarker_example1() {
        assertThat(signalProcessor.startOfPacketMarker(EXAMPLE_1)).isEqualTo(7);
    }

    @Test
    void startOfPackageMarker_example2() {
        assertThat(signalProcessor.startOfPacketMarker(EXAMPLE_2)).isEqualTo(5);
    }

    @Test
    void startOfPackageMarker_example3() {
        assertThat(signalProcessor.startOfPacketMarker(EXAMPLE_3)).isEqualTo(6);
    }

    @Test
    void startOfPackageMarker_example4() {
        assertThat(signalProcessor.startOfPacketMarker(EXAMPLE_4)).isEqualTo(10);
    }

    @Test
    void startOfPackageMarker_example5() {
        assertThat(signalProcessor.startOfPacketMarker(EXAMPLE_5)).isEqualTo(11);
    }

    @Test
    void startOfMessageMarker_example1() {
        assertThat(signalProcessor.startOfMessageMarker(EXAMPLE_1)).isEqualTo(19);
    }

    @Test
    void startOfMessageMarker_example2() {
        assertThat(signalProcessor.startOfMessageMarker(EXAMPLE_2)).isEqualTo(23);
    }

    @Test
    void startOfMessageMarker_example3() {
        assertThat(signalProcessor.startOfMessageMarker(EXAMPLE_3)).isEqualTo(23);
    }

    @Test
    void startOfMessageMarker_example4() {
        assertThat(signalProcessor.startOfMessageMarker(EXAMPLE_4)).isEqualTo(29);
    }

    @Test
    void startOfMessageMarker_example5() {
        assertThat(signalProcessor.startOfMessageMarker(EXAMPLE_5)).isEqualTo(26);
    }

}