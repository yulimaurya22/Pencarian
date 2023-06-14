package com.virnanda.candiindonesia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;

public class Notifikasi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifikasi);
    }
    private void createNotif(){    {
        String id = "Gambar_Candi_Baru";
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
       if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.0)
       {
           NotificationChannel channel =manager.getNotificationChannel(id);
           if(channel == null)
           {
               channel = new NotificationChannel(id, "candi terbaru", NotificationManager.IMPORTANCE_HIGH);
               channel.setDescription("[Channel description]");
               channel.enableVibration(true);
               channel.setVibrationPattern(new long []{100,1000,200,300});
               channel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
               manager.createNotificationChannel(channel);
           }
       }
        Intent notificationIntent = new Intent(this,Notifikasi.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent contentIntent =PendingIntent.getActivity(this,0,notificationIntent,0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,id)
                .setSmallIcon(R.drawable.icon)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.bg))
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.bg))
                        .bigLargeIcone(null))


    }