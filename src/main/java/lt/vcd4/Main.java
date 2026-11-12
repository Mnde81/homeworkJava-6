package lt.vcd4;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static long calculateSize(File directory) {
        long totalSize = 0;

        File[] files = directory.listFiles();

        if (files == null) {
            return 0;
        }

        for (File file : files) {
            if (file.isFile()) {
                totalSize += file.length();
            } else if (file.isDirectory()) {
                totalSize += calculateSize(file);
            }
        }

        return totalSize;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter directory name: ");
        String directoryName = scanner.nextLine();

        File directory = new File(directoryName);


        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Error: Directory does not exist!");
        } else {

            long bytes = calculateSize(directory);

            double kilobytes = bytes / 1024.0;
            double megabytes = kilobytes / 1024.0;

            System.out.println("Directory: " + directoryName);
            System.out.println("Total size:");
            System.out.println("Bytes: " + bytes + " B");
            System.out.println("Kilobytes: " + kilobytes + " KB");
            System.out.println("Megabytes: " + megabytes + " MB");
        }

        scanner.close();
    }
}
