package my.android.fazreil.catalog;

import my.android.fazreil.catalog.util.Rotate3dAnimation;
import android.os.Bundle;
import android.os.storage.OnObbStateChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.app.Activity;

public class Menu extends Activity implements OnItemClickListener, OnClickListener{

    private ListView theList;
    private ViewGroup theContainer;
    private ImageView theImageView;
	
	private static final String[] PHOTO_NAMES = 
		{
			"sample01",
			"sample02",
			"sample03",
			"sample04",
			"sample05",
			"sample06"
		};
	private static final int[] FILE_NAMES=
		{
			R.drawable.sample01,
			R.drawable.sample02,
			R.drawable.sample03,
			R.drawable.sample04,
			R.drawable.sample05,
			R.drawable.sample06
		};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		theList = (ListView)findViewById(R.id.listView1);
		theContainer = (FrameLayout)findViewById(R.id.container);
		theImageView = (ImageView)findViewById(R.id.image_view1);
		
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, PHOTO_NAMES);
		
		theList.setAdapter(adapter);
		theList.setOnItemClickListener(this);
		
		theImageView.setClickable(true);
		theImageView.setFocusable(true);
		theImageView.setOnClickListener(this);
		
		theContainer.setPersistentDrawingCache(ViewGroup.PERSISTENT_ANIMATION_CACHE);
		
	}
	
	
	
	/**
     * Setup a new 3D rotation on the container view.
     *
     * @param position the item that was clicked to show a picture, or -1 to show the list
     * @param start the start angle at which the rotation must begin
     * @param end the end angle of the rotation
     */
    private void applyRotation(int position, float start, float end) {
        // Find the center of the container
        final float centerX = theContainer.getWidth() / 2.0f;
        final float centerY = theContainer.getHeight() / 2.0f;

        // Create a new 3D rotation with the supplied parameter
        // The animation listener is used to trigger the next animation
        final Rotate3dAnimation rotation =
                new Rotate3dAnimation(start, end, centerX, centerY, 310.0f, true);
        rotation.setDuration(500);
        rotation.setFillAfter(true);
        rotation.setInterpolator(new AccelerateInterpolator());
        rotation.setAnimationListener(new DisplayNextView(position));

        theContainer.startAnimation(rotation);
    }

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		theImageView.setImageResource(FILE_NAMES[position]);
		applyRotation(position, 0, 90);
		
	}

	@Override
	public void onClick(View v) {
		applyRotation(-1, 180, 90);
		
	}
	
	/**
     * This class listens for the end of the first half of the animation.
     * It then posts a new action that effectively swaps the views when the container
     * is rotated 90 degrees and thus invisible.
     */
    private final class DisplayNextView implements Animation.AnimationListener {
        private final int mPosition;

        private DisplayNextView(int position) {
            mPosition = position;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            theContainer.post(new SwapViews(mPosition));
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }
	
    /**
     * This class is responsible for swapping the views and start the second
     * half of the animation.
     */
    private final class SwapViews implements Runnable {
        private final int mPosition;

        public SwapViews(int position) {
            mPosition = position;
        }

        public void run() {
            final float centerX = theContainer.getWidth() / 2.0f;
            final float centerY = theContainer.getHeight() / 2.0f;
            Rotate3dAnimation rotation;
            
            if (mPosition > -1) {
                theList.setVisibility(View.GONE);
                theImageView.setVisibility(View.VISIBLE);
                theImageView.requestFocus();

                rotation = new Rotate3dAnimation(90, 180, centerX, centerY, 310.0f, false);
            } else {
                theImageView.setVisibility(View.GONE);
                theList.setVisibility(View.VISIBLE);
                theList.requestFocus();

                rotation = new Rotate3dAnimation(90, 0, centerX, centerY, 310.0f, false);
            }

            rotation.setDuration(500);
            rotation.setFillAfter(true);
            rotation.setInterpolator(new DecelerateInterpolator());

            theContainer.startAnimation(rotation);
        }
    }

    
    
}

