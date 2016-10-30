package id.sch.smktelkom_mlg.learn.intent3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.imageViewCamera)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       capturePhoto();
                    }
                });
    }
            static final int REQUEST_IMAGE_CAPTURE = 1;
            public void capturePhoto() {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
            }
@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK)
    {
        Bitmap bitmap = data.getParcelableExtra("data");
        ImageView iv = (ImageView) findViewById(R.id.imageViewCamera);
        iv.setImageBitmap(bitmap);
    }
}
    }

