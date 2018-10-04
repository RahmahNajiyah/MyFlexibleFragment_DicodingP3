package com.hafidzcode.myflexiblefragment_dicodingp3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

//todo 2
//projek fragment part 1 = kita buat beberapa fragment untuk mengimplementasikan perpindahan tampilan tanpa perpindahan activity.
//klik kanan pada package utama pada project aplikasi Anda → New → Fragment → Fragment (Blank).
//uncheck untuk kedua pilihan (Include fragment factory methods dan include interface callbacks)
/**
 * A simple {@link Fragment} subclass.
 */
//todo 5 implementasi onClick
public class HomeFragment extends Fragment implements View.OnClickListener {


    public HomeFragment() {
        // Required empty public constructor
    }


    //Pada HomeFragment.java terdapat metode onCreateView()
    //dimana layout interface didefinisikan dan ditransformasi dari layout berupa file xml kedalam obyek view dengan menggunakan metode inflate().
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //todo 6
        //Inflater.inflate() merupakan obyek dari LayoutInflater yang berfungsi untuk mengubah layout xml ke dalam bentuk obyek viewgroup atau widget melalui pemanggilan metode inflate().
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Button btnCategory = (Button) view.findViewById(R.id.btn_category);
        btnCategory.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        //todo 7
        if (view.getId() == R.id.btn_category){
            //todo to CategoryFragment (sambungan dari CategoryFragment)
            // kita memanfaatkan FragmentManager untuk mengorganize atau mengkoordinasi
            //semua obyek fragment yang terdapat didalam sebuah activity dan menempelkan
            //CategoryFragment kedalam activity dengan menggunakan FragmentTransaction.
            CategoryFragment mCategoryFragment = new CategoryFragment();
            FragmentManager mFragmentManager = getFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.frame_container,mCategoryFragment,CategoryFragment.class.getSimpleName());//method replace() akan mengganti obyek fragment yang sedang tampil saat ini, HomeFragment dengan obyek fragment yang baru, CategoryFragment.
            mFragmentTransaction.addToBackStack(null); //Kita menggunakan addToBackStack(null) karena kita ingin obyek fragment yang saat ini kita ciptakan masuk kedalam sebuah fragment stack yang nantinya ketika kita tekan tombol back dia akan pop-out keluar dari stack dan menampilkan obyek fragment sebelumnya, HomeFragment.
            mFragmentTransaction.commit();

        }

    }
}
