package com.app.actech.swineapp;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.Toast;

import java.io.InputStream;

/**
 * Created by ACTECH on 8/20/2018.
 */

@SuppressLint("ValidFragment")
public class TabFragment extends Fragment {
    ImageView hd;

    String[] tab1={"About the SwineApp"};
    String[] tab2={"Importance of pig farming"};
    String[] tab3={"Indigenous pig breeds of India","Exotic pig breeds of India","crossbred pigs of India"};

    String[] tab31={"Agonda Goan","Doom","Ghungroo","Niang Megha","Nicobari Pig","Tenyi Vo","Zovawk","Other indigenous pig breeds"};
    String[] tab32={"Duroc","Hampshire","Landrace","Large Black","Middle White Yorkshire","Tamworth"};
    String[] tab33={"Asha","HD K","Jharsuk","Landlly","Lumsniang","Mannuthy White","Rani","SVVU T","TANUVAS KPM Gold"};


    String[] tab4={"Selection of breeding boar","Selection of sow","Essential Performance","General consideration for pig breeding"};
    String[] tab5={"Management of gilts","Estrus synchronization","Estrus","Natural mating","Artificial insemination","Pregnancy diagnosis","Manage repeat breeders","Culling of animal"};
    String[] tab6={"Care and Management of pregnant animals","Care and management during farrowing","Care and Management of sow just after farrowing","Piglet management","Weaning management"};
    String [] tab7={"Consideration for feeding","Nutrient requirements of different categories of pigs","Feed formula for different categories of pigs","Conventional feed ingredients used in swine feeding","Non conventional feed resources"};
    String[]  tab8={"General consideration of pig house","Space requirement for various categories of pigs","Housing material","Design of housing system"};
    String []  tab9={"Shelter and Managemental interventions","Nutritional modification","Genetic Approach"};
    String [] tab10={"Mange","Worms","Classical Swine Fever","Foot and Mouth Disease","Swine erysipelas","Porcine Reproductive and Respiratory Syndrome","Mastitis","Respiratory problem","Piglet diarrhoea","Piglet anaemia"};
    String[] tab11={"Vaccination program","Deworming Schedule for pigs","General Health Care for Piglets"};
    String[] tab12={"Transportation of pig"};
    String[] tab13={"Daily routine jobs","Weekly routine jobs","Monthly routine jobs","Periodical jobs"};
    String[] tab14={"Biosecurity guidelines of pig farm"};
    String[] tab15={"Integrated pig farming"};
    String[] tab16={"Slaughter of pig","Processing of pork"};
    String[] tab17={"Issues of pig waste","Methods of waste disposal"};
    String[] tab18={"Importance of record keeping","Records of pig farm"};
    String[] tab19={"Importance of traceability","Records of pig to pork traceability"};
    String[] tab20={"Technical Feasibility","Economic viability","Bankability"};
    String[] tab21={"ICAR","All India Coordinated Research Project","Mega Seed Project on pig farms"};

    String[] tab={};

    int tabname,tot;
    
    public TabFragment(int i,int n) {
        this.tabname=i;
        tot=n;

        switch (tot) {
            case 1:
                tab=tab1;
                break;
            case 2:
                tab=tab2;
                break;
            case 3:
                tab = tab3;
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
                tab = tab4;
                break;
            case 5:
                tab = tab5;
                break;
            case 6:
                tab = tab6;
                break;
            case 7:
                tab = tab7;
                break;
            case 8:
                tab = tab8;
                break;
            case 9:
                tab = tab9;
                break;
            case 10:
                tab = tab10;
                break;
            case 11:
                tab = tab11;
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
                tab = tab16;
                break;
            case 17:
                tab = tab17;
                break;
            case 18:
                tab = tab18;
                break;
            case 19:
                tab = tab19;
                break;
            case 20:
                tab = tab20;
                break;
            case 21:
                tab = tab21;
                break;
            default:
                tab = tab3;
        }

    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tabfragment,container,false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        hd=view.findViewById(R.id.imgheader);
        WebView myWebView=view.findViewById(R.id.rvw);

        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);



        String fname;

        if(tot==1 || tot==2||tot==12||tot==14||tot==15){
            fname=tot+". "+tab[0];//+".htm";
            String s="SwineAppHTML/"+fname+"_files/pic.jpg";
            setImg(s);
            Log.i("fname ", s);
            Log.i("fname ",fname);
            myWebView.loadUrl("file:///android_asset/SwineAppHTML/"+fname+".htm");
        }
        else {
            switch (tabname) {
                case 0:
                    fname = tot + ".1" + " " + tab[0];//+ ".htm";
                    String s="SwineAppHTML/"+fname+"_files/pic.jpg";
                    setImg(s);
                    Log.i("fname ", s);
                    /*
                    String s="file:///android_asset/SwineAppHTML/" + fname+".htm"+"image001.jpg";
                    int resID = getResources().getIdentifier(s, "drawable", "com.app.actech.swineapp");
                    hd.setImageResource(resID);
                    Log.i("fname ", s);
                    */
                    myWebView.loadUrl("file:///android_asset/SwineAppHTML/" + fname+".htm");
                    break;
                case 1:
                    fname = tot + ".2" + " " + tab[1];//+ ".htm";
                    String s1="SwineAppHTML/"+fname+"_files/pic.jpg";
                    setImg(s1);
                    myWebView.loadUrl("file:///android_asset/SwineAppHTML/" + fname+".htm");
                    break;
                case 2:
                    fname = tot + ".3" + " " + tab[2];//+ ".htm";
                    String s2="SwineAppHTML/"+fname+"_files/pic.jpg";
                    setImg(s2);
                    myWebView.loadUrl("file:///android_asset/SwineAppHTML/" + fname+".htm");
                    break;
                case 3:
                    fname = tot + ".4" + " " + tab[3];//+ ".htm";
                    String s3="SwineAppHTML/"+fname+"_files/pic.jpg";
                    setImg(s3);
                    Log.i("fname ", s3);
                    myWebView.loadUrl("file:///android_asset/SwineAppHTML/" + fname+".htm");
                    break;
                case 4:
                    fname = tot + ".5" + " " + tab[4];//+ ".htm";
                    String s4="SwineAppHTML/"+fname+"_files/pic.jpg";
                    setImg(s4);
                    Log.i("fname ", s4);
                    myWebView.loadUrl("file:///android_asset/SwineAppHTML/" + fname+".htm");
                    break;
                case 5:
                    fname = tot + ".6" + " " + tab[5];//+ ".htm";
                    String s5="SwineAppHTML/"+fname+"_files/pic.jpg";
                    setImg(s5);
                    Log.i("fname ", s5);
                    myWebView.loadUrl("file:///android_asset/SwineAppHTML/" + fname+".htm");
                    break;
                case 6:
                    fname = tot + ".7" + " " + tab[6];//+ ".htm";
                    String s6="SwineAppHTML/"+fname+"_files/pic.jpg";
                    setImg(s6);
                    Log.i("fname ", s6);
                    myWebView.loadUrl("file:///android_asset/SwineAppHTML/" + fname+".htm");
                    break;
                case 7:
                    fname = tot + ".8" + " " + tab[7];//+ ".htm";
                    String s7="SwineAppHTML/"+fname+"_files/pic.jpg";
                    setImg(s7);
                    Log.i("fname ", s7);
                    myWebView.loadUrl("file:///android_asset/SwineAppHTML/" + fname+".htm");
                    break;
                case 8:
                    fname = tot + ".9" + " " + tab[8];//+ ".htm";
                    String s8="SwineAppHTML/"+fname+"_files/pic.jpg";
                    setImg(s8);
                    Log.i("fname ", s8);
                    myWebView.loadUrl("file:///android_asset/SwineAppHTML/" + fname+".htm");
                    break;
                case 9:
                    fname = tot + ".10" + " " + tab[9];//+ ".htm";
                    String s9="SwineAppHTML/"+fname+"_files/pic.jpg";
                    setImg(s9);
                    Log.i("fname ", s9);
                    myWebView.loadUrl("file:///android_asset/SwineAppHTML/" + fname+".htm");
                    break;
                default:
                    Toast.makeText(getActivity(), "Nothing to show!!!", Toast.LENGTH_LONG).show();
            }
        }
        myWebView.setWebViewClient(new WebViewClient());

    }
    public void setImg(String s){
        try{
            InputStream ims = getActivity().getAssets().open(s);
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            hd.setImageDrawable(d);
        }
        catch (Exception e){
            return;
        }
    }
}
