package com.hafidzcode.myflexiblefragment_dicodingp3;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

//todo to projek fragment part 4 = pemanfaatan fragment untuk menampilkan sebuah custom dialog. Kita akan menggunakan DialogFragment lengkap dengan interaksinya

/**
 * A simple {@link Fragment} subclass.
 */
//implementasi onClick like usual
// inherit ke kelas DialogFragment pada android support library
public class OptionDialogFragment extends DialogFragment implements View.OnClickListener {
    //todo 3 part 4
    private Button btnChoose, btnClose;
    private RadioGroup rgOptions;
    private RadioButton rblillah, rbjihad, rbfisabilillah, rbhijrah;
    //OnOptionDialogListener di alt + enter > jadiin interface
    private OnOptionDialogListener onOptionDialogListener;

    public OptionDialogFragment() {
        // Required empty public constructor
    }

    //todo 4 part 4
    //pilih yg interface
    public OnOptionDialogListener getOnOptionDialogListener() {
        return onOptionDialogListener;
    }

    public void setOnOptionDialogListener(OnOptionDialogListener onOptionDialogListener) {
        this.onOptionDialogListener = onOptionDialogListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //todo 5 part 4
        View view = inflater.inflate(R.layout.fragment_option_dialog, container, false);
        btnChoose = (Button) view.findViewById(R.id.btn_choose);
        btnClose = (Button) view.findViewById(R.id.btn_close);
        rgOptions = (RadioGroup) view.findViewById(R.id.rg_options);
        rblillah = (RadioButton) view.findViewById(R.id.rb_lillah);
        rbfisabilillah = (RadioButton) view.findViewById(R.id.rb_fisabilillah);
        rbjihad = (RadioButton) view.findViewById(R.id.rb_jihad);
        rbhijrah = (RadioButton) view.findViewById(R.id.rb_hijrah);

        //event klik
        btnClose.setOnClickListener(this);
        btnChoose.setOnClickListener(this);
        return view;
    }

    //hasil implementasi
    @Override
    public void onClick(View view) {
        //todo 6 part 4
        switch (view.getId()) {
            case R.id.btn_close:
                getDialog().cancel();
                break;
            case R.id.btn_choose:
                int checkedRadioButtonId = rgOptions.getCheckedRadioButtonId();
                if (checkedRadioButtonId != -1) {
                    String coach = null;
                    switch (checkedRadioButtonId) {
                        case R.id.rb_lillah:
                            coach = rblillah.getText().toString().trim();
                            break;

                        case R.id.rb_fisabilillah:
                            coach = rbfisabilillah.getText().toString().trim();
                            break;

                        case R.id.rb_jihad:
                            coach = rbjihad.getText().toString().trim();
                            break;

                        case R.id.rb_hijrah:
                            coach = rbhijrah.getText().toString().trim();
                            break;
                    }
                    //todo 7 part 4
                    getOnOptionDialogListener().onOptionChoosen(coach);
                    getDialog().cancel();
                }
                break;
        }

    }

    //todo 8 part 4
    public interface OnOptionDialogListener {
        void onOptionChoosen(String text);
    }
}
    //Setelah selesai, tambahkan beberapa baris pada metode onClick() di DetailCategoryFragment (lihat di DetailCategoryFragment)