package aditya.rupal.translate.orcandtext.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import aditya.rupal.translate.orcandtext.R;
import aditya.rupal.translate.orcandtext.data.TranslationData;

public class TranslationRecyclerAdapter extends RecyclerView.Adapter<TranslationRecyclerAdapter.TranslationViewHolder> {

    Context context;
    ArrayList<TranslationData> list;

    public TranslationRecyclerAdapter(Context context, ArrayList<TranslationData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TranslationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TranslationViewHolder(LayoutInflater.from(context).inflate(R.layout.item_ocrtrans, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TranslationViewHolder holder, int position) {
        TranslationData td = list.get(position);

        holder.orig.setText(td.original);
        holder.trans.setText(td.translation);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TranslationViewHolder extends RecyclerView.ViewHolder {
        TextView orig, trans;

        public TranslationViewHolder(View itemView) {
            super(itemView);
            orig = itemView.findViewById(R.id.originalText);
            trans = itemView.findViewById(R.id.translatedText);
        }
    }
}
