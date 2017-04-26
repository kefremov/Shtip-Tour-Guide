package com.example.android.shtiptourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class SchoolsFragment extends Fragment {

    public SchoolsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.object_list, container, false);

       

        final ArrayList<Object> objects = new ArrayList<Object>();


        objects.add(new Object(R.drawable.ic_school_black_36dp, "Goce Delchev University", "http://www.ugd.edu.mk/", "https://www.google.mk/maps/place/Rektorat+Goce+Delčev/"));
        objects.add(new Object(R.drawable.ic_chair_school_black_36dp, "Elementary school Vancho Prke", "http://www.oouvancoprkestip.edu.mk/", "https://www.google.mk/maps/place/ОУ+\"Ванчо+Прќе\"/"));
        objects.add(new Object(R.drawable.ic_chair_school_black_36dp, "Elementary school Goce Delchev", "http://www.komspi.mk/?p=1501", "https://www.google.mk/maps/place/Goce+Delcev/@41.7396472,22.1973874,17z"));
        objects.add(new Object(R.drawable.ic_chair_school_black_36dp, "Elementary school Dimitar Vlahov", "http://komspi.mk/en/?p=1498", "geo:41.750895, 22.202406?q=41.750895, 22.202406"));
        objects.add(new Object(R.drawable.ic_chair_school_black_36dp, "Elementary school Tosho Arsov", "http://www.komspi.mk/?p=1494", "https://www.google.mk/maps/place/Toso+Arsov/"));
        objects.add(new Object(R.drawable.ic_chair_school_black_36dp, "High school Gymnasium Slavcho Stojmenski", "http://slavcostojmenski.edu.mk/", "https://www.google.mk/maps/place/Slavcho+Stojmenski+High+School/"));
        objects.add(new Object(R.drawable.ic_chair_school_black_36dp, "Musical High school Sergej Mihajlov", "http://www.komspi.mk/?p=4389", "geo:41.738131, 22.191064?q=41.738131, 22.191064"));
        objects.add(new Object(R.drawable.ic_chair_school_black_36dp, "Electrical High school Kole Nehtenin", "http://kolenehtenin.edu.mk/", "https://www.google.mk/maps/place/С.О.У.+\"Коле+Нехтенин\""));



        ObjectAdapter adapter = new ObjectAdapter(getActivity(), objects);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Object object = objects.get(position);

                if(view.getId()==R.id.map) {

                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(object.getGeo()));
                    if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }

                else {

                    Uri webpage = Uri.parse(object.getUrl());
                    Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                    if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }

            }
        });

        return rootView;
    }
}
