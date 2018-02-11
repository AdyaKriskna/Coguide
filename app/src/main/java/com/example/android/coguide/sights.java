package com.example.android.coguide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class sights extends Fragment {

    public static sights newInstance() {
        sights fragment = new sights();
        fragment.setRetainInstance(true);
        return fragment;
    }

    public sights() {
        // Required empty public constructor
    }

    ArrayList<cardview> listitems = new ArrayList<>();
    RecyclerView MyRecyclerView;

    int[] imageR= {R.drawable.s3,R.drawable.s4,R.drawable.s4b,R.drawable.s5,R.drawable.s6,R.drawable.s7,R.drawable.s8,R.drawable.s9,R.drawable.s10,R.drawable.s1,R.drawable.s2};
    String []name={"Puliakulam","Marudhamalai Temple","Marudhamalai","Dhyanalinga",
                   "Eachanari Vinayagar",
            //"Thirumoorthy Temple",
            "Kovai Kutralam",
            "Monkey Falls",
            "Aliyar Dam",
            "Velliangiri Mountains",
            "ISKCON Coimbatore","Mundhi Vinayaka"};

    String []address={
            "Puliakulam, Coimbatore, Tamil Nadu 641045\n",
            "Marudhamalai, Coimbatore, Tamil Nadu 641046\nPhone: 0422 242 2490\n",
            "Marudhamalai, Coimbatore, Tamil Nadu 641046\n",
            "Isha Yoga Centre, Velliangiri Foothills, Isha Vihar Post, Coimbatore, Tamil Nadu 641114\nPhone: 0422 251 5346\n",
            "Coimbatore to Pollachi NH-209 Road, Eachanari, Coimbatore, Tamil Nadu 641021\nPhone: 0422 267 2000\n",
         //   " It is situated 50 Kms from Pollachi and 20 kms from Udumalpet on the highway from Palani to Coimbatore.",
            "Kovai Kutralam Road, Booluvampatti, Tamil Nadu 641114\n",
            "Coimbatore district. Monkey Falls is about 30 km from Pollachi,Tamil Nadu 642101\n",
            "Coimbatore District, Tamil Nadu\n",
            " coimbatore bordering Palakkad District, Kerala.\n" +"Elevation: 1,778 m (5,833 ft)\n",
            "Sri Jagannath Mandir, Near to Codissia Trade fair complex, Civil Aerodrome Post, Coimbatore, Tamil Nadu 641014\n",
            "Address: Pankaja Mills Rd, Ramasamy Nagar, Puliakulam, Coimbatore, Tamil Nadu 641045"};
    String []content={
       /*3*/     "Puliakulam is a residential neighborhood in the city of Coimbatore. It is one of the oldest villages in the city of Coimbatore. People live here with well defined traces up to eight to ten generations. Arulmigu Mundhi Vinayagar temple , Loga Nayaga Shani Eswaran shrine and St. Antony Church are famous worship place.\n",
       /*4*/     " ",
      /*4b*/      "Architectural style: Dravidian architecture\n" + "Date built: 12th century\n" + "Subramaniyaswami Temple, Marudamalai is a popular 12th century hill temple dedicated to Hindu god Murugan, situated near Coimbatore, Tamil Nadu, India. It is considered as the Seventh House of Lord Murugan.\n",
     /*5*/          "The Dhyanalinga is a Yogic temple located 30 km from Coimbatore, Tamil Nadu. The temple was consecrated on June 24, 1999 by Sadhguru Jaggi Vasudev, a yogi and mystic. The temple is consecrated using prana prathista and is dedicated for meditation.\n",
     /*6*/      "Architectural style: Dravidian architecture\n" +"Eachanari Vinayagar Temple is a temple dedicated to Hindu god Vinayagar, situated near Coimbatore, Tamil Nadu, India. The temple is situated about 12 km from the city of Coimbatore on NH 209.\n",
     /*7*/        "Visit Kovai Kutralam Falls and explore its grand flow, variety of flora, see more attraction in and around in natural surroundings.\n",
//        //     "Thirumoorthy Temple is situated at the foot of the Thirumoorthy hills or Thirumoorthi hills adjoining the Thirumoorthy dam.",
    /*8*/           "Monkey Falls are natural waterfalls located near the uphill ghat road Valparai on the Pollachi-Valparai road in the Anaimalai Hills range.\n ",

            /*9*/      "Aliyar Reservoir is a 6.48 km² reservoir located in Aliyar village near Pollachi town in Coimbatore District, Tamil Nadu, South India. The dam is located in the foothills of Valparai, in the Anaimalai Hills of the Western Ghats. Wikipedia\n" +
            "Area: 6.48 km²\n" +
            "Surface elevation: 320 m\n" +
            "Catchment area: 468.8 km²\n",
            /*10*/    "The Velliangiri Mountains, a part of the Nilgiri Biosphere Reserve, are situated at the Western Ghats border of Coimbatore district.\n",
            " "," "};


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeList();

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_sights, container, false);
        MyRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        MyRecyclerView.setHasFixedSize(true);
        LinearLayoutManager MyLayoutManager = new LinearLayoutManager(getActivity());
        MyLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        if (listitems.size() > 0 & MyRecyclerView != null) {
            MyRecyclerView.setAdapter(new MyAdapter(listitems));
        }
        MyRecyclerView.setLayoutManager(MyLayoutManager);





        return  view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private ArrayList<cardview> list;

        public MyAdapter(ArrayList<cardview> Data) {
            list = Data;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
            // create a new view
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.cardview, parent, false);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {

            holder.image.setImageResource(list.get(position).getImage());
            holder.name.setText(list.get(position).getName());
            holder.address.setText(list.get(position).getAddress());
            holder.content.setText(list.get(position).getContent());

        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView address,content,name;
    public ImageView image;


        public MyViewHolder(View v) {
            super(v);
            image = (ImageView) v.findViewById(R.id.image);
            name=(TextView) v.findViewById(R.id.name);
            address = (TextView) v.findViewById(R.id.address);
            content= (TextView) v.findViewById(R.id.content);






        }
    }

    public void initializeList() {
        listitems.clear();

        for(int i =0;i<=10;i++) {


            cardview item = new cardview();
            item.setImage(imageR[i]);
            item.setName(name[i]);
            item.setAddress(address[i]);
            item.setContent(content[i]);
            listitems.add(item);


        }


    }

}
