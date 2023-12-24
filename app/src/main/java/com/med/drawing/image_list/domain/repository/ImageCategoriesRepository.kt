package com.med.drawing.image_list.domain.repository

import com.med.drawing.util.Resource
import kotlinx.coroutines.flow.Flow

/**
 * @author Ahmed Guedmioui
 */
interface ImageCategoriesRepository {
    suspend fun getImageCategoryList(): Flow<Resource<Unit>>
    suspend fun setGalleryAndCameraAndNativeItems()

}