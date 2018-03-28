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
    public NoteHelper(){ }

    public String Open(String fileName, Context context) {
        String content = "";
        if (FileExists(fileName, context)) {
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
        }
        else{
            content = "";
        }
        return content;
    }

    public String getFile(String fileName, Context context) {
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
    public void Save(String fileName, String content, Context context) {
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

    public boolean FileExists(String fname, Context context) {
        File file = context.getApplicationContext().getFileStreamPath(fname);
        //File file = new File(fname);
        return file.exists();
    }
}
