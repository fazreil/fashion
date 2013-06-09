package my.android.fazreil.catalog;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.app.Activity;
import android.database.DataSetObserver;

public class Menu extends Activity implements OnItemClickListener{

	String[] PHOTO_NAMES = {"AAA","BBB","CCC",};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, PHOTO_NAMES);
		ListView mPhotoList = (ListView)findViewById(R.id.listView1);
		mPhotoList.setAdapter(adapter);
		mPhotoList.setOnItemClickListener(this);
		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Toast.makeText(getApplicationContext(), "Selected item: "+id+", "+position,  Toast.LENGTH_SHORT).show();
		
	}
	

}
