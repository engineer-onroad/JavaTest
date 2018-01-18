package com.java.enums.test;

public enum CircleBusinessType {

        //明星业务
        CIRCLE_BUSINESS_TYPE_STAR(0),
        //图书业务
        CIRCLE_BUSINESS_TYPE_BOOK(4),
        //总编室
        CIRCLE_BUSINESS_TYPE_EDITOR_OFFICE(6),
        //运营业务
        CIRCLE_BUSINESS_TYPE_OPERATION(7),
        //漫画业务
        CIRCLE_BUSINESS_TYPE_COMIC(8),
        //PGC业务
        CIRCLE_BUSINESS_TYPE_PGC(9),
        //电影业务
        CIRCLE_BUSINESS_TYPE_FILM(10),
        //电影票业务
        CIRCLE_BUSINESS_TYPE_FILM_TICKET(11),
        //电视剧业务
        CIRCLE_BUSINESS_TYPE_TV_SERIES(12),
        //综艺业务
        CIRCLE_BUSINESS_TYPE_VARIETY_SHOW(13),
        //动漫业务
        CIRCLE_BUSINESS_TYPE_CARTOON(14),
        //其他业务
        CIRCLE_BUSINESS_TYPE_OTHER(15),
        //时尚业务
        CIRCLE_BUSINESS_TYPE_FASHION(16),
        //兴趣
        CIRCLE_BUSINESS_TYPE_INTEREST(17),

        // 游戏
        CIRCLE_BUSINESS_TYPE_GAME(18),

        // 用户(用户自建圈属于这种业务类型)
        CIRCLE_BUSINESS_TYPE_USER(19),
        // 主播
        CIRCLE_BUSINESS_TYPE_ANCHOR(20),

        //qim业务
        CIRCLE_BUSINESS_TYPE_QIM(21),

        // 热圈
        CIRCLE_BUSINESS_TYPE_HOT_CIRCLE(101);



        private Integer id;

        CircleBusinessType(Integer id) {
            this.id = id;
        }

        public Integer getValue(){
            return this.id;
        }
}