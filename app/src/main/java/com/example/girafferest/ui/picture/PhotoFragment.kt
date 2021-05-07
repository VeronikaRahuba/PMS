package com.example.girafferest.ui.picture

//import Maksym.Dudka.uakpicomsysio_8106.R
import android.R.attr.path
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.aminography.choosephotohelper.ChoosePhotoHelper
import com.aminography.choosephotohelper.callback.ChoosePhotoCallback
import com.arasthel.spannedgridlayoutmanager.SpanSize
import com.arasthel.spannedgridlayoutmanager.SpannedGridLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.example.girafferest.R


class PictureFragment : Fragment() {

    private lateinit var list: RecyclerView
    private val pictures = ArrayList<ImageView>()
    private lateinit var choosePhotoHelper: ChoosePhotoHelper
    private lateinit var uploadButton: Button
    private lateinit var image: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_picture_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        list = requireView().findViewById(R.id.pictures)
        val spannedGridLayoutManager = SpannedGridLayoutManager(
            SpannedGridLayoutManager.Orientation.VERTICAL,
            3
        )
        spannedGridLayoutManager.itemOrderIsStable = true

        list.layoutManager = spannedGridLayoutManager

        var adapter = MyPictureAdapter(requireContext(), pictures)

        spannedGridLayoutManager.spanSizeLookup =
            SpannedGridLayoutManager.SpanSizeLookup { position ->
                if (position % 9 == 0 ) {
                    SpanSize(2, 2)
                } else {
                    SpanSize(1, 1)
                }
            }

        list.adapter = adapter

        choosePhotoHelper = ChoosePhotoHelper.with(this)
            .asFilePath()
            .withState(savedInstanceState)
            .build(object : ChoosePhotoCallback<String> {
                override fun onChoose(photo: String?) {
                    image = ImageView(requireContext())

                    Glide.with(requireActivity())
                        .asBitmap()
                        .load(photo)
                        .into(object : SimpleTarget<Bitmap?>() {

                            override fun onResourceReady(
                                resource: Bitmap,
                                transition: Transition<in Bitmap?>?
                            ) {
                                image.setImageBitmap(resource)
                                pictures.add(image)
                                adapter = MyPictureAdapter(requireContext(), pictures)
                                list.adapter = adapter

                                println("test ${pictures[pictures.size - 1]}")
                            }
                        })
                }
            })

        uploadButton = requireView().findViewById(R.id.upload_picture)
        uploadButton.setOnClickListener {
            choosePhotoHelper.showChooser()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        choosePhotoHelper.onActivityResult(requestCode, resultCode, data)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        choosePhotoHelper.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        choosePhotoHelper.onSaveInstanceState(outState)
    }
}
