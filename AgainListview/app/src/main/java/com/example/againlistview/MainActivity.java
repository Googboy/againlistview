package com.example.againlistview;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ListActivity {


    String[] countries = {"shanghai","zhenghou","chongqing","qingdao","xian","qinghai","anhui","aomen","hubei","hunan","henan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setListAdapter(new IconicAdapter());
    }


    private class IconicAdapter extends ArrayAdapter<String> {
        public IconicAdapter() {
            super(MainActivity.this, R.layout.entry, countries);
        }

        //动态设置每个元素
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            View row = inflater.inflate(R.layout.entry, parent, false);
            TextView textView = (TextView) row.findViewById(R.id.tv_label);
            ImageView icon = (ImageView) row.findViewById(R.id.image_icon);
            textView.setText(countries[position]);
            if (countries[position].length() > 5) {//设置数组里面的元素如果长度大于4显示一种图标，小于4显示另外一种图标，这里设置的按下和正常时表示的2种状态
                icon.setImageResource(R.drawable.pressed);
            } else {
                icon.setImageResource(R.drawable.normal);
            }
            return row;
        }
    }


            //让程序更有效率
            /*
            View row = convertView;
            if (row == null){
                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(R.layout.entry,parent,false);
                TextView textView = (TextView) row.findViewById(R.id.tv_label);
                ImageView icon = (ImageView) row.findViewById(R.id.image_icon);
                textView.setText(countries[position]);
                if (countries[position].length()>5){//设置数组里面的元素如果长度大于4显示一种图标，小于4显示另外一种图标，这里设置的按下和正常时表示的2种状态
                    icon.setImageResource(R.drawable.pressed);
                }else {
                    icon.setImageResource(R.drawable.normal);
                }
                return row;
            }
            return row;
            */
            /*
            //进一步有效率 setTag()
            class ViewWrapper{
                View base;
                TextView textView = null;
                ImageView imageView = null;

                ViewWrapper(View base){
                    this.base = base;
                }
                TextView getTextView(){
                    if (textView == null)
                        textView = (TextView) findViewById(R.id.tv_label);
                        return textView;
                }
                ImageView getImageView(){
                    if (imageView == null)
                        imageView = (ImageView) findViewById(R.id.image_icon);
                        return imageView;
                    }
            }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            ViewWrapper wrapper = null;
            if (row == null){
                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(R.layout.entry,parent,false);
                wrapper = new ViewWrapper(row);
                row.setTag(wrapper);
            }else{
                wrapper = (ViewWrapper) row.getTag();
            }
            wrapper.getTextView().setText(countries[position]);
            if (countries[position].length()>5){
                wrapper.getImageView().setImageResource(R.drawable.pressed);
            }else{
                wrapper.getImageView().setImageResource(R.drawable.normal);
            }
            return row;
        }
    }
    */
}
