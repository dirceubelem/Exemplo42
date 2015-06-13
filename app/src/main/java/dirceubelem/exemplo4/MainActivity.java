package dirceubelem.exemplo4;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import dirceubelem.exemplo4.adapter.AmigoAdapter;
import dirceubelem.exemplo4.task.RedeTask;
import dirceubelem.exemplo4.to.TORede;


public class MainActivity extends ActionBarActivity {

    private ProgressDialog pd;
    private ListView listAmigos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listAmigos = (ListView) findViewById(R.id.listAmigos);

        obterRede();
    }

    public void obterRede() {

        pd = new ProgressDialog(this);
        pd.setMessage("Carregando...");
        pd.show();

        RedeTask r = new RedeTask() {
            @Override
            protected void onPostExecute(TORede toRede) {

                pd.hide();

                if (toRede != null) {

                    AmigoAdapter adapter = new AmigoAdapter(toRede, MainActivity.this);
                    listAmigos.setAdapter(adapter);

                }

            }
        };

        r.execute("");

    }


}
