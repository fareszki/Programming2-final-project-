import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        ArrayList<MedicalMapper> records = new ArrayList<>();

        try {
            File readFile = new File("medicalRecords.txt");
            Scanner reader = new Scanner(readFile);
            PrintWriter writer = new PrintWriter("convertedMedicalRecords.txt");
            while (reader.hasNext()) {
                MedicalMapper medicalmapper = new MedicalMapper();
                medicalmapper.setPid(reader.nextInt());
                medicalmapper.setAge(reader.nextInt());
                medicalmapper.setGender(reader.nextInt());
                medicalmapper.setWeight(reader.nextDouble());
                medicalmapper.setHeight(reader.nextDouble());
                medicalmapper.setSbp(reader.nextInt());
                medicalmapper.setDbp(reader.nextInt());
                medicalmapper.setFbs(reader.nextDouble());
                medicalmapper.setChol(reader.nextDouble());
                medicalmapper.setLdl(reader.nextDouble());
                medicalmapper.setHdl(reader.nextDouble());
                medicalmapper.setTg(reader.nextDouble());
                medicalmapper.setHba1c(reader.nextDouble());

                records.add(medicalmapper);
            }
            // sorts the array
            Collections.sort(records);

            for (int i = 0; i < records.size(); i++) {
                writer.println(records.get(i));
            }

            reader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
