package Adapters;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.noqfoodprototype.constructors.CardapioItens;
import com.example.android.noqfoodprototype.R;

import java.util.ArrayList;

public class CardapioAdapter extends ArrayAdapter<CardapioItens> {

    private int mColorResourceID;
    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param itens A List of BKCardapio objects to display in a list
     */
    public CardapioAdapter(Activity context, ArrayList<CardapioItens> itens, int colorResourceID) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, itens);
        mColorResourceID = colorResourceID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.cardapio_list, parent, false);
        }

        CardapioItens currentCardapioItem = getItem(position);
        // Find the ImageView in cardapio_list.xml layout with the ID productIcon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.productIcon);

        // Check if an image is provided for this word or not
        if (currentCardapioItem.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            iconView.setImageResource(currentCardapioItem.getImageResourceID());
            // Make sure the view is visible
            iconView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            iconView.setVisibility(View.GONE);
        }

        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        iconView.setImageResource(currentCardapioItem.getImageResourceID());

        // Find the TextView in the cardapio_list.xml layout with the ID productName
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.productName);
        nameTextView.setText(currentCardapioItem.getNomeProduto());

        // Find the TextView in the cardapio_list.xml layout with the ID productValor
        TextView valorTextView = (TextView) listItemView.findViewById(R.id.productValor);
        valorTextView.setText(currentCardapioItem.getValorProduto());

        int color = ContextCompat.getColor(getContext(), mColorResourceID);
        // Set the background color of the text container View

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
