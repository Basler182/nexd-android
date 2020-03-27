package app.nexd.android.ui.seeker.overview

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import app.nexd.android.R
import app.nexd.android.api.model.RequestEntity
import app.nexd.android.ui.seeker.overview.HelpRequestBinder.HelpRequestViewHolder
import mva2.adapter.ItemBinder
import mva2.adapter.ItemViewHolder
import java.text.DateFormat

class HelpRequestBinder : ItemBinder<RequestEntity, HelpRequestViewHolder>() {

    class HelpRequestViewHolder(itemView: View) : ItemViewHolder<RequestEntity?>(itemView) {
        var title: TextView = itemView.findViewById(R.id.tv_header)
    }

    override fun createViewHolder(parent: ViewGroup): HelpRequestViewHolder {
        return HelpRequestViewHolder(inflate(parent, R.layout.request_header_view))
    }

    override fun bindViewHolder(
        holder: HelpRequestViewHolder,
        item: RequestEntity
    ) {
        holder.title.text = DateFormat.getDateInstance(DateFormat.FULL).format(item.createdAt)
    }

    override fun canBindData(item: Any): Boolean {
        return item is RequestEntity
    }
}