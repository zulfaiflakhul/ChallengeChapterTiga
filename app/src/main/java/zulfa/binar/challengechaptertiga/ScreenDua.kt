package zulfa.binar.challengechaptertiga

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_screen_dua.*

class ScreenDua : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_screen_dua, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        but_screen3.setOnClickListener {

            val nama = et_nama.text.toString()

            val dataUser = DataUser(nama, null, null, null)
            val bundle = bundleOf("DATA_USER" to dataUser)
            Navigation.findNavController(view).navigate(R.id.navike_screentiga, bundle)
        }
    }

}