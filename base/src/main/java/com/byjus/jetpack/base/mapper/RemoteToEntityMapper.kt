package com.byjus.jetpack.base.mapper

interface RemoteToEntityMapper<R,E> {
    fun mapToEntity(remote: R): E
}