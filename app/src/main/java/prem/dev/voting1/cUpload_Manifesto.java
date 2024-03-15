package prem.dev.voting1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;
import java.util.Map;

public class cUpload_Manifesto extends AppCompatActivity {
    ImageView cmani;
    private Uri cImageUri;
    Button cbtn_upload_mani;


  FirebaseAuth cauth;
    DatabaseReference creference ,check;
    String cmiUrlOk = "";

    private StorageReference cmStorageRef;

    private StorageTask cmUploadTask;

    private static final int cPICK_IMAGE_REQUEST = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_upload__manifesto);

        //imageview
        cmani = findViewById(R.id.cmaniimg);


        cbtn_upload_mani = findViewById(R.id.upload_mani_button);
        cauth = FirebaseAuth.getInstance();
        String Uid = cauth.getUid();
        creference = FirebaseDatabase.getInstance().getReference("CandidateUsers").child(Uid);
        check = FirebaseDatabase.getInstance().getReference("CandidateUsers").child(Uid);



        cmani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });

        cmStorageRef = FirebaseStorage.getInstance().getReference("cuploads");


        ProgressDialog dialog;

            cbtn_upload_mani.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // Toast.makeText(cUpload_Manifesto.this, "click se pahele", Toast.LENGTH_SHORT).show();

                    creference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String nam = (String) snapshot.child("mani").getValue().toString();

                        if (nam.equals("No")){

                            cuploadFile();

                        }
                        else{

                            Toast.makeText(cUpload_Manifesto.this, "Manifesto Already Uploaded", Toast.LENGTH_SHORT).show();

                        }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }


                    });







                  //  Toast.makeText(cUpload_Manifesto.this, "click se baad", Toast.LENGTH_SHORT).show();

                }
            });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == cPICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            cImageUri = data.getData();

            Toast.makeText(cUpload_Manifesto.this, "Pdf Selected", Toast.LENGTH_SHORT).show();

            Glide.with(cmani.getContext()).load(cImageUri).into(cmani);


        }
    }
    private String getFileExtension(Uri uri) {
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }


    private void cuploadFile() {

      //  Toast.makeText(cUpload_Manifesto.this, "Upload file ke ander", Toast.LENGTH_SHORT).show();


        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Uploading");
        pd.setCancelable(false);
        pd.show();
        if (cImageUri != null) {
            final StorageReference fileReference = cmStorageRef.child(System.currentTimeMillis()
                    + "." + getFileExtension(cImageUri));

            cmUploadTask = fileReference.putFile(cImageUri);


            //PHOTO
            cmUploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                @Override
                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                    if (!task.isSuccessful()) {
                        throw task.getException();
                    }
                    return fileReference.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    if (task.isSuccessful()) {

                        Uri downloadUri = task.getResult();
                        cmiUrlOk = downloadUri.toString();







                        creference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {


                                // User vote = snapshot.getValue(User.class);

                                FirebaseUser firebaseUser = cauth.getCurrentUser();


                                Map<String, Object> hashMap = new HashMap<>();
                                hashMap.put("mani", cmiUrlOk);
                                creference.updateChildren(hashMap);
                                Toast.makeText(cUpload_Manifesto.this, "Success", Toast.LENGTH_SHORT).show();

                                    pd.dismiss();
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }


                        });



                    }

                        else{

                        Toast.makeText(cUpload_Manifesto.this, "Fail", Toast.LENGTH_SHORT).show();


                    }
                }



            }); }}



    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, cPICK_IMAGE_REQUEST);
    }


}