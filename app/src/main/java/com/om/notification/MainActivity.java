package com.om.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.om.notification.createchannel.CreateChannel;

public class MainActivity extends AppCompatActivity {
Button button,button1;
 NotificationManagerCompat notificationManagerCompat;
 int count1=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManagerCompat=NotificationManagerCompat.from(this);
        CreateChannel channel = new CreateChannel(this);
        channel.createChannel();

        button=findViewById(R.id.notify1);
        button1=findViewById(R.id.notify2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNotification2();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNotification1();
            }
        });
    }

    private void DisplayNotification2() {
        count1++;

        Notification notification=new NotificationCompat.Builder(this,CreateChannel.CHANNEL_2)
                .setSmallIcon(R.drawable.ic_message_black_24dp)
                .setContentTitle("Hangouts")
                .setContentText("You got friend request")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(count1,notification);

    }

    private void DisplayNotification1() {
        count1++;
        Notification notification=new NotificationCompat.Builder(this,CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_message_black_24dp)
                .setContentTitle("Facebook")
                .setContentText("You got friend request")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(count1,notification);


    }
}
