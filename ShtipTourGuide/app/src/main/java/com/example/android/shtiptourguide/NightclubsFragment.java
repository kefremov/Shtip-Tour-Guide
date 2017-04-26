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


/**
 * A simple {@link Fragment} subclass.
 */
public class NightclubsFragment extends Fragment {


    public NightclubsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.object_list, container, false);



        final ArrayList<Object> objects = new ArrayList<Object>();


        objects.add(new Object(R.drawable.ic_glass_mug_black_36dp, "Dublin Pub", "https://www.facebook.com/dublinpubstip/", "geo:41.736905, 22.192238?q=41.736905, 22.192238"));
        objects.add(new Object(R.drawable.ic_local_bar_black_36dp, "Piano Bar", "https://www.facebook.com/piano.bar.1217", "geo:41.737221, 22.192166?q=41.737221, 22.192166"));
        objects.add(new Object(R.drawable.ic_glass_mug_black_36dp, "Youth Center", "https://www.facebook.com/pages/Dom-Na-Mladi/264430896972366", "geo:41.739869, 22.188386?q=41.739869, 22.188386"));
        objects.add(new Object(R.drawable.ic_local_cafe_black_36dp, "Cafe Jet", "https://www.facebook.com/cafejet/", "geo:41.738516, 22.194277?q=41.738516, 22.194277"));
        objects.add(new Object(R.drawable.ic_local_bar_black_36dp, "Club Mystic", "https://www.facebook.com/club-MYSTIC-stip-1442873772601273/", "geo:41.738342, 22.193941?q=41.738342, 22.193941"));
        objects.add(new Object(R.drawable.ic_local_cafe_black_36dp, "Coffee Lab", "https://www.facebook.com/coffeelabmk/", "geo:41.738573, 22.195884?q=41.738573, 22.195884"));
        objects.add(new Object(R.drawable.ic_local_cafe_black_36dp, "Doma", "https://www.facebook.com/%D0%94%D0%9E%D0%9C%D0%90-343925242475651/", "geo:41.737127, 22.191447?q=41.737127, 22.191447"));
        objects.add(new Object(R.drawable.ic_local_cafe_black_36dp, "Square Pub", "https://www.facebook.com/pages/Square-Pub/161562263899774", "geo:41.738331, 22.194467?q=41.738331, 22.194467"));



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
