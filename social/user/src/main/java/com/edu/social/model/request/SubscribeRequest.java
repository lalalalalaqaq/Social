package com.edu.social.model.request;

import lombok.Data;
import java.io.Serializable;

/**
 * @author : orange.Zhang
 * @date : 2022-07-14
 **/
@Data
public class SubscribeRequest implements Serializable {

    private static final long serialVersionUID = 8403079888246736260L;

    public String    SubUserAccount;

    public String[]  beSubUserAccount;

}
