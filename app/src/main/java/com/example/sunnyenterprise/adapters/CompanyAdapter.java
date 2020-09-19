package com.example.sunnyenterprise.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sunnyenterprise.R;
import com.example.sunnyenterprise.activities.CatalogActivity;
import com.example.sunnyenterprise.model.companyModel.Company;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.ViewHolder> {
    Context context;
    List<Company> companyList;

    public CompanyAdapter(Context context, List<Company> companyList) {
        this.companyList = companyList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.company_grid_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.title.setText(companyList.get(position).getName());

        Picasso.get().
                load(companyList.get(position).getAvatarURL())
                .into(holder.gridIcon);

        holder.gridView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), CatalogActivity.class);
            intent.putExtra("title", String.valueOf(holder.title.getText()));
            intent.putExtra("companyid",String.valueOf(companyList.get(position).getId()));
            view.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return companyList.size();
    }

    public void setData(List<Company> companyList) {
        this.companyList = companyList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView gridIcon;
        CardView gridView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textView2);
            gridIcon = itemView.findViewById(R.id.comp_img);
            gridView = itemView.findViewById(R.id.compantGrid);

        }
    }
}
