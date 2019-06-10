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
import com.example.android.noqfoodprototype.constructors.CardapioItens;

import java.util.List;

public class CardapioAdapter extends RecyclerView.Adapter<CardapioAdapter.ViewHolder> {

    private List<CardapioItens> cardapioItens;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public CardapioAdapter(Context context, List<CardapioItens> cardapio) {
        this.mInflater = LayoutInflater.from(context);
        cardapioItens = cardapio;
    }

    // inflates the row layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.cardapio_list, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the view and textview in each row
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Define Logo
        holder.image.setImageResource( cardapioItens.get( position ).getCardapioItemImage() );
        //Define nome
        holder.nome.setText( cardapioItens.get( position ).getCardapioItemNome() );
        //Define preco
        holder.preco.setText( cardapioItens.get( position ).getCardapioItemPreco() );
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return cardapioItens.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;
        TextView nome;
        TextView preco;

        ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.productIcon);
            nome = itemView.findViewById(R.id.productName);
            preco = itemView.findViewById(R.id.productValor);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public String getItem(int id) {
        return cardapioItens.get(id).getCardapioItemNome();
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