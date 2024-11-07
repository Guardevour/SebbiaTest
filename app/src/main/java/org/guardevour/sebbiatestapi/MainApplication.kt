package org.guardevour.sebbiatestapi

import android.app.Application
import org.guardevour.sebbiatestapi.viewmodels.CategoriesViewModel
import org.guardevour.sebbiatestapi.viewmodels.DetailedArticleViewModel
import org.guardevour.sebbiatestapi.viewmodels.NewsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@MainApplication)
            modules(appModule)
        }
    }
    private val appModule = module {
        viewModel<CategoriesViewModel>(){
            CategoriesViewModel()
        }
        viewModel<NewsViewModel>(){
            NewsViewModel()
        }
        viewModel<DetailedArticleViewModel>(){
            DetailedArticleViewModel()
        }
    }
}
