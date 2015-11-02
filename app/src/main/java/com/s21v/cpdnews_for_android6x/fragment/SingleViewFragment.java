package com.s21v.cpdnews_for_android6x.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.s21v.cpdnews_for_android6x.R;

/**
 * Created by 弈 on 2015/11/2.
 */
public class SingleViewFragment extends Fragment {
    public static SingleViewFragment getInstance(int imgId) {
        SingleViewFragment singleViewFragment = new SingleViewFragment();
        Bundle data = new Bundle();
        data.putInt("ImgID", imgId);
        singleViewFragment.setArguments(data);
        return singleViewFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash_item,null);
        ImageView imageView = (ImageView) view.findViewById(R.id.id_splash_bg);
        imageView.setImageResource(getArguments().getInt("ImgID"));
        return view;
    }
}
