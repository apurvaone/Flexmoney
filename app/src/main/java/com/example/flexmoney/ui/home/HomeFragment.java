package com.example.flexmoney.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.flexmoney.R;
import com.example.flexmoney.databinding.FragmentHomeBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class HomeFragment extends Fragment {

    AutoCompleteTextView editText;
    Button completePayment;
    TextInputEditText name;
    TextInputEditText age;
    TextInputEditText phone;


    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        completePayment= binding.submit;
        name= binding.name;
        age= binding.age;
        phone= binding.phone;

        FirebaseFirestore db = FirebaseFirestore.getInstance();

//        db.collection("participants")
//                .whereEqualTo("batch", 0)
//
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()) {
//                            for (QueryDocumentSnapshot document : task.getResult()) {
//                                Log.d("batch1", document.getId() + " => " + document.get("name"));
//                            }
//                        } else {
//                            Log.d("batch1", "Error getting documents: ", task.getException());
//                        }
//                    }
//                });



        TextInputLayout batch = binding.selectBacth;
         editText=(AutoCompleteTextView) batch.getEditText();
        String[] messages = new String[]{"Select Batch","Batch1 (6am- 7am)","Batch2 (7am- 8am)","Batch3 (8am- 9am)", "Batch4 (5pm- 6pm)"};
        ArrayAdapter adapter= new ArrayAdapter(getContext(), R.layout.list_item, messages);
        editText.setAdapter(adapter);


        completePayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(),"Participant added",Toast.LENGTH_LONG).show();

                Map<String, Object> participant = new HashMap<>();
                participant.put("name", name.getText().toString());
                participant.put("age", age.getText().toString());
                participant.put("phone", phone.getText().toString());
                participant.put("batch",Integer.valueOf(editText.getText().subSequence(5,6).toString())-1);

                DocumentReference batchref = db.collection("Batches").document(String.valueOf((Integer.valueOf(editText.getText().subSequence(5,6).toString())-1)));

                batchref.update("filled", FieldValue.increment(1));



// Add a new document with a generated ID
                db.collection("participants")
                        .add(participant)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d("haal", "DocumentSnapshot added with ID: " + documentReference.getId());
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("haal", "Error adding document", e);
                            }
                        });

            }




        });






        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}