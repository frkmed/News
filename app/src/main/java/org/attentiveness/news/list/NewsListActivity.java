package org.attentiveness.news.list;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.view.MenuItem;

import org.attentiveness.news.R;
import org.attentiveness.news.base.BaseActivity;

public class NewsListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        setup();

        NewsListFragment newsListFragment = (NewsListFragment) getSupportFragmentManager().findFragmentById(R.id.fl_container);
        if (newsListFragment == null) {
            newsListFragment = NewsListFragment.newInstance();
            addFragment(getSupportFragmentManager(), R.id.fl_container, newsListFragment);
        }

        NewsListPresenter presenter = new NewsListPresenter(newsListFragment);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Open the navigation drawer when the home icon is selected from the toolbar.
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int itemId = item.getItemId();
                switch (itemId) {
                    case R.id.nav_news_list:
                        //do nothing
                        break;
                    case R.id.nav_feedback:
                        break;
                    case R.id.nav_about:
                        break;
                    case R.id.nav_settings:
                        break;
                    default:
                        break;
                }
                // Close the navigation drawer when an item is selected.
                item.setChecked(true);
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }

}
