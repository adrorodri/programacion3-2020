package com.upb.programacion32020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class EditarActivity extends AppCompatActivity {

    ToggleButton toggleButton;
    ImageView ivFarmacia;
    ImageButton ibRuler;
    TextView tvScaleType;
    RadioGroup rgCajeros;

    // SOLO EJEMPLO PARA ENUMS
    private enum TipoManzana {
        ROJO,
        VERDE
    }

    // SOLO EJEMPLO PARA ENUMS
    private class Manzana {
        double peso;
        TipoManzana tipo;

        public Manzana(double peso, TipoManzana tipo) {
            this.peso = peso;
            this.tipo = tipo;
        }
    }

    ImageView.ScaleType currentScaleType = ImageView.ScaleType.CENTER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        // SOLO EJEMPLO PARA ENUMS
        Manzana manzana = new Manzana(150.77, TipoManzana.VERDE);

        toggleButton = findViewById(R.id.tb_pago_tarjeta);
        ivFarmacia = findViewById(R.id.iv_farmacia);
        ibRuler = findViewById(R.id.ib_ruler);
        tvScaleType = findViewById(R.id.tv_scaleType);
        rgCajeros = findViewById(R.id.rg_cajeros);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (checked) {
                    Toast.makeText(EditarActivity.this, "Tarjeta de Credito Activada", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EditarActivity.this, "Tarjeta de Credito Desactivada", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ivFarmacia.setScaleType(currentScaleType);
        tvScaleType.setText(currentScaleType.toString());

        ibRuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (currentScaleType) {
                    case CENTER:
                        currentScaleType = ImageView.ScaleType.CENTER_CROP;
                        break;
                    case CENTER_CROP:
                        currentScaleType = ImageView.ScaleType.CENTER_INSIDE;
                        break;
                    case CENTER_INSIDE:
                        currentScaleType = ImageView.ScaleType.MATRIX;
                        break;
                    case MATRIX:
                        currentScaleType = ImageView.ScaleType.FIT_XY;
                        break;
                    case FIT_XY:
                        currentScaleType = ImageView.ScaleType.FIT_START;
                        break;
                    case FIT_START:
                        currentScaleType = ImageView.ScaleType.FIT_CENTER;
                        break;
                    case FIT_CENTER:
                        currentScaleType = ImageView.ScaleType.FIT_END;
                        break;
                    case FIT_END:
                        currentScaleType = ImageView.ScaleType.CENTER;
                        break;
                }

                ivFarmacia.setScaleType(currentScaleType);
                tvScaleType.setText(currentScaleType.toString());
            }
        });

        rgCajeros.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                switch (id) {
                    case R.id.rb_cajero_1: {
                        Toast.makeText(EditarActivity.this, "CAJERO 1 SELECCIONADO", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.rb_cajero_2: {
                        Toast.makeText(EditarActivity.this, "CAJERO 2 SELECCIONADO", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.rb_cajero_3: {
                        Toast.makeText(EditarActivity.this, "CAJERO 3 SELECCIONADO", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
            }
        });
    }
}
