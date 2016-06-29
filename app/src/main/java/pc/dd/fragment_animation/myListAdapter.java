package pc.dd.fragment_animation;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 22.06.2016.
 */
public class myListAdapter  extends ArrayAdapter<Integer> {


    public myListAdapter(Context context, int resource, Integer[] objects) {
        super(context, resource, objects);
    }

    @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View v = convertView;

            if (v == null) {
                LayoutInflater vi;
                vi = LayoutInflater.from(getContext());
                v = vi.inflate(R.layout.fragment_listview, null);
            }

            Integer objects = getItem(position);

            if (objects != null) {
                ImageView tt1 = (ImageView) v.findViewById(R.id._fragmentImage);
                TextView tt2 = (TextView) v.findViewById(R.id._fragmentNickanme);
                TextView tt3 = (TextView) v.findViewById(R.id._fragmentDescription);

                if (tt1 != null) {
                    tt1.setImageResource(objects);
                }

            }

            return v;
        }

}
