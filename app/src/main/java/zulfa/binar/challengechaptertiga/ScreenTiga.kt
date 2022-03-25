package zulfa.binar.challengechaptertiga

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_screen_tiga.*

class ScreenTiga : Fragment() {

    private lateinit var nama : String
    private lateinit var umur : String
    private lateinit var alamat : String
    private lateinit var pekerjaan : String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_screen_tiga, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val datauser = arguments?.getParcelable<DataUser>("DATA_USER") as DataUser

        nama = datauser.nama.toString()
        umur = datauser.umur.toString()
        alamat = datauser.alamat.toString()
        pekerjaan = datauser.pekerjaan.toString()

        but_screen4.setOnClickListener {

            val dataUser = DataUser(nama, umur, alamat, pekerjaan)
            val bundle = bundleOf("DATA_USER" to dataUser)
            Navigation.findNavController(view).navigate(R.id.navike_screenempat, bundle)
        }

        hasilData()
    }

    private  fun hasilData(){

        if (umur == "null"){
            text_namasatu.text = nama
        } else {
            semuaData()
        }
    }

    private fun semuaData() {
        val textUmur = if (umur != "") {

            cekUmur(umur.toInt())
        } else {
            ""
        }

        text_namadua.text = nama
        text_umur.text = textUmur
        text_alamat.text = alamat
        text_pekerjaan.text = pekerjaan
    }

    private fun cekUmur(umur: Int): String {
        return if (umur % 2 == 0) {
            "$umur, bernilai Genap"
        } else {
            "$umur, bernilai Ganjil"
        }
    }
}