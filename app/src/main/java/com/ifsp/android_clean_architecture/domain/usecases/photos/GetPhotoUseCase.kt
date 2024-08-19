package com.ifsp.android_clean_architecture.domain.usecases.photos

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

import com.ifsp.android_clean_architecture.common.Resources
import com.ifsp.android_clean_architecture.domain.entities.photo.Photos
import com.ifsp.android_clean_architecture.domain.repositories.PhotoRepository
import kotlinx.coroutines.flow.flow

class GetPhotoUseCase @Inject constructor(
    private val repository: PhotoRepository
) {
    suspend operator fun invoke(query: String?, page: Int): Flow<Resources<Photos>> {
        return if (query.isNullOrEmpty()) {
            flow {
                emit(Resources.Success(data = null))
            }
        } else {
            repository.getPhoto(query, page)
        }
    }
}