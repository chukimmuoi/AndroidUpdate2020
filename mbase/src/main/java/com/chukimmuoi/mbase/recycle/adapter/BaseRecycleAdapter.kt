package com.chukimmuoi.mbase.recycle.adapter

import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

/**
 * @author  : Chu Kim Muoi
 * @Skype   : chukimmuoi
 * @Mobile  : +84 373 672 505
 * @Email   : chukimmuoi@gmail.com
 * @Project : accesstrade
 * Created by chukimmuoi on 2019-11-23.
 */
open class BaseRecycleAdapter(private val listItems: MutableList<Any>) :
    ListDelegationAdapter<List<Any>>(), IRecycleAdapter {

    private lateinit var mRecyclerView: RecyclerView

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        mRecyclerView = recyclerView
    }

    override fun setListItem(listItem: List<Any>) {
        listItems.clear()
        this.listItems.addAll(listItem)
        notifyDataSetChanged()
    }

    override fun insertItem(position: Int, any: Any, isScroll: Boolean) {
        if (position >= 0 && any != null) {
            listItems.add(position, any)
            notifyItemInserted(position)

            if (isScroll) {
                mRecyclerView.scrollToPosition(position)
            }
        }
    }

    override fun insertItem(positionStart: Int, insertList: List<Any>, isScroll: Boolean) {
        if (positionStart >= 0 && insertList != null) {
            val itemCount = insertList.size
            if (itemCount > 0) {
                listItems.addAll(positionStart, insertList)
                notifyItemRangeInserted(positionStart, itemCount)

                if (isScroll) {
                    mRecyclerView.scrollToPosition(positionStart)
                }
            }
        }
    }

    override fun insertItem(insertList: List<Any>, isScroll: Boolean) {
        insertItem(itemCount, insertList, isScroll)
    }

    override fun loadMoreItem(insertList: List<Any>) {
        insertList?.let {
            var positionStart = itemCount
            if (positionStart > 0) {
                positionStart -= 1
                listItems.removeAt(positionStart)
                notifyItemRemoved(positionStart)
            }

            val itemCount = insertList.size
            if (itemCount > 0) {
                listItems.addAll(positionStart, insertList)
                notifyItemRangeInserted(positionStart, itemCount)
            }
        }
    }

    override fun updateItem(position: Int, isScroll: Boolean) {
        if (position in 0 until itemCount) {
            notifyItemChanged(position)

            if (isScroll) {
                mRecyclerView.scrollToPosition(position)
            }
        }
    }

    //https://stackoverflow.com/questions/32769009/recyclerview-notifyitemrangechanged-doesnt-show-new-data
    override fun updateItem(positionStart: Int, itemCount: Int, isScroll: Boolean) {
        if (positionStart >= 0 && itemCount > 0 && positionStart + itemCount <= getItemCount()) {
            notifyItemRangeChanged(positionStart, itemCount)

            if (isScroll) {
                mRecyclerView.scrollToPosition(positionStart)
            }
        }
    }

    override fun removeItem(position: Int, isScroll: Boolean) {
        if (position in 0 until itemCount) {
            listItems.removeAt(position)
            notifyItemRemoved(position)

            if (isScroll) {
                val positionNew = position - 1
                mRecyclerView.scrollToPosition(if (positionNew >= 0) positionNew else 0)
            }
        }
    }

    override fun removeItem(positionStart: Int, itemCount: Int, isScroll: Boolean) {
        if (positionStart >= 0 && itemCount > 0 && positionStart + itemCount <= getItemCount()) {
            for (i in 0 until itemCount) {
                listItems.removeAt(positionStart)
            }
            notifyItemRangeRemoved(positionStart, itemCount)

            if (isScroll) {
                val positionNew = positionStart - 1
                mRecyclerView.scrollToPosition(if (positionNew >= 0) positionNew else 0)
            }
        }
    }

    override fun movedItem(fromPosition: Int, toPosition: Int, isScroll: Boolean) {
        val sizeList = itemCount
        if (fromPosition in 0 until sizeList && toPosition >= 0 && toPosition < sizeList && fromPosition != toPosition) {
            listItems.removeAt(fromPosition)
            listItems[fromPosition]?.let { listItems.add(toPosition, it) }
            notifyItemMoved(fromPosition, toPosition)

            if (isScroll) {
                mRecyclerView.scrollToPosition(toPosition)
            }
        }
    }

    override fun clearAll() {
        listItems.clear()
        notifyDataSetChanged()
    }

    override fun reloadAll(isScroll: Boolean, position: Int) {
        notifyDataSetChanged()

        if (isScroll) {
            mRecyclerView.scrollToPosition(position)
        }
    }
}