package com.example.androidrecyclerviewexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHoder> {

    private CourseData[] courseData;

    public CourseAdapter(CourseData[] courseData) {
        this.courseData = courseData;
    }

    @Override
    public CourseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View courseLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_layout, null);
        ViewHolder viewHolder = new ViewHolder(courseLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.courseViewTitle.setText(coursesData[position].getTitle());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView courseViewTitle;
        public ImageView imgViewIcon;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            courseViewTitle = (TextView) itemLayoutView.findViewById(R.id.course_title);
            imgViewIcon = (ImageView)
                    itemLayoutView.findViewById(R.id.course_icon);
        }
    }

    @Override
    public int getItemCount(){
        return courseData.length;
    }
}
