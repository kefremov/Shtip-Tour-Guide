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
public class RestaurantsFragment extends Fragment {


    public RestaurantsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.object_list, container, false);



        final ArrayList<Object> objects = new ArrayList<Object>();


        objects.add(new Object(R.drawable.ic_restaurant_black_36dp, "Merak", "https://www.facebook.com/CafeRestorantKazablanka/", "geo:41.748035, 22.181270?q=41.748035, 22.181270"));
        objects.add(new Object(R.drawable.ic_restaurant_black_36dp, "Necko", "http://necko.mk/", "geo:41.748209, 22.183627?q=41.748209, 22.183627"));
        objects.add(new Object(R.drawable.ic_restaurant_black_36dp, "Longurov", "https://www.facebook.com/Ultra-Restoran-Longurov-640857625943824/", "geo:41.747246, 22.183827?q=41.747246, 22.183827"));
        objects.add(new Object(R.drawable.ic_local_cafe_black_36dp, "Matis Jazz Art Club", "https://www.facebook.com/Matis-Jazz-Art-Club-474906829273825/", "geo:41.737105, 22.192962?q=41.737105, 22.192962"));
        objects.add(new Object(R.drawable.ic_food_black_36dp, "Fast food Bambi", "https://www.getlokal.mk/mk/stip/bambi-4", "geo:41.737111, 22.193446?q=41.737111, 22.193446"));
        objects.add(new Object(R.drawable.ic_restaurant_menu_black_36dp, "Jaja bakery", "https://www.facebook.com/Pekara-jaja-534551590034668/", "geo:41.737127, 22.193269?q=41.737127, 22.193269"));
        objects.add(new Object(R.drawable.ic_food_black_36dp, "Fresh Burger", "https://www.facebook.com/freshburgerstip/", "geo:41.738379, 22.193592?q=41.738379, 22.193592"));
        objects.add(new Object(R.drawable.ic_food_black_36dp, "Hambi", "https://restaurant.cybo.com/MK-biz/hambi", "geo:41.738426, 22.193691?q=41.738426, 22.193691"));



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
