package fr.isen.besopraclient;

import java.util.Collection;

import fr.isen.besopraclient.data.DataManager;
import fr.isen.besopraclient.data.GetCategoryData;
import fr.isen.besopraclient.model.Category;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Spinner mySpinnerView = (Spinner) this.findViewById(R.id.categorySpinner);
		ArrayAdapter<Category> customAdapter = new ArrayAdapter<Category>(this,android.R.layout.simple_spinner_item, DataManager.getCategoryList());
		mySpinnerView.setAdapter(customAdapter);
		
		new GetCategoryData(customAdapter).execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
