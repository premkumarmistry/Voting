package prem.dev.voting1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;
import java.util.Objects;

public class Register_for_candinate extends AppCompatActivity {

    ImageView cuploadPhoto, cuploadAadhar, cuploadLeave, cuploadBirth,cuploadAadharFront,cuploadAadharBack;
    private Uri cImageUri, cImageUri1, cImageUri2, cImageUri3,cImageUri5,cImageUri6;
    EditText cname, cage, cbirthday, cgender, caddress, cmobile, cemail, cpassword,cpartyname,cpartcode;
    Button cbtn_register;
    String cmyurl = "";

    FirebaseAuth cauth;
    DatabaseReference creference;


    String cmiUrlOk = "";
    String cmiUrlOk1 = "";
    String cmiUrlOk2 = "";
    String cmiUrlOk3 = "";
    String cmiUrlOk5 = "";
    String cmiUrlOk6 = "";
    //private Uri mImageUri , pdfUri;

        private StorageReference cmStorageRef;

    private StorageTask cmUploadTask, cmUploadTask1, cmUploadTask2, cmUploadTask3,cmUploadTask5,cmUploadTask6;


    private static final int cPICK_IMAGE_REQUEST = 1;
    private static final int cPICK_IMAGE_REQUEST2 = 2;
    private static final int cPICK_IMAGE_REQUEST3 = 3;
    private static final int cPICK_IMAGE_REQUEST4 = 4;
    private static final int cPICK_IMAGE_REQUEST5 = 5;
    private static final int cPICK_IMAGE_REQUEST6 = 6;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_for_candinate);

        //findidS
        cuploadPhoto = findViewById(R.id.cuploadImg);
        //   uploadAadhar = findViewById(R.id.upload_aadhar_img);
        cuploadAadharFront = findViewById(R.id.cupload_aadharfront_img);
        cuploadAadharBack = findViewById(R.id.cupload_aadharback_img);

        cuploadLeave = findViewById(R.id.cupload_leaving_img);
        cuploadBirth = findViewById(R.id.cupload_birthday_img);
        cname = findViewById(R.id.cname_data);
        cage = findViewById(R.id.cage_data);
        caddress = findViewById(R.id.caddress_data);
        cbirthday = findViewById(R.id.cbirth_data);
        cgender = findViewById(R.id.cgender_data);
        cmobile = findViewById(R.id.cmobile_data);
        cemail = findViewById(R.id.cemail_data);
        cpassword = findViewById(R.id.cpassword_data);
        cbtn_register = findViewById(R.id.csing_up);
        cpartcode = findViewById(R.id.cpartycode_data);
        cpartyname = findViewById(R.id.cpartyname_data);

        cauth = FirebaseAuth.getInstance();


        cuploadPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });


        cuploadLeave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser3();
            }
        });

        cuploadBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser4();
            }
        });
        cuploadAadharFront.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser5();
            }
        });
        cuploadAadharBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser6();
            }
        });

        cbtn_register.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                String ctxt_birthday = Objects.requireNonNull(cbirthday.getText()).toString();

                String ctxt_age = Objects.requireNonNull(cage.getText()).toString();
                String ctxt_gender = Objects.requireNonNull(cgender.getText()).toString();
                String ctxt_mobile = Objects.requireNonNull(cmobile.getText()).toString();
                String ctxt_name = Objects.requireNonNull(cname.getText()).toString();
                String ctxt_email = Objects.requireNonNull(cemail.getText()).toString();
                String ctxt_password = Objects.requireNonNull(cpassword.getText()).toString();
                String ctxt_address = Objects.requireNonNull(caddress.getText()).toString();
                String ctxt_partyname = Objects.requireNonNull(cpartyname.getText()).toString();
                String ctxt_partycode = Objects.requireNonNull(cpartcode.getText()).toString();

                cuploadFile(ctxt_name, ctxt_email, ctxt_password, ctxt_age, ctxt_birthday, ctxt_gender, ctxt_mobile, ctxt_address, ctxt_partyname, ctxt_partycode);

            }

        });
        cmStorageRef = FirebaseStorage.getInstance().getReference("cuploads");


        ProgressDialog dialog;








    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == cPICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            cImageUri = data.getData();


            Glide.with(cuploadPhoto.getContext()).load(cImageUri).into(cuploadPhoto);


        }


        if (requestCode == cPICK_IMAGE_REQUEST4 && resultCode == RESULT_OK
                && data != null && data.getData() != null) {

            cImageUri2 = data.getData();


            Glide.with(cuploadBirth.getContext()).load(cImageUri2).into(cuploadBirth);

        }
        if (requestCode == cPICK_IMAGE_REQUEST3 && resultCode == RESULT_OK
                && data != null && data.getData() != null) {

            cImageUri3 = data.getData();


            Glide.with(cuploadLeave.getContext()).load(cImageUri3).into(cuploadLeave);

        }
        if (requestCode == cPICK_IMAGE_REQUEST5 && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            cImageUri5 = data.getData();


            Glide.with(cuploadAadharFront.getContext()).load(cImageUri5).into(cuploadAadharFront);


        }

        if (requestCode == cPICK_IMAGE_REQUEST6 && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            cImageUri6 = data.getData();


            Glide.with(cuploadAadharBack.getContext()).load(cImageUri6).into(cuploadAadharBack);


        }





    }


    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, cPICK_IMAGE_REQUEST);
    }

    private void openFileChooser2() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, cPICK_IMAGE_REQUEST2);
    }

    private void openFileChooser3() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, cPICK_IMAGE_REQUEST3);
    }

    private void openFileChooser4() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, cPICK_IMAGE_REQUEST4);
    }

    private void openFileChooser6() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, cPICK_IMAGE_REQUEST6);
    }
    private void openFileChooser5() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, cPICK_IMAGE_REQUEST5);
    }

    private String getFileExtension(Uri uri) {
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }

    //Uploadfiles code


    private void cuploadFile(String txt_name, String txt_email, String txt_password, String txt_age, String txt_birthday, String txt_gender, String txt_mobile, String txt_address,String txt_partyname,String txt_partycode) {
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Uploading");
        pd.setCancelable(false);
        pd.show();
        if (cImageUri != null) {
            final StorageReference fileReference = cmStorageRef.child(System.currentTimeMillis()
                    + "." + getFileExtension(cImageUri));
           /* if (mImageUri1 != null) {
                final StorageReference fileReference1 = mStorageRef.child(System.currentTimeMillis()
                        + "." + getFileExtension(mImageUri1));*/
            if (cImageUri2 != null) {
                final StorageReference fileReference2 = cmStorageRef.child(System.currentTimeMillis()
                        + "." + getFileExtension(cImageUri2));

                if (cImageUri3 != null) {
                    final StorageReference fileReference3 = cmStorageRef.child(System.currentTimeMillis()
                            + "." + getFileExtension(cImageUri3));


                    if (cImageUri5 != null) {
                        final StorageReference fileReference5 = cmStorageRef.child(System.currentTimeMillis()
                                + "." + getFileExtension(cImageUri5));

                        if (cImageUri6 != null) {
                            final StorageReference fileReference6 = cmStorageRef.child(System.currentTimeMillis()
                                    + "." + getFileExtension(cImageUri6));



                            cmUploadTask = fileReference.putFile(cImageUri);
                        //  mUploadTask1 = fileReference1.putFile(mImageUri1);
                        cmUploadTask2 = fileReference2.putFile(cImageUri2);
                        cmUploadTask3 = fileReference3.putFile(cImageUri3);
                        cmUploadTask5 = fileReference5.putFile(cImageUri5);
                        cmUploadTask6 = fileReference6.putFile(cImageUri6);


                            //FrontAadhar

                            cmUploadTask5.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                                @Override
                                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                                    if (!task.isSuccessful()) {
                                        throw task.getException();
                                    }
                                    return fileReference5.getDownloadUrl();
                                }
                            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    if (task.isSuccessful()) {


                                        Uri downloadUri5 = task.getResult();
                                        cmiUrlOk5 = downloadUri5.toString();

                                        //BackAadhar


                                        cmUploadTask6.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                                            @Override
                                            public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                                                if (!task.isSuccessful()) {
                                                    throw task.getException();
                                                }
                                                return fileReference6.getDownloadUrl();
                                            }
                                        }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Uri> task) {
                                                if (task.isSuccessful()) {


                                                    Uri downloadUri6 = task.getResult();
                                                    cmiUrlOk6 = downloadUri6.toString();

                                                    //leave

                                                    cmUploadTask3.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                                                        @Override
                                                        public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                                                            if (!task.isSuccessful()) {
                                                                throw task.getException();
                                                            }
                                                            return fileReference3.getDownloadUrl();
                                                        }
                                                    }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                                                        @Override
                                                        public void onComplete(@NonNull Task<Uri> task) {
                                                            if (task.isSuccessful()) {


                                                                Uri downloadUri3 = task.getResult();
                                                                cmiUrlOk3 = downloadUri3.toString();

                                                                //birth
                                                                cmUploadTask2.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                                                                    @Override
                                                                    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                                                                        if (!task.isSuccessful()) {
                                                                            throw task.getException();
                                                                        }
                                                                        return fileReference2.getDownloadUrl();
                                                                    }
                                                                }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                                                                    @Override
                                                                    public void onComplete(@NonNull Task<Uri> task) {
                                                                        if (task.isSuccessful()) {


                                                                            Uri downloadUri2 = task.getResult();
                                                                            cmiUrlOk2 = downloadUri2.toString();


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



                                                                                        cauth.createUserWithEmailAndPassword(txt_email, txt_password)
                                                                                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                                                                                    @Override
                                                                                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                                                                                        if (task.isSuccessful()) {
                                                                                                            FirebaseUser firebaseUser = cauth.getCurrentUser();
                                                                                                            assert firebaseUser != null;
                                                                                                            String userid = firebaseUser.getUid();

                                                                                                            creference = FirebaseDatabase.getInstance().getReference("CandidateUsers").child(userid);

                                                                                                            HashMap<String, String> hashMap = new HashMap<>();
                                                                                                            hashMap.put("cid", userid);
                                                                                                            hashMap.put("mani", "No");
                                                                                                            hashMap.put("feed", "No");

                                                                                                            hashMap.put("Cisvoter", "false");
                                                                                                            hashMap.put("cVoted", "false");
                                                                                                            hashMap.put("isCandidate", "true");
                                                                                                            hashMap.put("cname", txt_name);
                                                                                                            hashMap.put("cemail", txt_email);
                                                                                                            hashMap.put("cage", txt_age);
                                                                                                            hashMap.put("cbirthday", txt_birthday);
                                                                                                            hashMap.put("cgender", txt_gender);
                                                                                                            hashMap.put("cmobile", txt_mobile);
                                                                                                            hashMap.put("caddress", txt_address);
                                                                                                            hashMap.put("cpartyname", txt_partyname);
                                                                                                            hashMap.put("cpartycode", txt_partycode);
                                                                                                            hashMap.put("cisEnabled", "No");
                                                                                                            hashMap.put("cPhoto", cmiUrlOk);
                                                                                                            hashMap.put("cAadharCardFront", cmiUrlOk5);
                                                                                                            hashMap.put("cAadharCardBack", cmiUrlOk6);
                                                                                                            hashMap.put("cBirthCertificate", cmiUrlOk2);
                                                                                                            hashMap.put("cleaving", cmiUrlOk3);
                                                                                                            creference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                                @Override
                                                                                                                public void onComplete(@NonNull Task<Void> task) {
                                                                                                                    if (task.isSuccessful()) {
                                                                                                                        Intent intent = new Intent(Register_for_candinate.this, Choose_Login.class);
                                                                                                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                                                                                        startActivity(intent);
                                                                                                                        finish();
                                                                                                                    }
                                                                                                                }
                                                                                                            });
                                                                                                        } else {
                                                                                                            Toast.makeText(Register_for_candinate.this, "You can't register with this email or password", Toast.LENGTH_SHORT).show();
                                                                                                        }
                                                                                                    }
                                                                                                });

                                                                                        pd.dismiss();

                                                                                    } else {
                                                                                        Toast.makeText(Register_for_candinate.this, "Failed", Toast.LENGTH_SHORT).show();
                                                                                    }
                                                                                }
                                                                            }).addOnFailureListener(new OnFailureListener() {
                                                                                @Override
                                                                                public void onFailure(@NonNull Exception e) {
                                                                                    Toast.makeText(Register_for_candinate.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                                                                }
                                                                            });

                                                                        } else {
                                                                            Toast.makeText(Register_for_candinate.this, "No image selected", Toast.LENGTH_SHORT).show();
                                                                            pd.dismiss();
                                                                        }


                                                                    }
                                                                });
                                                            }
                                                        }
                                                    });
                                                }
                                            }
                                        });
                                    }
                                }
                            });
                        }
                    }
                }
            }
        }
    }
}



