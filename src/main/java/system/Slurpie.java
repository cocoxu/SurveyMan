package system;

import gui.SurveyMan;

import java.io.*;
import java.net.URL;

/**
 * Slurpie.slurp reads an entire file into a string.
 */
public class Slurpie {
    // convenience class to slurp in a whole file

    public static String slurp(String filename) throws IOException {
        return slurp(filename, Integer.MAX_VALUE);
    }

    public static String slurp(String filename, int numChars) throws IOException {
        URL resource = Slurpie.class.getClassLoader().getResource(filename);
        SurveyMan.LOGGER.info(filename + "\turl: " + resource);
        BufferedReader br;
        if (resource==null)
            br = new BufferedReader(new FileReader(filename));
        else br = new BufferedReader(new InputStreamReader(resource.openStream()));
        StringBuilder s = new StringBuilder();
        char[] buf = new char[1024*1024];
        for (int totalCharsRead = 0 ; totalCharsRead < numChars ; ) {
            int charsRead = br.read(buf);
            if (charsRead == -1)
                break;
            s.append(buf, 0, charsRead);
            totalCharsRead += buf.length;
        }
        return s.toString();
    }
}
