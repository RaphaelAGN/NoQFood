package Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.noqfoodprototype.R;
import com.example.android.noqfoodprototype.constructors.EstablishmentsItens;

import java.util.List;

public class EstabilishmentItemAdapter extends RecyclerView.Adapter<EstabilishmentItemAdapter.ViewHolder> {

    private List<EstablishmentsItens> estabelecimentos;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public EstabilishmentItemAdapter(Context context, List<EstablishmentsItens> estabelecimento) {
        this.mInflater = LayoutInflater.from(context);
        estabelecimentos = estabelecimento;
    }

    // inflates the row layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.estabilishment_item, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the view and textview in each row
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int logo = estabelecimentos.get(position).getImageID();
        String nome = estabelecimentos.get(position).getNomeEstabelecimento();

        //Define Logo
        holder.image.setImageResource( logo );
        //Define nome
        holder.nome.setText(nome);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return estabelecimentos.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;
        TextView nome;

        ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.logoEstabilishment);
            nome = itemView.findViewById(R.id.nomeEstabilishments);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public String getItem(int id) {
        return estabelecimentos.get(id).getNomeEstabelecimento();
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}