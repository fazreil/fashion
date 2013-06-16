package my.android.fazreil.catalog.util;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

//http://stackoverflow.com/questions/9156698/how-to-get-images-dynamiclly-from-drawable-folder

public class ResourceResolver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public ResourceResolver()
	{}
	
	public int[] resolveImages(Resources resource, String packageName)
	{
		/*
		  for (int j = 1; j < 6; j++) {
   			Drawable drawable = getResources().getDrawable(getResources()
                  .getIdentifier("d002_p00"+j, "drawable", getPackageName()));
			} 
		  */
		int[] returnImages = {};
		
		for (int j = 1; j < 6; j++) {
   			Drawable drawable = resource.getDrawable(resource.getIdentifier("d002_p00"+j, "drawable", packageName));
			} 
		
		return returnImages;
	}

}
