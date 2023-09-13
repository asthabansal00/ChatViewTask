package com.asthabansal.chatviewtask

//import android.os.Interface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter (var chatlist:ArrayList<chatDataClass>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var viewType: Int? = null
    var chatDialogInterface: chatDialogInterface? = null

    class meViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var meChat = view.findViewById<TextView>(R.id.tvMeChat)
        var edit = view.findViewById<TextView>(R.id.tvEdit)
        var delete = view.findViewById<TextView>(R.id.tvDelete)
    }

    class otherViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var otherChat = view.findViewById<TextView>(R.id.tvOtherChat)
        var edit = view.findViewById<TextView>(R.id.tvEdit)
        var delete = view.findViewById<TextView>(R.id.tvDelete)

    }

    class groupViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var groupChat = view.findViewById<TextView>(R.id.tvGroupChat)
        var edit = view.findViewById<TextView>(R.id.tvEdit)
        var delete = view.findViewById<TextView>(R.id.tvDelete)
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

                    }
                }

                is otherViewHolder -> {
                    holder.otherChat.setText(chatlist[position].message.toString())
                    holder.edit.setOnClickListener {

                    }
                    holder.delete.setOnClickListener {

                    }
                }

                is groupViewHolder -> {
                    holder.groupChat.setText(chatlist[position].message.toString())
                    holder.edit.setOnClickListener {

                    }
                    holder.delete.setOnClickListener {

                    }
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


