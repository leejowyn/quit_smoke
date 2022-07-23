package com.example.quitsmokingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HelpAdapter extends RecyclerView.Adapter<HelpAdapter.GuideVH> {

    private static final String TAG = "HelpAdapter";
    List<Help> helpList;

    public HelpAdapter(List<Help> helpList) {
        this.helpList = helpList;
    }

    @NonNull
    @Override
    public GuideVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gethelp_row, parent, false);
        return new GuideVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GuideVH holder, int position) {

        Help help = helpList.get(position);
        holder.titleTextView.setText(help.getTitle());
        holder.yearTextView.setText(help.getYear());
        holder.plotTextView.setText(help.getPlot());

        boolean isExpanded = helpList.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return helpList.size();
    }

    class GuideVH extends RecyclerView.ViewHolder {

        private static final String TAG = "GuideVH";

        ConstraintLayout expandableLayout;
        TextView titleTextView, yearTextView, plotTextView;

        public GuideVH(@NonNull final View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.titleTextView);
            yearTextView = itemView.findViewById(R.id.yearTextView);
            plotTextView = itemView.findViewById(R.id.plotTextView);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);


            titleTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Help help = helpList.get(getAdapterPosition());
                    help.setExpanded(!help.isExpanded());
                    notifyItemChanged(getAdapterPosition());

                }
            });
        }
    }
}
