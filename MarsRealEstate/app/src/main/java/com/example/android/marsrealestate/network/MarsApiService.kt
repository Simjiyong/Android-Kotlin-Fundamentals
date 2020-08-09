/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.example.android.marsrealestate.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

enum class MarsApiFilter(val value: String) {
    SHOW_RENT("rent"),
    SHOW_BUY("buy"),
    SHOW_ALL("all")
}

private const val BASE_URL = " https://android-kotlin-fun-mars-server.appspot.com/"

private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

//private val retrofit = Retrofit.Builder()
//        .addConverterFactory(MoshiConverterFactory.create(moshi))
//        .baseUrl(BASE_URL)
//        .build()

// Retrofit with coroutines
private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(BASE_URL)
        .build()

interface MarsApiService {
//    @GET("realestate")
//    fun getProperties():
//            Call<List<MarsProperty>>

    //Retrofit with coroutines
    @GET("realestate")
    fun getProperties(@Query("filter") type: String):
            Deferred<List<MarsProperty>>
    /**
     * Deferred interface는 결과 값을 반환하는 코루틴 작업을 정의 (Job을 상속)
     * Deferred interface에는 값이 준비된 다음 해당 값이 변환 될 때까지 코드가 차단되지 않고
     * 대기하도록하는 await()라는 method가 포함되어 있음.
     *
     * @Query 어노테이션은 getProperties()가 호출 될 때마다 요청 URL에는 웹 서비스가 해당
     * 쿼리와 일치하는 결과로 응답하도록 지시하는 filter = type 부분이 포함된다.
     */

}

object MarsApi {
    val retrofitService: MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}