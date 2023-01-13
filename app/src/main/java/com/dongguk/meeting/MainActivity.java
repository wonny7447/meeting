package com.dongguk.meeting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btn_next;
    private EditText ed_address1, ed_address2, ed_address3;
    List<Address> addr_list1, addr_list2, addr_list3 = null;
    String addr1, addr2, addr3 = null;
    String x_1, x_2, x_3, y_1, y_2, y_3 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("1. 각자의 출발 위치 입력");

        final Geocoder geocoder = new Geocoder(this);

        // 레이아웃 변수 선언
        btn_next = (Button)findViewById(R.id.button);
        ed_address1 = (EditText)findViewById(R.id.ed_address1);
        ed_address2 = (EditText)findViewById(R.id.ed_address2);
        ed_address3 = (EditText)findViewById(R.id.ed_address3);

        // 버튼 클릭 시 이벤트
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 입력한 주소에 대한 위도, 경도 찾기
                addr1 = ed_address1.getText().toString();
                addr2 = ed_address2.getText().toString();
                addr3 = ed_address3.getText().toString();

                try {
                    addr_list1 = geocoder.getFromLocationName(addr1,10); // 지역이름, 읽을 개수
                    addr_list2 = geocoder.getFromLocationName(addr2,10); // 지역이름, 읽을 개수
                    addr_list3 = geocoder.getFromLocationName(addr3,10); // 지역이름, 읽을 개수
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e("wonny","입출력 오류 - 서버에서 주소변환시 에러발생");
                }
                if (addr_list1 != null) {
                    if (addr_list1.size() == 0) {
                        Log.e("wonny","주소1 : 해당되는 주소 정보는 없습니다");
                    } else {
                        x_1 = String.valueOf(addr_list1.get(0).getLongitude());
                        y_1 = String.valueOf(addr_list1.get(0).getLatitude());
                    }
                }
                if (addr_list2 != null) {
                    if (addr_list2.size() == 0) {
                        Log.e("wonny","주소2 : 해당되는 주소 정보는 없습니다");
                    } else {
                        x_2 = String.valueOf(addr_list2.get(0).getLongitude());
                        y_2 = String.valueOf(addr_list2.get(0).getLatitude());
                    }
                }
                if (addr_list3 != null) {
                    if (addr_list3.size() == 0) {
                        Log.e("wonny","주소3 : 해당되는 주소 정보는 없습니다");
                    } else {
                        x_3 = String.valueOf(addr_list3.get(0).getLongitude());
                        y_3 = String.valueOf(addr_list3.get(0).getLatitude());
                    }
                }


                // 화면 전환
                Intent intent = new Intent(getApplicationContext(), FindNearStationActivity.class);
                intent.putExtra("addr1", addr1);
                intent.putExtra("addr2", addr2);
                intent.putExtra("addr3", addr3);
                intent.putExtra("x_1", x_1);    intent.putExtra("y_1", y_1);
                intent.putExtra("x_2", x_2);    intent.putExtra("y_2", y_2);
                intent.putExtra("x_3", x_3);    intent.putExtra("y_3", y_3);
                startActivity(intent);
            }
        });
        // OnClick
    }
}