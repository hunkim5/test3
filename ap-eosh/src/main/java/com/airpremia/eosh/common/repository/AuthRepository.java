package com.airpremia.eosh.common.repository;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.common.dto.AuthObjectDto;
import com.airpremia.eosh.common.dto.AuthUserInfoDto;


@Repository
public interface AuthRepository {

    AuthUserInfoDto selectUserInfoByUserId(String userId);

    AuthUserInfoDto selectUserInfoByThirdParty(String userTrdprtyCd, String trdprtyUuid);

    AuthUserInfoDto selectUserInfoByUserSeq(Long endUserSeq);

    void updateFcmUser(AuthObjectDto authObjectDto);


}
