package com.chukimmuoi.androidupdate2020.ui.legotheme

import androidx.lifecycle.ViewModel
import com.chukimmuoi.androidupdate2020.ui.legotheme.repository.LegoThemeRepository
import javax.inject.Inject

/**
 * @author  : Chu Kim Muoi
 * @Skype   : chukimmuoi
 * @Mobile  : +84 373 672 505
 * @Email   : chukimmuoi@gmail.com
 * @Project : AndroidUpdate2020
 * Created by chukimmuoi on 2019-12-30.
 */
class LegoThemeViewModel @Inject constructor(repository: LegoThemeRepository) : ViewModel() {

    val legoThemes = repository.themes
}