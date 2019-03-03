package Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.droid2developer.india.ParallaxViewpager.R;

/**
 * Created by Edward on 3/1/2018.
 */

public class SlideShowAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    public int[] images = {
            R.drawable.picture,
            R.drawable.picture1,
            R.drawable.picture2,
            R.drawable.picture3
    };


    public SlideShowAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slideshow_layout,container,false);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageViewID);
        //imageView.setImageResource(images[position]);
        Glide.with(context)
                .load(images[position])
                .apply(new RequestOptions()
                        .centerCrop())
                .into(imageView);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}
