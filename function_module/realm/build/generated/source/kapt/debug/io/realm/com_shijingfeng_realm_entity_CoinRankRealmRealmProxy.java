package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_shijingfeng_realm_entity_CoinRankRealmRealmProxy extends com.shijingfeng.realm.entity.CoinRankRealm
    implements RealmObjectProxy, com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface {

    static final class CoinRankRealmColumnInfo extends ColumnInfo {
        long userIdColKey;
        long usernameColKey;
        long levelColKey;
        long rankColKey;
        long coinCountColKey;

        CoinRankRealmColumnInfo(OsSchemaInfo schemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("coin_rank");
            this.userIdColKey = addColumnDetails("userId", "userId", objectSchemaInfo);
            this.usernameColKey = addColumnDetails("username", "username", objectSchemaInfo);
            this.levelColKey = addColumnDetails("level", "level", objectSchemaInfo);
            this.rankColKey = addColumnDetails("rank", "rank", objectSchemaInfo);
            this.coinCountColKey = addColumnDetails("coinCount", "coinCount", objectSchemaInfo);
        }

        CoinRankRealmColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new CoinRankRealmColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final CoinRankRealmColumnInfo src = (CoinRankRealmColumnInfo) rawSrc;
            final CoinRankRealmColumnInfo dst = (CoinRankRealmColumnInfo) rawDst;
            dst.userIdColKey = src.userIdColKey;
            dst.usernameColKey = src.usernameColKey;
            dst.levelColKey = src.levelColKey;
            dst.rankColKey = src.rankColKey;
            dst.coinCountColKey = src.coinCountColKey;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private CoinRankRealmColumnInfo columnInfo;
    private ProxyState<com.shijingfeng.realm.entity.CoinRankRealm> proxyState;

    com_shijingfeng_realm_entity_CoinRankRealmRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (CoinRankRealmColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.shijingfeng.realm.entity.CoinRankRealm>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$userId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.userIdColKey);
    }

    @Override
    public void realmSet$userId(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'userId' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$username() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.usernameColKey);
    }

    @Override
    public void realmSet$username(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'username' to null.");
            }
            row.getTable().setString(columnInfo.usernameColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'username' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.usernameColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$level() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.levelColKey);
    }

    @Override
    public void realmSet$level(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.levelColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.levelColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$rank() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.rankColKey);
    }

    @Override
    public void realmSet$rank(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.rankColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.rankColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$coinCount() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.coinCountColKey);
    }

    @Override
    public void realmSet$coinCount(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.coinCountColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.coinCountColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("coin_rank", false, 5, 0);
        builder.addPersistedProperty("userId", RealmFieldType.STRING, Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("username", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("level", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("rank", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("coinCount", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static CoinRankRealmColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new CoinRankRealmColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "coin_rank";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "coin_rank";
    }

    @SuppressWarnings("cast")
    public static com.shijingfeng.realm.entity.CoinRankRealm createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.shijingfeng.realm.entity.CoinRankRealm obj = null;
        if (update) {
            Table table = realm.getTable(com.shijingfeng.realm.entity.CoinRankRealm.class);
            CoinRankRealmColumnInfo columnInfo = (CoinRankRealmColumnInfo) realm.getSchema().getColumnInfo(com.shijingfeng.realm.entity.CoinRankRealm.class);
            long pkColumnKey = columnInfo.userIdColKey;
            long objKey = Table.NO_MATCH;
            if (!json.isNull("userId")) {
                objKey = table.findFirstString(pkColumnKey, json.getString("userId"));
            }
            if (objKey != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(com.shijingfeng.realm.entity.CoinRankRealm.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_shijingfeng_realm_entity_CoinRankRealmRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("userId")) {
                if (json.isNull("userId")) {
                    obj = (io.realm.com_shijingfeng_realm_entity_CoinRankRealmRealmProxy) realm.createObjectInternal(com.shijingfeng.realm.entity.CoinRankRealm.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_shijingfeng_realm_entity_CoinRankRealmRealmProxy) realm.createObjectInternal(com.shijingfeng.realm.entity.CoinRankRealm.class, json.getString("userId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'userId'.");
            }
        }

        final com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface objProxy = (com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface) obj;
        if (json.has("username")) {
            if (json.isNull("username")) {
                objProxy.realmSet$username(null);
            } else {
                objProxy.realmSet$username((String) json.getString("username"));
            }
        }
        if (json.has("level")) {
            if (json.isNull("level")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'level' to null.");
            } else {
                objProxy.realmSet$level((int) json.getInt("level"));
            }
        }
        if (json.has("rank")) {
            if (json.isNull("rank")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'rank' to null.");
            } else {
                objProxy.realmSet$rank((int) json.getInt("rank"));
            }
        }
        if (json.has("coinCount")) {
            if (json.isNull("coinCount")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'coinCount' to null.");
            } else {
                objProxy.realmSet$coinCount((int) json.getInt("coinCount"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.shijingfeng.realm.entity.CoinRankRealm createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.shijingfeng.realm.entity.CoinRankRealm obj = new com.shijingfeng.realm.entity.CoinRankRealm();
        final com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface objProxy = (com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("userId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$userId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$userId(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("username")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$username((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$username(null);
                }
            } else if (name.equals("level")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$level((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'level' to null.");
                }
            } else if (name.equals("rank")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$rank((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'rank' to null.");
                }
            } else if (name.equals("coinCount")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$coinCount((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'coinCount' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'userId'.");
        }
        return realm.copyToRealm(obj);
    }

    static com_shijingfeng_realm_entity_CoinRankRealmRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.shijingfeng.realm.entity.CoinRankRealm.class), false, Collections.<String>emptyList());
        io.realm.com_shijingfeng_realm_entity_CoinRankRealmRealmProxy obj = new io.realm.com_shijingfeng_realm_entity_CoinRankRealmRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.shijingfeng.realm.entity.CoinRankRealm copyOrUpdate(Realm realm, CoinRankRealmColumnInfo columnInfo, com.shijingfeng.realm.entity.CoinRankRealm object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.shijingfeng.realm.entity.CoinRankRealm) cachedRealmObject;
        }

        com.shijingfeng.realm.entity.CoinRankRealm realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.shijingfeng.realm.entity.CoinRankRealm.class);
            long pkColumnKey = columnInfo.userIdColKey;
            long objKey = table.findFirstString(pkColumnKey, ((com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface) object).realmGet$userId());
            if (objKey == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_shijingfeng_realm_entity_CoinRankRealmRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.shijingfeng.realm.entity.CoinRankRealm copy(Realm realm, CoinRankRealmColumnInfo columnInfo, com.shijingfeng.realm.entity.CoinRankRealm newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.shijingfeng.realm.entity.CoinRankRealm) cachedRealmObject;
        }

        com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface unmanagedSource = (com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface) newObject;

        Table table = realm.getTable(com.shijingfeng.realm.entity.CoinRankRealm.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.userIdColKey, unmanagedSource.realmGet$userId());
        builder.addString(columnInfo.usernameColKey, unmanagedSource.realmGet$username());
        builder.addInteger(columnInfo.levelColKey, unmanagedSource.realmGet$level());
        builder.addInteger(columnInfo.rankColKey, unmanagedSource.realmGet$rank());
        builder.addInteger(columnInfo.coinCountColKey, unmanagedSource.realmGet$coinCount());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_shijingfeng_realm_entity_CoinRankRealmRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        return managedCopy;
    }

    public static long insert(Realm realm, com.shijingfeng.realm.entity.CoinRankRealm object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.shijingfeng.realm.entity.CoinRankRealm.class);
        long tableNativePtr = table.getNativePtr();
        CoinRankRealmColumnInfo columnInfo = (CoinRankRealmColumnInfo) realm.getSchema().getColumnInfo(com.shijingfeng.realm.entity.CoinRankRealm.class);
        long pkColumnKey = columnInfo.userIdColKey;
        long objKey = Table.NO_MATCH;
        Object primaryKeyValue = ((com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface) object).realmGet$userId();
        if (primaryKeyValue != null) {
            objKey = Table.nativeFindFirstString(tableNativePtr, pkColumnKey, (String)primaryKeyValue);
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, objKey);
        String realmGet$username = ((com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface) object).realmGet$username();
        if (realmGet$username != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.usernameColKey, objKey, realmGet$username, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.levelColKey, objKey, ((com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface) object).realmGet$level(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.rankColKey, objKey, ((com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface) object).realmGet$rank(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.coinCountColKey, objKey, ((com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface) object).realmGet$coinCount(), false);
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.shijingfeng.realm.entity.CoinRankRealm.class);
        long tableNativePtr = table.getNativePtr();
        CoinRankRealmColumnInfo columnInfo = (CoinRankRealmColumnInfo) realm.getSchema().getColumnInfo(com.shijingfeng.realm.entity.CoinRankRealm.class);
        long pkColumnKey = columnInfo.userIdColKey;
        com.shijingfeng.realm.entity.CoinRankRealm object = null;
        while (objects.hasNext()) {
            object = (com.shijingfeng.realm.entity.CoinRankRealm) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = Table.NO_MATCH;
            Object primaryKeyValue = ((com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface) object).realmGet$userId();
            if (primaryKeyValue != null) {
                objKey = Table.nativeFindFirstString(tableNativePtr, pkColumnKey, (String)primaryKeyValue);
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, objKey);
            String realmGet$username = ((com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface) object).realmGet$username();
            if (realmGet$username != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.usernameColKey, objKey, realmGet$username, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.levelColKey, objKey, ((com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface) object).realmGet$level(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.rankColKey, objKey, ((com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface) object).realmGet$rank(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.coinCountColKey, objKey, ((com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface) object).realmGet$coinCount(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.shijingfeng.realm.entity.CoinRankRealm object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.shijingfeng.realm.entity.CoinRankRealm.class);
        long tableNativePtr = table.getNativePtr();
        CoinRankRealmColumnInfo columnInfo = (CoinRankRealmColumnInfo) realm.getSchema().getColumnInfo(com.shijingfeng.realm.entity.CoinRankRealm.class);
        long pkColumnKey = columnInfo.userIdColKey;
        long objKey = Table.NO_MATCH;
        Object primaryKeyValue = ((com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface) object).realmGet$userId();
        if (primaryKeyValue != null) {
            objKey = Table.nativeFindFirstString(tableNativePtr, pkColumnKey, (String)primaryKeyValue);
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
        }
        cache.put(object, objKey);
        String realmGet$username = ((com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface) object).realmGet$username();
        if (realmGet$username != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.usernameColKey, objKey, realmGet$username, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.usernameColKey, objKey, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.levelColKey, objKey, ((com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface) object).realmGet$level(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.rankColKey, objKey, ((com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface) object).realmGet$rank(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.coinCountColKey, objKey, ((com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface) object).realmGet$coinCount(), false);
        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.shijingfeng.realm.entity.CoinRankRealm.class);
        long tableNativePtr = table.getNativePtr();
        CoinRankRealmColumnInfo columnInfo = (CoinRankRealmColumnInfo) realm.getSchema().getColumnInfo(com.shijingfeng.realm.entity.CoinRankRealm.class);
        long pkColumnKey = columnInfo.userIdColKey;
        com.shijingfeng.realm.entity.CoinRankRealm object = null;
        while (objects.hasNext()) {
            object = (com.shijingfeng.realm.entity.CoinRankRealm) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = Table.NO_MATCH;
            Object primaryKeyValue = ((com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface) object).realmGet$userId();
            if (primaryKeyValue != null) {
                objKey = Table.nativeFindFirstString(tableNativePtr, pkColumnKey, (String)primaryKeyValue);
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
            }
            cache.put(object, objKey);
            String realmGet$username = ((com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface) object).realmGet$username();
            if (realmGet$username != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.usernameColKey, objKey, realmGet$username, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.usernameColKey, objKey, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.levelColKey, objKey, ((com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface) object).realmGet$level(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.rankColKey, objKey, ((com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface) object).realmGet$rank(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.coinCountColKey, objKey, ((com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface) object).realmGet$coinCount(), false);
        }
    }

    public static com.shijingfeng.realm.entity.CoinRankRealm createDetachedCopy(com.shijingfeng.realm.entity.CoinRankRealm realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.shijingfeng.realm.entity.CoinRankRealm unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.shijingfeng.realm.entity.CoinRankRealm();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.shijingfeng.realm.entity.CoinRankRealm) cachedObject.object;
            }
            unmanagedObject = (com.shijingfeng.realm.entity.CoinRankRealm) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface unmanagedCopy = (com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface) unmanagedObject;
        com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface realmSource = (com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$userId(realmSource.realmGet$userId());
        unmanagedCopy.realmSet$username(realmSource.realmGet$username());
        unmanagedCopy.realmSet$level(realmSource.realmGet$level());
        unmanagedCopy.realmSet$rank(realmSource.realmGet$rank());
        unmanagedCopy.realmSet$coinCount(realmSource.realmGet$coinCount());

        return unmanagedObject;
    }

    static com.shijingfeng.realm.entity.CoinRankRealm update(Realm realm, CoinRankRealmColumnInfo columnInfo, com.shijingfeng.realm.entity.CoinRankRealm realmObject, com.shijingfeng.realm.entity.CoinRankRealm newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface realmObjectTarget = (com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface) realmObject;
        com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface realmObjectSource = (com_shijingfeng_realm_entity_CoinRankRealmRealmProxyInterface) newObject;
        Table table = realm.getTable(com.shijingfeng.realm.entity.CoinRankRealm.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addString(columnInfo.userIdColKey, realmObjectSource.realmGet$userId());
        builder.addString(columnInfo.usernameColKey, realmObjectSource.realmGet$username());
        builder.addInteger(columnInfo.levelColKey, realmObjectSource.realmGet$level());
        builder.addInteger(columnInfo.rankColKey, realmObjectSource.realmGet$rank());
        builder.addInteger(columnInfo.coinCountColKey, realmObjectSource.realmGet$coinCount());

        builder.updateExistingTopLevelObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("CoinRankRealm = proxy[");
        stringBuilder.append("{userId:");
        stringBuilder.append(realmGet$userId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{username:");
        stringBuilder.append(realmGet$username());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{level:");
        stringBuilder.append(realmGet$level());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{rank:");
        stringBuilder.append(realmGet$rank());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{coinCount:");
        stringBuilder.append(realmGet$coinCount());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long objKey = proxyState.getRow$realm().getObjectKey();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (objKey ^ (objKey >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_shijingfeng_realm_entity_CoinRankRealmRealmProxy aCoinRankRealm = (com_shijingfeng_realm_entity_CoinRankRealmRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aCoinRankRealm.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aCoinRankRealm.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aCoinRankRealm.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
