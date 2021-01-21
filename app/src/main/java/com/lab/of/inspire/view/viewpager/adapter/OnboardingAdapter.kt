package com.lab.of.inspire.view.viewpager.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lab.of.inspire.databinding.ItemOnboardingBinding
import com.lab.of.inspire.enums.OnboardingPage
import com.lab.of.inspire.extensions.clearAndAddAll
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.textResource

class OnboardingAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val pages: MutableList<OnboardingPage> = mutableListOf()

    fun updateData(pages: MutableList<OnboardingPage>) {
        this.pages.clearAndAddAll(pages)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return OnboardingViewHolder(ItemOnboardingBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return pages.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as OnboardingViewHolder).bind(pages[position])
    }

    inner class OnboardingViewHolder(private val binding: ItemOnboardingBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(page: OnboardingPage) {
            binding.iconIV.imageResource = page.imgResId
            binding.titleTV.textResource = page.titleResId
            binding.descriptionTV.textResource = page.descriptionResId
        }

    }

}