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
public class LandmarksFragment extends Fragment {


    public LandmarksFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.object_list, container, false);



        final ArrayList<Object> objects = new ArrayList<Object>();


        objects.add(new Object(R.drawable.ic_castle_black_36dp, "Isar Fortress", "http://whereismacedonia.org/where-to-go-in-macedonia/cultural-heritage-in-macedonia/249-isar-fortress-in-stip", "https://www.google.mk/maps/place/Isar/@41.7386405,22.1852697"));
        objects.add(new Object(R.drawable.ic_pillar_black_36dp, "Late Antique town of Bargala", "http://whereismacedonia.org/where-to-go-in-macedonia/cultural-heritage-in-macedonia/250-bargala-late-antique-town-near-stip", "https://www.google.mk/maps/place/Bargala/@41.7973749,22.2889089,16.75z/data=!4m8!1m2!3m1!2sBargala!3m4!1s0x0:0x7f4387ad124c409d!8m2!3d41.7987115!4d22.2904605"));
        objects.add(new Object(R.drawable.ic_church_black_36dp, "St. Nicholas Church", "https://mk.wikipedia.org/wiki/%D0%A6%D1%80%D0%BA%D0%B2%D0%B0_%E2%80%9E%D0%A1%D0%B2._%D0%9D%D0%B8%D0%BA%D0%BE%D0%BB%D0%B0%E2%80%9C_-_%D0%A8%D1%82%D0%B8%D0%BF", "https://www.google.mk/maps/place/Church+\"St.+Nicholas\"/@41.7365886,22.1867073,17z"));
        objects.add(new Object(R.drawable.ic_bank_black_36dp, "City Museum", "http://stip.gov.mk/index.php/en/profile/culture/national-institutions/335-2009-12-11-09-07-22", "geo:41.7364945,22.1898536?q=41.7364945,22.1898536"));
        objects.add(new Object(R.drawable.ic_routes_black_36dp, "New Village", "https://mk.wikipedia.org/wiki/%D0%9D%D0%BE%D0%B2%D0%BE_%D0%A1%D0%B5%D0%BB%D0%BE_(%D0%A8%D1%82%D0%B8%D0%BF%D1%81%D0%BA%D0%BE)", "https://www.google.mk/maps/place/Novo+Selo,+Shtip/"));
        objects.add(new Object(R.drawable.ic_palette_black_36dp, "Bezisten Art Gallery", "http://www.stip.gov.mk/index.php/en/profile/culture/317-2009-12-10-13-46-35", "geo:41.737505, 22.192440?q=41.737505, 22.192440"));
        objects.add(new Object(R.drawable.ic_bell_ring_outline_black_36dp, "Old city clock", "http://www.stip.gov.mk/index.php/en/profile/culture/319-2009-12-10-13-53-27", "geo:41.7383511,22.1927712?q=41.7383511,22.1927712"));
        objects.add(new Object(R.drawable.ic_domain_black_36dp, "Trade Center", "http://www.porta3.mk/rekonstrukcija-na-trgovskiot-centar-vo-shtip/", "geo:41.738560, 22.196350?q=41.738560, 22.196350"));



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
