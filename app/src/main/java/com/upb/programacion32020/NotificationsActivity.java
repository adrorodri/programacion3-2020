package com.upb.programacion32020;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class NotificationsActivity extends AppCompatActivity {

    Button btToast;
    Button btDialog;
    Button btPopupMenu;
    Button btSnackBar;
    Button btNotification;

    CartSharedPreferencesManager cartSharedPreferencesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        cartSharedPreferencesManager = new CartSharedPreferencesManager(this);

        btToast = findViewById(R.id.btToast);
        btDialog = findViewById(R.id.btDialog);
        btPopupMenu = findViewById(R.id.btPopupMenu);
        btSnackBar = findViewById(R.id.btSnackBar);
        btNotification = findViewById(R.id.btNotification);

        createNotificationChannel();

        btToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(NotificationsActivity.this, "Ejemplo de Toast!", Toast.LENGTH_SHORT).show();
            }
        });

        btDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(NotificationsActivity.this);
                builder.setTitle("ALERTA");
                builder.setMessage("Estas seguro de borrar todo el carrito?");
                builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        cartSharedPreferencesManager.deleteAll();
                        Toast.makeText(NotificationsActivity.this, "Borrado correctamente", Toast.LENGTH_SHORT).show();
                        dialogInterface.cancel();
                    }
                });
                builder.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        btSnackBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Ejemplo de SnackBar!", BaseTransientBottomBar.LENGTH_LONG).show();
            }
        });

        btNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(NotificationsActivity.this, "123")
                        .setSmallIcon(R.drawable.ic_shark)
                        .setContentTitle("Farmacia Progra 3")
                        .setContentText("Recuerda que nuestras farmacias estan abiertas 24h")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(NotificationsActivity.this);
                notificationManager.notify(1234, builder.build());
            }
        });
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Notificaciones comunes";
            String description = "Cualquier notificacion de la app";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("123", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
