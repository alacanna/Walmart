package br.com.walmart.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import br.com.walmart.R;


/**
 * Created by amanda.lacanna on 14/04/2015.
 */
public class MyProgressBar extends RelativeLayout{

    LayoutInflater mInflater;
    public MyProgressBar(Context context) {
        super(context);
        mInflater = LayoutInflater.from(context);
        init();

    }
    public MyProgressBar(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        mInflater = LayoutInflater.from(context);
        init();
    }
    public MyProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mInflater = LayoutInflater.from(context);
        init();
    }
    public void init()
    {
        mInflater.inflate(R.layout.my_progress, this, true);
        RelativeLayout progress = (RelativeLayout)getRootView().findViewById(R.id.progress);

        progress.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
