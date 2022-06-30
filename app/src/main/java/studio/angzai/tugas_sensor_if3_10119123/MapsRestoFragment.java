package studio.angzai.tugas_sensor_if3_10119123;
//Nama : ANGGA CAHYA ABADI
//NIM : 10119123
//Kelas : IF-3
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsRestoFragment extends Fragment {

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng lokasi1 = new LatLng(-6.88855266433536, 107.61577445785068);
            googleMap.addMarker(new MarkerOptions().position(lokasi1).title("Martabak Mertua").snippet("Restoran Martabak").icon(BitmapDescriptorFactory.fromResource(R.drawable.resto)));
            LatLng lokasi2 = new LatLng(-6.8883375030556175, 107.61570485350079);
            googleMap.addMarker(new MarkerOptions().position(lokasi2).title("Baso Aci Akang").snippet("Restoran Baso").icon(BitmapDescriptorFactory.fromResource(R.drawable.resto)));
            LatLng lokasi3 = new LatLng(-6.888105747917743, 107.61523120693961);
            googleMap.addMarker(new MarkerOptions().position(lokasi3).title("Kirai Kitchen").snippet("Restoran Dim Sum").icon(BitmapDescriptorFactory.fromResource(R.drawable.resto)));
            LatLng lokasi4 = new LatLng(-6.887790023345073, 107.61515452129196);
            googleMap.addMarker(new MarkerOptions().position(lokasi4).title("Recheese Factory").snippet("Restoran Cepat Saji").icon(BitmapDescriptorFactory.fromResource(R.drawable.resto)));
            LatLng lokasi5 = new LatLng(-6.88657526549741, 107.6150237046191);
            googleMap.addMarker(new MarkerOptions().position(lokasi5).title("Warung Nasi SPG").snippet("Restoran Masakan Ayam").icon(BitmapDescriptorFactory.fromResource(R.drawable.resto)));

            googleMap.moveCamera(CameraUpdateFactory.newLatLng(lokasi4));
            googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lokasi4,18));
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps_resto, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}