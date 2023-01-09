package com.dongguk.meeting;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FindNearStationActivity extends AppCompatActivity {

    // 지오코딩 결과를 인텐트로 받을 변수
    String addr1, addr2, addr3, x_1, x_2, x_3, y_1, y_2, y_3 = "";
    private TextView txt1, txt2, txt3, txt1_station, txt2_station, txt3_station;
    private Button btn_next;

    // 가까운 역 찾기 위한 변수
    Call<data_model> call, call2, call3;
    String lang = "0";
    String radius = "1000";
    String stationClass = "2";
    String apiKey = "3qhygnrwYaEAhYr8/NKH+Vv0i0ZcsLW/YrVaBbY4toQ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_near_station);

        // 인텐트 데이터 받기
        Intent intent = getIntent();
        addr1 = intent.getStringExtra("addr1"); x_1 = intent.getStringExtra("x_1"); y_1 = intent.getStringExtra("y_1");
        addr2 = intent.getStringExtra("addr2"); x_2 = intent.getStringExtra("x_2"); y_2 = intent.getStringExtra("y_2");
        addr3 = intent.getStringExtra("addr3"); x_3 = intent.getStringExtra("x_3"); y_3 = intent.getStringExtra("y_3");

        txt1 = findViewById(R.id.txt1);  txt1.setText(addr1 + " : " + x_1 + ", " + y_1);
        txt2 = findViewById(R.id.txt2);  txt2.setText(addr2 + " : " + x_2 + ", " + y_2);
        txt3 = findViewById(R.id.txt3);  txt3.setText(addr3 + " : " + x_3 + ", " + y_3);

        btn_next = (Button)findViewById(R.id.button);
        txt1_station = findViewById(R.id.txt1_station);
        txt2_station = findViewById(R.id.txt2_station);
        txt3_station = findViewById(R.id.txt3_station);

        // 버튼 클릭 시 이벤트
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 현재 위도, 경도를 기점으로 가까운 지하철 역 찾기
                call = retrofit_client.getApiService().test_api_get(lang, x_1, y_1, radius, stationClass, apiKey);
                call.enqueue(new Callback<data_model>(){
                    //콜백 받는 부분
                    @Override
                    public void onResponse(Call<data_model> call, Response<data_model> response) {
                        data_model result = response.body();
                        String str = "";

                        int count = result.getResult().getCount();
                        List<Station> stationList = result.getResult().getStation();
                        if(count > 0) {
                            str = "[" + stationList.get(0).getType() + "호선] " + stationList.get(0).getStationName() + "역 (" + stationList.get(0).getStationID() + ")";
                        } else {
                            str = "일치하는 역이 없습니다";
                        }
                        txt1_station.setText(str);
                    }

                    @Override
                    public void onFailure(Call<data_model> call, Throwable t) {

                    }
                });
                // call1 end

                call2 = retrofit_client.getApiService().test_api_get(lang, x_2, y_2, radius, stationClass, apiKey);
                call2.enqueue(new Callback<data_model>(){
                    //콜백 받는 부분
                    @Override
                    public void onResponse(Call<data_model> call, Response<data_model> response) {
                        data_model result = response.body();
                        String str = "";

                        int count = result.getResult().getCount();
                        List<Station> stationList = result.getResult().getStation();
                        if(count > 0) {
                            str = "[" + stationList.get(0).getType() + "호선] " + stationList.get(0).getStationName() + "역 (" + stationList.get(0).getStationID() + ")";
                        } else {
                            str = "일치하는 역이 없습니다";
                        }
                        txt2_station.setText(str);
                    }

                    @Override
                    public void onFailure(Call<data_model> call, Throwable t) {

                    }
                });
                // call1 end

                call3 = retrofit_client.getApiService().test_api_get(lang, x_3, y_3, radius, stationClass, apiKey);
                call3.enqueue(new Callback<data_model>(){
                    //콜백 받는 부분
                    @Override
                    public void onResponse(Call<data_model> call, Response<data_model> response) {
                        data_model result = response.body();
                        String str = "";

                        int count = result.getResult().getCount();
                        List<Station> stationList = result.getResult().getStation();
                        if(count > 0) {
                            str = "[" + stationList.get(0).getType() + "호선] " + stationList.get(0).getStationName() + "역 (" + stationList.get(0).getStationID() + ")";
                        } else {
                            str = "일치하는 역이 없습니다";
                        }
                        txt3_station.setText(str);
                    }

                    @Override
                    public void onFailure(Call<data_model> call, Throwable t) {

                    }
                });
                // call1 end
            }
        });
        // OnClick



    }
}