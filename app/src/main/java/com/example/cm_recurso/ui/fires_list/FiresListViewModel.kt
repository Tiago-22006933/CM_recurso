package com.example.cm_recurso.ui.fires_list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.cm_recurso.model.fire.FireParceLable
import com.example.cm_recurso.ui.repository.FireRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FiresListViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = FireRepository.getInstance()

    fun getAllFires(callback: (List<FireParceLable>) -> Unit){
        CoroutineScope(Dispatchers.Main).launch {
            repository.getAllFires(callback)
        }
    }

    fun getAllRegistros(onFinished: (List<FireParceLable>) -> Unit){
        repository.getAllRegistos(onFinished)
    }

    fun getAllFiresList(): List<FireParceLable> {
        return repository.getAllFiresList()
    }

    fun getActiveFire() : List<FireParceLable> {
        return repository.getActiveFires()
    }

    fun getDistrictWithMostFires() : String {
        return repository.getDistrictWithMostFires()
    }
}