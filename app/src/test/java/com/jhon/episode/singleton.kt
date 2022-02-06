package com.jhon.episode

/**
 * SingleTon
 *
 * - 생성자가 여러 차례 호출 되더라도, 실제로 생성되는 객체는 하나 인 것.
 * - 최초 생성 이후에 호출된 생성자는 최초의 생성자가 생성한 객체를 리턴.
 * - 코틀린에서는 object 키워드로 나타낼 수 있음
 *
 * companion object vs object
 *
 * - companion object는 어떤 클래스의 모든 인스턴스가 공유하는 객체를 만들고 싶을 때
 * 사용하며, 클래스당 한 개만 가질 수 있다.
 *
 */

class TestRetrofit

object CouponDataInstance {

    private var retrofit: TestRetrofit? = null

    @JvmName("getInstance1")
    fun getInstance(): TestRetrofit? {
        if(retrofit==null) {
            retrofit = TestRetrofit()
            return retrofit
        }
        return retrofit
    }

}

fun main() {
    val retrofit = CouponDataInstance.getInstance()
    val retrofit2 = CouponDataInstance.getInstance()

}