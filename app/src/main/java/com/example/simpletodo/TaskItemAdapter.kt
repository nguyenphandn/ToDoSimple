package com.example.simpletodo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskItemAdapter(val ListOfItems: List<String>, val longClickListener: OnLongClickListener) :
    RecyclerView.Adapter<TaskItemAdapter.ViewHolder>() {

    interface OnLongClickListener {
        fun onItemLongClicked(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        // Get the data model based on position
//        val contact: Contact = mContacts.get(position)
//        // Set item views based on your views and data model
//        val textView = viewHolder.nameTextView
//        textView.setText(contact.name)
//        val button = viewHolder.messageButton
//        button.text = if (contact.isOnline) "Message" else "Offline"
//        button.isEnabled = contact.isOnline
        val item = ListOfItems.get(position)

        holder.textView.text = item
    }

    override fun getItemCount(): Int {
        return ListOfItems.size
    }
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // TO DO
        val textView: TextView

        init {
            textView = itemView.findViewById(android.R.id.text1)

            itemView.setOnLongClickListener {
//                Log.i("Yoon","Long clicked on item: " + adapterPosition)
                longClickListener.onItemLongClicked(adapterPosition)
                true
            }
        }
    }
}