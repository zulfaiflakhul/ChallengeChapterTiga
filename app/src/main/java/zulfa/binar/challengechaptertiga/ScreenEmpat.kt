package zulfa.binar.challengechaptertiga

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_screen_empat.*

class ScreenEmpat : Fragment() {

    private lateinit var nama : String
    private lateinit var umur : String
    private lateinit var alamat : String
    private lateinit var pekerjaan : String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_screen_empat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val datauser = arguments?.getParcelable<DataUser>("DATA_USER") as DataUser

        nama = datauser.nama.toString()
        umur = datauser.umur.toString()
        alamat = datauser.alamat.toString()
        pekerjaan = datauser.pekerjaan.toString()

        but_backscreen3.setOnClickListener {

            umur = et_umur.text.toString()
            alamat = et_alamat.text.toString()
            pekerjaan = et_pekerjaan.text.toString()

            val dataUser = DataUser(nama, umur, alamat, pekerjaan)
            val bundle = bundleOf("DATA_USER" to dataUser)
            Navigation.findNavController(view).navigate(R.id.navback_screentiga, bundle)
        }

    }
}