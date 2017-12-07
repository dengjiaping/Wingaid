package com.yd.org.sellpopularizesystem.javaBean;

import java.util.List;
import java.util.Set;

/**
 * Created by hejin on 2017/3/9.
 */

public class Answer {
    private String userId;
    private String paperId;
    private String type;
    private String questionId;
    private String answerId;
    private Set<String> answerContent;

    public Answer() {
    }

    public Answer(String questionId, String answerId, Set<String> answerContent) {
        this.questionId = questionId;
        this.answerId = answerId;
        this.answerContent = answerContent;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    public Set<String> getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(Set<String> answerContent) {
        this.answerContent = answerContent;
    }

    /*public static class AnswerContent{
            private  String checkId;
            private String userAnswer;

        public String getCheckId() {
            return checkId;
        }

        public void setCheckId(String checkId) {
            this.checkId = checkId;
        }

        public String getUserAnswer() {
            return userAnswer;
        }

        public void setUserAnswer(String userAnswer) {
            this.userAnswer = userAnswer;
        }
    }*/
}
