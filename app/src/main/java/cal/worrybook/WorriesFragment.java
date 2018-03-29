package cal.worrybook;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link WorriesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link WorriesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WorriesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String fileName, content;
    private NoteHelper helper;
    private EditText worriesText;

    //private OnFragmentInteractionListener mListener;

    public WorriesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param fileName Parameter 1.
     * @param content Parameter 2.
     * @return A new instance of fragment WorriesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WorriesFragment newInstance(String fileName, String content) {
        WorriesFragment fragment = new WorriesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, fileName);
        args.putString(ARG_PARAM2, content);
        fragment.setArguments(args);
        return fragment;
    }

    //Figure out how to save file while still in fragment

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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_worries, container, false);
        worriesText = (EditText) view.findViewById(R.id.worriesText);
        worriesText.setText(content); //?? TODO fix if necessary
        Log.d("onCreateView", "entered");
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        content = worriesText.getText().toString();
        helper.Save(fileName, content, getContext().getApplicationContext());
        savedInstanceState.putString(ARG_PARAM1, fileName);
        savedInstanceState.putString(ARG_PARAM2, content);
    }

/*
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }*/

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    /*
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/
}
