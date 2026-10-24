package com.kaser.muslimmini;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.*;
import android.graphics.Typeface;

public class MainActivity extends Activity {

    int count = 0;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scroll = new ScrollView(this);
        layout = new LinearLayout(this);
        layout.setOrientation(1);
        layout.setPadding(20, 20, 20, 20);
        layout.setBackgroundColor(Color.rgb(245, 242, 233));
        scroll.addView(layout);
        setContentView(scroll);

        title("قصص الأنبياء والتسبيح");

        button("التسبيح", v -> tasbeeh());
        button("قصص الأنبياء", v -> stories());
        tasbeeh();
    }

    void title(String text) {
        TextView t = new TextView(this);
        t.setText(text);
        t.setTextSize(25);
        t.setTypeface(null, Typeface.BOLD);
        t.setTextColor(Color.rgb(7, 59, 50));
        t.setGravity(Gravity.CENTER);
        t.setPadding(10, 25, 10, 25);
        layout.addView(t);
    }

    void button(String text, android.view.View.OnClickListener listener) {
        Button b = new Button(this);
        b.setText(text);
        b.setOnClickListener(listener);
        layout.addView(b);
    }

    void tasbeeh() {
        layout.removeAllViews();
        title("التسبيح");

        TextView number = new TextView(this);
        number.setText("عدد التسبيحات: " + count);
        number.setTextSize(24);
        number.setGravity(Gravity.CENTER);
        layout.addView(number);

        button("سبحان الله", v -> {
            count++;
            number.setText("عدد التسبيحات: " + count);
        });

        button("الحمد لله", v -> {
            count++;
            number.setText("عدد التسبيحات: " + count);
        });

        button("الله أكبر", v -> {
            count++;
            number.setText("عدد التسبيحات: " + count);
        });

        button("إعادة العداد", v -> {
            count = 0;
            number.setText("عدد التسبيحات: 0");
        });

        button("قصص الأنبياء", v -> stories());
    }

    void stories() {
        layout.removeAllViews();
        title("قصص الأنبياء");

        String[] names = {
            "آدم عليه السلام",
            "نوح عليه السلام",
            "إبراهيم عليه السلام",
            "موسى عليه السلام",
            "يوسف عليه السلام",
            "يونس عليه السلام",
            "محمد ﷺ"
        };

        String[] stories = {
            "خلق الله آدم عليه السلام، وأمر الملائكة بالسجود له، وعلمه الأسماء.",
            "دعا نوح عليه السلام قومه إلى عبادة الله، وصنع السفينة بأمر الله.",
            "دعا إبراهيم عليه السلام إلى التوحيد، وابتلاه الله فصبر.",
            "أرسل الله موسى عليه السلام إلى فرعون، وأيده بالآيات.",
            "ابتلي يوسف عليه السلام وصبر، ثم مكن الله له في الأرض.",
            "دعا يونس عليه السلام ربه في الظلمات فاستجاب الله له.",
            "محمد ﷺ خاتم الأنبياء والمرسلين، أرسله الله رحمة للعالمين."
        };

        for (int i = 0; i < names.length; i++) {
            final int index = i;
            button(names[i], v -> {
                new android.app.AlertDialog.Builder(this)
                    .setTitle(names[index])
                    .setMessage(stories[index])
                    .setPositiveButton("إغلاق", null)
                    .show();
            });
        }

        button("العودة إلى التسبيح", v -> tasbeeh());
    }
}