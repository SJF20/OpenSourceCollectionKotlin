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
public class com_shijingfeng_realm_entity_CityDataRealmRealmProxy extends com.shijingfeng.realm.entity.CityDataRealm
    implements RealmObjectProxy, com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface {

    static final class CityDataRealmColumnInfo extends ColumnInfo {
        long cityCodeColKey;
        long longitudeColKey;
        long latitudeColKey;
        long cityNameColKey;
        long cityFullNameColKey;
        long weatherTypeColKey;
        long weatherDescColKey;
        long curTempColKey;
        long lowestTempColKey;
        long highestTempColKey;
        long weatherDataColKey;
        long orderNumberColKey;

        CityDataRealmColumnInfo(OsSchemaInfo schemaInfo) {
            super(12);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("city_data");
            this.cityCodeColKey = addColumnDetails("cityCode", "city_code", objectSchemaInfo);
            this.longitudeColKey = addColumnDetails("longitude", "longitude", objectSchemaInfo);
            this.latitudeColKey = addColumnDetails("latitude", "latitude", objectSchemaInfo);
            this.cityNameColKey = addColumnDetails("cityName", "city_name", objectSchemaInfo);
            this.cityFullNameColKey = addColumnDetails("cityFullName", "city_full_name", objectSchemaInfo);
            this.weatherTypeColKey = addColumnDetails("weatherType", "weather_type", objectSchemaInfo);
            this.weatherDescColKey = addColumnDetails("weatherDesc", "weather_desc", objectSchemaInfo);
            this.curTempColKey = addColumnDetails("curTemp", "cur_temp", objectSchemaInfo);
            this.lowestTempColKey = addColumnDetails("lowestTemp", "lowest_temp", objectSchemaInfo);
            this.highestTempColKey = addColumnDetails("highestTemp", "highest_temp", objectSchemaInfo);
            this.weatherDataColKey = addColumnDetails("weatherData", "weather_data", objectSchemaInfo);
            this.orderNumberColKey = addColumnDetails("orderNumber", "order_number", objectSchemaInfo);
        }

        CityDataRealmColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new CityDataRealmColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final CityDataRealmColumnInfo src = (CityDataRealmColumnInfo) rawSrc;
            final CityDataRealmColumnInfo dst = (CityDataRealmColumnInfo) rawDst;
            dst.cityCodeColKey = src.cityCodeColKey;
            dst.longitudeColKey = src.longitudeColKey;
            dst.latitudeColKey = src.latitudeColKey;
            dst.cityNameColKey = src.cityNameColKey;
            dst.cityFullNameColKey = src.cityFullNameColKey;
            dst.weatherTypeColKey = src.weatherTypeColKey;
            dst.weatherDescColKey = src.weatherDescColKey;
            dst.curTempColKey = src.curTempColKey;
            dst.lowestTempColKey = src.lowestTempColKey;
            dst.highestTempColKey = src.highestTempColKey;
            dst.weatherDataColKey = src.weatherDataColKey;
            dst.orderNumberColKey = src.orderNumberColKey;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private CityDataRealmColumnInfo columnInfo;
    private ProxyState<com.shijingfeng.realm.entity.CityDataRealm> proxyState;

    com_shijingfeng_realm_entity_CityDataRealmRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (CityDataRealmColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.shijingfeng.realm.entity.CityDataRealm>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$cityCode() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.cityCodeColKey);
    }

    @Override
    public void realmSet$cityCode(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'cityCode' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$longitude() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.longitudeColKey);
    }

    @Override
    public void realmSet$longitude(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.longitudeColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.longitudeColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$latitude() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.latitudeColKey);
    }

    @Override
    public void realmSet$latitude(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.latitudeColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.latitudeColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$cityName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.cityNameColKey);
    }

    @Override
    public void realmSet$cityName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'cityName' to null.");
            }
            row.getTable().setString(columnInfo.cityNameColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'cityName' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.cityNameColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$cityFullName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.cityFullNameColKey);
    }

    @Override
    public void realmSet$cityFullName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'cityFullName' to null.");
            }
            row.getTable().setString(columnInfo.cityFullNameColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'cityFullName' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.cityFullNameColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$weatherType() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.weatherTypeColKey);
    }

    @Override
    public void realmSet$weatherType(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.weatherTypeColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.weatherTypeColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$weatherDesc() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.weatherDescColKey);
    }

    @Override
    public void realmSet$weatherDesc(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'weatherDesc' to null.");
            }
            row.getTable().setString(columnInfo.weatherDescColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'weatherDesc' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.weatherDescColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$curTemp() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.curTempColKey);
    }

    @Override
    public void realmSet$curTemp(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.curTempColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.curTempColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$lowestTemp() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.lowestTempColKey);
    }

    @Override
    public void realmSet$lowestTemp(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.lowestTempColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.lowestTempColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$highestTemp() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.highestTempColKey);
    }

    @Override
    public void realmSet$highestTemp(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.highestTempColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.highestTempColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$weatherData() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.weatherDataColKey);
    }

    @Override
    public void realmSet$weatherData(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'weatherData' to null.");
            }
            row.getTable().setString(columnInfo.weatherDataColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'weatherData' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.weatherDataColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$orderNumber() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.orderNumberColKey);
    }

    @Override
    public void realmSet$orderNumber(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.orderNumberColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.orderNumberColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("city_data", false, 12, 0);
        builder.addPersistedProperty("city_code", RealmFieldType.STRING, Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("longitude", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("latitude", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("city_name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("city_full_name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("weather_type", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("weather_desc", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("cur_temp", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("lowest_temp", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("highest_temp", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("weather_data", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("order_number", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static CityDataRealmColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new CityDataRealmColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "city_data";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "city_data";
    }

    @SuppressWarnings("cast")
    public static com.shijingfeng.realm.entity.CityDataRealm createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.shijingfeng.realm.entity.CityDataRealm obj = null;
        if (update) {
            Table table = realm.getTable(com.shijingfeng.realm.entity.CityDataRealm.class);
            CityDataRealmColumnInfo columnInfo = (CityDataRealmColumnInfo) realm.getSchema().getColumnInfo(com.shijingfeng.realm.entity.CityDataRealm.class);
            long pkColumnKey = columnInfo.cityCodeColKey;
            long objKey = Table.NO_MATCH;
            if (!json.isNull("cityCode")) {
                objKey = table.findFirstString(pkColumnKey, json.getString("cityCode"));
            }
            if (objKey != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(com.shijingfeng.realm.entity.CityDataRealm.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_shijingfeng_realm_entity_CityDataRealmRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("cityCode")) {
                if (json.isNull("cityCode")) {
                    obj = (io.realm.com_shijingfeng_realm_entity_CityDataRealmRealmProxy) realm.createObjectInternal(com.shijingfeng.realm.entity.CityDataRealm.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_shijingfeng_realm_entity_CityDataRealmRealmProxy) realm.createObjectInternal(com.shijingfeng.realm.entity.CityDataRealm.class, json.getString("cityCode"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'cityCode'.");
            }
        }

        final com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface objProxy = (com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) obj;
        if (json.has("longitude")) {
            if (json.isNull("longitude")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'longitude' to null.");
            } else {
                objProxy.realmSet$longitude((double) json.getDouble("longitude"));
            }
        }
        if (json.has("latitude")) {
            if (json.isNull("latitude")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'latitude' to null.");
            } else {
                objProxy.realmSet$latitude((double) json.getDouble("latitude"));
            }
        }
        if (json.has("cityName")) {
            if (json.isNull("cityName")) {
                objProxy.realmSet$cityName(null);
            } else {
                objProxy.realmSet$cityName((String) json.getString("cityName"));
            }
        }
        if (json.has("cityFullName")) {
            if (json.isNull("cityFullName")) {
                objProxy.realmSet$cityFullName(null);
            } else {
                objProxy.realmSet$cityFullName((String) json.getString("cityFullName"));
            }
        }
        if (json.has("weatherType")) {
            if (json.isNull("weatherType")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'weatherType' to null.");
            } else {
                objProxy.realmSet$weatherType((int) json.getInt("weatherType"));
            }
        }
        if (json.has("weatherDesc")) {
            if (json.isNull("weatherDesc")) {
                objProxy.realmSet$weatherDesc(null);
            } else {
                objProxy.realmSet$weatherDesc((String) json.getString("weatherDesc"));
            }
        }
        if (json.has("curTemp")) {
            if (json.isNull("curTemp")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'curTemp' to null.");
            } else {
                objProxy.realmSet$curTemp((double) json.getDouble("curTemp"));
            }
        }
        if (json.has("lowestTemp")) {
            if (json.isNull("lowestTemp")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'lowestTemp' to null.");
            } else {
                objProxy.realmSet$lowestTemp((double) json.getDouble("lowestTemp"));
            }
        }
        if (json.has("highestTemp")) {
            if (json.isNull("highestTemp")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'highestTemp' to null.");
            } else {
                objProxy.realmSet$highestTemp((double) json.getDouble("highestTemp"));
            }
        }
        if (json.has("weatherData")) {
            if (json.isNull("weatherData")) {
                objProxy.realmSet$weatherData(null);
            } else {
                objProxy.realmSet$weatherData((String) json.getString("weatherData"));
            }
        }
        if (json.has("orderNumber")) {
            if (json.isNull("orderNumber")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'orderNumber' to null.");
            } else {
                objProxy.realmSet$orderNumber((double) json.getDouble("orderNumber"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.shijingfeng.realm.entity.CityDataRealm createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.shijingfeng.realm.entity.CityDataRealm obj = new com.shijingfeng.realm.entity.CityDataRealm();
        final com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface objProxy = (com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("cityCode")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$cityCode((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$cityCode(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("longitude")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$longitude((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'longitude' to null.");
                }
            } else if (name.equals("latitude")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$latitude((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'latitude' to null.");
                }
            } else if (name.equals("cityName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$cityName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$cityName(null);
                }
            } else if (name.equals("cityFullName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$cityFullName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$cityFullName(null);
                }
            } else if (name.equals("weatherType")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$weatherType((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'weatherType' to null.");
                }
            } else if (name.equals("weatherDesc")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$weatherDesc((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$weatherDesc(null);
                }
            } else if (name.equals("curTemp")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$curTemp((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'curTemp' to null.");
                }
            } else if (name.equals("lowestTemp")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$lowestTemp((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'lowestTemp' to null.");
                }
            } else if (name.equals("highestTemp")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$highestTemp((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'highestTemp' to null.");
                }
            } else if (name.equals("weatherData")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$weatherData((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$weatherData(null);
                }
            } else if (name.equals("orderNumber")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$orderNumber((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'orderNumber' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'cityCode'.");
        }
        return realm.copyToRealm(obj);
    }

    static com_shijingfeng_realm_entity_CityDataRealmRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.shijingfeng.realm.entity.CityDataRealm.class), false, Collections.<String>emptyList());
        io.realm.com_shijingfeng_realm_entity_CityDataRealmRealmProxy obj = new io.realm.com_shijingfeng_realm_entity_CityDataRealmRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.shijingfeng.realm.entity.CityDataRealm copyOrUpdate(Realm realm, CityDataRealmColumnInfo columnInfo, com.shijingfeng.realm.entity.CityDataRealm object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.shijingfeng.realm.entity.CityDataRealm) cachedRealmObject;
        }

        com.shijingfeng.realm.entity.CityDataRealm realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.shijingfeng.realm.entity.CityDataRealm.class);
            long pkColumnKey = columnInfo.cityCodeColKey;
            long objKey = table.findFirstString(pkColumnKey, ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$cityCode());
            if (objKey == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_shijingfeng_realm_entity_CityDataRealmRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.shijingfeng.realm.entity.CityDataRealm copy(Realm realm, CityDataRealmColumnInfo columnInfo, com.shijingfeng.realm.entity.CityDataRealm newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.shijingfeng.realm.entity.CityDataRealm) cachedRealmObject;
        }

        com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface unmanagedSource = (com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) newObject;

        Table table = realm.getTable(com.shijingfeng.realm.entity.CityDataRealm.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.cityCodeColKey, unmanagedSource.realmGet$cityCode());
        builder.addDouble(columnInfo.longitudeColKey, unmanagedSource.realmGet$longitude());
        builder.addDouble(columnInfo.latitudeColKey, unmanagedSource.realmGet$latitude());
        builder.addString(columnInfo.cityNameColKey, unmanagedSource.realmGet$cityName());
        builder.addString(columnInfo.cityFullNameColKey, unmanagedSource.realmGet$cityFullName());
        builder.addInteger(columnInfo.weatherTypeColKey, unmanagedSource.realmGet$weatherType());
        builder.addString(columnInfo.weatherDescColKey, unmanagedSource.realmGet$weatherDesc());
        builder.addDouble(columnInfo.curTempColKey, unmanagedSource.realmGet$curTemp());
        builder.addDouble(columnInfo.lowestTempColKey, unmanagedSource.realmGet$lowestTemp());
        builder.addDouble(columnInfo.highestTempColKey, unmanagedSource.realmGet$highestTemp());
        builder.addString(columnInfo.weatherDataColKey, unmanagedSource.realmGet$weatherData());
        builder.addDouble(columnInfo.orderNumberColKey, unmanagedSource.realmGet$orderNumber());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_shijingfeng_realm_entity_CityDataRealmRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        return managedCopy;
    }

    public static long insert(Realm realm, com.shijingfeng.realm.entity.CityDataRealm object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.shijingfeng.realm.entity.CityDataRealm.class);
        long tableNativePtr = table.getNativePtr();
        CityDataRealmColumnInfo columnInfo = (CityDataRealmColumnInfo) realm.getSchema().getColumnInfo(com.shijingfeng.realm.entity.CityDataRealm.class);
        long pkColumnKey = columnInfo.cityCodeColKey;
        long objKey = Table.NO_MATCH;
        Object primaryKeyValue = ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$cityCode();
        if (primaryKeyValue != null) {
            objKey = Table.nativeFindFirstString(tableNativePtr, pkColumnKey, (String)primaryKeyValue);
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, objKey);
        Table.nativeSetDouble(tableNativePtr, columnInfo.longitudeColKey, objKey, ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$longitude(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.latitudeColKey, objKey, ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$latitude(), false);
        String realmGet$cityName = ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$cityName();
        if (realmGet$cityName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cityNameColKey, objKey, realmGet$cityName, false);
        }
        String realmGet$cityFullName = ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$cityFullName();
        if (realmGet$cityFullName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cityFullNameColKey, objKey, realmGet$cityFullName, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.weatherTypeColKey, objKey, ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$weatherType(), false);
        String realmGet$weatherDesc = ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$weatherDesc();
        if (realmGet$weatherDesc != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.weatherDescColKey, objKey, realmGet$weatherDesc, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.curTempColKey, objKey, ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$curTemp(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.lowestTempColKey, objKey, ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$lowestTemp(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.highestTempColKey, objKey, ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$highestTemp(), false);
        String realmGet$weatherData = ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$weatherData();
        if (realmGet$weatherData != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.weatherDataColKey, objKey, realmGet$weatherData, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.orderNumberColKey, objKey, ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$orderNumber(), false);
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.shijingfeng.realm.entity.CityDataRealm.class);
        long tableNativePtr = table.getNativePtr();
        CityDataRealmColumnInfo columnInfo = (CityDataRealmColumnInfo) realm.getSchema().getColumnInfo(com.shijingfeng.realm.entity.CityDataRealm.class);
        long pkColumnKey = columnInfo.cityCodeColKey;
        com.shijingfeng.realm.entity.CityDataRealm object = null;
        while (objects.hasNext()) {
            object = (com.shijingfeng.realm.entity.CityDataRealm) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = Table.NO_MATCH;
            Object primaryKeyValue = ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$cityCode();
            if (primaryKeyValue != null) {
                objKey = Table.nativeFindFirstString(tableNativePtr, pkColumnKey, (String)primaryKeyValue);
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, objKey);
            Table.nativeSetDouble(tableNativePtr, columnInfo.longitudeColKey, objKey, ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$longitude(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.latitudeColKey, objKey, ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$latitude(), false);
            String realmGet$cityName = ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$cityName();
            if (realmGet$cityName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.cityNameColKey, objKey, realmGet$cityName, false);
            }
            String realmGet$cityFullName = ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$cityFullName();
            if (realmGet$cityFullName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.cityFullNameColKey, objKey, realmGet$cityFullName, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.weatherTypeColKey, objKey, ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$weatherType(), false);
            String realmGet$weatherDesc = ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$weatherDesc();
            if (realmGet$weatherDesc != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.weatherDescColKey, objKey, realmGet$weatherDesc, false);
            }
            Table.nativeSetDouble(tableNativePtr, columnInfo.curTempColKey, objKey, ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$curTemp(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.lowestTempColKey, objKey, ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$lowestTemp(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.highestTempColKey, objKey, ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$highestTemp(), false);
            String realmGet$weatherData = ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$weatherData();
            if (realmGet$weatherData != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.weatherDataColKey, objKey, realmGet$weatherData, false);
            }
            Table.nativeSetDouble(tableNativePtr, columnInfo.orderNumberColKey, objKey, ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$orderNumber(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.shijingfeng.realm.entity.CityDataRealm object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.shijingfeng.realm.entity.CityDataRealm.class);
        long tableNativePtr = table.getNativePtr();
        CityDataRealmColumnInfo columnInfo = (CityDataRealmColumnInfo) realm.getSchema().getColumnInfo(com.shijingfeng.realm.entity.CityDataRealm.class);
        long pkColumnKey = columnInfo.cityCodeColKey;
        long objKey = Table.NO_MATCH;
        Object primaryKeyValue = ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$cityCode();
        if (primaryKeyValue != null) {
            objKey = Table.nativeFindFirstString(tableNativePtr, pkColumnKey, (String)primaryKeyValue);
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
        }
        cache.put(object, objKey);
        Table.nativeSetDouble(tableNativePtr, columnInfo.longitudeColKey, objKey, ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$longitude(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.latitudeColKey, objKey, ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$latitude(), false);
        String realmGet$cityName = ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$cityName();
        if (realmGet$cityName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cityNameColKey, objKey, realmGet$cityName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cityNameColKey, objKey, false);
        }
        String realmGet$cityFullName = ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$cityFullName();
        if (realmGet$cityFullName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cityFullNameColKey, objKey, realmGet$cityFullName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cityFullNameColKey, objKey, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.weatherTypeColKey, objKey, ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$weatherType(), false);
        String realmGet$weatherDesc = ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$weatherDesc();
        if (realmGet$weatherDesc != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.weatherDescColKey, objKey, realmGet$weatherDesc, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.weatherDescColKey, objKey, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.curTempColKey, objKey, ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$curTemp(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.lowestTempColKey, objKey, ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$lowestTemp(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.highestTempColKey, objKey, ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$highestTemp(), false);
        String realmGet$weatherData = ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$weatherData();
        if (realmGet$weatherData != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.weatherDataColKey, objKey, realmGet$weatherData, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.weatherDataColKey, objKey, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.orderNumberColKey, objKey, ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$orderNumber(), false);
        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.shijingfeng.realm.entity.CityDataRealm.class);
        long tableNativePtr = table.getNativePtr();
        CityDataRealmColumnInfo columnInfo = (CityDataRealmColumnInfo) realm.getSchema().getColumnInfo(com.shijingfeng.realm.entity.CityDataRealm.class);
        long pkColumnKey = columnInfo.cityCodeColKey;
        com.shijingfeng.realm.entity.CityDataRealm object = null;
        while (objects.hasNext()) {
            object = (com.shijingfeng.realm.entity.CityDataRealm) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = Table.NO_MATCH;
            Object primaryKeyValue = ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$cityCode();
            if (primaryKeyValue != null) {
                objKey = Table.nativeFindFirstString(tableNativePtr, pkColumnKey, (String)primaryKeyValue);
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
            }
            cache.put(object, objKey);
            Table.nativeSetDouble(tableNativePtr, columnInfo.longitudeColKey, objKey, ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$longitude(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.latitudeColKey, objKey, ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$latitude(), false);
            String realmGet$cityName = ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$cityName();
            if (realmGet$cityName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.cityNameColKey, objKey, realmGet$cityName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.cityNameColKey, objKey, false);
            }
            String realmGet$cityFullName = ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$cityFullName();
            if (realmGet$cityFullName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.cityFullNameColKey, objKey, realmGet$cityFullName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.cityFullNameColKey, objKey, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.weatherTypeColKey, objKey, ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$weatherType(), false);
            String realmGet$weatherDesc = ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$weatherDesc();
            if (realmGet$weatherDesc != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.weatherDescColKey, objKey, realmGet$weatherDesc, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.weatherDescColKey, objKey, false);
            }
            Table.nativeSetDouble(tableNativePtr, columnInfo.curTempColKey, objKey, ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$curTemp(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.lowestTempColKey, objKey, ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$lowestTemp(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.highestTempColKey, objKey, ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$highestTemp(), false);
            String realmGet$weatherData = ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$weatherData();
            if (realmGet$weatherData != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.weatherDataColKey, objKey, realmGet$weatherData, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.weatherDataColKey, objKey, false);
            }
            Table.nativeSetDouble(tableNativePtr, columnInfo.orderNumberColKey, objKey, ((com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) object).realmGet$orderNumber(), false);
        }
    }

    public static com.shijingfeng.realm.entity.CityDataRealm createDetachedCopy(com.shijingfeng.realm.entity.CityDataRealm realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.shijingfeng.realm.entity.CityDataRealm unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.shijingfeng.realm.entity.CityDataRealm();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.shijingfeng.realm.entity.CityDataRealm) cachedObject.object;
            }
            unmanagedObject = (com.shijingfeng.realm.entity.CityDataRealm) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface unmanagedCopy = (com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) unmanagedObject;
        com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface realmSource = (com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$cityCode(realmSource.realmGet$cityCode());
        unmanagedCopy.realmSet$longitude(realmSource.realmGet$longitude());
        unmanagedCopy.realmSet$latitude(realmSource.realmGet$latitude());
        unmanagedCopy.realmSet$cityName(realmSource.realmGet$cityName());
        unmanagedCopy.realmSet$cityFullName(realmSource.realmGet$cityFullName());
        unmanagedCopy.realmSet$weatherType(realmSource.realmGet$weatherType());
        unmanagedCopy.realmSet$weatherDesc(realmSource.realmGet$weatherDesc());
        unmanagedCopy.realmSet$curTemp(realmSource.realmGet$curTemp());
        unmanagedCopy.realmSet$lowestTemp(realmSource.realmGet$lowestTemp());
        unmanagedCopy.realmSet$highestTemp(realmSource.realmGet$highestTemp());
        unmanagedCopy.realmSet$weatherData(realmSource.realmGet$weatherData());
        unmanagedCopy.realmSet$orderNumber(realmSource.realmGet$orderNumber());

        return unmanagedObject;
    }

    static com.shijingfeng.realm.entity.CityDataRealm update(Realm realm, CityDataRealmColumnInfo columnInfo, com.shijingfeng.realm.entity.CityDataRealm realmObject, com.shijingfeng.realm.entity.CityDataRealm newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface realmObjectTarget = (com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) realmObject;
        com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface realmObjectSource = (com_shijingfeng_realm_entity_CityDataRealmRealmProxyInterface) newObject;
        Table table = realm.getTable(com.shijingfeng.realm.entity.CityDataRealm.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addString(columnInfo.cityCodeColKey, realmObjectSource.realmGet$cityCode());
        builder.addDouble(columnInfo.longitudeColKey, realmObjectSource.realmGet$longitude());
        builder.addDouble(columnInfo.latitudeColKey, realmObjectSource.realmGet$latitude());
        builder.addString(columnInfo.cityNameColKey, realmObjectSource.realmGet$cityName());
        builder.addString(columnInfo.cityFullNameColKey, realmObjectSource.realmGet$cityFullName());
        builder.addInteger(columnInfo.weatherTypeColKey, realmObjectSource.realmGet$weatherType());
        builder.addString(columnInfo.weatherDescColKey, realmObjectSource.realmGet$weatherDesc());
        builder.addDouble(columnInfo.curTempColKey, realmObjectSource.realmGet$curTemp());
        builder.addDouble(columnInfo.lowestTempColKey, realmObjectSource.realmGet$lowestTemp());
        builder.addDouble(columnInfo.highestTempColKey, realmObjectSource.realmGet$highestTemp());
        builder.addString(columnInfo.weatherDataColKey, realmObjectSource.realmGet$weatherData());
        builder.addDouble(columnInfo.orderNumberColKey, realmObjectSource.realmGet$orderNumber());

        builder.updateExistingTopLevelObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("CityDataRealm = proxy[");
        stringBuilder.append("{cityCode:");
        stringBuilder.append(realmGet$cityCode());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{longitude:");
        stringBuilder.append(realmGet$longitude());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{latitude:");
        stringBuilder.append(realmGet$latitude());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cityName:");
        stringBuilder.append(realmGet$cityName());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cityFullName:");
        stringBuilder.append(realmGet$cityFullName());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{weatherType:");
        stringBuilder.append(realmGet$weatherType());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{weatherDesc:");
        stringBuilder.append(realmGet$weatherDesc());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{curTemp:");
        stringBuilder.append(realmGet$curTemp());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{lowestTemp:");
        stringBuilder.append(realmGet$lowestTemp());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{highestTemp:");
        stringBuilder.append(realmGet$highestTemp());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{weatherData:");
        stringBuilder.append(realmGet$weatherData());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{orderNumber:");
        stringBuilder.append(realmGet$orderNumber());
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
        com_shijingfeng_realm_entity_CityDataRealmRealmProxy aCityDataRealm = (com_shijingfeng_realm_entity_CityDataRealmRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aCityDataRealm.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aCityDataRealm.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aCityDataRealm.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
