package com.upb.programacion32020;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Parent Linear Layout
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        setContentView(linearLayout);

        // Header Text View
        TextView textViewHeader = new TextView(this);
        textViewHeader.setGravity(Gravity.CENTER);
        textViewHeader.setBackgroundResource(R.color.colorLightBlue);
        textViewHeader.setTextColor(ContextCompat.getColor(this, R.color.colorWhite));
        linearLayout.addView(textViewHeader);

        // Top Linear Layout
        LinearLayout linearLayoutButtons1 = new LinearLayout(this);
        linearLayoutButtons1.setOrientation(LinearLayout.HORIZONTAL);
        linearLayoutButtons1.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));

        Button buttonEditar = new Button(this);
        buttonEditar.setText(R.string.main_menu_button_edit);
        buttonEditar.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f));
        buttonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EditarActivity.class);
                startActivity(intent);
            }
        });

        Button buttonProductos = new Button(this);
        buttonProductos.setText(R.string.main_menu_button_products);
        buttonProductos.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f));
        buttonProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProductosActivity.class);
                startActivity(intent);
            }
        });

        linearLayoutButtons1.addView(buttonEditar);
        linearLayoutButtons1.addView(buttonProductos);

        // Bottom Linear Layout
        LinearLayout linearLayoutButtons2 = new LinearLayout(this);
        linearLayoutButtons2.setOrientation(LinearLayout.HORIZONTAL);
        linearLayoutButtons2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));

        Button buttonDelivery = new Button(this);
        buttonDelivery.setText(R.string.main_menu_button_delivery);
        buttonDelivery.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f));

        Button buttonSalir = new Button(this);
        buttonSalir.setText(R.string.main_menu_button_exit);
        buttonSalir.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f));

        linearLayoutButtons2.addView(buttonDelivery);
        linearLayoutButtons2.addView(buttonSalir);

        linearLayout.addView(linearLayoutButtons1);
        linearLayout.addView(linearLayoutButtons2);


        Intent intent = getIntent();
        if (intent.hasExtra("adminEnabled")) {
            boolean adminEnabled = intent.getBooleanExtra("adminEnabled", false);
            buttonEditar.setEnabled(adminEnabled);
        }

        if (intent.hasExtra("user")) {
            user = (Usuario) intent.getSerializableExtra("user");
            if (user != null) {
                textViewHeader.setText("Bienvenido " + user.getUsername() + "!");
            }
        }

        buttonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("nombre", user.getUsername());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
