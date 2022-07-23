package com.edu.social.model.request;

import lombok.Data;
import lombok.ToString;

/**
 * @author : orange.Zhang
 * @date : 2022-07-24
 **/
@Data
@ToString
public class ArticleRequest {

    public String useraccount;
    public String username;
    public String title;
    public String content;

}
