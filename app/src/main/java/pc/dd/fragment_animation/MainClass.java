package pc.dd.fragment_animation;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v4.app.Fragment;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainClass extends FragmentActivity {

    public FragmentManager manager;
    public FragmentTransaction transition;

    private String EXTRA_PHOTO = "source";
    Integer[] items = new Integer[]{R.drawable.image1,R.drawable.picture,R.drawable.p3,R.drawable.p5,R.drawable.p6,R.drawable.p7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
               setContentView(R.layout.main_activity);

        final ListView myListView = (ListView)findViewById(R.id.listMainAct);
        myListAdapter adapter =
                new myListAdapter(this, android.R.layout.simple_list_item_1, items); //создали класс адаптера и закинули туда все что нам нужно
        myListView.setAdapter( adapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CircleImageView photo = (CircleImageView) view.findViewById(R.id._fragmentImage);

                Intent intent = new Intent(MainClass.this, Second_Activity.class); //откуда-куда
                intent.setAction(intent.ACTION_VIEW);
                photo.buildDrawingCache();
                Bitmap image= photo.getDrawingCache();

                Bundle extras = new Bundle();
                extras.putParcelable(MainClass.this.EXTRA_PHOTO, image); //ложим айди
                intent.putExtras(extras);



                startActivity(intent,
                        ActivityOptions.makeSceneTransitionAnimation(
                                MainClass.this,
                                photo //наше фото
                                ,
                                photo.getTransitionName() // transition name
                        ).toBundle());


            }
        });
        /*
         final View photo = findViewById (R.id.source); //изображение которое будем посылать в анимацию
        // ImageView target = (ImageView) findViewById(R.id.image_target);
            photo.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainClass.this, Second_Activity.class); //откуда-куда
                intent.setAction(intent.ACTION_VIEW);
                intent.putExtra(MainClass.this.EXTRA_PHOTO, v.getId()); //связь
                startActivity(intent,
                        ActivityOptions.makeSceneTransitionAnimation(
                                MainClass.this,
                                photo //наше фото
                                ,
                                "target2" // transition name
                        ).toBundle());
            }
        });
       */
    }

}
