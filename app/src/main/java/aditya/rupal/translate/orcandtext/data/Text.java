package aditya.rupal.translate.orcandtext.data;

import com.google.firebase.ml.vision.text.FirebaseVisionText;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Text {
    Coords xy;
    ArrayList<FirebaseVisionText.Line> text;

    public Text(Coords xy, ArrayList<FirebaseVisionText.Line> text) {
        this.xy = xy;
        this.text = text;
    }

    public void add(FirebaseVisionText.Line element) {
        text.add(element);
        Collections.sort(text, new Comparator<FirebaseVisionText.Line>() {
            @Override
            public int compare(FirebaseVisionText.Line o1, FirebaseVisionText.Line o2) {
                return o1.getBoundingBox().centerX() - o2.getBoundingBox().centerX();
            }
        });
    }

    public ArrayList<FirebaseVisionText.Line> getText() {
        return text;
    }
}
