package ml.ananthakumar.androidlabweek7.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ml.ananthakumar.androidlabweek7.R;
import ml.ananthakumar.androidlabweek7.support.ApiClient;
import ml.ananthakumar.androidlabweek7.support.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link WebServerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link WebServerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WebServerFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private View view;
    private Button load;
    private ListView list;
    BooksArrayAdapter adapter;

    List<String> data;

    public WebServerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment WebServerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WebServerFragment newInstance(String param1) {
        WebServerFragment fragment = new WebServerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_web_server, container, false);
        data = new ArrayList<>();
        load = (Button) view.findViewById(R.id.load_button);
        list = (ListView) view.findViewById(R.id.books_list);
        adapter = new BooksArrayAdapter(view.getContext(),android.R.layout.simple_list_item_1,data);
        list.setAdapter(adapter);
        //list.setVisibility(View.INVISIBLE);


        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();

            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    void loadData(){
        Log.i("AndroidLab","button clicked");
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<List<String>> call = apiService.getBooks();
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>>call, Response<List<String>> response) {
                List<String> books = response.body();
                Log.d("AndroidLab", "Number of books received: " + books.size());
                //list.setVisibility(View.VISIBLE);
                //data = books;
                copyData(books);
                adapter.dataChanged(data);
                //Log.i("AndroidLab","data received "+data.get(4));
            }

            @Override
            public void onFailure(Call<List<String>>call, Throwable t) {
                // Log error here since request failed
                Log.e("AndroidLab", t.toString());
            }
        });
    }

    private void copyData(List<String> p){
        for ( String i : p) {
            data.add(i);
        }
    }
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
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    private class BooksArrayAdapter extends ArrayAdapter<String>{

        List<String> dataList = new ArrayList<String>();
        public BooksArrayAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<String> objects) {
            super(context, resource, objects);
            dataList = objects;
        }

        @Override
        public long getItemId(int pos){
            String item = getItem(pos);
            return dataList.indexOf(item);
        }

        @Override
        public boolean hasStableIds(){
            return true;
        }

        public void dataChanged(List<String> d)
        {
            dataList = d;
            notifyDataSetChanged();
        }
    }
}
