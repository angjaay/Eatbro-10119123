package studio.angzai.tugas_sensor_if3_10119123;

//Nama : ANGGA CAHYA ABADI
//NIM : 10119123
//Kelas : IF-3

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;

import nl.joery.animatedbottombar.AnimatedBottomBar;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    AnimatedBottomBar animatedBottomBar;
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        animatedBottomBar = findViewById(R.id.animatedBottomBar);

        if (savedInstanceState==null){
            animatedBottomBar.selectTabById(R.id.resto, true);
            fragmentManager = getSupportFragmentManager();
            MapsRestoFragment mapsRestoFragment = new MapsRestoFragment();
            fragmentManager.beginTransaction().replace(R.id.fragment_container, mapsRestoFragment)
                    .commit();
        }

        animatedBottomBar.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
            @Override
            public void onTabSelected(int lastIndex, @Nullable AnimatedBottomBar.Tab lastTab, int newIndex, @NonNull AnimatedBottomBar.Tab newTab) {
                Fragment fragment = null;
                switch (newTab.getId()){
                    case R.id.resto:
                        fragment = new MapsRestoFragment();
                        break;
                    case R.id.user:
                        fragment = new MapsUserFragment();
                        break;
                    case  R.id.profile:
                        fragment = new ProfileFragment();
                        break;
                    case  R.id.about:
                        fragment = new AboutFragment();
                        break;
                }

                if (fragment != null){
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
                            .commit();
                }else{
                    Log.e(TAG, "Error in creating fragment");
                }
            }

            @Override
            public void onTabReselected(int lastIndex, @NonNull AnimatedBottomBar.Tab lastTab) {

            }
        });
    }
}