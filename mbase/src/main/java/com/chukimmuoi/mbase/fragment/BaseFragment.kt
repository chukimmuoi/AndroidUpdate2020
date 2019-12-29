package com.chukimmuoi.mbase.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.chukimmuoi.mbase.activity.BaseActivity
import timber.log.Timber

/**
 * @author  : Chu Kim Muoi
 * @Skype   : chukimmuoi
 * @Mobile  : +84 373 672 505
 * @Email   : chukimmuoi@gmail.com
 * @Project : accesstrade
 * Created by chukimmuoi on 2019-11-10.
 */
open class BaseFragment : Fragment() {

    lateinit var baseActivity: BaseActivity

    /**
     * 1. Call when Fragment connect Activity. [onDetach]
     *
     * @param context
     */
    override fun onAttach(context: Context) {
        Timber.i("onAttach")
        super.onAttach(context)

        baseActivity = activity as BaseActivity
    }

    /**
     * 2. Use onCreate variable not UI. [onDestroy]
     * eg: context, adapter, arrayList
     *
     * @param savedInstanceState bien luu trang thai truoc do, dung khi muon khoi phuc lai.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.i("onCreate")
        super.onCreate(savedInstanceState)
    }

    /**
     * 3. Set layout XML. [onDestroyView]
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.i("onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    /**
     * 4. Set variable UI.
     *
     * @param view
     * @param savedInstanceState
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    /**
     * 5. Call when Activity complete method. [onCreate]
     *
     * @param savedInstanceState
     */
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Timber.i("onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    /**
     * 5. Call when fragment ready show on screen. [onStop]
     */
    override fun onStart() {
        Timber.i("onStart")
        super.onStart()
    }

    /**
     * 6. Handle resources. Multi screen. [onPause]
     */
    override fun onResume() {
        Timber.i("onResume")
        super.onResume()
    }

    override fun onPause() {
        Timber.i("onPause")
        super.onPause()
    }

    override fun onStop() {
        Timber.i("onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Timber.i("onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Timber.i("onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        Timber.i("onDetach")
        super.onDetach()
    }
}