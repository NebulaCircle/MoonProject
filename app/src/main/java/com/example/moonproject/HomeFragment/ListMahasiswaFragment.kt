package com.example.moonproject.HomeFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.moonproject.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListMahasiswaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListMahasiswaFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_mahasiswa, container, false)

        // Access the ListView
        val listView: ListView = view.findViewById(R.id.listView)

        // Access the string-array from resources
        val mahasiswaArray = resources.getStringArray(R.array.mahasiswa)

        // Set up ArrayAdapter and bind to ListView
        val adapter =
            ArrayAdapter(requireContext(), R.layout.list_view_item, R.id.text, mahasiswaArray)
        listView.adapter = adapter
        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedName = mahasiswaArray[position]
            Toast.makeText(requireContext(), "Nama: $selectedName", Toast.LENGTH_SHORT).show()
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListMahasiswaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListMahasiswaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}