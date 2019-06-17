package by.arro.testtask.presentation.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.arro.testtask.R
import by.arro.testtask.domain.entity.Row
import kotlinx.android.synthetic.main.item_row.view.*

class RowsAdatpter(
    context: Context,
    private val onDeleteClicked: (Int) -> Unit
) : RecyclerView.Adapter<RowsAdatpter.RowViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    private val items = mutableListOf<Row>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowViewHolder {
        val itemView = inflater.inflate(R.layout.item_row, parent, false)
        return RowViewHolder(itemView, onDeleteClicked)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RowViewHolder, position: Int) {
        holder.updateWith(items[position])
    }

    fun update(newItems: List<Row>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    class RowViewHolder(
        itemView: View,
        onDeleteClicked: (Int) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        private var model: Row? = null

        init {
            itemView?.containerDelete.setOnClickListener {
                model?.let { model ->
                    onDeleteClicked(model.id)
                }
            }
        }

        fun updateWith(newModel: Row) {
            model = newModel
            updateUI()
        }

        private fun updateUI() {
            model?.apply {
                itemView.textView.text = id.toString()
            }
        }
    }
}