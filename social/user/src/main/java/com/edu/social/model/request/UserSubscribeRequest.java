package com.edu.social.model.request;

import com.edu.social.model.entity.User;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author : orange.Zhang
 * @date : 2022-07-14
 **/
@Data
public class UserSubscribeRequest implements Serializable {

    private static final long serialVersionUID = 8403079888246736260L;

    public String        beSubUserAccount;

    public List<String>  SubUserAccount;

}
