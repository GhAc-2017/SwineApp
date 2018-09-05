package com.app.actech.swineapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ACTECH on 8/20/2018.
 */

@SuppressLint("ValidFragment")
public class FixturesTabs extends Fragment {
    String[] tab1={"About the SwineApp"};
    String[] tab2={"Importance of pig farming"};
    String[] tab3={"Indigenous pig breeds of India","Exotic pig breeds available in India ","crossbred pigs of India"};

    String[] tab31={"Agonda Goan","Doom","Ghungroo","Niang Megha","Nicobari Pig","Tenyi Vo","Zovawk","Other indigenous pig breeds"};
    String[] tab32={"duroc","hampshire","Landrace","Large Black","Middle White Yorkshire","Tamworth"};
    String[] tab33={"Asha","HD K","JHARSUK","LANDLLY","LUMSNIANG","Mannuthy White","RANI","SVVU T","TANUVAS KPM Gold"};

    String[] tab4={"Selection of breeding boar"," Selection of sow"," Essential Performance","General consideration for pig breeding"};
    String[] tab5={"Management of gilts"," Estrus synchronization","Estrus","Natural mating","Artificial insemination","Pregnancy diagnosis","Manage repeat breeder","Culling of animal"};
    String[] tab6={"Care and Management of pregnant animals","Care and management during farrowing","Care and Management of sow just after farrowing","Piglet management","Weaning management"};
    String [] tab7={"Consideration for feeding","Nutrient requirements of different categories of pigs"," Feed formula for different categories of pigs","Conventional feed ingredients used in swine feeding","Non conventional feed resources"};
    String[] tab8={" General consideration of pig house","Space requirement for various categories of pigs","Housing material","Design of housing system"};
    String [] tab9={"Shelter and Managemental interventions","Nutritional modification","Genetic Approach"};
    String [] tab10={"Mange","Worms"," Classical Swine Fever","Foot and Mouth Disease","Swine erysipelas","Porcine Reproductive and Respiratory Syndrome","Mastitis"," Respiratory problem","Piglet diarrhoea","Piglet anaemia"};
    String[] tab11={"Vaccination program","Deworming Schedule for pigs"," General Health Care for Piglets"};
    String[] tab12={"Transportation of pig"};
    String[] tab13={"Daily routine jobs","Weekly routine jobs","Monthly routine jobs","Periodical jobs"};
    String[] tab14={"Biosecurity guidelines of pig farm"};
    String[] tab15={"Integrated pig farming"};
    String[] tab16={"   Slaughter of pig      ","    Processing of pork  "};
    String[] tab17={" Issues of pig waste","Methods of waste disposal"};
    String[] tab18={"Importance of record keeping","Records of pig farm"};
    String[] tab19={" Importance of traceability","Records of pig to pork traceability"};
    String[] tab20={"Technical Feasibility"," Economic viability","Bankability"};
    String[] tab21={"ICAR - NRC on Pig     ","All India Coordinated Research Project","Mega Seed Project on pig farms"};


    TabLayout tl;

    String[] tab={};

    int n;

    public FixturesTabs(int x) {
       n=x;
        switch (n){
            case 1:
                tab=tab1;
                break;
            case 2:
                tab=tab2;
                break;
            case 3:
                tab=tab3;
                break;
            case 31:
                tab=tab31;
                break;
            case 32:
                tab=tab32;
                break;
            case 33:
                tab=tab33;
                break;
            case 4:
                tab=tab4;
                break;
            case 5:
                tab=tab5;
                break;
            case 6:
                tab=tab6;
                break;
            case 7:
                tab=tab7;
                break;
            case 8:
                tab=tab8;
                break;
            case 9:
                tab=tab9;
                break;
            case 10:
                tab=tab10;
                break;
            case 11:
                tab=tab11;
                break;
            case 12:
                tab=tab12;
                break;
            case 13:
                tab=tab13;
                break;
            case 14:
                tab=tab14;
                break;
            case 15:
                tab=tab15;
                break;
            case 16:
                tab=tab16;
                break;
            case 17:
                tab=tab17;
                break;
            case 18:
                tab=tab18;
                break;
            case 19:
                tab=tab19;
                break;
            case 20:
                tab=tab20;
                break;
            case 21:
                tab=tab21;
                break;
            default:
                tab=tab3;
                Log.i("in Ficture tabs","It is called");
        }
    }

    TabLayout tabs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fixtures_new_tabs,container, false);
        // Setting ViewPager for each Tabs
        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        // Set Tabs inside Toolbar
        tabs = (TabLayout) view.findViewById(R.id.result_tabs);
        tabs.setupWithViewPager(viewPager);


        if(n==1 || n==2 || n==12 || n==14 || n==15){
            tabs.setTabMode(TabLayout.MODE_FIXED);
        }
        else {
            tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
        }
        //Toast.makeText(getActivity(),"x val is "+n,Toast.LENGTH_SHORT).show();



/*
        try
        {
            setupTabIcons();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
*/

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                viewPager.setCurrentItem(position,false);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        return view;

    }


    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {

        if(tab==tab31)
            n=31;
        if(tab==tab32)
            n=32;
        if(tab==tab33)
            n=33;
        Adapter adapter = new Adapter(getChildFragmentManager());
        for(int i=0;i<tab.length;i++) {
            adapter.addFragment(new TabFragment(i,n), tab[i]);

        }
        viewPager.setAdapter(adapter);



    }
/*
    private View prepareTabView(int pos) {
        View view = getLayoutInflater().inflate(R.layout.custom_tab,null);
        TextView tv_title = (TextView) view.findViewById(R.id.tv_title);

        tv_title.setText(tabTitle[pos]);

        return view;
    }

    private void setupTabIcons()
    {

        for(int i=0;i<tabTitle.length;i++)
        {
            tabs.getTabAt(i).setCustomView(prepareTabView(i));
        }


    }
    */

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }




}