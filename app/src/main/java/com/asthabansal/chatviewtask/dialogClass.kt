package com.asthabansal.chatviewtask

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.asthabansal.chatviewtask.databinding.FragmentDialogBinding

interface chatDialogInterface{
    fun returnChatType():Int
    }


class dialogClass:DialogFragment() {

    lateinit var fragmentDialog : Dialog
    lateinit var dialogBinding:FragmentDialogBinding
    lateinit var mainActivity: MainActivity

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        mainActivity = activity as MainActivity
        fragmentDialog = Dialog(requireContext())
        dialogBinding = FragmentDialogBinding.inflate(layoutInflater)
        fragmentDialog?.setContentView(dialogBinding.root)
        dialogBinding.tvMe.setOnClickListener {
            fun returnChatDataType(): Int {
                return 1
            }
        }
        dialogBinding.tvGroup.setOnClickListener {
            fun returnChatDataType(): Int {
                return 2
            }        }
        dialogBinding.tvOthers.setOnClickListener {
            fun returnChatDataType(): Int {
                return 3
            }        }

        return fragmentDialog
    }
    companion object{
        //        const val TAG = "DialogClass"
        var TAG = this::class.java.canonicalName

    }

}
