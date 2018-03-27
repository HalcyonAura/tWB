package cal.worrybook;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.OutputStreamWriter;

/**
 * Created by C on 3/27/2018.
 */

public class NoteHelper {
    private Context context;
    public NoteHelper(Context context){
        this.context = context;
    }
    public String Open(String fileName) {
        String content = "";
        try {
            InputStream in = context.openFileInput(fileName);
            if ( in != null) {
                InputStreamReader tmp = new InputStreamReader( in );
                BufferedReader reader = new BufferedReader(tmp);
                String str;
                StringBuilder buf = new StringBuilder();
                while ((str = reader.readLine()) != null) {
                    buf.append(str + "\n");
                } in .close();

                content = buf.toString();
            }
        } catch (java.io.FileNotFoundException e) {} catch (Throwable t) {
            Toast.makeText(context, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }

        return content;
    }
    public void Save(String fileName, String content) {
        try {
            OutputStreamWriter out =
                    new OutputStreamWriter(context.openFileOutput(fileName, 0));
            //out.write(mainText.getText().toString()); TODO FIX THIS CALL
            out.write(content);
            out.close();
            Toast.makeText(context, "Note saved!", Toast.LENGTH_SHORT).show();
        } catch (Throwable t) {
            Toast.makeText(context, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
    }

    public boolean FileExists(String fname) {
        //File file = getBaseContext().getFileStreamPath(fname);
        File file = new File(fname);
        return file.exists();
    }
}
