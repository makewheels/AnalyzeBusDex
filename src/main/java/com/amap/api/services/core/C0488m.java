package com.amap.api.services.core;

import com.alipay.sdk.cons.C0108a;
import com.alipay.sdk.cons.C0110c;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.district.DistrictItem;
import com.amap.api.services.district.DistrictSearchQuery;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeRoad;
import com.amap.api.services.geocoder.StreetNumber;
import com.amap.api.services.help.Tip;
import com.amap.api.services.poisearch.Cinema;
import com.amap.api.services.poisearch.Dining;
import com.amap.api.services.poisearch.Discount;
import com.amap.api.services.poisearch.Groupbuy;
import com.amap.api.services.poisearch.Hotel;
import com.amap.api.services.poisearch.Photo;
import com.amap.api.services.poisearch.PoiItemDetail;
import com.amap.api.services.poisearch.PoiItemDetail.DeepType;
import com.amap.api.services.poisearch.Scenic;
import com.amap.api.services.road.Crossroad;
import com.amap.api.services.route.BusPath;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.BusStep;
import com.amap.api.services.route.District;
import com.amap.api.services.route.Doorway;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.DriveStep;
import com.amap.api.services.route.RouteBusLineItem;
import com.amap.api.services.route.RouteBusWalkItem;
import com.amap.api.services.route.RouteSearchCity;
import com.amap.api.services.route.WalkPath;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.services.route.WalkStep;
import com.umeng.analytics.onlineconfig.C1248a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* compiled from: JSONHelper */
/* renamed from: com.amap.api.services.core.m */
public class C0488m {
    /* renamed from: a */
    public static ArrayList<SuggestionCity> m4042a(JSONObject jSONObject) throws JSONException, NumberFormatException {
        if (!jSONObject.has("cities")) {
            return null;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("cities");
        ArrayList<SuggestionCity> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            arrayList.add(new SuggestionCity(C0488m.m4055b(jSONObject2, C0110c.f289e), C0488m.m4055b(jSONObject2, "citycode"), C0488m.m4055b(jSONObject2, "adcode"), C0488m.m4079i(C0488m.m4055b(jSONObject2, "num"))));
        }
        return arrayList;
    }

    /* renamed from: b */
    public static ArrayList<String> m4056b(JSONObject jSONObject) throws JSONException {
        if (!jSONObject.has("keywords")) {
            return null;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("keywords");
        ArrayList<String> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return arrayList;
    }

    /* renamed from: c */
    public static ArrayList<PoiItem> m4062c(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("pois");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return null;
        }
        ArrayList<PoiItem> arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(C0488m.m4066d(optJSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    /* renamed from: d */
    public static PoiItemDetail m4066d(JSONObject jSONObject) throws JSONException {
        PoiItemDetail poiItemDetail = new PoiItemDetail(C0488m.m4055b(jSONObject, "id"), C0488m.m4060c(jSONObject, LocationManagerProxy.KEY_LOCATION_CHANGED), C0488m.m4055b(jSONObject, C0110c.f289e), C0488m.m4055b(jSONObject, "address"));
        poiItemDetail.setAdCode(C0488m.m4055b(jSONObject, "adcode"));
        poiItemDetail.setProvinceName(C0488m.m4055b(jSONObject, "pname"));
        poiItemDetail.setCityName(C0488m.m4055b(jSONObject, "cityname"));
        poiItemDetail.setAdName(C0488m.m4055b(jSONObject, "adname"));
        poiItemDetail.setCityCode(C0488m.m4055b(jSONObject, "citycode"));
        poiItemDetail.setProvinceCode(C0488m.m4055b(jSONObject, "pcode"));
        if (jSONObject.has("distance")) {
            String string = jSONObject.getString("distance");
            if (!C0488m.m4078h(string)) {
                try {
                    poiItemDetail.setDistance(Integer.parseInt(string));
                } catch (NumberFormatException e) {
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (poiItemDetail.getDistance() == 0) {
                    poiItemDetail.setDistance(-1);
                }
            }
        }
        poiItemDetail.setTel(C0488m.m4055b(jSONObject, "tel"));
        poiItemDetail.setTypeDes(C0488m.m4055b(jSONObject, C1248a.f5654a));
        poiItemDetail.setEnter(C0488m.m4060c(jSONObject, "entr_location"));
        poiItemDetail.setExit(C0488m.m4060c(jSONObject, "exit_location"));
        poiItemDetail.setWebsite(C0488m.m4055b(jSONObject, "website"));
        poiItemDetail.setPostcode(C0488m.m4055b(jSONObject, "citycode"));
        poiItemDetail.setEmail(C0488m.m4055b(jSONObject, "email"));
        if (C0488m.m4076g(C0488m.m4055b(jSONObject, "groupbuy_num"))) {
            poiItemDetail.setGroupbuyInfo(false);
        } else {
            poiItemDetail.setGroupbuyInfo(true);
        }
        if (C0488m.m4076g(C0488m.m4055b(jSONObject, "discount_num"))) {
            poiItemDetail.setDiscountInfo(false);
        } else {
            poiItemDetail.setDiscountInfo(true);
        }
        if (C0488m.m4076g(C0488m.m4055b(jSONObject, "indoor_map"))) {
            poiItemDetail.setIndoorMap(false);
        } else {
            poiItemDetail.setIndoorMap(true);
        }
        return poiItemDetail;
    }

    /* renamed from: e */
    public static ArrayList<BusStationItem> m4071e(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("busstops");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return null;
        }
        ArrayList<BusStationItem> arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(C0488m.m4073f(optJSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    /* renamed from: f */
    public static BusStationItem m4073f(JSONObject jSONObject) throws JSONException {
        BusStationItem g = C0488m.m4075g(jSONObject);
        g.setAdCode(C0488m.m4055b(jSONObject, "adcode"));
        g.setCityCode(C0488m.m4055b(jSONObject, "citycode"));
        JSONArray jSONArray = jSONObject.getJSONArray("buslines");
        List arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(C0488m.m4077h(jSONArray.getJSONObject(i)));
        }
        g.setBusLineItems(arrayList);
        return g;
    }

    /* renamed from: g */
    public static BusStationItem m4075g(JSONObject jSONObject) throws JSONException {
        BusStationItem busStationItem = new BusStationItem();
        busStationItem.setBusStationId(C0488m.m4055b(jSONObject, "id"));
        busStationItem.setLatLonPoint(C0488m.m4060c(jSONObject, LocationManagerProxy.KEY_LOCATION_CHANGED));
        busStationItem.setBusStationName(C0488m.m4055b(jSONObject, C0110c.f289e));
        return busStationItem;
    }

    /* renamed from: h */
    public static BusLineItem m4077h(JSONObject jSONObject) throws JSONException {
        BusLineItem busLineItem = new BusLineItem();
        busLineItem.setBusLineId(C0488m.m4055b(jSONObject, "id"));
        busLineItem.setBusLineType(C0488m.m4055b(jSONObject, C1248a.f5654a));
        busLineItem.setBusLineName(C0488m.m4055b(jSONObject, C0110c.f289e));
        busLineItem.setDirectionsCoordinates(C0488m.m4068d(jSONObject, "polyline"));
        busLineItem.setCityCode(C0488m.m4055b(jSONObject, "citycode"));
        busLineItem.setOriginatingStation(C0488m.m4055b(jSONObject, "start_stop"));
        busLineItem.setTerminalStation(C0488m.m4055b(jSONObject, "end_stop"));
        return busLineItem;
    }

    /* renamed from: i */
    public static ArrayList<BusLineItem> m4080i(JSONObject jSONObject) throws JSONException {
        ArrayList<BusLineItem> arrayList = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONArray("buslines");
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(C0488m.m4082j(jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    /* renamed from: j */
    public static BusLineItem m4082j(JSONObject jSONObject) throws JSONException {
        BusLineItem h = C0488m.m4077h(jSONObject);
        h.setFirstBusTime(C0480e.m4027d(C0488m.m4055b(jSONObject, "start_time")));
        h.setLastBusTime(C0480e.m4027d(C0488m.m4055b(jSONObject, "end_time")));
        h.setBusCompany(C0488m.m4055b(jSONObject, "company"));
        h.setDistance(C0488m.m4081j(C0488m.m4055b(jSONObject, "distance")));
        h.setBasicPrice(C0488m.m4081j(C0488m.m4055b(jSONObject, "basic_price")));
        h.setTotalPrice(C0488m.m4081j(C0488m.m4055b(jSONObject, "total_price")));
        h.setBounds(C0488m.m4068d(jSONObject, "bounds"));
        JSONArray jSONArray = jSONObject.getJSONArray("busstops");
        List arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(C0488m.m4075g(jSONArray.getJSONObject(i)));
        }
        h.setBusStations(arrayList);
        return h;
    }

    /* renamed from: a */
    public static Scenic m4041a(PoiItemDetail poiItemDetail, JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Scenic scenic = new Scenic();
        scenic.setIntro(C0488m.m4055b(jSONObject, "intro"));
        scenic.setRating(C0488m.m4055b(jSONObject, "rating"));
        scenic.setDeepsrc(C0488m.m4055b(jSONObject, "deepsrc"));
        scenic.setLevel(C0488m.m4055b(jSONObject, "level"));
        scenic.setPrice(C0488m.m4055b(jSONObject, "price"));
        scenic.setSeason(C0488m.m4055b(jSONObject, "season"));
        scenic.setRecommend(C0488m.m4055b(jSONObject, "recommend"));
        scenic.setTheme(C0488m.m4055b(jSONObject, "theme"));
        scenic.setOrderWapUrl(C0488m.m4055b(jSONObject, "ordering_wap_url"));
        scenic.setOrderWebUrl(C0488m.m4055b(jSONObject, "ordering_web_url"));
        scenic.setOpentimeGDF(C0488m.m4055b(jSONObject, "opentime_GDF"));
        scenic.setOpentime(C0488m.m4055b(jSONObject, "opentime"));
        scenic.setPhotos(C0488m.m4085l(jSONObject));
        poiItemDetail.setDeepType(DeepType.SCENIC);
        poiItemDetail.setScenic(scenic);
        return scenic;
    }

    /* renamed from: b */
    public static void m4058b(PoiItemDetail poiItemDetail, JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Cinema cinema = new Cinema();
        cinema.setIntro(C0488m.m4055b(jSONObject, "intro"));
        cinema.setRating(C0488m.m4055b(jSONObject, "rating"));
        cinema.setDeepsrc(C0488m.m4055b(jSONObject, "deepsrc"));
        cinema.setParking(C0488m.m4055b(jSONObject, "parking"));
        cinema.setOpentimeGDF(C0488m.m4055b(jSONObject, "opentime_GDF"));
        cinema.setOpentime(C0488m.m4055b(jSONObject, "opentime"));
        cinema.setPhotos(C0488m.m4085l(jSONObject));
        if (C0488m.m4084k(jSONObject2)) {
            cinema.setSeatOrdering(C0488m.m4053a(jSONObject2, "seat_ordering"));
        }
        poiItemDetail.setDeepType(DeepType.CINEMA);
        poiItemDetail.setCinema(cinema);
    }

    /* renamed from: c */
    public static void m4064c(PoiItemDetail poiItemDetail, JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Hotel hotel = new Hotel();
        hotel.setStar(C0488m.m4055b(jSONObject, "star"));
        hotel.setIntro(C0488m.m4055b(jSONObject, "intro"));
        hotel.setRating(C0488m.m4055b(jSONObject, "rating"));
        hotel.setLowestPrice(C0488m.m4055b(jSONObject, "lowest_price"));
        hotel.setDeepsrc(C0488m.m4055b(jSONObject, "deepsrc"));
        hotel.setFaciRating(C0488m.m4055b(jSONObject, "faci_rating"));
        hotel.setHealthRating(C0488m.m4055b(jSONObject, "health_rating"));
        hotel.setEnvironmentRating(C0488m.m4055b(jSONObject, "environment_rating"));
        hotel.setServiceRating(C0488m.m4055b(jSONObject, "service_rating"));
        hotel.setTraffic(C0488m.m4055b(jSONObject, "traffic"));
        hotel.setAddition(C0488m.m4055b(jSONObject, "addition"));
        hotel.setPhotos(C0488m.m4085l(jSONObject));
        poiItemDetail.setDeepType(DeepType.HOTEL);
        poiItemDetail.setHotel(hotel);
    }

    /* renamed from: d */
    public static void m4069d(PoiItemDetail poiItemDetail, JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Dining dining = new Dining();
        dining.setCuisines(C0488m.m4055b(jSONObject, "cuisines"));
        dining.setTag(C0488m.m4055b(jSONObject, "tag"));
        dining.setIntro(C0488m.m4055b(jSONObject, "intro"));
        dining.setRating(C0488m.m4055b(jSONObject, "rating"));
        dining.setCpRating(C0488m.m4055b(jSONObject, "cp_rating"));
        dining.setDeepsrc(C0488m.m4055b(jSONObject, "deepsrc"));
        dining.setTasteRating(C0488m.m4055b(jSONObject, "taste_rating"));
        dining.setEnvironmentRating(C0488m.m4055b(jSONObject, "environment_rating"));
        dining.setServiceRating(C0488m.m4055b(jSONObject, "service_rating"));
        dining.setCost(C0488m.m4055b(jSONObject, "cost"));
        dining.setRecommend(C0488m.m4055b(jSONObject, "recommend"));
        dining.setAtmosphere(C0488m.m4055b(jSONObject, "atmosphere"));
        dining.setOrderingWapUrl(C0488m.m4055b(jSONObject, "ordering_wap_url"));
        dining.setOrderingWebUrl(C0488m.m4055b(jSONObject, "ordering_web_url"));
        dining.setOrderinAppUrl(C0488m.m4055b(jSONObject, "ordering_app_url"));
        dining.setOpentimeGDF(C0488m.m4055b(jSONObject, "opentime_GDF"));
        dining.setOpentime(C0488m.m4055b(jSONObject, "opentime"));
        dining.setAddition(C0488m.m4055b(jSONObject, "addition"));
        dining.setPhotos(C0488m.m4085l(jSONObject));
        if (C0488m.m4084k(jSONObject2)) {
            dining.setMealOrdering(C0488m.m4053a(jSONObject2, "meal_ordering"));
        }
        poiItemDetail.setDeepType(DeepType.DINING);
        poiItemDetail.setDining(dining);
    }

    /* renamed from: e */
    public static void m4072e(PoiItemDetail poiItemDetail, JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject != null) {
            String b = C0488m.m4055b(jSONObject, C1248a.f5654a);
            if (b.equalsIgnoreCase("hotel")) {
                C0488m.m4064c(poiItemDetail, jSONObject, jSONObject2);
            }
            if (b.equalsIgnoreCase("dining")) {
                C0488m.m4069d(poiItemDetail, jSONObject, jSONObject2);
            }
            if (b.equalsIgnoreCase("cinema")) {
                C0488m.m4058b(poiItemDetail, jSONObject, jSONObject2);
            }
            if (b.equalsIgnoreCase("scenic")) {
                C0488m.m4041a(poiItemDetail, jSONObject, jSONObject2);
            }
        }
    }

    /* renamed from: a */
    public static boolean m4053a(JSONObject jSONObject, String str) throws JSONException {
        return C0488m.m4052a(C0488m.m4055b(jSONObject.optJSONObject("biz_ext"), str));
    }

    /* renamed from: a */
    public static boolean m4052a(String str) {
        try {
            if (str.equals(bi_常量类.f6358b_空串)) {
                return false;
            }
            int parseInt = Integer.parseInt(str);
            if (parseInt != 0 && parseInt == 1) {
                return true;
            }
            return false;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* renamed from: k */
    public static boolean m4084k(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("biz_ext")) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static void m4046a(PoiItemDetail poiItemDetail, JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            if (poiItemDetail.isGroupbuyInfo()) {
                C0488m.m4057b(poiItemDetail, jSONObject);
            }
            if (poiItemDetail.isDiscountInfo()) {
                C0488m.m4063c(poiItemDetail, jSONObject);
            }
        }
    }

    /* renamed from: b */
    public static void m4057b(PoiItemDetail poiItemDetail, JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("groupbuys")) {
            JSONArray jSONArray = jSONObject.getJSONArray("groupbuys");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                Groupbuy groupbuy = new Groupbuy();
                groupbuy.setTypeCode(C0488m.m4055b(jSONObject2, "typecode"));
                groupbuy.setTypeDes(C0488m.m4055b(jSONObject2, C1248a.f5654a));
                groupbuy.setDetail(C0488m.m4055b(jSONObject2, "detail"));
                groupbuy.setStartTime(C0480e.m4026c(C0488m.m4055b(jSONObject2, "start_time")));
                groupbuy.setEndTime(C0480e.m4026c(C0488m.m4055b(jSONObject2, "end_time")));
                groupbuy.setCount(C0488m.m4079i(C0488m.m4055b(jSONObject2, "num")));
                groupbuy.setSoldCount(C0488m.m4079i(C0488m.m4055b(jSONObject2, "sold_num")));
                groupbuy.setOriginalPrice(C0488m.m4081j(C0488m.m4055b(jSONObject2, "original_price")));
                groupbuy.setGroupbuyPrice(C0488m.m4081j(C0488m.m4055b(jSONObject2, "groupbuy_price")));
                groupbuy.setDiscount(C0488m.m4081j(C0488m.m4055b(jSONObject2, "discount")));
                groupbuy.setTicketAddress(C0488m.m4055b(jSONObject2, "ticket_address"));
                groupbuy.setTicketTel(C0488m.m4055b(jSONObject2, "ticket_tel"));
                groupbuy.setUrl(C0488m.m4055b(jSONObject2, "url"));
                groupbuy.setProvider(C0488m.m4055b(jSONObject2, "provider"));
                C0488m.m4045a(groupbuy, jSONObject2);
                poiItemDetail.addGroupbuy(groupbuy);
            }
        }
    }

    /* renamed from: a */
    public static void m4045a(Groupbuy groupbuy, JSONObject jSONObject) throws JSONException {
        groupbuy.initPhotos(C0488m.m4085l(jSONObject));
    }

    /* renamed from: c */
    public static void m4063c(PoiItemDetail poiItemDetail, JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("discounts")) {
            JSONArray jSONArray = jSONObject.getJSONArray("discounts");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                Discount discount = new Discount();
                discount.setTitle(C0488m.m4055b(jSONObject2, "title"));
                discount.setDetail(C0488m.m4055b(jSONObject2, "detail"));
                discount.setStartTime(C0480e.m4026c(C0488m.m4055b(jSONObject2, "start_time")));
                discount.setEndTime(C0480e.m4026c(C0488m.m4055b(jSONObject2, "end_time")));
                discount.setSoldCount(C0488m.m4079i(C0488m.m4055b(jSONObject2, "sold_num")));
                discount.setUrl(C0488m.m4055b(jSONObject2, "url"));
                discount.setProvider(C0488m.m4055b(jSONObject2, "provider"));
                C0488m.m4044a(discount, jSONObject2);
                poiItemDetail.addDiscount(discount);
            }
        }
    }

    /* renamed from: a */
    public static void m4044a(Discount discount, JSONObject jSONObject) {
        discount.initPhotos(C0488m.m4085l(jSONObject));
    }

    /* renamed from: l */
    public static List<Photo> m4085l(JSONObject jSONObject) {
        List arrayList = new ArrayList();
        if (jSONObject != null && jSONObject.has("photos")) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("photos");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    Photo photo = new Photo();
                    photo.setTitle(C0488m.m4055b(optJSONObject, "title"));
                    photo.setUrl(C0488m.m4055b(optJSONObject, "url"));
                    arrayList.add(photo);
                }
            } catch (Exception e) {
            }
        }
        return arrayList;
    }

    /* renamed from: m */
    public static DistrictItem m4087m(JSONObject jSONObject) throws JSONException {
        DistrictItem districtItem = new DistrictItem();
        districtItem.setCitycode(C0488m.m4055b(jSONObject, "citycode"));
        districtItem.setAdcode(C0488m.m4055b(jSONObject, "adcode"));
        districtItem.setName(C0488m.m4055b(jSONObject, C0110c.f289e));
        districtItem.setLevel(C0488m.m4055b(jSONObject, "level"));
        districtItem.setCenter(C0488m.m4060c(jSONObject, "center"));
        C0488m.m4050a(jSONObject.optJSONArray("districts"), new ArrayList(), districtItem);
        return districtItem;
    }

    /* renamed from: a */
    public static void m4050a(JSONArray jSONArray, ArrayList<DistrictItem> arrayList, DistrictItem districtItem) throws JSONException {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(C0488m.m4087m(jSONArray.getJSONObject(i)));
            }
            if (districtItem != null) {
                districtItem.setSubDistrict(arrayList);
            }
        }
    }

    /* renamed from: n */
    public static ArrayList<GeocodeAddress> m4088n(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("geocodes");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return null;
        }
        ArrayList<GeocodeAddress> arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
            GeocodeAddress geocodeAddress = new GeocodeAddress();
            geocodeAddress.setFormatAddress(C0488m.m4055b(jSONObject2, "formatted_address"));
            geocodeAddress.setProvince(C0488m.m4055b(jSONObject2, DistrictSearchQuery.KEYWORDS_PROVINCE));
            geocodeAddress.setCity(C0488m.m4055b(jSONObject2, DistrictSearchQuery.KEYWORDS_CITY));
            geocodeAddress.setDistrict(C0488m.m4055b(jSONObject2, DistrictSearchQuery.KEYWORDS_DISTRICT));
            geocodeAddress.setTownship(C0488m.m4055b(jSONObject2, "township"));
            geocodeAddress.setNeighborhood(C0488m.m4055b(jSONObject2.getJSONObject("neighborhood"), C0110c.f289e));
            geocodeAddress.setBuilding(C0488m.m4055b(jSONObject2.getJSONObject("building"), C0110c.f289e));
            geocodeAddress.setAdcode(C0488m.m4055b(jSONObject2, "adcode"));
            geocodeAddress.setLatLonPoint(C0488m.m4060c(jSONObject2, LocationManagerProxy.KEY_LOCATION_CHANGED));
            geocodeAddress.setLevel(C0488m.m4055b(jSONObject2, "level"));
            arrayList.add(geocodeAddress);
        }
        return arrayList;
    }

    /* renamed from: o */
    public static ArrayList<Tip> m4089o(JSONObject jSONObject) throws JSONException {
        ArrayList<Tip> arrayList = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONArray("tips");
        for (int i = 0; i < jSONArray.length(); i++) {
            Tip tip = new Tip();
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            tip.setName(C0488m.m4055b(jSONObject2, C0110c.f289e));
            tip.setDistrict(C0488m.m4055b(jSONObject2, DistrictSearchQuery.KEYWORDS_DISTRICT));
            tip.setAdcode(C0488m.m4055b(jSONObject2, "adcode"));
            arrayList.add(tip);
        }
        return arrayList;
    }

    /* renamed from: a */
    public static void m4049a(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        List arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Crossroad crossroad = new Crossroad();
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            crossroad.setId(C0488m.m4055b(jSONObject, "id"));
            crossroad.setDirection(C0488m.m4055b(jSONObject, "direction"));
            crossroad.setDistance(C0488m.m4081j(C0488m.m4055b(jSONObject, "distance")));
            crossroad.setCenterPoint(C0488m.m4060c(jSONObject, LocationManagerProxy.KEY_LOCATION_CHANGED));
            crossroad.setFirstRoadId(C0488m.m4055b(jSONObject, "first_id"));
            crossroad.setFirstRoadName(C0488m.m4055b(jSONObject, "first_name"));
            crossroad.setSecondRoadId(C0488m.m4055b(jSONObject, "second_id"));
            crossroad.setSecondRoadName(C0488m.m4055b(jSONObject, "second_name"));
            arrayList.add(crossroad);
        }
        regeocodeAddress.setCrossroads(arrayList);
    }

    /* renamed from: b */
    public static void m4059b(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        List arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            RegeocodeRoad regeocodeRoad = new RegeocodeRoad();
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            regeocodeRoad.setId(C0488m.m4055b(jSONObject, "id"));
            regeocodeRoad.setName(C0488m.m4055b(jSONObject, C0110c.f289e));
            regeocodeRoad.setLatLngPoint(C0488m.m4060c(jSONObject, LocationManagerProxy.KEY_LOCATION_CHANGED));
            regeocodeRoad.setDirection(C0488m.m4055b(jSONObject, "direction"));
            regeocodeRoad.setDistance(C0488m.m4081j(C0488m.m4055b(jSONObject, "distance")));
            arrayList.add(regeocodeRoad);
        }
        regeocodeAddress.setRoads(arrayList);
    }

    /* renamed from: c */
    public static void m4065c(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        List arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            PoiItem poiItem = new PoiItem(C0488m.m4055b(jSONObject, "id"), C0488m.m4060c(jSONObject, LocationManagerProxy.KEY_LOCATION_CHANGED), C0488m.m4055b(jSONObject, C0110c.f289e), bi_常量类.f6358b_空串);
            poiItem.setDirection(C0488m.m4055b(jSONObject, "direction"));
            poiItem.setDistance(C0488m.m4079i(C0488m.m4055b(jSONObject, "distance")));
            poiItem.setTel(C0488m.m4055b(jSONObject, "tel"));
            poiItem.setTypeDes(C0488m.m4055b(jSONObject, C1248a.f5654a));
            arrayList.add(poiItem);
        }
        regeocodeAddress.setPois(arrayList);
    }

    /* renamed from: a */
    public static void m4051a(JSONObject jSONObject, RegeocodeAddress regeocodeAddress) throws JSONException {
        regeocodeAddress.setProvince(C0488m.m4055b(jSONObject, DistrictSearchQuery.KEYWORDS_PROVINCE));
        regeocodeAddress.setCity(C0488m.m4055b(jSONObject, DistrictSearchQuery.KEYWORDS_CITY));
        regeocodeAddress.setCityCode(C0488m.m4055b(jSONObject, "citycode"));
        regeocodeAddress.setAdCode(C0488m.m4055b(jSONObject, "adcode"));
        regeocodeAddress.setDistrict(C0488m.m4055b(jSONObject, DistrictSearchQuery.KEYWORDS_DISTRICT));
        regeocodeAddress.setTownship(C0488m.m4055b(jSONObject, "township"));
        regeocodeAddress.setNeighborhood(C0488m.m4055b(jSONObject.getJSONObject("neighborhood"), C0110c.f289e));
        regeocodeAddress.setBuilding(C0488m.m4055b(jSONObject.getJSONObject("building"), C0110c.f289e));
        StreetNumber streetNumber = new StreetNumber();
        JSONObject jSONObject2 = jSONObject.getJSONObject("streetNumber");
        streetNumber.setStreet(C0488m.m4055b(jSONObject2, "street"));
        streetNumber.setNumber(C0488m.m4055b(jSONObject2, "number"));
        streetNumber.setLatLonPoint(C0488m.m4060c(jSONObject2, LocationManagerProxy.KEY_LOCATION_CHANGED));
        streetNumber.setDirection(C0488m.m4055b(jSONObject2, "direction"));
        streetNumber.setDistance(C0488m.m4081j(C0488m.m4055b(jSONObject2, "distance")));
        regeocodeAddress.setStreetNumber(streetNumber);
    }

    /* renamed from: b */
    public static BusRouteResult m4054b(String str) throws AMapException {
        BusRouteResult busRouteResult = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("route")) {
                busRouteResult = new BusRouteResult();
                jSONObject = jSONObject.getJSONObject("route");
                busRouteResult.setStartPos(C0488m.m4060c(jSONObject, "origin"));
                busRouteResult.setTargetPos(C0488m.m4060c(jSONObject, "destination"));
                busRouteResult.setTaxiCost(C0488m.m4081j(C0488m.m4055b(jSONObject, "taxi_cost")));
                if (jSONObject.has("transits")) {
                    busRouteResult.setPaths(C0488m.m4043a(jSONObject.getJSONArray("transits")));
                }
            }
            return busRouteResult;
        } catch (JSONException e) {
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* renamed from: a */
    public static List<BusPath> m4043a(JSONArray jSONArray) throws JSONException {
        List<BusPath> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            BusPath busPath = new BusPath();
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            busPath.setCost(C0488m.m4081j(C0488m.m4055b(jSONObject, "cost")));
            busPath.setDuration(C0488m.m4083k(C0488m.m4055b(jSONObject, "duration")));
            busPath.setNightBus(C0488m.m4086l(C0488m.m4055b(jSONObject, "nightflag")));
            busPath.setWalkDistance(C0488m.m4081j(C0488m.m4055b(jSONObject, "walking_distance")));
            if (jSONObject.has("segments")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("segments");
                List arrayList2 = new ArrayList();
                float f = 0.0f;
                float f2 = 0.0f;
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    BusStep p = C0488m.m4090p(jSONArray2.getJSONObject(i2));
                    arrayList2.add(p);
                    if (p.getWalk() != null) {
                        f += p.getWalk().getDistance();
                    }
                    if (p.getBusLine() != null) {
                        f2 += p.getBusLine().getDistance();
                    }
                }
                busPath.setSteps(arrayList2);
                busPath.setBusDistance(f2);
                busPath.setWalkDistance(f);
            }
            arrayList.add(busPath);
        }
        return arrayList;
    }

    /* renamed from: p */
    public static BusStep m4090p(JSONObject jSONObject) throws JSONException {
        BusStep busStep = new BusStep();
        if (jSONObject.has("walking")) {
            try {
                busStep.setWalk(C0488m.m4091q(jSONObject.getJSONObject("walking")));
            } catch (JSONException e) {
            }
        }
        if (jSONObject.has("bus")) {
            busStep.setBusLines(C0488m.m4092r(jSONObject.getJSONObject("bus")));
        }
        if (jSONObject.has("entrance")) {
            try {
                busStep.setEntrance(C0488m.m4093s(jSONObject.getJSONObject("entrance")));
            } catch (Exception e2) {
            }
        }
        if (jSONObject.has("exit")) {
            try {
                busStep.setExit(C0488m.m4093s(jSONObject.getJSONObject("exit")));
            } catch (JSONException e3) {
            }
        }
        return busStep;
    }

    /* renamed from: q */
    public static RouteBusWalkItem m4091q(JSONObject jSONObject) throws JSONException {
        RouteBusWalkItem routeBusWalkItem = new RouteBusWalkItem();
        routeBusWalkItem.setOrigin(C0488m.m4060c(jSONObject, "origin"));
        routeBusWalkItem.setDestination(C0488m.m4060c(jSONObject, "destination"));
        routeBusWalkItem.setDistance(C0488m.m4081j(C0488m.m4055b(jSONObject, "distance")));
        routeBusWalkItem.setDuration(C0488m.m4083k(C0488m.m4055b(jSONObject, "duration")));
        if (!jSONObject.has("steps")) {
            return routeBusWalkItem;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("steps");
        List arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(C0488m.m4094t(jSONArray.getJSONObject(i)));
        }
        routeBusWalkItem.setSteps(arrayList);
        return routeBusWalkItem;
    }

    /* renamed from: r */
    public static List<RouteBusLineItem> m4092r(JSONObject jSONObject) throws JSONException {
        List<RouteBusLineItem> arrayList = new ArrayList();
        if (!jSONObject.has("buslines")) {
            return arrayList;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("buslines");
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(C0488m.m4095u(jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    /* renamed from: s */
    public static Doorway m4093s(JSONObject jSONObject) throws JSONException {
        Doorway doorway = new Doorway();
        doorway.setName(C0488m.m4055b(jSONObject, C0110c.f289e));
        doorway.setLatLonPoint(C0488m.m4060c(jSONObject, LocationManagerProxy.KEY_LOCATION_CHANGED));
        return doorway;
    }

    /* renamed from: t */
    public static WalkStep m4094t(JSONObject jSONObject) throws JSONException {
        WalkStep walkStep = new WalkStep();
        walkStep.setInstruction(C0488m.m4055b(jSONObject, "instruction"));
        walkStep.setOrientation(C0488m.m4055b(jSONObject, "orientation"));
        walkStep.setRoad(C0488m.m4055b(jSONObject, "road"));
        walkStep.setDistance(C0488m.m4081j(C0488m.m4055b(jSONObject, "distance")));
        walkStep.setDuration(C0488m.m4081j(C0488m.m4055b(jSONObject, "duration")));
        walkStep.setPolyline(C0488m.m4068d(jSONObject, "polyline"));
        walkStep.setAction(C0488m.m4055b(jSONObject, "action"));
        walkStep.setAssistantAction(C0488m.m4055b(jSONObject, "assistant_action"));
        return walkStep;
    }

    /* renamed from: u */
    public static RouteBusLineItem m4095u(JSONObject jSONObject) throws JSONException {
        RouteBusLineItem routeBusLineItem = new RouteBusLineItem();
        if (jSONObject.has("departure_stop")) {
            routeBusLineItem.setDepartureBusStation(C0488m.m4097w(jSONObject.getJSONObject("departure_stop")));
        }
        if (jSONObject.has("arrival_stop")) {
            routeBusLineItem.setArrivalBusStation(C0488m.m4097w(jSONObject.getJSONObject("arrival_stop")));
        }
        routeBusLineItem.setBusLineName(C0488m.m4055b(jSONObject, C0110c.f289e));
        routeBusLineItem.setBusLineId(C0488m.m4055b(jSONObject, "id"));
        routeBusLineItem.setBusLineType(C0488m.m4055b(jSONObject, C1248a.f5654a));
        routeBusLineItem.setDistance(C0488m.m4081j(C0488m.m4055b(jSONObject, "distance")));
        routeBusLineItem.setDuration(C0488m.m4081j(C0488m.m4055b(jSONObject, "duration")));
        routeBusLineItem.setPolyline(C0488m.m4068d(jSONObject, "polyline"));
        routeBusLineItem.setFirstBusTime(C0480e.m4027d(C0488m.m4055b(jSONObject, "start_time")));
        routeBusLineItem.setLastBusTime(C0480e.m4027d(C0488m.m4055b(jSONObject, "end_time")));
        routeBusLineItem.setPassStationNum(C0488m.m4079i(C0488m.m4055b(jSONObject, "via_num")));
        routeBusLineItem.setPassStations(C0488m.m4096v(jSONObject));
        return routeBusLineItem;
    }

    /* renamed from: v */
    public static List<BusStationItem> m4096v(JSONObject jSONObject) throws JSONException {
        List<BusStationItem> arrayList = new ArrayList();
        if (!jSONObject.has("via_stops")) {
            return arrayList;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("via_stops");
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(C0488m.m4097w(jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    /* renamed from: w */
    public static BusStationItem m4097w(JSONObject jSONObject) throws JSONException {
        BusStationItem busStationItem = new BusStationItem();
        busStationItem.setBusStationName(C0488m.m4055b(jSONObject, C0110c.f289e));
        busStationItem.setBusStationId(C0488m.m4055b(jSONObject, "id"));
        busStationItem.setLatLonPoint(C0488m.m4060c(jSONObject, LocationManagerProxy.KEY_LOCATION_CHANGED));
        return busStationItem;
    }

    /* renamed from: c */
    public static DriveRouteResult m4061c(String str) throws AMapException {
        DriveRouteResult driveRouteResult = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("route")) {
                driveRouteResult = new DriveRouteResult();
                jSONObject = jSONObject.getJSONObject("route");
                driveRouteResult.setStartPos(C0488m.m4060c(jSONObject, "origin"));
                driveRouteResult.setTargetPos(C0488m.m4060c(jSONObject, "destination"));
                if (jSONObject.has("paths")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("paths");
                    List arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        DrivePath drivePath = new DrivePath();
                        jSONObject = jSONArray.getJSONObject(i);
                        drivePath.setDistance(C0488m.m4081j(C0488m.m4055b(jSONObject, "distance")));
                        drivePath.setDuration(C0488m.m4083k(C0488m.m4055b(jSONObject, "duration")));
                        drivePath.setStrategy(C0488m.m4055b(jSONObject, "strategy"));
                        drivePath.setTolls(C0488m.m4081j(C0488m.m4055b(jSONObject, "tolls")));
                        drivePath.setTollDistance(C0488m.m4081j(C0488m.m4055b(jSONObject, "toll_distance")));
                        if (jSONObject.has("steps")) {
                            JSONArray jSONArray2 = jSONObject.getJSONArray("steps");
                            List arrayList2 = new ArrayList();
                            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                                DriveStep driveStep = new DriveStep();
                                JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                                driveStep.setInstruction(C0488m.m4055b(jSONObject2, "instruction"));
                                driveStep.setOrientation(C0488m.m4055b(jSONObject2, "orientation"));
                                driveStep.setRoad(C0488m.m4055b(jSONObject2, "road"));
                                driveStep.setDistance(C0488m.m4081j(C0488m.m4055b(jSONObject2, "distance")));
                                driveStep.setTolls(C0488m.m4081j(C0488m.m4055b(jSONObject2, "tolls")));
                                driveStep.setTollDistance(C0488m.m4081j(C0488m.m4055b(jSONObject2, "toll_distance")));
                                driveStep.setTollRoad(C0488m.m4055b(jSONObject2, "toll_road"));
                                driveStep.setDuration(C0488m.m4081j(C0488m.m4055b(jSONObject2, "duration")));
                                driveStep.setPolyline(C0488m.m4068d(jSONObject2, "polyline"));
                                driveStep.setAction(C0488m.m4055b(jSONObject2, "action"));
                                driveStep.setAssistantAction(C0488m.m4055b(jSONObject2, "assistant_action"));
                                C0488m.m4047a(driveStep, jSONObject2);
                                arrayList2.add(driveStep);
                            }
                            drivePath.setSteps(arrayList2);
                        }
                        arrayList.add(drivePath);
                    }
                    driveRouteResult.setPaths(arrayList);
                }
            }
            return driveRouteResult;
        } catch (JSONException e) {
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* renamed from: a */
    public static void m4047a(DriveStep driveStep, JSONObject jSONObject) {
        if (jSONObject.has("cities")) {
            try {
                List arrayList = new ArrayList();
                JSONArray jSONArray = jSONObject.getJSONArray("cities");
                for (int i = 0; i < jSONArray.length(); i++) {
                    RouteSearchCity routeSearchCity = new RouteSearchCity();
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    routeSearchCity.setSearchCityName(C0488m.m4055b(jSONObject2, C0110c.f289e));
                    routeSearchCity.setSearchCitycode(C0488m.m4055b(jSONObject2, "citycode"));
                    routeSearchCity.setSearchCityhAdCode(C0488m.m4055b(jSONObject2, "adcode"));
                    C0488m.m4048a(routeSearchCity, jSONObject2);
                    arrayList.add(routeSearchCity);
                }
                driveStep.setRouteSearchCityList(arrayList);
            } catch (JSONException e) {
            }
        }
    }

    /* renamed from: a */
    public static void m4048a(RouteSearchCity routeSearchCity, JSONObject jSONObject) {
        if (jSONObject.has("districts")) {
            try {
                List arrayList = new ArrayList();
                JSONArray jSONArray = jSONObject.getJSONArray("districts");
                for (int i = 0; i < jSONArray.length(); i++) {
                    District district = new District();
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    district.setDistrictName(C0488m.m4055b(jSONObject2, C0110c.f289e));
                    district.setDistrictAdcode(C0488m.m4055b(jSONObject2, "adcode"));
                    arrayList.add(district);
                }
                routeSearchCity.setDistricts(arrayList);
            } catch (JSONException e) {
            }
        }
    }

    /* renamed from: d */
    public static WalkRouteResult m4067d(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            WalkRouteResult walkRouteResult = new WalkRouteResult();
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("route");
                walkRouteResult.setStartPos(C0488m.m4060c(jSONObject2, "origin"));
                walkRouteResult.setTargetPos(C0488m.m4060c(jSONObject2, "destination"));
                if (!jSONObject2.has("paths")) {
                    return walkRouteResult;
                }
                JSONArray jSONArray = jSONObject2.getJSONArray("paths");
                List arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    WalkPath walkPath = new WalkPath();
                    jSONObject2 = jSONArray.getJSONObject(i);
                    walkPath.setDistance(C0488m.m4081j(C0488m.m4055b(jSONObject2, "distance")));
                    walkPath.setDuration(C0488m.m4083k(C0488m.m4055b(jSONObject2, "duration")));
                    if (jSONObject2.has("steps")) {
                        JSONArray jSONArray2 = jSONObject2.getJSONArray("steps");
                        List arrayList2 = new ArrayList();
                        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                            WalkStep walkStep = new WalkStep();
                            JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                            walkStep.setInstruction(C0488m.m4055b(jSONObject3, "instruction"));
                            walkStep.setOrientation(C0488m.m4055b(jSONObject3, "orientation"));
                            walkStep.setRoad(C0488m.m4055b(jSONObject3, "road"));
                            walkStep.setDistance(C0488m.m4081j(C0488m.m4055b(jSONObject3, "distance")));
                            walkStep.setDuration(C0488m.m4081j(C0488m.m4055b(jSONObject3, "duration")));
                            walkStep.setPolyline(C0488m.m4068d(jSONObject3, "polyline"));
                            walkStep.setAction(C0488m.m4055b(jSONObject3, "action"));
                            walkStep.setAssistantAction(C0488m.m4055b(jSONObject3, "assistant_action"));
                            arrayList2.add(walkStep);
                        }
                        walkPath.setSteps(arrayList2);
                    }
                    arrayList.add(walkPath);
                }
                walkRouteResult.setPaths(arrayList);
                return walkRouteResult;
            } catch (JSONException e) {
                return walkRouteResult;
            }
        } catch (JSONException e2) {
            return null;
        }
    }

    /* renamed from: b */
    public static String m4055b(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject == null) {
            return bi_常量类.f6358b_空串;
        }
        String str2 = bi_常量类.f6358b_空串;
        if (!jSONObject.has(str) || jSONObject.getString(str).equals("[]")) {
            return str2;
        }
        return jSONObject.optString(str);
    }

    /* renamed from: c */
    public static LatLonPoint m4060c(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str)) {
            return C0488m.m4074f(jSONObject.optString(str));
        }
        return null;
    }

    /* renamed from: d */
    public static ArrayList<LatLonPoint> m4068d(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject.has(str)) {
            return C0488m.m4070e(jSONObject.getString(str));
        }
        return null;
    }

    /* renamed from: e */
    public static ArrayList<LatLonPoint> m4070e(String str) {
        ArrayList<LatLonPoint> arrayList = new ArrayList();
        String[] split = str.split(";");
        for (String f : split) {
            arrayList.add(C0488m.m4074f(f));
        }
        return arrayList;
    }

    /* renamed from: f */
    public static LatLonPoint m4074f(String str) {
        if (str == null || str.equals(bi_常量类.f6358b_空串) || str.equals("[]")) {
            return null;
        }
        String[] split = str.split(",");
        if (split.length != 2) {
            return null;
        }
        return new LatLonPoint(Double.parseDouble(split[1]), Double.parseDouble(split[0]));
    }

    /* renamed from: g */
    public static boolean m4076g(String str) {
        if (str == null || str.equals(bi_常量类.f6358b_空串) || str.equals("0")) {
            return true;
        }
        return false;
    }

    /* renamed from: h */
    public static boolean m4078h(String str) {
        if (str == null || str.equals(bi_常量类.f6358b_空串)) {
            return true;
        }
        return false;
    }

    /* renamed from: i */
    public static int m4079i(String str) {
        int i = 0;
        if (!(str == null || str.equals(bi_常量类.f6358b_空串) || str.equals("[]"))) {
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    /* renamed from: j */
    public static float m4081j(String str) {
        float f = 0.0f;
        if (!(str == null || str.equals(bi_常量类.f6358b_空串) || str.equals("[]"))) {
            try {
                f = Float.parseFloat(str);
            } catch (NumberFormatException e) {
            }
        }
        return f;
    }

    /* renamed from: k */
    public static long m4083k(String str) {
        long j = 0;
        if (!(str == null || str.equals(bi_常量类.f6358b_空串) || str.equals("[]"))) {
            try {
                j = Long.parseLong(str);
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }

    /* renamed from: l */
    public static boolean m4086l(String str) {
        if (str == null || str.equals(bi_常量类.f6358b_空串) || str.equals("[]") || str.equals("0") || !str.equals(C0108a.f262e)) {
            return false;
        }
        return true;
    }
}
