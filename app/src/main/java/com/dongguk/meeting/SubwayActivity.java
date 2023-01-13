package com.dongguk.meeting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubwayActivity extends AppCompatActivity {


    // 가까운 역 찾기 위한 변수
    Call<SubwayResultSet> call, call2, call3;
    String lang = "0";
    String CID = "1000";
    String Sopt = "1";
    String apiKey = "3qhygnrwYaEAhYr8/NKH+Vv0i0ZcsLW/YrVaBbY4toQ";


    ArrayList<String> depart_1 = new ArrayList<>();
    ArrayList<String> same_station = new ArrayList<>();
    private TextView txt1, txt2, txt3;
    String station_1, station_2, station_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subway);
        getSupportActionBar().setTitle("3. 중간 위치 탐색");

        // 인텐트 데이터 받기
        Intent intent = getIntent();
        station_1 = intent.getStringExtra("station_1");
        station_2 = intent.getStringExtra("station_2");
        station_3 = intent.getStringExtra("station_3");

        txt1 = findViewById(R.id.txt1); txt2 = findViewById(R.id.txt2); txt3 = findViewById(R.id.txt3);
        // call 1 호출
        call = retrofit_client.getApiService2().test_api_get(lang, CID, station_1, station_2, Sopt, apiKey);
        call.enqueue(new Callback<SubwayResultSet>(){
            //콜백 받는 부분
            @Override
            public void onResponse(Call<SubwayResultSet> call, Response<SubwayResultSet> response) {
                SubwayResultSet result = response.body();
                String str = result.getResult().getGlobalTravelTime().toString();

                int line = 0;

                List<SubwayStation> stations = result.getResult().getStationSet().getStations();
                for(int i = 0 ; i < stations.size(); i++) {
                    if(i==0) {
                        str = "  " + stations.get(i).getStartName() + "역에서 총 " + result.getResult().getGlobalTravelTime().toString() + "분이 소요됩니다.\n";
                        line = stations.get(i).getStartID() / 100;
                        str += "  [" + line + "호선] ";
                    }

                    if((stations.get(i).getStartID() / 100) != line) {
                        str += "\n  [" + stations.get(i).getStartName() + "역 환승] " + line + "호선 → " + (stations.get(i).getStartID() / 100) + "호선";
                        line = stations.get(i).getStartID() / 100;
                        str += "\n  [" + line + "호선] ";
                    }

                    str += stations.get(i).getStartName() + "  ";
                    depart_1.add(stations.get(i).getStartName());

                    if((i+1) == stations.size()) {
                        str += stations.get(i).getEndName();
                        depart_1.add(stations.get(i).getStartName());
                    }
                }

                txt1.setText(str);
                Log.e("wonny-depart_1 크기", String.valueOf(depart_1.size()));

                // call 2 호출
                call2 = retrofit_client.getApiService2().test_api_get(lang, CID, station_2, station_3, Sopt, apiKey);
                call2.enqueue(new Callback<SubwayResultSet>(){
                    //콜백 받는 부분
                    @Override
                    public void onResponse(Call<SubwayResultSet> call, Response<SubwayResultSet> response) {
                        SubwayResultSet result = response.body();
                        String str = result.getResult().getGlobalTravelTime().toString();
                        String str2 = "\n 겹친역 : ";
                        List<SubwayStation> stations = result.getResult().getStationSet().getStations();

                        int line = 0;
                        for(int i = 0 ; i < stations.size(); i++) {
                            if(i==0) {
                                str = "  " + stations.get(i).getStartName() + "역에서 총 " + result.getResult().getGlobalTravelTime().toString() + "분이 소요됩니다.\n";
                                line = stations.get(i).getStartID() / 100;
                                str += "  [" + line + "호선] ";
                            }

                            if((stations.get(i).getStartID() / 100) != line) {
                                str += "\n  [" + stations.get(i).getStartName() + "역 환승] " + line + "호선 → " + (stations.get(i).getStartID() / 100) + "호선";
                                line = stations.get(i).getStartID() / 100;
                                str += "\n  [" + line + "호선] ";
                            }

                            str += stations.get(i).getStartName() + "  ";

                            if(depart_1.contains(stations.get(i).getStartName())) {
                                same_station.add(stations.get(i).getStartName());
                                str2 += stations.get(i).getStartName() + " ";
                            }

                            if((i+1) == stations.size())
                                str += stations.get(i).getEndName();
                        }

                        txt2.setText(str);
//                        txt2.setText(str + str2);
                        Log.e("wonny-same_station 크기", String.valueOf(same_station.size()));

                        // call3 호출
                        call3 = retrofit_client.getApiService2().test_api_get(lang, CID, station_3, station_1, Sopt, apiKey);
                        call3.enqueue(new Callback<SubwayResultSet>(){
                            //콜백 받는 부분
                            @Override
                            public void onResponse(Call<SubwayResultSet> call, Response<SubwayResultSet> response) {
                                SubwayResultSet result = response.body();
                                String str = result.getResult().getGlobalTravelTime().toString();
                                String str2 = "\n 겹친역 : ";

                                List<SubwayStation> stations = result.getResult().getStationSet().getStations();
                                ArrayList<String> temp = (ArrayList<String>) same_station.clone();
                                same_station.clear();
                                Log.e("wonny-temp 크기", String.valueOf(temp.size()));

                                int line = 0;

                                for(int i = 0 ; i < stations.size(); i++) {
                                    if(i==0) {
                                        str = "  " + stations.get(i).getStartName() + "역에서 총 " + result.getResult().getGlobalTravelTime().toString() + "분이 소요됩니다.\n";
                                        line = stations.get(i).getStartID() / 100;
                                        str += "  [" + line + "호선] ";
                                    }

                                    if((stations.get(i).getStartID() / 100) != line) {
                                        str += "\n  [" + stations.get(i).getStartName() + "역 환승] " + line + "호선 → " + (stations.get(i).getStartID() / 100) + "호선";
                                        line = stations.get(i).getStartID() / 100;
                                        str += "\n  [" + line + "호선] ";
                                    }

                                    str += stations.get(i).getStartName() + "  ";

                                    if(temp.contains(stations.get(i).getStartName())) {
                                        same_station.add(stations.get(i).getStartName());
                                        str2 += stations.get(i).getStartName() + " ";
                                    }

                                    if((i+1) == stations.size())
                                        str += stations.get(i).getEndName();
                                }

//                                txt3.setText(str + str2);
                                txt3.setText(str);
                                Log.e("wonny-same_station-2 크기", String.valueOf(same_station.size()));


                            }

                            @Override
                            public void onFailure(Call<SubwayResultSet> call, Throwable t) {

                            }
                        });
                        // call3 end

                    } // call 2 onRespose

                    @Override
                    public void onFailure(Call<SubwayResultSet> call, Throwable t) {

                    }
                }); // call 2 end

            } // call 1 onRespose

            @Override
            public void onFailure(Call<SubwayResultSet> call, Throwable t) {

            }
        });


    }
}