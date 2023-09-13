package com.asthabansal.chatviewtask

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.asthabansal.chatviewtask.databinding.FragmentDialogBinding

interface chatDialogInterface{
    fun returnChatType(viewType: Int)
    }


class DialogClass() : DialogFragment() {

    lateinit var fragmentDialog : Dialog
    lateinit var dialogBinding:FragmentDialogBinding
    lateinit var mainActivity: MainActivity
    lateinit var  chatDialogInterface: chatDialogInterface
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        mainActivity = activity as MainActivity
        fragmentDialog = Dialog(requireContext())
        dialogBinding = FragmentDialogBinding.inflate(layoutInflater)
        fragmentDialog?.setContentView(dialogBinding.root)
        dialogBinding.tvMe.setOnClickListener {
            chatDialogInterface.returnChatType(2)
            fragmentDialog.dismiss()

        }

        dialogBinding.tvOthers.setOnClickListener {
            chatDialogInterface.returnChatType(1)
            fragmentDialog.dismiss()

        }

            dialogBinding.tvGroup.setOnClickListener {

                chatDialogInterface.returnChatType(3)
                fragmentDialog.dismiss()
            }



        return fragmentDialog
    }
    companion object{
        //        const val TAG = "DialogClass"
        var TAG = this::class.java.canonicalName

    }

}
