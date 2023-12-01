package com.example.tschakkaduschaffstdas.ui

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.tschakkaduschaffstdas.MainActivity
import com.example.tschakkaduschaffstdas.R
import com.example.tschakkaduschaffstdas.data.model.Info
import com.example.tschakkaduschaffstdas.databinding.FragmentHomeBinding
import com.example.tschakkaduschaffstdas.ui.adapter.ItemAdapter

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: ItemAdapter
    private lateinit var mainActivity: MainActivity
    private var dataset: List<Info> = emptyList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainActivity = activity as MainActivity

        dataset = mainActivity.dataset

        adapter = ItemAdapter(dataset)
        binding.mainRV.adapter = adapter

        binding.addBTN.setOnClickListener {
            addNoteDialog()
        }
    }

    private fun addNoteDialog() {

        val dialogBuilder = AlertDialog.Builder(requireContext())
        val inflater = requireActivity().layoutInflater
        val dialogView = inflater.inflate(R.layout.add_note_dialog, null)

        val headlineET = dialogView.findViewById<EditText>(R.id.headline_ET)
        val contentET = dialogView.findViewById<EditText>(R.id.contentLine_ET)

        dialogBuilder.setView(dialogView)
            .setTitle("Add Note")
            .setPositiveButton("add note") { _, _ ->
                val textHeadlineInput = headlineET.text.toString()
                val textContentLineInput = contentET.text.toString()

                val myNote = Info(textHeadlineInput, textContentLineInput)

                mainActivity.addInfo(myNote)
                adapter.newData(mainActivity.dataset)
                binding.mainRV.scrollToPosition(0)
            }
            .setNegativeButton("cancel") { dialogInterface, _ ->
                dialogInterface.cancel()
            }
            .show()
    }
}