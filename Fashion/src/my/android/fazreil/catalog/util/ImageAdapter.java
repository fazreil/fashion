package my.android.fazreil.catalog.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Gallery.LayoutParams;

import my.android.fazreil.catalog.R;

public class ImageAdapter extends BaseAdapter {
        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView i = new ImageView(mContext);

            i.setImageResource(mThumbIds[position]);
            i.setAdjustViewBounds(true);
            i.setLayoutParams(new Gallery.LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            //i.setBackgroundResource(R.drawable.picture_frame);
            return i;
        }

        private Context mContext;
        
        private Integer[] mThumbIds = {
                R.drawable.sample01thumb, R.drawable.sample02thumb,
                R.drawable.sample03thumb, R.drawable.sample04thumb, 
                R.drawable.sample05thumb, R.drawable.sample06thumb};

        private Integer[] mImageIds = {
                R.drawable.sample01, R.drawable.sample02,
                R.drawable.sample03, R.drawable.sample04, 
                R.drawable.sample05, R.drawable.sample06};

		public Integer[] getmThumbIds() {
			return mThumbIds;
		}

		public void setmThumbIds(Integer[] mThumbIds) {
			this.mThumbIds = mThumbIds;
		}

		public Integer[] getmImageIds() {
			return mImageIds;
		}

		public void setmImageIds(Integer[] mImageIds) {
			this.mImageIds = mImageIds;
		}
        
        
}
