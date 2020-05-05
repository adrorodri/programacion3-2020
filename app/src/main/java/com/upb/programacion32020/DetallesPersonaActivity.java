package com.upb.programacion32020;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import java.io.File;

public class DetallesPersonaActivity extends AppCompatActivity {

    ImageView imageViewPersona;
    Button buttonShare;
    ImageButton buttonCamera;
    ImageButton buttonGallery;
    Persona persona;
    Uri imageUri;

    static int REQUEST_CAMERA = 1234;
    static int REQUEST_GALLERY = 2468;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_persona);

        imageViewPersona = findViewById(R.id.ivPersona);
        buttonShare = findViewById(R.id.btShare);
        buttonCamera = findViewById(R.id.btChangePhoto);
        buttonGallery = findViewById(R.id.btGallery);

        File file = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "photo.jpg");
        imageUri = FileProvider.getUriForFile(
                this,
                "com.upb.programacion32020.provider",
                file);

        Intent intent = getIntent();
        if (intent.hasExtra("persona")) {
            persona = (Persona) intent.getSerializableExtra("persona");
            imageViewPersona.setImageResource(persona.getImage());
        }

        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "Hey, comparte la aplicacion con " + persona.getNombre());
                startActivity(intent);
            }
        });

        buttonCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(intent, REQUEST_CAMERA);
            }
        });

        buttonGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);
                startActivityForResult(Intent.createChooser(intent, "Selecciona una imagen:"), REQUEST_GALLERY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CAMERA && resultCode == RESULT_OK) {
//            Bitmap image = data.getParcelableExtra("data");
//            imageViewPersona.setImageBitmap(image);
            imageViewPersona.setImageURI(imageUri);
        }
        if (requestCode == REQUEST_GALLERY && resultCode == RESULT_OK) {
            imageViewPersona.setImageURI(data.getData());
        }
    }
}
