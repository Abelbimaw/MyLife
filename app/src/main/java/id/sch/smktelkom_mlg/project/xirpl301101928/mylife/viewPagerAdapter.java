package id.sch.smktelkom_mlg.project.xirpl301101928.mylife;


import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class viewPagerAdapter extends FragmentPagerAdapter {
    ArrayList<android.support.v4.app.Fragment> arf;

    public viewPagerAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
        // TODO Auto-generated constructor stub
        arf = new ArrayList<>();
        arf.add(new DataViewer());
        arf.add(new AddViewer());
        arf.add(new SettingsViewer());
    }

    @Override
    public android.support.v4.app.Fragment getItem(int arg0) {
        // TODO Auto-generated method stub
        return arf.get(arg0);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return arf.size();
    }

}
