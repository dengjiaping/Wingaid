package com.yd.org.sellpopularizesystem.javaBean;

import java.io.Serializable;

/**
 * Created by hejin on 2017/3/3.
 */

public class Question implements Serializable{
    private String questionTitle;
    private String optionContent;

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getOptionContent() {
        return optionContent;
    }

    public void setOptionContent(String optionContent) {
        this.optionContent = optionContent;
    }
}
