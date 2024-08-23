package com.example.mynewsapp.presentation.news_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynewsapp.data.database.NewsDataBase
import com.example.mynewsapp.data.model.News
import com.example.mynewsapp.data.response.NewsResponse
import com.example.mynewsapp.presentation.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsDetailsViewModel @Inject constructor(dataBase: NewsDataBase) : ViewModel() {

    private val _state= MutableStateFlow<State<BookMarkAction>>(State.Loading)
    val state=_state as StateFlow<State<BookMarkAction>>

    private val newsDao=dataBase.newsDao()

    fun addNews(news: News){
        viewModelScope.launch {
            try {

                _state.tryEmit(State.Loading)
                newsDao.addNews(news)
                _state.tryEmit(State.Success(BookMarkAction.ADD))

            }catch (e:Exception){
                _state.tryEmit(State.Error(e.message.toString()))
            }
        }
    }

    fun removeNews(news:News){
        viewModelScope.launch {
            try {

                _state.tryEmit(State.Loading)
                newsDao.deleteNews(news)
                _state.tryEmit(State.Success(BookMarkAction.REMOVE))

            }catch (e:Exception){
                _state.tryEmit(State.Error(e.message.toString()))
            }
        }
    }


}

enum class BookMarkAction{
    ADD,REMOVE
}