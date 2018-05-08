package com.leo.data.dao.db;

import android.support.annotation.NonNull;

import java.lang.reflect.Field;

import io.realm.DynamicRealm;
import io.realm.FieldAttribute;
import io.realm.RealmMigration;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;

/**
 * @author leo, ZhangWei
 * @date 2018/4/26
 * @function
 */
public class MyRealmMigration implements RealmMigration {

    private final String TAG = getClass().getSimpleName();
    private long oldVersion;

    @Override
    public void migrate(@NonNull DynamicRealm realm, long oldVersion, long newVersion) {
        this.oldVersion = oldVersion;
        while (this.oldVersion < newVersion) {
            updateVersion(getUpdateFun(realm, this.oldVersion));
        }

    }

    private void updateVersion(UpdateVersion updateVersion) {
        if (updateVersion != null) {
            updateVersion.update();
        }
    }

    /**
     * 更新版本統一接口 状态模式
     */
    interface UpdateVersion {
        /**
         * 具体的更新执行
         */
        void update();
    }

    /**
     * 获取更新实际更新类
     *
     * @param oldVersion 旧版本号
     */
    private UpdateVersion getUpdateFun(@NonNull DynamicRealm realm, long oldVersion) {
        if (oldVersion == 0) {
            return new UpdateToVersion1(realm);
        }
        if (oldVersion == 1) {
            return new UpdateToVersion2(realm);
        }
        if (oldVersion == 2) {
            return new UpdateToVersion3(realm);
        }
        return null;
    }

    abstract class BaseUpdateVersion implements UpdateVersion {
        DynamicRealm realm;

        BaseUpdateVersion(DynamicRealm realm) {
            this.realm = realm;
        }
    }

    /**
     * 升级到版本1的具体方法及版本变更详情
     */
    class UpdateToVersion1 extends BaseUpdateVersion {

        UpdateToVersion1(DynamicRealm realm) {
            super(realm);
        }

        @Override
        public void update() {
            //具体更新参考 详见 https://realm.io/docs/java/latest#migrations
            RealmSchema schema = realm.getSchema();
            RealmObjectSchema personSchema = schema.create(PersonRealmDAO.class.getSimpleName());
            Field[] fields = PersonRealmDAO.class.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                personSchema.addField(field.getName(), field.getType());
            }
            MyRealmMigration.this.oldVersion++;
        }
    }

    /**
     * 升级到版本2的具体方法及版本变更详情
     */
    class UpdateToVersion2 extends BaseUpdateVersion {

        private final String NAME = "name";
        private final String SEX = "sex";

        UpdateToVersion2(DynamicRealm realm) {
            super(realm);
        }

        @Override
        public void update() {
            //具体更新参考 详见 https://realm.io/docs/java/latest#migrations
            RealmSchema schema = realm.getSchema();
            RealmObjectSchema personSchema = schema.get(PersonRealmDAO.class.getSimpleName());
            if (personSchema != null) {
                personSchema.setRequired(NAME, true);
                personSchema.setRequired(SEX, true);
            }
            MyRealmMigration.this.oldVersion++;
        }
    }

    /**
     * 升级到版本2的具体方法及版本变更详情
     */
    class UpdateToVersion3 extends BaseUpdateVersion {

        private final String ID = "id";
        private final String NAME = "name";
        private final String TAG = "tag";

        UpdateToVersion3(DynamicRealm realm) {
            super(realm);
        }

        @Override
        public void update() {
            //具体更新参考 详见 https://realm.io/docs/java/latest#migrations
            RealmSchema schema = realm.getSchema();
            RealmObjectSchema dogSchem = schema.create(DogRealmDAO.class.getSimpleName());
            dogSchem.addField(ID, int.class, FieldAttribute.PRIMARY_KEY);
            dogSchem.addField(NAME, String.class, FieldAttribute.REQUIRED);
            dogSchem.addField(TAG, String.class, FieldAttribute.REQUIRED);
            MyRealmMigration.this.oldVersion++;
        }
    }
}
