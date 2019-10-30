package com.tnt.homestays.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tnt.homestays.R;

public class DetailHomeActivity extends AppCompatActivity {
    private ImageView imgHome;
    private TextView tvTitle;
    private TextView tvAddress;
    private TextView tvArea;
    private TextView tvPhone;
    private TextView tvDes;
    private TextView tvPrice;
    private FloatingActionButton flbMore;
    private String imgages;
    private String title;
    private String address;
    private String area;
    private String phone;
    private String des;
    private String price;
    BottomSheetDialog bottomSheetDialog;
    private LinearLayout lnCall;
    private LinearLayout lnLocation;
    private LinearLayout lnShare;
    private LinearLayout lnClose;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_home);
        init();
        createBottomSheetDialog();
        Intent intent = getIntent();
        imgages = intent.getStringExtra("img");
        title = intent.getStringExtra("title");
        address = intent.getStringExtra("address");
        area = intent.getStringExtra("area");
        phone = intent.getStringExtra("phone");
        des = intent.getStringExtra("des");
        price = intent.getStringExtra("price");

        Glide.with(this).load(imgages).into(imgHome);
        tvTitle.setText(title);
        tvAddress.setText(address);
        tvArea.setText(area);
        tvPhone.setText(phone);
        tvDes.setText(des);
        tvPrice.setText(price + "/Tháng");
    }

    private void init() {

        imgHome = (ImageView) findViewById(R.id.imgHome);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvAddress = (TextView) findViewById(R.id.tvAddress);
        tvArea = (TextView) findViewById(R.id.tvArea);
        tvPhone = (TextView) findViewById(R.id.tvPhone);
        tvDes = (TextView) findViewById(R.id.tvDes);
        tvPrice = (TextView) findViewById(R.id.tvPrice);
        flbMore = findViewById(R.id.flbMore);

        flbMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.show();
            }
        });

    }

    private void createBottomSheetDialog() {
        if (bottomSheetDialog == null) {
            View view = LayoutInflater.from(this).inflate(R.layout.dialog_bottom_detail_home, null);
            lnCall = (LinearLayout) view.findViewById(R.id.lnCall);
            lnLocation = (LinearLayout) view.findViewById(R.id.lnLocation);
            lnShare = (LinearLayout) view.findViewById(R.id.lnShare);
            lnClose = (LinearLayout) view.findViewById(R.id.lnClose);

            lnClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    bottomSheetDialog.dismiss();
                }
            });

            lnCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(Intent.ACTION_DIAL);
                    String p = "tel:" + phone;
                    i.setData(Uri.parse(p));
                    startActivity(i);
//                    Toast.makeText(DetailHomeActivity.this, "Coming soon", Toast.LENGTH_SHORT).show();
                    bottomSheetDialog.dismiss();
                }
            });

            lnLocation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(DetailHomeActivity.this, "Coming soon", Toast.LENGTH_SHORT).show();
                    bottomSheetDialog.dismiss();
                }
            });

            lnShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                    intent.putExtra(Intent.EXTRA_TEXT, "This is my text");
                    startActivity(Intent.createChooser(intent, "choose one"));
                    bottomSheetDialog.dismiss();
                }
            });
            bottomSheetDialog = new BottomSheetDialog(this);
            bottomSheetDialog.setContentView(view);
            FrameLayout bottomSheet = (FrameLayout) bottomSheetDialog.findViewById(R.id.design_bottom_sheet);
            bottomSheet.setBackground(null);
        }
    }

    public void onClickBackToMain(View view) {
        finish();
    }

}
