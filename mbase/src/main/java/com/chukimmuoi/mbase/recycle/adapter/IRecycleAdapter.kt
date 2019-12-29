package com.chukimmuoi.mbase.recycle.adapter

/**
 * @author  : Chu Kim Muoi
 * @Skype   : chukimmuoi
 * @Mobile  : +84 373 672 505
 * @Email   : chukimmuoi@gmail.com
 * @Project : accesstrade
 * Created by chukimmuoi on 2019-11-23.
 */
interface IRecycleAdapter {

    fun setListItem(listItem: List<Any>)

    fun insertItem(position: Int, any: Any, isScroll: Boolean = false)

    fun insertItem(positionStart: Int, insertList: List<Any>, isScroll: Boolean = false)

    fun insertItem(insertList: List<Any>, isScroll: Boolean = false)

    fun loadMoreItem(insertList: List<Any>)

    fun updateItem(position: Int, isScroll: Boolean = false)

    fun updateItem(positionStart: Int, itemCount: Int, isScroll: Boolean = false)

    fun removeItem(position: Int, isScroll: Boolean = false)

    fun removeItem(positionStart: Int, itemCount: Int, isScroll: Boolean = false)

    fun movedItem(fromPosition: Int, toPosition: Int, isScroll: Boolean = false)

    fun clearAll()

    fun reloadAll(isScroll: Boolean = false, position: Int = 0)
}