package com.example.android.coguide;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.hardware.Camera;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class camera extends Fragment  {
  public  Button b;
  public    ImageView img;
    private File mFile;
    private Camera mCamera;
    private TextureView myTexture;
    private TextView t,Awesome;
    private View rootview;
    private static final int CAN_REQUEST=1313;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


         rootview= inflater.inflate(R.layout.fragment_camera, container, false);
     //  TextureView t=(TextureView)rootview.findViewById(R.id.textureView1);
        Awesome=(TextView)rootview.findViewById(R.id.textView2);
        Awesome.setVisibility(View.INVISIBLE);
         t=(TextView)rootview.findViewById(R.id.textView);
        b=(Button)rootview.findViewById(R.id.smile);
        img =(ImageView)rootview.findViewById(R.id.photo);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String mCurrentPhotoPath;
                Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,CAN_REQUEST);

            }

        });


        //card View
        




       return rootview;


    }
/**/
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAN_REQUEST) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            img.setImageBitmap(bitmap);

             t.setText("");
             b.setEnabled(false);
            Awesome.setVisibility(View.VISIBLE);

           rootview.setBackgroundColor(Color.parseColor("#FFD0FAD0"));
        }
    }

}
