package com.sklagat46.cashbacktestapp.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sklagat46.cashbacktestapp.R
import com.sklagat46.cashbacktestapp.data.local.model.Offers
import com.sklagat46.cashbacktestapp.utils.Constants
import com.sklagat46.cashbacktestapp.utils.Util
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_offers_item.view.*


class OffersAdapter(private val context: Context) : ListAdapter<Offers, OffersAdapter.OffersAdapterDetailHolder>(OffersDiffer) {
    inner class OffersAdapterDetailHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(offersData: Offers) {
            offersData.apply {
                itemView.tvProductName.text =  productName.toString()
                itemView.tvKshBackAmount.text =  productCashBack.toString()
                var com =""
                if (productCashBack != null) {
                    com = promotion_details_retailer_commission?.div(100)?.times(productCashBack.div(100)).toString()
                }
                //com=0.5/100 * 3/100

                itemView.tvKshComAmount.text = com.toString()
                itemView.tvQuantity.text =  productSize.toString()
                itemView.tvDate.text =  Util.dateStringToReadableFullDate(offerEndDate)
                itemView.tvProductName.text =  productName.toString()

                Picasso.with(context).load(productImage).fit().centerCrop()
                    .placeholder(R.drawable.ic_app_icon_foreground)
                    .error(R.drawable.ic_app_icon_foreground)
                    .into(itemView.ivProductImage);
            }
        }
    }

    companion object OffersDiffer : DiffUtil.ItemCallback<Offers>() {
        override fun areItemsTheSame(oldItem: Offers, newItem: Offers): Boolean = (oldItem.productId == newItem.productId)

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Offers, newItem: Offers): Boolean = (oldItem == newItem)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OffersAdapterDetailHolder {
        return OffersAdapterDetailHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_offers_item, parent, false))
    }

    override fun onBindViewHolder(holder: OffersAdapterDetailHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
