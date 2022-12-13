package com.example.flexmoney.ui.dashboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.flexmoney.MainActivity;
import com.example.flexmoney.R;
import com.example.flexmoney.databinding.FragmentDashboardBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class DashboardFragment extends Fragment {

    MyAdapter adapter;
    TextView tv1;
    TextView tv2;

    TextView tv3;
    TextView tv4;

    TextView tv5;
    TextView tv6;
    TextView tv7;
    TextView tv8;
    TextView tv9;
    TextView tv10;
    TextView tv11;
    TextView tv12;

















    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);



        binding = FragmentDashboardBinding.inflate(inflater, container, false);

        tv1= binding.tv1;

        tv4= binding.tv4;

        tv7= binding.tv7;

        tv10= binding.tv10;













        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("Batches")


                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                if (document.getId().equals("0")){
                                tv1.setText(document.getData().toString());}
                                if (document.getId().equals("1")){
                                    tv4.setText(document.getData().toString());}
                                if (document.getId().equals("2")){
                                    tv7.setText(document.getData().toString());}
                                if (document.getId().equals("3")){
                                    tv10.setText(document.getData().toString());}
//                                tv2.setText("Capacity-"+document.getString("capacity"));
//                                tv3.setText("Occupied-"+document.getString("filled"));

                            }
                        } else {
                            Log.d("batch", "Error getting documents: ", task.getException());
                        }
                    }
                });




        View root = binding.getRoot();



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}