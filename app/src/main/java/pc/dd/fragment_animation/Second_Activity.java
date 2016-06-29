package pc.dd.fragment_animation;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by User on 17.06.2016.
 */
public class Second_Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);


        ImageView imageView = (ImageView) findViewById(R.id.image_target);
        Bundle extras = getIntent().getExtras();
        Bitmap bmp = (Bitmap) extras.getParcelable("source");
        imageView.setImageBitmap(bmp );

        TextView text = (TextView) findViewById(R.id.nickname_second_activity);
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Bold.ttf");
        text.setTypeface(type);

        TextView text2 = (TextView) findViewById(R.id.second_activity_largetext);
        Typeface type2 = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Light.ttf");
        text2.setTypeface(type2);

        final ImageView follow = (ImageView) findViewById(R.id.followImage);

        final boolean[] anim_change = {false}; // Для активации разной анимации
        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (anim_change[0] == false){

                    follow.setBackgroundResource(R.drawable.animation_list_filling);

                    // Get the background, which has been compiled to an AnimationDrawable object.
                    AnimationDrawable frameAnimation = (AnimationDrawable) follow.getBackground();

                    // Start the animation (looped playback by default).
                    frameAnimation.start();


                    anim_change[0] = true;
                }
                else if (anim_change[0] == true){

                    follow.setBackgroundResource(R.drawable.animation_list_emptying);

                    // Get the background, which has been compiled to an AnimationDrawable object.
                    AnimationDrawable frameAnimation = (AnimationDrawable) follow.getBackground();

                    // Start the animation (looped playback by default).
                    frameAnimation.start();

                    anim_change[0] = false;

                }
                
            }
        });


    }
}
