package sanpablook.study.sanpablook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.study.sanpablook.R;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.List;

public class HomepageActivity extends AppCompatActivity implements OnMapReadyCallback{

    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        //carousel
        ImageCarousel imageCarousel = findViewById(R.id.carousel);
        imageCarousel.registerLifecycle(getLifecycle());

        List<CarouselItem> list = new ArrayList<>();
        list.add(new CarouselItem("https://fastly.4sqi.net/img/general/width960/133621146_RQ5otMtUZup3VUJsKSFbU7qbtUbQY-QRCRvtc12snbU.jpg", "Welcome to San Pablo City, Laguna!"));
        list.add(new CarouselItem("https://virtual.reality.travel/wp-content/uploads/2021/07/cathedral-church-of-st-paul-the-first-hermit-san-pablo-city-1700x900.jpg", "San Pablo Church"));
        list.add(new CarouselItem("https://files01.pna.gov.ph/ograph/2018/08/01/san-pablo-city-marker.png", "Tara!"));

        imageCarousel.setData(list);


        //Maps
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);

        if(mapFragment !=null){
            mapFragment.getMapAsync(this);
        }


        //button redirect to nature page
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) View button = findViewById(R.id.natureBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomepageActivity.this, NatureActivity.class);
                startActivity(intent);
                finish();
            }
        });
        return;
    }


    //google Maps location
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;

        LatLng latlng = new LatLng(14.0642, 121.3233);
        map.moveCamera(CameraUpdateFactory.newLatLng(latlng));
        CameraUpdate location = CameraUpdateFactory.newLatLngZoom(latlng, 13);
        map.animateCamera(location);

        //map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        MarkerOptions options = new MarkerOptions().position(latlng).title("San Pablo City");
        options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
        map.addMarker(options);
    }
}