package com.gilbram.rs.Hospital;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.gilbram.rs.POJO.ModelRumahSakit;
import com.gilbram.rs.R;
import com.gilbram.rs.holder.HospitalHolder;

import java.util.List;

public class HospitalUmumAdapter extends RecyclerView.Adapter<HospitalHolder> {

    public List<ModelRumahSakit> rumahSakitList;
    private HospitalUmumAdapter.onSelectData onSelectData;
    private Context mContext;

    public interface onSelectData {
        void onSelected(ModelRumahSakit modelRumahSakit);
    }

    public HospitalUmumAdapter(Context context, List<ModelRumahSakit> modelRumahSakitList,
                               HospitalUmumAdapter.onSelectData xSelectData) {
        this.mContext = context;
        this.rumahSakitList = modelRumahSakitList;
        this.onSelectData = xSelectData;
    }

    @Override
    public HospitalHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_data_rsu, viewGroup, false);
        return new HospitalHolder(view);
    }

    @Override
    public void onBindViewHolder(HospitalHolder viewHolder, int position) {

        final ModelRumahSakit data = rumahSakitList.get(position);
        viewHolder.tv_nama_rs.setText("RS" + " " + data.getNamaRs());
        viewHolder.tv_location.setText(data.getLocation());
        viewHolder.cvRs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSelectData.onSelected(data);
            }
        });
    }

    @Override
    public int getItemCount() {
        return rumahSakitList.size();
    }

}