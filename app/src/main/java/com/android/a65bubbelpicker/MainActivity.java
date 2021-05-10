package com.android.a65bubbelpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.igalata.bubblepicker.BubblePickerListener;
import com.igalata.bubblepicker.model.PickerItem;
import com.igalata.bubblepicker.rendering.BubblePicker;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BubblePicker bubblePicker;

    String[] name={
            "Fahmi",
            "Danny",
            "Scott",
            "Wu"
    };

    int [] image={
            R.drawable.fahmi,
            R.drawable.danny,
            R.drawable.scott,
            R.drawable.wu
    };
    int[] color={
            Color.parseColor("#1A237E"),
            Color.parseColor("#6200EA"),
            Color.parseColor("#004D40"),
            Color.parseColor("#880E4F")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bubblePicker = findViewById(R.id.bubble);
        ArrayList<PickerItem> list = new ArrayList<>();
        for (int i=0;i<name.length;i++){
            PickerItem item = new PickerItem(name[i],color[i],Color.WHITE,getDrawable(image[i]));
            list.add(item);
        }

        bubblePicker.setItems(list);
        bubblePicker.setListener(new BubblePickerListener() {
            @Override
            public void onBubbleSelected(@NotNull PickerItem pickerItem) {
                Toast.makeText(MainActivity.this, ""+pickerItem.getTitle()+" selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBubbleDeselected(@NotNull PickerItem pickerItem) {
                Toast.makeText(MainActivity.this, ""+pickerItem.getTitle()+" deselected", Toast.LENGTH_SHORT).show();
            }
        });

    }
}