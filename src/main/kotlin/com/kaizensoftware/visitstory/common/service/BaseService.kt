package com.kaizensoftware.visitstory.common.service

import org.springframework.beans.factory.annotation.Autowired

import com.google.common.base.Preconditions.checkArgument
import com.kaizensoftware.visitstory.common.persistence.model.BaseEntity
import com.kaizensoftware.visitstory.common.persistence.repository.SoftDeleteRepository
import com.kaizensoftware.visitstory.common.util.ObjectUtil
import java.util.Objects.requireNonNull

import java.lang.reflect.ParameterizedType
import org.modelmapper.ModelMapper
import java.io.Serializable

import javax.persistence.EntityNotFoundException

abstract class BaseService<R : SoftDeleteRepository<E, ID>, E : BaseEntity<ID>, ID : Serializable>
    @Autowired constructor(
            private val modelMapper: ModelMapper,
            private val objectUtil: ObjectUtil
    ) {

//    protected var repository: R? = null
//        @Autowired(required = false)
//        set(value) {
//            field = value
//        }
//
//    private var clazz: Class<E>? = null
//
//    private val entityNotFoundByIdTemplate = "%s with id: %d doest not exists"
//
//    private fun clazz(): Class<E>? {
//
//        if (this.clazz == null) {
//            val actualClass = this.javaClass
//            val pt = actualClass.genericSuperclass as ParameterizedType
//            this.clazz = pt.actualTypeArguments[1] as Class<E>
//        }
//
//        return this.clazz
//    }
//
//    protected fun existsById(id: ID): Boolean {
//        return repository!!.existsById(id)
//    }
//
//    @Throws(Exception::class)
//    protected fun <T> findInactiveById(id: ID, clazz: Class<T>): T {
//
//        checkArgument(id != 0L, "The given id must not be null!")
//
//        val optionalEntity = this.repository!!.findInactiveById(id)
//
//        optionalEntity.orElseThrow {
//            EntityNotFoundException("Entity with id: " + id + "does not exists")
//        }
//
//        val entity = optionalEntity.get()
//
//        return modelMapper.map(entity, clazz)
//    }
//
//    @Throws(EntityNotFoundException::class)
//    protected fun <T> findById(id: ID, clazz: Class<T>): T {
//
//        checkArgument(id != 0L, "The given id must not be null!")
//
//        val optionalEntity = this.repository!!.findById(id)
//
//        optionalEntity.orElseThrow{
//            EntityNotFoundException(String.format(entityNotFoundByIdTemplate, this.clazz()!!.simpleName, id))
//        }
//
//        val entity = optionalEntity.get()
//
//        return modelMapper.map(entity, clazz)
//    }
//
//    protected fun <T> findAllInactive(clazz: Class<T>): List<T> {
//        return repository!!.findAllInactive().map {
//            modelMapper.map(it, clazz)
//        }
//    }
//
//    protected fun <T> findAll(clazz: Class<T>): List<T> {
//        return repository!!.findAll().map {
//            modelMapper.map(it, clazz)
//        }
//    }
//
//    @Throws(Exception::class)
//    fun <T, K> save(createDTO: T, clazz: Class<K>): K {
//
//        requireNonNull(createDTO)
//
//        val entity = modelMapper.map(createDTO, this.clazz())
//
//        return modelMapper.map(repository!!.saveAndFlush(entity), clazz)
//    }
//
//    @Throws(Exception::class)
//    protected fun <T, K> update(id: ID, updateDTO: K, clazz: Class<T>, partialUpdate: Boolean): T {
//
//        checkArgument(id != 0L)
//        requireNonNull(updateDTO)
//
//        val optionalEntity = this.repository!!.findById(id)
//
//        optionalEntity.orElseThrow {
//            EntityNotFoundException("Entity with id: " + id + "does not exists")
//        }
//
//        val entity = optionalEntity.get()
//
//        if (partialUpdate) {
//            objectUtil.merge(updateDTO!!, entity)
//        } else {
//            modelMapper.map(updateDTO, entity)
//        }
//
//        repository!!.saveAndFlush(entity)
//
//        return modelMapper.map(entity, clazz)
//    }
//
//    @Throws(Exception::class)
//    protected fun <T> delete(id: ID, clazz: Class<T>, hardDelete: Boolean): T {
//
//        checkArgument(id != 0L, "The given id must not be null!")
//
//        val optionalEntity = this.repository!!.findById(id)
//
//        optionalEntity.orElseThrow{
//            EntityNotFoundException("Entity with id: " + id + "does not exists")
//        }
//
//        val entity = optionalEntity.get()
//
//        if (hardDelete) {
//            repository!!.delete(entity)
//        } else {
//            repository!!.softDelete(entity)
//        }
//
//        return modelMapper.map(entity, clazz)
//    }
//
//    @Throws(Exception::class)
//    protected fun deleteAll() {
//        this.repository!!.deleteAll()
//    }

}