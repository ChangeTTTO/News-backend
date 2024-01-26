package com.pn.constants;

public interface MqConstants {
    interface Exchange{
         /*点赞记录有关的交换机*/
        String LIKE_RECORD_EXCHANGE = "like.record.topic";

    }

    interface Key{
        String LIKED_TIMES_KEY_TEMPLATE = "{}.times.changed";

    }
}
