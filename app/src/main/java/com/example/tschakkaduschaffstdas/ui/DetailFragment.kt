package com.example.tschakkaduschaffstdas.ui

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.fragment.navArgs
import com.example.tschakkaduschaffstdas.MainActivity
import com.example.tschakkaduschaffstdas.R
import com.example.tschakkaduschaffstdas.databinding.FragmentDetailBinding
import com.example.tschakkaduschaffstdas.ui.adapter.ItemAdapter

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var adapter: ItemAdapter
    private val args: DetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val position = args.position
        val mainActivity = activity as MainActivity
        val content = mainActivity.dataset[position]

        binding.headlineMTV.text = content.headline
        binding.contentLineMTV.text = content.contentLine

        adapter = ItemAdapter(mainActivity.dataset)

        binding.editBTN.setOnClickListener {
            addNoteDialog(position)
        }

    }

    private fun addNoteDialog(position: Int) {

        val dialogBuilder = AlertDialog.Builder(requireContext())
        val inflater = requireActivity().layoutInflater
        val dialogView = inflater.inflate(R.layout.add_note_dialog, null)

        val headlineET = dialogView.findViewById<EditText>(R.id.headline_ET)
        val contentET = dialogView.findViewById<EditText>(R.id.contentLine_ET)

        val mainActivity = activity as MainActivity
        val noteToEdit = mainActivity.dataset[position]

        headlineET.setText(noteToEdit.headline)
        contentET.setText(noteToEdit.contentLine)

        dialogBuilder.setView(dialogView)
            .setTitle("Edit Note")
            .setPositiveButton("edit note") { _, _ ->
                val textHeadlineInput = headlineET.text.toString()
                val textContentLineInput = contentET.text.toString()

                noteToEdit.headline = textHeadlineInput
                noteToEdit.contentLine = textContentLineInput

                adapter.newData(mainActivity.dataset)

                binding.headlineMTV.text = textHeadlineInput
                binding.contentLineMTV.text = textContentLineInput
            }
            .setNegativeButton("cancel") { dialogInterface, _ ->
                dialogInterface.cancel()
            }
            .show()
    }
}