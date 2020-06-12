package com.example.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Listviewumuzu tanımlayalım.
        ListView listView=findViewById(R.id.LİstView);
        //1.arrayimizi oluşturalım.
        ArrayList<String> sevenWondersoftheWorld = new ArrayList<>();
        sevenWondersoftheWorld.add("Great Wall of China (China)");
        sevenWondersoftheWorld.add("Christ the Redeemer Statue (rio de Janeiro)");
        sevenWondersoftheWorld.add("Machu Picchu (peru)");
        sevenWondersoftheWorld.add("Chichen Itza (Yucatan Peninsula, mexico)");
        sevenWondersoftheWorld.add("The Roman Colosseum (rome)");
        sevenWondersoftheWorld.add("Taj Mahal (Agra, india)");
        sevenWondersoftheWorld.add("Petra (jordan)");

        //2.arrayimizi oluşturalım.
        final ArrayList<String> title=new ArrayList<String>();
        title.add("Great Wall of China");
        title.add("Christ the Redeemer Statue ");
        title.add("Machu Picchu");
        title.add("Chichen Itza");
        title.add("The Roman Colosseum");
        title.add("Taj Mahal");
        title.add("Petra ");

        //3.Arrayimizi oluşturalım
        final ArrayList<String> description=new ArrayList<String>();
        description.add("   Built between the 5th century B.C. and the 16th century, the Great Wall of China is a stone-and-earth fortification created to protect the borders of the Chinese Empire from invading Mongols. The Great Wall is actually a succession of multiple walls spanning approximately 4,000 miles, making it the world's longest manmade structure.");
        description.add("   The Art Deco-style Christ the Redeemer statue has been looming over the Brazilians from upon Corcovado mountain in an awe-inspiring state of eternal blessing since 1931. The 130-foot reinforced concrete-and-soapstone statue was designed by Heitor da Silva Costa and cost approximately $250,000 to build - much of the money was raised through donations. The statue has become an easily recognized icon for rio and Brazil.");
        description.add("   Machu Picchu, an Incan city of sparkling granite precariously perched between 2 towering Andean peaks, is thought by scholars to have been a sacred archaeological center for the nearby Incan capital of Cusco. Built at the peak of the Incan Empire in the mid-1400s, this mountain citadel was later abandoned by the Incas. The site remained unknown except to locals until 1911, when it was rediscovered by archaeologist Hiram Bingham. The site can only be reached by foot, train or helicopter; most visitors visit by train from nearby Cusco.");
        description.add("   The genius and adaptability of Mayan culture can be seen in the splendid ruins of Chichen Itza. This powerful city, a trading center for cloth, slaves, honey and salt, flourished from approximately 800 to 1200, and acted as the political and economic hub of the Mayan civilization. The most familiar ruin at the site is El Caracol, a sophisticated astronomical observatory.");
        description.add("   Rome's, if not Italy's, most enduring icon is undoubtedly its Colosseum. Built between A.D. 70 and 80 A.D., it was in use for some 500 years. The elliptical structure sat nearly 50,000 spectators, who gathered to watch the gladiatorial events as well as other public spectacles, including battle reenactments, animal hunts and executions. Earthquakes and stone-robbers have left the Colosseum in a state of ruin, but portions of the structure remain open to tourists, and its design still influences the construction of modern-day amphitheaters, some 2,000 years later.");
        description.add("   A mausoleum commissioned for the wife of Mughal Emperor Shah Jahan, the Taj Mahal was built between 1632 and 1648. Considered the most perfect specimen of Muslim art in india, the white marble structure actually represents a number of architectural styles, including Persian, Islamic, Turkish and Indian. The Taj Mahal also encompasses formal gardens of raised pathways, sunken flower beds and a linear reflecting pool.");
        description.add("   Declared a World Heritage Site in 1985, Petra was the capital of the Nabataean empire of King Aretas IV, and likely existed in its prime from 9 B.C. to A.D. 40. The members of this civilization proved to be early experts in manipulating water technology, constructing intricate tunnels and water chambers, which helped create an pseudo-oasis. A number of incredible structures carved into stone, a 4,000-seat amphitheater and the El-Deir monastery have also helped the site earn its fame");


        //4.Arrayimizi oluşturalım.(resimleri byte koda ceviriyoruz)
        Bitmap china= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.china);
        Bitmap rio= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.rio);
        Bitmap peru= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.peru);
        Bitmap mexico= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.mexico);
        Bitmap rome= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.rome);
        Bitmap india= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.india);
        Bitmap jordan= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.jordan);

        final ArrayList<Bitmap> sevenImage = new ArrayList<>();
        sevenImage.add(china);
        sevenImage.add(rio);
        sevenImage.add(peru);
        sevenImage.add(mexico);
        sevenImage.add(rome);
        sevenImage.add(india);
        sevenImage.add(jordan);


        //adapterümüzü kuralım.
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,sevenWondersoftheWorld);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            //herhangi bir pozisyon değerine tıkladığımızda gerçekleşir.
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(getApplicationContext(),DescriptionActivity.class);
                //verileri gönderelim diğer tarafa
                intent.putExtra("title",title.get(position));
                intent.putExtra("description",description.get(position));
                Singleton singleton=Singleton.getInstance();
                singleton.setSelectedItem(sevenImage.get(position));


                startActivity(intent);

            }
        });


    }
}