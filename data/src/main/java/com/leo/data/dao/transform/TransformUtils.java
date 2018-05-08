package com.leo.data.dao.transform;

import com.leo.data.dao.db.MessageDAO;
import com.leo.data.dao.db.MessageRealmDao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leo, ZhangWei
 * @date 2018/4/25
 * @function
 */
public class TransformUtils {

    public static MessageRealmDao transformMessageDao(MessageDAO messageDao) {
        return new MessageRealmDao(messageDao.getId()
                , messageDao.getMessage_id()
                , messageDao.getTitle()
                , messageDao.getContent()
                , messageDao.getMct_id()
                , messageDao.getIs_read()
                , messageDao.getCtime());
    }

    public static List<MessageRealmDao> transformMessageDaos(List<MessageDAO> messageDaos) {
        List<MessageRealmDao> list = new ArrayList<>(messageDaos.size());
        for (MessageDAO messageDAO : messageDaos) {
            list.add(transformMessageDao(messageDAO));
        }

        return list;
    }


}
