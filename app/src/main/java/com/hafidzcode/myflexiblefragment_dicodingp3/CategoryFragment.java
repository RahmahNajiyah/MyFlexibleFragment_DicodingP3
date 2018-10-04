package com.hafidzcode.myflexiblefragment_dicodingp3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */

//todo 2 part2 implementasi
public class CategoryFragment extends Fragment implements View.OnClickListener{

    //jangan lupa tambahkan baris dibawah ini > deklarasi
    private Button btnDetailCategory;
    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //todo 3 part2
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        btnDetailCategory = (Button) view.findViewById(R.id.btn_detail_category);
        btnDetailCategory.setOnClickListener(this);
        return view;
    }

    //hasil implementasi
    @Override
    public void onClick(View view) {
        //todo 4 part2
        if (view.getId() == R.id.btn_detail_category){
            //todo 7 part 3 sambungan dari DetailCategoryFragment
            DetailCategoryFragment mDetailCategoryFragment = new DetailCategoryFragment();
            //sistem bundle
            Bundle mBundle = new Bundle();
            mBundle.putString(DetailCategoryFragment.EXTRA_NAME, "Lifestyle");
            String description = "Kategori ini akan berisi produk2 lifestle";
            mDetailCategoryFragment.setArguments(mBundle);
            mDetailCategoryFragment.setDescription(description);
            FragmentManager mFragmentManager = getFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.frame_container, mDetailCategoryFragment, DetailCategoryFragment.class.getSimpleName());
            mFragmentTransaction.addToBackStack(null);
            mFragmentTransaction.commit();
        }

        //Pada langkah diatas kita sedang menyiapkan langkah selanjutnya,
        //bagaimana kita bisa mengirimkan data dari satu fragment ke fragment lain.
        //Sekarang pada HomeFragment tambahkan baris berikut (sdh ditaro atau lihat di HomeFragment) pada method onClick().


        //>> jalannya aplikasi
        //ketika Anda mengklik tombol Kategory Lifestyle pada CategoryFragment akan ada data
        //yang dikirimkan sewaktu perpindahan fragment yang itu melalui object bundle dan mekanisme metode setter and getter
    }

}
