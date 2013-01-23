package net.meiolania.apps.habrahabr.fragments.qa;

import net.meiolania.apps.habrahabr.Preferences;
import net.meiolania.apps.habrahabr.R;
import net.meiolania.apps.habrahabr.ui.MainTabListener;
import android.os.Bundle;
import android.os.Handler;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.app.ActionBar.Tab;

public class QaMainFragment extends SherlockFragment {

    public static QaMainFragment newInstance() {
	return new QaMainFragment();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
	super.onActivityCreated(savedInstanceState);
	// It's not good
	// TODO: Think about that
	Handler h = new Handler();
	h.postDelayed(new Runnable() {
	    public void run() {
		showActionBar();
	    }
	}, 300);
    }

    private void showActionBar() {
	SherlockFragmentActivity activity = getSherlockActivity();

	ActionBar actionBar = activity.getSupportActionBar();
	actionBar.removeAllTabs();
	actionBar.setDisplayHomeAsUpEnabled(true);
	actionBar.setTitle(R.string.qa);
	actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

	Preferences preferences = Preferences.getInstance(activity);
	int selectedTab = preferences.getQaDefaultTab();

	/* Inbox tab */
	Tab tab = actionBar.newTab();
	tab.setText(R.string.inbox);
	tab.setTag("inbox");
	tab.setTabListener(new MainTabListener<QaInboxFragment>(activity, "inbox", QaInboxFragment.class));
	actionBar.addTab(tab, (selectedTab == 0 ? true : false));

	/* Hot tab */
	tab = actionBar.newTab();
	tab.setText(R.string.hot);
	tab.setTag("hot");
	tab.setTabListener(new MainTabListener<QaHotFragment>(activity, "hot", QaHotFragment.class));
	actionBar.addTab(tab, (selectedTab == 1 ? true : false));

	/* Popular tab */
	tab = actionBar.newTab();
	tab.setText(R.string.popular);
	tab.setTag("popular");
	tab.setTabListener(new MainTabListener<QaPopularFragment>(activity, "popular", QaPopularFragment.class));
	actionBar.addTab(tab, (selectedTab == 2 ? true : false));

	/* Unanswered tab */
	tab = actionBar.newTab();
	tab.setText(R.string.unanswered);
	tab.setTag("unanswered");
	tab.setTabListener(new MainTabListener<QaUnansweredFragment>(activity, "unanswered", QaUnansweredFragment.class));
	actionBar.addTab(tab, (selectedTab == 3 ? true : false));
    }
}