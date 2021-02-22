package com.lab.of.inspire.view.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lab.of.inspire.databinding.ItemPhotoBinding
import com.lab.of.inspire.entity.photo.Photo
import com.lab.of.inspire.view.recyclerview.viewholder.PhotoViewHolder

class PhotosAdapter(private val listener: PhotosListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val photos: MutableList<Photo> = mutableListOf()

    interface PhotosListener {
        fun onPhotoClick(photo: Photo)
    }

    fun addData(photos: List<Photo>) {
        val lastIndex = this.photos.size
        this.photos.addAll(photos)
        notifyItemRangeInserted(lastIndex, photos.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PhotoViewHolder(ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false), listener)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PhotoViewHolder).bind(photos[position])
    }

}