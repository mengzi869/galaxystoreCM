package com.clean888.cleansuper.cleaner.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class mf {
    public static float a() {
        try {
            Process exec = Runtime.getRuntime().exec("cat sys/class/thermal/thermal_zone0/temp");
            exec.waitFor();
            String readLine = new BufferedReader(new InputStreamReader(exec.getInputStream())).readLine();
            if (readLine == null) {
                return 31.0f;
            }
            float parseFloat = Float.parseFloat(readLine);
            if (parseFloat < 1000.0f) {
                return 31.0f;
            }
            return parseFloat / 1000.0f;
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0f;
        }
    }
}
