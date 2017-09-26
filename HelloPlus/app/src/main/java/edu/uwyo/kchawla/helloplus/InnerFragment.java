package edu.uwyo.kchawla.helloplus;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InnerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class InnerFragment extends Fragment {

    public static final String TAG = "HEY_LISTEN_fragment";

    private OnFragmentInteractionListener mListener;

    private EditText mNameField;
    private Button mSubmitButton;
    private TextView mHelloText;

    public InnerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        Log.i(TAG,"Fragment created");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_inner, container, false);

        mNameField = (EditText)v.findViewById(R.id.text_field);

        mHelloText = (TextView)v.findViewById(R.id.hello_text);
        mHelloText.setVisibility(View.INVISIBLE);

        mSubmitButton = (Button)v.findViewById(R.id.submit_button);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG,"Button clicked - send name to activity");
                mListener.onFragmentInteraction(mNameField.getText().toString());

                Log.i(TAG,"Update Hello text");
                mHelloText.setText("Hello " + mNameField.getText());
                mHelloText.setVisibility(View.VISIBLE);
            }
        });


        return v;
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

        Log.i(TAG,"Attach");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;

        Log.i(TAG,"Detach");
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     *
     * Passes string to activity
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String str);
    }
}
