package com.jcodecraeer.jcode.fragment;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ikimuhendis.ldrawer.ActionBarDrawerToggle;
import com.ikimuhendis.ldrawer.DrawerArrowDrawable;
import com.jcodecraeer.jcode.AppContext;
import com.jcodecraeer.jcode.Category;
import com.jcodecraeer.jcode.Code;
import com.jcodecraeer.jcode.HttpUtil;
import com.jcodecraeer.jcode.R;
import com.jcodecraeer.jcode.EventBus;
import com.jcodecraeer.jcode.R.drawable;
import com.jcodecraeer.jcode.R.id;
import com.jcodecraeer.jcode.R.layout;
import com.jcodecraeer.jcode.R.string;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

/**
 * Fragment used for managing interactions for and presentation of a navigation
 * drawer. See the <a href=
 * "https://developer.android.com/design/patterns/navigation-drawer.html#Interaction"
 * > design guidelines</a> for a complete explanation of the behaviors
 * implemented here.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class NavigationDrawerFragment extends Fragment implements EventBus.EventHandler{

	/**
	 * Remember the position of the selected item.
	 */
	private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";

	/**
	 * Per the design guidelines, you should show the drawer on launch until the
	 * user manually expands it. This shared preference tracks this.
	 */
	private static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";

	/**
	 * A pointer to the current callbacks instance (the Activity).
	 */
	private NavigationDrawerCallbacks mCallbacks;

	/**
	 * Helper component that ties the action bar to the navigation drawer.
	 */
	private ActionBarDrawerToggle mDrawerToggle;
 
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerListView;
	private View mFragmentContainerView;

	private int mCurrentSelectedPosition = 0;
	private boolean mFromSavedInstanceState;
	private boolean mUserLearnedDrawer;
	
	private ArrayList<Category> mCateList;
	private DrawerListAdapter mDrawerAdapter;
	public NavigationDrawerFragment() {
		mCateList = new ArrayList<Category>();
	}
	static class ViewHolder {
		public TextView title;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Read in the flag indicating whether or not the user has demonstrated
		// awareness of the
		// drawer. See PREF_USER_LEARNED_DRAWER for details.
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(getActivity());
		mUserLearnedDrawer = sp.getBoolean(PREF_USER_LEARNED_DRAWER, false);

		if (savedInstanceState != null) {
			mCurrentSelectedPosition = savedInstanceState
					.getInt(STATE_SELECTED_POSITION);
			mFromSavedInstanceState = true;
		}
		loadCateList(AppContext.CODE_LIST_URL);
		// Select either the default item (0) or the last selected item.
		selectItem(mCurrentSelectedPosition);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		// Indicate that this fragment would like to influence the set of
		// actions in the action bar.
		setHasOptionsMenu(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		LinearLayout drawerListViewContainer = (LinearLayout) inflater.inflate(
				R.layout.fragment_navigation_drawer, container, false);
		mDrawerListView = (ListView)drawerListViewContainer.findViewById(R.id.drawer_list);
		mDrawerListView
				.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						selectItem(position);
					}
				});
	    mDrawerAdapter =  new DrawerListAdapter();
		mDrawerListView.setAdapter(mDrawerAdapter);
		mDrawerListView.setItemChecked(mCurrentSelectedPosition, true);
		
		return drawerListViewContainer;
	}
	
   
	public boolean isDrawerOpen() {
		return mDrawerLayout != null
				&& mDrawerLayout.isDrawerOpen(mFragmentContainerView);
	}

	/**
	 * Users of this fragment must call this method to set up the navigation
	 * drawer interactions.
	 * 
	 * @param fragmentId
	 *            The android:id of this fragment in its activity's layout.
	 * @param drawerLayout
	 *            The DrawerLayout containing this fragment's UI.
	 */
	public void setUp(int fragmentId, DrawerLayout drawerLayout) {
		mFragmentContainerView = getActivity().findViewById(fragmentId);
 
		mDrawerLayout = drawerLayout;

		// set a custom shadow that overlays the main content when the drawer
		// opens
//		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
//				GravityCompat.START);
		// set up the drawer's list view with items and click listener
 
 
	    
	    DrawerArrowDrawable drawerArrow = new DrawerArrowDrawable(getActivity()) {
            @Override
            public boolean isLayoutRtl() {
                return false;
            }
        };
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), mDrawerLayout,
            drawerArrow, R.string.app_name,
            R.string.app_name) {

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getActivity().invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActivity().invalidateOptionsMenu(); 
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);	 
        mDrawerToggle.syncState();
		// If the user hasn't 'learned' about the drawer, open it to introduce
		// them to the drawer,
		// per the navigation drawer design guidelines.
		if (!mUserLearnedDrawer && !mFromSavedInstanceState) {
			//mDrawerLayout.openDrawer(mFragmentContainerView);
		}
	}

	private void selectItem(int position) {
		mCurrentSelectedPosition = position;
		if (mDrawerListView != null) {
			mDrawerListView.setItemChecked(position, true);
		}
		if (mDrawerLayout != null) {
			mDrawerLayout.closeDrawer(mFragmentContainerView);
		}
		if (mCallbacks != null) {
			mCallbacks.onNavigationDrawerItemSelected(position);
		}
		if(mCateList.size() != 0){
			Category  cate = mCateList.get(position);
			EventBus.getInstance().sendEvent(EventBus.EventType.CATEGORY, cate);			
		}
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mCallbacks = (NavigationDrawerCallbacks) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(
					"Activity must implement NavigationDrawerCallbacks.");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mCallbacks = null;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt(STATE_SELECTED_POSITION, mCurrentSelectedPosition);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Forward the new configuration the drawer toggle component.
		 
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
 
		super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		return super.onOptionsItemSelected(item);
	}
	
	/**
	 * Callbacks interface that all activities using this fragment must
	 * implement.
	 */
	public static interface NavigationDrawerCallbacks {
		/**
		 * Called when an item in the navigation drawer is selected.
		 */
		void onNavigationDrawerItemSelected(int position);
	}

	private void loadCateList(final String url) {
	    final  Handler handler = new Handler(){
			public void handleMessage(Message msg) {		
				if (msg.what == 1) {
					ArrayList<Category> cateList = (ArrayList<Category>)msg.obj;
				    for (Category cate : cateList) {
				    	mCateList.add(cate);		 
				    }
				    mDrawerAdapter.notifyDataSetChanged();
				}
			}
	    };

		new Thread() {
			public void run() {
				Message msg = new Message();
				ArrayList<Code> codeList = new ArrayList<Code>();
				try {
					codeList = parseCodeList(url);
				} catch (Exception e) {
					e.printStackTrace();
					msg.what = -1;
					msg.obj = e;
				}
				msg.what = 1;
				msg.obj = codeList;
				handler.sendMessage(msg);
			}
		}.start();
	}
	
	private ArrayList<Code> parseCodeList(String url) {
		final ArrayList<Code> codeList = new ArrayList<Code>();
		try {
			url = HttpUtil._MakeURL(url, new HashMap<String, Object>(){{
			    put("ismobile", 1);
		    }});	
			String key ="category_request";
			String result = "";
	    	//cache
			if (HttpUtil.isNetworkConnected() && HttpUtil.isCacheDataFailure(key)) {
					result = HttpUtil.http_get(AppContext.getInstance(), url );
					HttpUtil.saveObject(result, key);
					result = (String) HttpUtil.readObject(key);	
			} else {
				result = (String) HttpUtil.readObject(key);
				if (result == null)
					result = "erro";
			}
			try {
				JSONArray array = new JSONArray(result);
				JSONObject catelistobject = array.getJSONObject(1); 	
				String cateListStr  = catelistobject.getString("catelist");
				JSONArray arrayCate = new JSONArray(cateListStr);  
				for(int i = 0; i < arrayCate.length(); i++){
				   JSONObject obj = arrayCate.getJSONObject(i); 
				   Category cate = new Category();
				   cate.setID(i);
				   cate.setName(obj.getString("catename"));
				   cate.setValue(obj.getString("catevalue"));
				   mCateList.add(cate);						        
			   }				   	
				
			}catch (Exception e){	
				e.printStackTrace();
			} 
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return codeList;		
	}
	
    class DrawerListAdapter extends BaseAdapter {
    	public int getCount() {
    		return mCateList.size();
    	}

    	public Object getItem(int arg0) {
    		return null;
    	}

    	public long getItemId(int arg0) {
    		return 0;
    	}

    	public View getView(int position, View convertView, ViewGroup parent) {
    		ViewHolder viewHolder = null;
    		if (convertView == null) {
    			LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
    			viewHolder = new ViewHolder();
    		    convertView = layoutInflater.inflate(R.layout.drawer_item, null);
    	 	    viewHolder.title = (TextView) convertView.findViewById(R.id.item_name);
    			convertView.setTag(viewHolder);
    		} else {
    			viewHolder = (ViewHolder) convertView.getTag();
    		}
    		Category cate = mCateList.get(position);
            viewHolder.title.setText(cate.getName());
    		return convertView;
    	}
    }	
    
	@Override
	public void handleEvent(int eventType, Object obj) {
	    if(eventType == EventBus.EventType.TOGGLE){
            if (mDrawerLayout.isDrawerOpen(mFragmentContainerView)) {
            	mDrawerLayout.closeDrawer(mFragmentContainerView);
            } else {
            	mDrawerLayout.openDrawer(mFragmentContainerView);
            }				
	    }
	}
}
