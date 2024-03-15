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

public class Register_for_voter extends AppCompatActivity {
    ImageView uploadPhoto, uploadAadhar, uploadLeave, uploadBirth,uploadAadharFront,uploadAadharBack;
    private Uri mImageUri, mImageUri1, mImageUri2, mImageUri3,mImageUri5,mImageUri6;
    EditText name, age, birthday, gender, address, mobile, email, password;
    Button btn_register;
    String myurl = "";

    FirebaseAuth auth;
    DatabaseReference reference;


    String miUrlOk = "";
    String miUrlOk1 = "";
    String miUrlOk2 = "";
    String miUrlOk3 = "";
    String miUrlOk5 = "";
    String miUrlOk6 = "";
    //private Uri mImageUri , pdfUri;

    private StorageReference mStorageRef;

    private StorageTask mUploadTask, mUploadTask1, mUploadTask2, mUploadTask3,mUploadTask5,mUploadTask6;


    private static final int PICK_IMAGE_REQUEST = 1;
    private static final int PICK_IMAGE_REQUEST2 = 2;
    private static final int PICK_IMAGE_REQUEST3 = 3;
    private static final int PICK_IMAGE_REQUEST4 = 4;
    private static final int PICK_IMAGE_REQUEST5 = 5;
    private static final int PICK_IMAGE_REQUEST6 = 6;

    /*
        private static final int PICK_PDF_REQUEST = 2;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_for_voter);


        //findidS
        uploadPhoto = findViewById(R.id.uploadImg);
     //   uploadAadhar = findViewById(R.id.upload_aadhar_img);
        uploadAadharFront = findViewById(R.id.upload_aadharfront_img);
        uploadAadharBack = findViewById(R.id.upload_aadharback_img);

        uploadLeave = findViewById(R.id.upload_leaving_img);
        uploadBirth = findViewById(R.id.upload_birthday_img);
        name = findViewById(R.id.name_data);
        age = findViewById(R.id.age_data);
        address = findViewById(R.id.address_data);
        birthday = findViewById(R.id.birth_data);
        gender = findViewById(R.id.gender_data);
        mobile = findViewById(R.id.mobile_data);
        email = findViewById(R.id.email_data);
        password = findViewById(R.id.password_data);
        btn_register = findViewById(R.id.sing_up);


        auth = FirebaseAuth.getInstance();


        uploadPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });

        /*uploadAadhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser2();
            }
        });
*/
        uploadLeave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser3();
            }
        });

        uploadBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser4();
            }
        });
        uploadAadharFront.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser5();
            }
        });
        uploadAadharBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser6();
            }
        });




        btn_register.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                String txt_birthday = Objects.requireNonNull(birthday.getText()).toString();

                String txt_age = Objects.requireNonNull(age.getText()).toString();
                String txt_gender = Objects.requireNonNull(gender.getText()).toString();
                String txt_mobile = Objects.requireNonNull(mobile.getText()).toString();
                String txt_name = Objects.requireNonNull(name.getText()).toString();
                String txt_email = Objects.requireNonNull(email.getText()).toString();
                String txt_password = Objects.requireNonNull(password.getText()).toString();
                String txt_address = Objects.requireNonNull(address.getText()).toString();

                    uploadFile(txt_name, txt_email, txt_password, txt_age, txt_birthday, txt_gender, txt_mobile, txt_address);

                }

        });

        mStorageRef = FirebaseStorage.getInstance().getReference("uploads");


        ProgressDialog dialog;


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            mImageUri = data.getData();


            Glide.with(uploadPhoto.getContext()).load(mImageUri).into(uploadPhoto);


        }
      /*  if (requestCode == PICK_IMAGE_REQUEST2 && resultCode == RESULT_OK
                && data != null && data.getData() != null) {

            mImageUri1 = data.getData();


            Glide.with(uploadAadhar.getContext()).load(mImageUri1).into(uploadAadhar);

        }*/
        if (requestCode == PICK_IMAGE_REQUEST4 && resultCode == RESULT_OK
                && data != null && data.getData() != null) {

            mImageUri2 = data.getData();


            Glide.with(uploadBirth.getContext()).load(mImageUri2).into(uploadBirth);

        }
        if (requestCode == PICK_IMAGE_REQUEST3 && resultCode == RESULT_OK
                && data != null && data.getData() != null) {

            mImageUri3 = data.getData();


            Glide.with(uploadLeave.getContext()).load(mImageUri3).into(uploadLeave);

        }
        if (requestCode == PICK_IMAGE_REQUEST5 && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            mImageUri5 = data.getData();


            Glide.with(uploadAadharFront.getContext()).load(mImageUri5).into(uploadAadharFront);


        }

        if (requestCode == PICK_IMAGE_REQUEST6 && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            mImageUri6 = data.getData();


            Glide.with(uploadAadharBack.getContext()).load(mImageUri6).into(uploadAadharBack);


        }





    }

    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    private void openFileChooser2() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST2);
    }

    private void openFileChooser3() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST3);
    }

    private void openFileChooser4() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST4);
    }

    private void openFileChooser6() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST6);
    }
    private void openFileChooser5() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST5);
    }

    private String getFileExtension(Uri uri) {
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }





    private void uploadFile(String txt_name, String txt_email, String txt_password, String txt_age, String txt_birthday, String txt_gender, String txt_mobile, String txt_address) {
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Uploading");
        pd.setCancelable(false);
        pd.show();
        if (mImageUri != null) {
            final StorageReference fileReference = mStorageRef.child(System.currentTimeMillis()
                    + "." + getFileExtension(mImageUri));
           /* if (mImageUri1 != null) {
                final StorageReference fileReference1 = mStorageRef.child(System.currentTimeMillis()
                        + "." + getFileExtension(mImageUri1));*/
                if (mImageUri2 != null) {
                    final StorageReference fileReference2 = mStorageRef.child(System.currentTimeMillis()
                            + "." + getFileExtension(mImageUri2));

                    if (mImageUri3 != null) {
                        final StorageReference fileReference3 = mStorageRef.child(System.currentTimeMillis()
                                + "." + getFileExtension(mImageUri3));


                        if (mImageUri5 != null) {
                            final StorageReference fileReference5 = mStorageRef.child(System.currentTimeMillis()
                                    + "." + getFileExtension(mImageUri5));

                            if (mImageUri6 != null) {
                                final StorageReference fileReference6 = mStorageRef.child(System.currentTimeMillis()
                                        + "." + getFileExtension(mImageUri6));


                        mUploadTask = fileReference.putFile(mImageUri);
                      //  mUploadTask1 = fileReference1.putFile(mImageUri1);
                        mUploadTask2 = fileReference2.putFile(mImageUri2);
                        mUploadTask3 = fileReference3.putFile(mImageUri3);
                                mUploadTask5 = fileReference5.putFile(mImageUri5);
                                mUploadTask6 = fileReference6.putFile(mImageUri6);

                           //FrontAadhar

                                mUploadTask5.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
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
                                            miUrlOk5 = downloadUri5.toString();

                                            //BackAadhar


                                            mUploadTask6.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
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
                                                        miUrlOk6 = downloadUri6.toString();


                                                        //leave

                                                        mUploadTask3.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
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
                                                                    miUrlOk3 = downloadUri3.toString();


                                   /* mUploadTask1.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                                        @Override
                                        public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                                            if (!task.isSuccessful()) {
                                                throw task.getException();
                                            }
                                            return fileReference1.getDownloadUrl();
                                        }
                                    }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Uri> task) {
                                            if (task.isSuccessful()) {


                                                Uri downloadUri1 = task.getResult();
                                                miUrlOk1 = downloadUri1.toString();
*/

                                                                    //birth
                                                                    mUploadTask2.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
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
                                                                                miUrlOk2 = downloadUri2.toString();
                                                                                //PHOTO
                                                                                mUploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
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
                                                                                            FirebaseAuth mAuthH = FirebaseAuth.getInstance();
                                                                                            FirebaseUser currentUser = mAuthH.getCurrentUser();

                                                                                            Uri downloadUri = task.getResult();
                                                                                            miUrlOk = downloadUri.toString();
                                                                                            if (currentUser != null) {
                                                                                                Toast.makeText(Register_for_voter.this, "Failed", Toast.LENGTH_SHORT).show();

                                                                                            } else {
                                                                                                auth.createUserWithEmailAndPassword(txt_email, txt_password)
                                                                                                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                                                                                            @Override
                                                                                                            public void onComplete(@NonNull Task<AuthResult> task) {
                                                                                                                if (task.isSuccessful()) {
                                                                                                                    FirebaseUser firebaseUser = auth.getCurrentUser();
                                                                                                                    assert firebaseUser != null;
                                                                                                                    String userid = firebaseUser.getUid();

                                                                                                                    reference = FirebaseDatabase.getInstance().getReference("Users").child(userid);

                                                                                                                    HashMap<String, String> hashMap = new HashMap<>();
                                                                                                                    hashMap.put("id", userid);
                                                                                                                    hashMap.put("isCandidate", "false");
                                                                                                                    hashMap.put("isvoter", "true");
                                                                                                                    hashMap.put("voted", "false");
                                                                                                                    hashMap.put("name", txt_name);
                                                                                                                    hashMap.put("email", txt_email);
                                                                                                                    hashMap.put("age", txt_age);
                                                                                                                    hashMap.put("birthday", txt_birthday);
                                                                                                                    hashMap.put("gender", txt_gender);
                                                                                                                    hashMap.put("mobile", txt_mobile);
                                                                                                                    hashMap.put("address", txt_address);
                                                                                                                    hashMap.put("isEnabled", "No");
                                                                                                                    hashMap.put("Photo", miUrlOk);
                                                                                                                    hashMap.put("AadharCardFront", miUrlOk5);
                                                                                                                    hashMap.put("AadharCardBack", miUrlOk6);
                                                                                                                    hashMap.put("BirthCertificate", miUrlOk2);
                                                                                                                    hashMap.put("leaving", miUrlOk3);


                                                                                                                    reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                                        @Override
                                                                                                                        public void onComplete(@NonNull Task<Void> task) {
                                                                                                                            if (task.isSuccessful()) {
                                                                                                                                Intent intent = new Intent(Register_for_voter.this, Choose_Login.class);
                                                                                                                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                                                                                                startActivity(intent);
                                                                                                                                finish();
                                                                                                                            }
                                                                                                                        }
                                                                                                                    });
                                                                                                                } else {
                                                                                                                    Toast.makeText(Register_for_voter.this, "You can't register with this email or password", Toast.LENGTH_SHORT).show();
                                                                                                                }
                                                                                                            }
                                                                                                        });

                                                                                                pd.dismiss();
                                                                                            }




                                                                                        } else {
                                                                                            Toast.makeText(Register_for_voter.this, "Failed", Toast.LENGTH_SHORT).show();
                                                                                        }
                                                                                    }
                                                                                }).addOnFailureListener(new OnFailureListener() {
                                                                                    @Override
                                                                                    public void onFailure(@NonNull Exception e) {
                                                                                        Toast.makeText(Register_for_voter.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                                                                    }
                                                                                });

                                                                            } else {
                                                                                Toast.makeText(Register_for_voter.this, "No image selected", Toast.LENGTH_SHORT).show();
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






















