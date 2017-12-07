package com.yd.org.sellpopularizesystem.javaBean;

import java.util.List;

/**
 * Created by hejin on 2017/5/17.
 */

public class TeamBean extends Domine{

    /**
     * code : 1
     * msg : 获取成功
     * result : {"leader":{"id":100048,"surname":"Jia","firstname":"Lixin"},"sub":[{"id":100068,"surname":" Bian","firstname":"Zhou ","commission":"0","sub":[{"id":100005,"surname":"Zou","firstname":"Yuan","commission":"0","sub":null}]},{"id":100070,"surname":" Sha","firstname":"Binchen ","commission":"0","sub":null},{"id":100065,"surname":" Wu","firstname":"Zhirou","commission":"0","sub":[{"id":100004,"surname":"Gu","firstname":"Jialei ","commission":"0","sub":null}]},{"id":100008,"surname":" Yuan","firstname":"Liping","commission":"0","sub":[{"id":100019,"surname":" Zhang","firstname":"Daohai","commission":"0","sub":null},{"id":100094,"surname":"eretry","firstname":"er","commission":"0","sub":null},{"id":100057,"surname":"Ge","firstname":"Chen ","commission":"0","sub":null}]},{"id":100069,"surname":" Yuan","firstname":"Shuai ","commission":"0","sub":null},{"id":100058,"surname":" Zhou","firstname":"Lei","commission":"0","sub":[{"id":100067,"surname":"Yan","firstname":"Rubin","commission":"0","sub":null},{"id":100046,"surname":"Zhang","firstname":"Kaiqiang","commission":"0","sub":null}]},{"id":100075,"surname":"Chen","firstname":"Xiaoyi ","commission":"0","sub":[{"id":100022,"surname":"Lu","firstname":"Jianpong ","commission":"0","sub":null},{"id":100045,"surname":"Zhuang","firstname":"Tai","commission":"0","sub":null}]},{"id":100007,"surname":"Deng","firstname":"JiaJing ","commission":"0","sub":null},{"id":100074,"surname":"Gong ","firstname":"Min ","commission":"0","sub":null},{"id":100048,"surname":"Jia","firstname":"Lixin","commission":"0"},{"id":100036,"surname":"Jin","firstname":"Yingping","commission":"0","sub":null},{"id":100010,"surname":"Li","firstname":"Zhongping","commission":"0","sub":[{"id":100009,"surname":" Zhou","firstname":"Charles","commission":"0","sub":null},{"id":100077,"surname":"Xu","firstname":"Meihong","commission":"0","sub":null}]},{"id":100002,"surname":"Lin","firstname":"hanxia","commission":"0","sub":null},{"id":100025,"surname":"Ma","firstname":"Feifei","commission":"0","sub":null},{"id":100042,"surname":"Shen","firstname":"Jiafei","commission":"0","sub":null},{"id":100088,"surname":"test","firstname":"test","commission":"0","sub":[{"id":100089,"surname":"23","firstname":"tretyt","commission":"0","sub":null}]},{"id":100029,"surname":"Wu ","firstname":"Yilin","commission":"0","sub":null},{"id":100083,"surname":"Wu","firstname":"Wenqing ","commission":"0","sub":null},{"id":100072,"surname":"Zhou","firstname":"Wen","commission":"0","sub":null}]}
     */

    private String code;
    private String msg;
    private ResultBean result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * leader : {"id":100048,"surname":"Jia","firstname":"Lixin"}
         * sub : [{"id":100068,"surname":" Bian","firstname":"Zhou ","commission":"0","sub":[{"id":100005,"surname":"Zou","firstname":"Yuan","commission":"0","sub":null}]},{"id":100070,"surname":" Sha","firstname":"Binchen ","commission":"0","sub":null},{"id":100065,"surname":" Wu","firstname":"Zhirou","commission":"0","sub":[{"id":100004,"surname":"Gu","firstname":"Jialei ","commission":"0","sub":null}]},{"id":100008,"surname":" Yuan","firstname":"Liping","commission":"0","sub":[{"id":100019,"surname":" Zhang","firstname":"Daohai","commission":"0","sub":null},{"id":100094,"surname":"eretry","firstname":"er","commission":"0","sub":null},{"id":100057,"surname":"Ge","firstname":"Chen ","commission":"0","sub":null}]},{"id":100069,"surname":" Yuan","firstname":"Shuai ","commission":"0","sub":null},{"id":100058,"surname":" Zhou","firstname":"Lei","commission":"0","sub":[{"id":100067,"surname":"Yan","firstname":"Rubin","commission":"0","sub":null},{"id":100046,"surname":"Zhang","firstname":"Kaiqiang","commission":"0","sub":null}]},{"id":100075,"surname":"Chen","firstname":"Xiaoyi ","commission":"0","sub":[{"id":100022,"surname":"Lu","firstname":"Jianpong ","commission":"0","sub":null},{"id":100045,"surname":"Zhuang","firstname":"Tai","commission":"0","sub":null}]},{"id":100007,"surname":"Deng","firstname":"JiaJing ","commission":"0","sub":null},{"id":100074,"surname":"Gong ","firstname":"Min ","commission":"0","sub":null},{"id":100048,"surname":"Jia","firstname":"Lixin","commission":"0"},{"id":100036,"surname":"Jin","firstname":"Yingping","commission":"0","sub":null},{"id":100010,"surname":"Li","firstname":"Zhongping","commission":"0","sub":[{"id":100009,"surname":" Zhou","firstname":"Charles","commission":"0","sub":null},{"id":100077,"surname":"Xu","firstname":"Meihong","commission":"0","sub":null}]},{"id":100002,"surname":"Lin","firstname":"hanxia","commission":"0","sub":null},{"id":100025,"surname":"Ma","firstname":"Feifei","commission":"0","sub":null},{"id":100042,"surname":"Shen","firstname":"Jiafei","commission":"0","sub":null},{"id":100088,"surname":"test","firstname":"test","commission":"0","sub":[{"id":100089,"surname":"23","firstname":"tretyt","commission":"0","sub":null}]},{"id":100029,"surname":"Wu ","firstname":"Yilin","commission":"0","sub":null},{"id":100083,"surname":"Wu","firstname":"Wenqing ","commission":"0","sub":null},{"id":100072,"surname":"Zhou","firstname":"Wen","commission":"0","sub":null}]
         */

        private LeaderBean leader;
        private List<SubBeanX> sub;

        public LeaderBean getLeader() {
            return leader;
        }

        public void setLeader(LeaderBean leader) {
            this.leader = leader;
        }

        public List<SubBeanX> getSub() {
            return sub;
        }

        public void setSub(List<SubBeanX> sub) {
            this.sub = sub;
        }

        public static class LeaderBean {
            /**
             * id : 100048
             * surname : Jia
             * firstname : Lixin
             */

            private int id;
            private String surname;
            private String firstname;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getSurname() {
                return surname;
            }

            public void setSurname(String surname) {
                this.surname = surname;
            }

            public String getFirstname() {
                return firstname;
            }

            public void setFirstname(String firstname) {
                this.firstname = firstname;
            }
        }

        public static class SubBeanX {
            /**
             * id : 100068
             * surname :  Bian
             * firstname : Zhou
             * commission : 0
             * sub : [{"id":100005,"surname":"Zou","firstname":"Yuan","commission":"0","sub":null}]
             */

            private int id;
            private String surname;
            private String firstname;
            private String commission;
            private List<SubBean> sub;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getSurname() {
                return surname;
            }

            public void setSurname(String surname) {
                this.surname = surname;
            }

            public String getFirstname() {
                return firstname;
            }

            public void setFirstname(String firstname) {
                this.firstname = firstname;
            }

            public String getCommission() {
                return commission;
            }

            public void setCommission(String commission) {
                this.commission = commission;
            }

            public List<SubBean> getSub() {
                return sub;
            }

            public void setSub(List<SubBean> sub) {
                this.sub = sub;
            }

            public static class SubBean {
                /**
                 * id : 100005
                 * surname : Zou
                 * firstname : Yuan
                 * commission : 0
                 * sub : null
                 */

                private int id;
                private String surname;
                private String firstname;
                private String commission;
                private Object sub;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getSurname() {
                    return surname;
                }

                public void setSurname(String surname) {
                    this.surname = surname;
                }

                public String getFirstname() {
                    return firstname;
                }

                public void setFirstname(String firstname) {
                    this.firstname = firstname;
                }

                public String getCommission() {
                    return commission;
                }

                public void setCommission(String commission) {
                    this.commission = commission;
                }

                public Object getSub() {
                    return sub;
                }

                public void setSub(Object sub) {
                    this.sub = sub;
                }
            }
        }
    }
}
