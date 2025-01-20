package com.airpremia.eosh.inteface;

public interface SubscribeActionInterface<T> {
    /**
     * @param saveDto 저장에 대한 개체
     * @implNote 해당 기능은 저장객체에 대해서 저장 처리를 하며 구독의 키 값을 리턴하는 기능이다. 이미 생성된 uuid 가 있다면 그대로 리턴 하는 형태소이다.
     */
    String saveAndUuid(T saveDto);

    boolean delete(String uuid);
}
