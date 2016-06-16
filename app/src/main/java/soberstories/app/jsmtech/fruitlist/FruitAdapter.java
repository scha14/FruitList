package soberstories.app.jsmtech.fruitlist;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sukriti on 6/8/16.
 */
public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.RV_ViewHolder> {

    private List<String> listOfFruits;
    View itemView;



    public FruitAdapter(Context context, ArrayList<String> listOfFruits) {
        this.mContext = context;
        this.listOfFruits = listOfFruits;

    }

    @Override
    public RV_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_fruit, parent, false); // link to xml
        return new RV_ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final RV_ViewHolder holder, final int position) {
        // This method gets called over and over again as we scroll and as position changes.
        final String fruit = listOfFruits.get(holder.getAdapterPosition());
        holder.mFruitName.setText(fruit);

    }

    @Override
    public int getItemCount() {
        return listOfFruits.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    public class RV_ViewHolder extends RecyclerView.ViewHolder {

        protected TextView mFruitName;

        public RV_ViewHolder(View itemView) {
            super(itemView);

            mFruitName = (TextView) itemView.findViewById(R.id.username_text);

        }


    }
}
