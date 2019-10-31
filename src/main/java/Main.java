import java.io.BufferedWriter;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        RecordListJsonFormat recordListJsonFormat = new RecordListJsonFormat();
        DateTime currDateTime = new DateTime("2019-06-07 12:12");

        for (int i = 0; i < 180; i++) {
            RecordListJsonEntry recordListJsonEntry = new RecordListJsonEntry("BloodSugar",
                    currDateTime.toString(), getConcentration(), null, null);
            recordListJsonFormat.add(recordListJsonEntry);
            currDateTime = currDateTime.addOneDay();
        }

        for (int i = 0; i < 180; i++) {
            double height = getHeight(166);
            double weight = getWeight(height);

            RecordListJsonEntry recordListJsonEntry = new RecordListJsonEntry("Bmi",
                    currDateTime.toString(), null, "" + height, "" + weight);
            recordListJsonFormat.add(recordListJsonEntry);
            currDateTime = currDateTime.addOneDay();
        }


        File output = new File("a.json");
        output.createNewFile();
        BufferedWriter bw = new BufferedWriter(new FileWriter(output));
        bw.write(recordListJsonFormat.toString());
        bw.close();
    }

    private static String getConcentration() {
        return "" + (getRandomNumberInRange(4.0, 7.8));
    }

    private static double getHeight(double heightInCm) {
        return (getRandomNumberInRange(0.95, 1.05) * heightInCm);

    }

    private static double getWeight(double heightInCm) {
        double heightInMeters = heightInCm / 100;
        return (getRandomNumberInRange(18.5, 25) * (heightInMeters * heightInMeters));

    }

    private static double getRandomNumberInRange(double min, double max) {
        Random r = new Random();
        return min + (max - min) * r.nextDouble();
    }

}
