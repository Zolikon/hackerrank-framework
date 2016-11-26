package com.zolikon.helpers;

import java.io.*;
import java.net.URL;

@SuppressWarnings("unused")
public class ConsoleReader {

    private ByteArrayOutputStream out;
    private PrintStream original;
    private StringBuilder expected;
    private InputStream fileSource;

    public static ConsoleReader init() {
        return new ConsoleReader();
    }

    private ConsoleReader() {
        expected = new StringBuilder();
        original = System.out;
        out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        System.setOut(printStream);
    }

    public ConsoleReader addLines(String line, String... lines) {
        expected.append(line).append("\n");
        for (String oneLine : lines) {
            expected.append(oneLine).append("\n");
        }
        return this;
    }

    public ConsoleReader fromFile(String fileName) {
        try {
            URL url = ConsoleWriter.class.getClassLoader().getResource(fileName);
            fileSource = new FileInputStream(new File(url.toURI()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public ConsoleReader finish() {
        System.setOut(original);
        return this;
    }

    public void findFails() {
        checkResults(true);
    }

    public void printResults() {
        checkResults(false);
    }

    private void checkResults(boolean onlyFailed) {
        try (ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
             BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            BufferedReader expectedReader;
            if (fileSource != null) {
                expectedReader = new BufferedReader(new InputStreamReader(fileSource));
            } else {
                expectedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(expected.toString()
                        .getBytes())));
            }
            String line;
            int counter = 0;
            int failedCounter = 0;
            while ((line = reader.readLine()) != null) {
                counter++;
                String expectedLine = expectedReader.readLine();
                if (expectedLine == null) {
                    System.out.println("Mismatch in result count");
                    break;
                }
                if (!(onlyFailed && line.equals(expectedLine))) {
                    System.out.println("expected result: |" + expectedLine + "|");
                    System.out.println("actual result:   |" + line + "|");
                    System.out.println("result:" + line.equals(expectedLine));
                    System.out.println();
                }
                if (!line.equals(expectedLine)) {
                    failedCounter++;
                }

            }
            System.out.println(String.format("Test cases:   %s", counter));
            System.out.println(String.format("Failed tests: %s", failedCounter));
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
