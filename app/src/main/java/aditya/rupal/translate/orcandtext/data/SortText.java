package aditya.rupal.translate.orcandtext.data;

import com.google.firebase.ml.vision.text.FirebaseVisionText;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortText {
    private ArrayList<Text> allText;

    public SortText() {
        allText = new ArrayList<>();
    }

    public void add(FirebaseVisionText.Line element) {

        if (allText.size() == 0) {
            ArrayList<FirebaseVisionText.Line> arrayList = new ArrayList<>();
            arrayList.add(element);
            allText.add(new Text(new Coords(element.getBoundingBox().centerX(), element.getBoundingBox().centerY()), arrayList));
            return;
        }

        for (int i = 0; i < allText.size(); i++) {
            Text text = allText.get(i);

            if (text.xy.inLine(new Coords(element.getBoundingBox().centerX(), element.getBoundingBox().centerY()))) {

                text.add(element);

                return;
            }
        }

        ArrayList<FirebaseVisionText.Line> arrayList = new ArrayList<>();
        arrayList.add(element);
        allText.add(new Text(new Coords(element.getBoundingBox().centerX(), element.getBoundingBox().centerY()), arrayList));
    }

    @Override
    public String toString() {
        String str = "";
        for (Text t : allText) {
            for (FirebaseVisionText.Line e : t.text) {
                str += e.getText() + " ";
            }
            str += "\n";
        }
        return str;
    }

    public ArrayList<Text> getAllText() {
        return allText;
    }

    public void sort() {
        Collections.sort(allText, new Comparator<Text>() {
            @Override
            public int compare(Text o1, Text o2) {
                return (int) (o1.xy.y - o2.xy.y);
            }
        });
    }
}
