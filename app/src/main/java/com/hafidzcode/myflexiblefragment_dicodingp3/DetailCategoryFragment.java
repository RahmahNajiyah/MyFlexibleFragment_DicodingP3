package com.hafidzcode.myflexiblefragment_dicodingp3;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

// todo to projek fragment part 3 = proses implementasi dari pengiriman data melalui perpindahan fragment
//Kita telah belajar bagaimana berpindah dari satu fragment ke fragment lain,
//sekarang kita akan membuat bagaimana berpindah fragment dengan membawa data.
// Terdapat dua cara, 1. Dengan menggunakan obyek Bundle dan
// 2. Dengan menggunakan setter dan getter

/**
 * A simple {@link Fragment} subclass.
 */
//implementasi sprti di part 1 dan 2
public class DetailCategoryFragment extends Fragment implements View.OnClickListener {
    //todo 2 part 3
    private TextView tvCategoryName;
    private TextView tvCategoryDescription;
    private Button btnProfile;
    private Button btnshowDialog;
    public static String EXTRA_NAME = "extra_name";
    private String description;

    public DetailCategoryFragment() {
        // Required empty public constructor
    }
    //todo 3 part 3 sistem setter n getter
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //todo 4 part 3
        View view =  inflater.inflate(R.layout.fragment_detail_category, container, false);
        tvCategoryName = (TextView) view.findViewById(R.id.tv_category_name);
        tvCategoryDescription = (TextView) view.findViewById(R.id.tv_category_description);
        btnProfile = (Button) view.findViewById(R.id.btn_profile);
        btnshowDialog = (Button) view.findViewById(R.id.btn_show_dialog);
        //event click
        btnProfile.setOnClickListener(this);
        btnshowDialog.setOnClickListener(this);
        return view;
    }
    //todo 5 part 3 > mendemonstrasikan bagaimana melakukan penampilan data yang dikirim melalui perpindahan fragment.
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String categoryName = getArguments().getString(EXTRA_NAME);
        tvCategoryName.setText(categoryName);
        tvCategoryDescription.setText(getDescription());
    }

    //hasil implementasi
    @Override
    public void onClick(View view) {
        //todo 6 part 3
        switch (view.getId()){
            case R.id.btn_profile:
                //todo 2 part 5
                //getActivity() adalah kelas activity dimana fragment tersebut ditempelkan.
                Intent mIntent = new Intent(getActivity(), ProfileActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_show_dialog:
                //todo 9 part 4 sambungan dari option dialog fragment
                OptionDialogFragment mOptionDialogFragment = new OptionDialogFragment();
                mOptionDialogFragment.setOnOptionDialogListener(new OptionDialogFragment.OnOptionDialogListener() {
                    @Override
                    public void onOptionChoosen(String text) {
                        Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
                    }
                });
                //todo 10 part 4
                FragmentManager mFragmentManager = getChildFragmentManager();
                mOptionDialogFragment.show(mFragmentManager, OptionDialogFragment.class.getSimpleName());
                break;
        }

        //tinggal selangkah lagi proses implementasi dari pengiriman data melalui perpindahan fragment selesai,
        // sekarang buka kembali CategoryFragment.java
        // lalu tambahkan baris berikut pada method onClick(). >> (baris sdh ditambahkan atau lihat di CategoryFragment)

    }
}
