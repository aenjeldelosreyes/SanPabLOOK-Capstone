package sanpablook.study.sanpablook;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.study.sanpablook.R;

public class HotelCasa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_casa);

        findViewById(R.id.backBtn).setOnClickListener(view -> onBackPressed());

        findViewById(R.id.btnShare).setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "Share this App");
            intent.putExtra(Intent.EXTRA_TEXT, "http://casa_location.google.com");
            startActivity(Intent.createChooser(intent, "Share using"));
        });

        ((TextView) findViewById(R.id.stayPrice)).setText(Html.fromHtml("<font color=#1A9AB7>₱ 3,900</font> <font color=#000000>/ night</font>", Html.FROM_HTML_MODE_COMPACT));
    }
}