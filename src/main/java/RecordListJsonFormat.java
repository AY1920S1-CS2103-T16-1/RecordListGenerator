import java.util.ArrayList;
import java.util.List;

public class RecordListJsonFormat {

    List<RecordListJsonEntry> recordEntriesList;

    RecordListJsonFormat() {
        this.recordEntriesList = new ArrayList<>();
    }

    public void add(RecordListJsonEntry entry) {
        this.recordEntriesList.add(entry);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{\n" + "  \"records\" : [ ");

        for (int i = 0; i < recordEntriesList.size(); i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(recordEntriesList.get(i));
        }

        stringBuilder.append(" ]\n");
        stringBuilder.append("}");
        return stringBuilder.toString().trim();
    }


}
