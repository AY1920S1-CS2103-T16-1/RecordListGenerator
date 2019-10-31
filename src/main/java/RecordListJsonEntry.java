import java.time.LocalDate;

public class RecordListJsonEntry {
    String recordType;
    DateTime dateTime;
    String concentration;
    String height;
    String weight;

    RecordListJsonEntry(String recordType, String dateTime, String concentration, String height, String weight) {
        this.recordType = recordType;
        this.dateTime = new DateTime(dateTime);
        this.concentration = concentration;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "{\n"
                + "    \"recordType\" : " + "\"" + recordType + "\",\n"
                + "    \"dateTime\" : " + "\"" + dateTime.toString() + "\",\n"
                + "    \"concentration\" : " + (concentration == null ? null : "\"" + concentration + "\"") + ",\n"
                + "    \"height\" : " + (height == null ? null : "\"" + height + "\"") + ",\n"
                + "    \"weight\" : " + (weight == null ? null : "\"" + weight + "\"") + "\n"
                + "  }";

    }
}
