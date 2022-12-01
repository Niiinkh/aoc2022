package de.aboueldahab.aoc.common;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AocFileReader {

    public List<String> readInput(String filename) {
        try {
            Path path = Paths.get(getClass().getClassLoader().getResource(filename).toURI());
            List<String> lines = Files.lines(path).collect(Collectors.toList());
            return removeLastLineIfEmpty(lines);
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    protected List<String> removeLastLineIfEmpty(List<String> lines) {
        lines = new ArrayList<>(lines);
        if (lines.size() > 0) {
            int lastIndex = lines.size() - 1;
            String lastLine = lines.get(lastIndex);
            if (StringUtils.isAllBlank(lastLine)) {
                lines.remove(lastIndex);
            }
        }
        return lines;
    }


}
