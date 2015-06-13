package dirceubelem.exemplo4.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import dirceubelem.exemplo4.R;
import dirceubelem.exemplo4.to.TOAmigo;
import dirceubelem.exemplo4.to.TORede;

/**
 * Created by dirceubelem on 16/05/15.
 */
public class AmigoAdapter extends BaseAdapter {

    private TORede rede;
    private Context context;

    public AmigoAdapter(TORede rede, Context context) {
        this.rede = rede;
        this.context = context;
    }

    @Override
    public int getCount() {
        return rede.getLista().size();
    }

    @Override
    public Object getItem(int position) {
        return rede.getLista().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TOAmigo t = rede.getLista().get(position);

        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View v = inflater.inflate(R.layout.item_rede, null);

        TextView txtAmigo = (TextView) v.findViewById(R.id.nome);
        txtAmigo.setText(t.getUsuario());

        return v;
    }
}
