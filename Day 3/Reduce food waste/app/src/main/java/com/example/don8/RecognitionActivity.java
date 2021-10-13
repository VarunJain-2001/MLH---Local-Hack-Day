package com.example.don8;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.label.FirebaseVisionImageLabel;
import com.google.firebase.ml.vision.label.FirebaseVisionImageLabeler;
import com.google.firebase.ml.vision.label.FirebaseVisionOnDeviceImageLabelerOptions;
import com.wonderkiln.camerakit.CameraKitError;
import com.wonderkiln.camerakit.CameraKitEvent;
import com.wonderkiln.camerakit.CameraKitEventListener;
import com.wonderkiln.camerakit.CameraKitImage;
import com.wonderkiln.camerakit.CameraKitVideo;
import com.wonderkiln.camerakit.CameraView;

import java.io.ByteArrayOutputStream;
import java.util.List;

import dmax.dialog.SpotsDialog;

//import com.google.firebase.ml.vision.label.FirebaseVisionCloudImageLabelerOptions;

public class RecognitionActivity extends AppCompatActivity {
    private static final int MY_CAMERA_REQUEST_CODE = 100;
    Intent anotherIntent;
    public Bitmap imageCaptured;
    CameraView cameraView;
    Button btnDetect;
    AlertDialog waitingDialog;
    @Override
    protected void onResume() {
        super.onResume();
        if (ContextCompat.checkSelfPermission(RecognitionActivity.this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_DENIED){
//            permission not granted
        }
        else {
            ActivityCompat.requestPermissions(RecognitionActivity.this, new String[] {Manifest.permission.CAMERA}, MY_CAMERA_REQUEST_CODE);
        }
        cameraView.start();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case MY_CAMERA_REQUEST_CODE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        cameraView.stop();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recognition); // not sure if this should be for another storyboard?
        anotherIntent = new Intent(RecognitionActivity.this, ConfirmationActivity.class);
        cameraView = (CameraView)findViewById(R.id.camera_view);
        btnDetect = (Button) findViewById(R.id.btn_detect);
        waitingDialog = new SpotsDialog.Builder()
                .setContext(this)
                .setMessage("Please wait...")
                .setCancelable(false).build();
        cameraView.addCameraKitListener(new CameraKitEventListener() {
            @Override
            public void onEvent(CameraKitEvent cameraKitEvent) {
            }
            @Override
            public void onError(CameraKitError cameraKitError) {
            }
            @Override
            public void onImage(CameraKitImage cameraKitImage) {
                //System.out.println("YUII");
                waitingDialog.show();
                //System.out.println("BEFE");
                Bitmap bitmap = cameraKitImage.getBitmap();
                //System.out.println("Test 1" + bitmap);
                bitmap = Bitmap.createScaledBitmap(bitmap, cameraView.getWidth(), cameraView.getHeight(), false);
                imageCaptured=bitmap;
                ImageView mImg;
                mImg = (ImageView) findViewById(R.id.imageView);
                mImg.setImageBitmap(imageCaptured);


                System.out.println("stopped here");
                cameraView.stop();

                runDetector(bitmap);
            }
            @Override
            public void onVideo(CameraKitVideo cameraKitVideo) {
            }
        });

        btnDetect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cameraView.start();
                cameraView.captureImage();
//                System.out.println(imageCaptured);
//                ImageView imageView=(ImageView) findViewById(R.id.imageView);
//                Bitmap image=((BitmapDrawable) imageView.getDrawable()).getBitmap();
//                anotherIntent.putExtra("image", image);
                //startActivity(anotherIntent);


            }
        });
    }
    private void runDetector(Bitmap bitmap) {
        FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(bitmap);
        cameraView.stop();
        FirebaseVisionOnDeviceImageLabelerOptions options =
                new FirebaseVisionOnDeviceImageLabelerOptions.Builder()
                        .setConfidenceThreshold(0.8f)
                        .build();
        FirebaseVisionImageLabeler detector = FirebaseVision.getInstance().getOnDeviceImageLabeler(options);
        detector.processImage(image).addOnSuccessListener(new OnSuccessListener<List<FirebaseVisionImageLabel>>() {
            @Override
            public void onSuccess(List<FirebaseVisionImageLabel> firebaseVisionImageLabels) {
                processDataResults(firebaseVisionImageLabels);

                //switch to donation, pass the information

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("Error Found", e.getMessage());
            }
        });
//        FirebaseVisionImageLabeler labeler = FirebaseVision.getInstance()
//                .getOnDeviceImageLabeler();
//
//        labeler.processImage(image)
//                .addOnSuccessListener(new OnSuccessListener<List<FirebaseVisionImageLabel>>() {
//                    @Override
//                    public void onSuccess(List<FirebaseVisionImageLabel> labels) {
//                        // Task completed successfully
//                        // ...
//                       processDataResults(labels);
//
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        // Task failed with an exception
//                        // ...
//                        Log.d("Error", e.getMessage());
//                    }
//                });
    }
    private void processDataResults(List<FirebaseVisionImageLabel> labels){
        for(FirebaseVisionImageLabel label: labels){
            Toast.makeText(this, "Image result: " + label.getText(), Toast.LENGTH_SHORT).show();
        }
        if(waitingDialog.isShowing()) {
            waitingDialog.dismiss();
        }
    }
}