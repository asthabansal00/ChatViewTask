package com.asthabansal.chatviewtask

//import android.os.Interface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.asthabansal.chatviewtask.databinding.BottomSheetDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.text.SimpleDateFormat
import java.util.Calendar

class RecyclerAdapter (var chatlist:ArrayList<chatDataClass>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var viewType: Int? = null
    var chatDialogInterface: chatDialogInterface? = null
    var date =  SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().time)
    var time =  SimpleDateFormat("hh:mm:ss").format(Calendar.getInstance().time)

    class meViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var meChat = view.findViewById<TextView>(R.id.tvMeChat)
        var edit = view.findViewById<TextView>(R.id.tvEdit)
        var delete = view.findViewById<TextView>(R.id.tvDelete)
        var myChatDate = view.findViewById<TextView>(R.id.tvDate)
        var myChatTime = view.findViewById<TextView>(R.id.tvTime)
        var editButton = view.findViewById<TextView>(R.id.tvEdit)

    }

    class otherViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var otherChat = view.findViewById<TextView>(R.id.tvOtherChat)
        var edit = view.findViewById<TextView>(R.id.tvEdit)
        var delete = view.findViewById<TextView>(R.id.tvDelete)
        var otherChatDate = view.findViewById<TextView>(R.id.tvDate)
        var otherChatTime = view.findViewById<TextView>(R.id.tvTime)

    }

    class groupViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var groupChat = view.findViewById<TextView>(R.id.tvGroupChat)
        var edit = view.findViewById<TextView>(R.id.tvEdit)
        var delete = view.findViewById<TextView>(R.id.tvDelete)
        var groupChatDate = view.findViewById<TextView>(R.id.tvDate)
        var groupChatTime = view.findViewById<TextView>(R.id.tvTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        /*when(viewType){
            1->{}
            2->{}
            else->{}
        }*/
        if (this.viewType == 1 ) {
                    return otherViewHolder(
                        LayoutInflater.from(parent.context)
                            .inflate(R.layout.other_item_view, parent, false)
                    )
                }
        else if (this.viewType == 2 ) {
                    return groupViewHolder(
                        LayoutInflater.from(parent.context)
                            .inflate(R.layout.group_item_view, parent, false)
                    )
        }

        else {
            return meViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.me_item_view, parent, false)
            )
        }
    }

        override fun getItemCount(): Int {
            return chatlist.size
        }

    override fun getItemViewType(position: Int): Int {
        this.viewType = chatlist[position].viewType
        return chatlist[position].viewType
    }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            when (holder) {
                is meViewHolder -> {
                    holder.meChat.setText(chatlist[position].message.toString())
                    holder.edit.setOnClickListener {
                    }
                    holder.delete.setOnClickListener {
                        chatlist.clear()
                    }
                    holder.myChatTime.setText(time.toString())
                    holder.myChatDate.setText(date.toString())

                    /*holder.editButton.setOnClickListener {
                        var bottomSheetDialog:BottomSheetDialog?=null
                        var dialogBinding = BottomSheetDialogBinding.inflate()
                        bottomSheetDialog?.dismiss()
                        bottomSheetDialog?.show()
                    }*/
                }

                is otherViewHolder -> {
                    holder.otherChat.setText(chatlist[position].message.toString())
                    holder.edit.setOnClickListener {

                    }
                    holder.delete.setOnClickListener {
                        chatlist.clear()
                    }
                    holder.otherChatTime.setText(time.toString())
                    holder.otherChatDate.setText(date.toString())
                }

                is groupViewHolder -> {
                    holder.groupChat.setText(chatlist[position].message.toString())
                    holder.edit.setOnClickListener {

                    }
                    holder.delete.setOnClickListener {
                        chatlist.clear()
                    }
                    holder.groupChatTime.setText(time.toString())
                    holder.groupChatDate.setText(date.toString())
                }
            }

        }

        override fun getItemId(position: Int): Long {
            if (position % 2 == 0) {
                viewType = 2//chatDialogInterface.mychat()

            } else {
                viewType = 1
            }
            return super.getItemId(position)
        }
}


