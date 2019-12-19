package Utility;

import java.io.File;
import java.text.NumberFormat;

public class SystemInfo {

    public static String Info() {
        StringBuilder sb = new StringBuilder();
        sb.append(OsInfo());
        sb.append(MemInfo());
        sb.append(DiskInfo());
        return sb.toString();
    }

    public static String MemInfo() {
        NumberFormat format = NumberFormat.getInstance();
        StringBuilder sb = new StringBuilder();
        Runtime runtime = Runtime.getRuntime();

        long maxMemory = runtime.maxMemory();
        long allocatedMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        sb.append("Free memory: ");
        sb.append(format.format(freeMemory / 1024) + " KB");
        sb.append("\n");
        sb.append("Allocated memory: ");
        sb.append(format.format(allocatedMemory / 1024) + " KB");
        sb.append("\n");
        sb.append("Max memory: ");
        sb.append(format.format(maxMemory / 1024) + " KB");
        sb.append("\n");
        sb.append("Total free memory: ");
        sb.append(format.format((freeMemory + (maxMemory - allocatedMemory)) / 1024) + " KB");
        sb.append("\n");
        return sb.toString();
    }

    public static String OsInfo() {
        Runtime runtime = Runtime.getRuntime();

        StringBuilder sb = new StringBuilder();
        sb.append("OS: ");
        sb.append(OSname());
        sb.append("\n");
        sb.append("Version: ");
        sb.append(OSversion());
        sb.append("\n");
        sb.append("Arch: ");
        sb.append(OsArch());
        sb.append("\n");
        sb.append("Available processors (cores): ");
        sb.append(runtime.availableProcessors());
        sb.append("\n");
        return sb.toString();
    }

    public static String DiskInfo() {
        /* Get a list of all filesystem roots on this system */
        File[] roots = File.listRoots();
        StringBuilder sb = new StringBuilder();

        /* For each filesystem root, print some info */
        for (File root : roots) {
            sb.append("File system root: ");
            sb.append(root.getAbsolutePath());
            sb.append("\n");
            sb.append("Total space (bytes): ");
            sb.append(root.getTotalSpace());
            sb.append("\n");
            sb.append("Free space (bytes): ");
            sb.append(root.getFreeSpace());
            sb.append("\n");
            sb.append("Usable space (bytes): ");
            sb.append(root.getUsableSpace());
            sb.append("\n");
        }

        return sb.toString();
    }

    private static String OSname() {
        return System.getProperty("os.name");
    }

    private static String OSversion() {
        return System.getProperty("os.version");
    }

    private static String OsArch() {
        return System.getProperty("os.arch");
    }

    private static long totalMem() {
        return Runtime.getRuntime().totalMemory();
    }

    private static long usedMem() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }
}
