package com.lab.of.inspire.view.recyclerview.viewholder

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lab.of.inspire.databinding.ItemPhotoBinding
import com.lab.of.inspire.entity.photo.Photo
import com.lab.of.inspire.extensions.loadWithCache
import com.lab.of.inspire.extensions.loadWithCacheCircled
import com.lab.of.inspire.extensions.singleClickListener
import com.lab.of.inspire.view.recyclerview.adapter.PhotosAdapter

class PhotoViewHolder(private val binding: ItemPhotoBinding, private val listener: PhotosAdapter.PhotosListener): RecyclerView.ViewHolder(binding.root) {

    fun bind(photo: Photo) {
        binding.root.singleClickListener { listener.onPhotoClick(photo) }
        binding.previewIV.setAspectRatio(photo.width, photo.height)
        photo.color?.let { binding.previewIV.background = ColorDrawable(Color.parseColor(it)) }
        Glide.with(binding.previewIV.context).loadWithCache(photo.urls?.regular.orEmpty(), binding.previewIV)
        Glide.with(binding.authorIV.context).loadWithCacheCircled(photo.user?.image?.large.orEmpty(), binding.authorIV)
        binding.authorTV.text = photo.user?.getUsernameForShowing()
    }

}