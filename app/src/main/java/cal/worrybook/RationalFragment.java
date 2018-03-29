package cal.worrybook;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RationalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RationalFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String fileName, content;
    private NoteHelper helper;
    private EditText rationalText;

    public RationalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RationalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RationalFragment newInstance(String fileName, String content) {
        RationalFragment fragment = new RationalFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, fileName);
        args.putString(ARG_PARAM2, content);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            fileName = getArguments().getString(ARG_PARAM1);
            content = getArguments().getString(ARG_PARAM2);
        }
        helper = new NoteHelper();
        Log.d("onCreate", "entered");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rational, container, false);
        rationalText = (EditText) view.findViewById(R.id.rationalText);
        rationalText.setText(content); //?? TODO fix if necessary
        Log.d("onCreateView", "entered");
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        content = rationalText.getText().toString();
        helper.Save(fileName, content, getContext().getApplicationContext());
        savedInstanceState.putString(ARG_PARAM1, fileName);
        savedInstanceState.putString(ARG_PARAM2, content);
    }
}
