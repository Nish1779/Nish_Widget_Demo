package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import java.security.PublicKey;

public class DemoWidgetStackService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new DemoWidgetStackiewsFactory(this.getApplicationContext());
    }
}


class DemoWidgetStackiewsFactory implements RemoteViewsService.RemoteViewsFactory {

    public static int numimg= 6;
    public Context context;

    public DemoWidgetStackiewsFactory(Context context){
        this.context=context;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDataSetChanged() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return numimg;
    }

    @Override
    public RemoteViews getViewAt(int i) {
        RemoteViews view = new RemoteViews(context.getPackageName() , R.layout.stack_items);

        // i goes from 0 to 1 and images number are 1 to...

        int num = i-1;
        String image_id= "img_"+num ;

        // getResource().getIdentifier("myicon", "drawable", getPackageName());

         view.setImageViewResource(R.id.stk_img, context.getResources().getIdentifier(image_id,"drawable",context.getPackageName()));
        return view;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}
