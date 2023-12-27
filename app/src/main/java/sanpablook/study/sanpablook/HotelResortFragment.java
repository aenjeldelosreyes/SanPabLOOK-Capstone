package sanpablook.study.sanpablook;

import android.content.Intent;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.study.sanpablook.R;

public class HotelResortFragment extends Fragment {
    CardView medingCard, casaCard, palmeraCard, bluediamondCard;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hotel_all, container, false);

        medingCard = view.findViewById(R.id.medingCard);
        casaCard = view.findViewById(R.id.casaCard);
        palmeraCard = view.findViewById(R.id.palmeraCard);

        medingCard.setOnClickListener(v -> goToHotel(HotelMeding.class));
        casaCard.setOnClickListener(v -> goToHotel(HotelCasa.class));
        palmeraCard.setOnClickListener(v -> goToHotel(HotelPalmeras.class));

        return view;
    }

    private void goToHotel(Class<?> hotelClass) {
        Intent intent = new Intent(getActivity(), hotelClass);
        startActivity(intent);

    }
}