package com.example.listadapter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.listadapter.databinding.LayoutPersonDetailBinding
import com.example.listadapter.model.Person

class PersonListAdapter: ListAdapter<Person, PersonViewHolder>(DIFF_UTIL) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)

        //このviewの生成方法に注意する必要ある
        val binding = LayoutPersonDetailBinding.inflate(layoutInflater, parent, false)

        return PersonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {

        // 位置ごとで，viewと紐づける
        holder.bind(getItem(position))
    }

}

// layoutで紐づけられたviewを，ここでもらって，viewBindingで処理
class PersonViewHolder(
    private val binding: LayoutPersonDetailBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(person: Person) {

        binding.nameTextview.text = person.name
        binding.ageTextview.text = person.age.toString()
    }
}

val DIFF_UTIL = object : DiffUtil.ItemCallback<Person>() {

    // オブジェクト特有の値を用いて比較を行う．
    override fun areItemsTheSame(
        oldItem: Person,
        newItem: Person
    ): Boolean {

        return oldItem.name == newItem.name
    }

    // オブジェクトの中身が同じであるかを確認する
    override fun areContentsTheSame(
        oldItem: Person,
        newItem: Person
    ): Boolean {

        // data class だから、この比較を行える
        return oldItem == newItem
    }
}