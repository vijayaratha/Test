
import java.io.Serializable;

public class NormaliseATGRaw implements Serializable {
    private String siteCode;
    private String Timestamp;
    private String forecourtCode;
    private String tankCode;
    private String tankCapacity;
    private String rawVolumeL;
    private String atgVolumeL;
    private String atgLevelMM;
    private String waterLevel;
    private String temperature;
    private String productCode;
    private String tankUllage;
    private String sODVolumve;
    private String deliveries;
    private String dispenserSales;
    private String operatingVariance;
    private String status;
    private String backfilled;
    private String s3Timestamp;

    public NormaliseATGRaw(String siteCode, String timestamp,
        String forecourtCode, String tankCode, String tankCapacity,
        String rawVolumeL, String atgVolumeL, String atgLevelMM,
        String waterLevel, String temperature, String productCode,
        String tankUllage, String sODVolumve, String deliveries,
        String dispenserSales, String operatingVariance, String status,
        String backfilled, String s3Timestamp) {

        this.siteCode = siteCode;
        this.Timestamp = timestamp;
        this.forecourtCode = forecourtCode;
        this.tankCode = tankCode;
        this.tankCapacity = tankCapacity;
        this.rawVolumeL = rawVolumeL;
        this.atgVolumeL = atgVolumeL;
        this.atgLevelMM = atgLevelMM;
        this.waterLevel = waterLevel;
        this.temperature = temperature;
        this.productCode = productCode;
        this.tankUllage = tankUllage;
        this.sODVolumve = sODVolumve;
        this.deliveries = deliveries;
        this.dispenserSales = dispenserSales;
        this.operatingVariance = operatingVariance;
        this.status = status;
        this.backfilled = backfilled;
        this.s3Timestamp = s3Timestamp;
    }

    public NormaliseATGRaw(String siteCode, String atgLevelMM) {
        this.siteCode = siteCode;
        this.atgLevelMM = atgLevelMM;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    public String getForecourtCode() {
        return forecourtCode;
    }

    public void setForecourtCode(String forecourtCode) {
        this.forecourtCode = forecourtCode;
    }

    public String getTankCode() {
        return tankCode;
    }

    public void setTankCode(String tankCode) {
        this.tankCode = tankCode;
    }

    public String getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(String tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public String getRawVolumeL() {
        return rawVolumeL;
    }

    public void setRawVolumeL(String rawVolumeL) {
        this.rawVolumeL = rawVolumeL;
    }

    public String getAtgVolumeL() {
        return atgVolumeL;
    }

    public void setAtgVolumeL(String atgVolumeL) {
        this.atgVolumeL = atgVolumeL;
    }

    public String getAtgLevelMM() {
        return atgLevelMM;
    }

    public void setAtgLevelMM(String atgLevelMM) {
        this.atgLevelMM = atgLevelMM;
    }

    public String getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(String waterLevel) {
        this.waterLevel = waterLevel;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getTankUllage() {
        return tankUllage;
    }

    public void setTankUllage(String tankUllage) {
        this.tankUllage = tankUllage;
    }

    public String getsODVolumve() {
        return sODVolumve;
    }

    public void setsODVolumve(String sODVolumve) {
        this.sODVolumve = sODVolumve;
    }

    public String getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(String deliveries) {
        this.deliveries = deliveries;
    }

    public String getDispenserSales() {
        return dispenserSales;
    }

    public void setDispenserSales(String dispenserSales) {
        this.dispenserSales = dispenserSales;
    }

    public String getOperatingVariance() {
        return operatingVariance;
    }

    public void setOperatingVariance(String operatingVariance) {
        this.operatingVariance = operatingVariance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBackfilled() {
        return backfilled;
    }

    public void setBackfilled(String backfilled) {
        this.backfilled = backfilled;
    }

    @Override
    public String toString() {
        return "NormaliseATGRaw [siteCode=" + siteCode + ", Timestamp="
            + Timestamp + ", forecourtCode=" + forecourtCode + ", tankCode="
            + tankCode + ", tankCapacity=" + tankCapacity + ", rawVolumeL="
            + rawVolumeL + ", atgVolumeL=" + atgVolumeL + ", atgLevelMM="
            + atgLevelMM + ", waterLevel=" + waterLevel + ", temperature="
            + temperature + ", productCode=" + productCode + ", tankUllage="
            + tankUllage + ", sODVolumve=" + sODVolumve + ", deliveries="
            + deliveries + ", dispenserSales=" + dispenserSales
            + ", operatingVariance=" + operatingVariance + ", status=" + status
            + ", backfilled=" + backfilled + ", S3-Timestamp=" + s3Timestamp
            + " ]";
    }

    public String[] toArray() {

        String[] array = new String[NormalisedATGEnum.values().length];
        array[NormalisedATGEnum.SITE_CODE.getColumnIndex()] = this.siteCode;
        array[NormalisedATGEnum.TIMESTAMP.getColumnIndex()] = this.Timestamp;
        array[NormalisedATGEnum.FORECOURT_CODE.getColumnIndex()] =
            this.forecourtCode;
        array[NormalisedATGEnum.TANK_CODE.getColumnIndex()] = this.tankCode;
        array[NormalisedATGEnum.CAPACITY.getColumnIndex()] = this.tankCapacity;
        array[NormalisedATGEnum.RAW_VOLUME.getColumnIndex()] = this.rawVolumeL;
        array[NormalisedATGEnum.ATG_VOLUME.getColumnIndex()] = this.atgVolumeL;
        array[NormalisedATGEnum.ATG_LEVEL.getColumnIndex()] = this.atgLevelMM;
        array[NormalisedATGEnum.WATER_LEVEL.getColumnIndex()] = this.waterLevel;
        array[NormalisedATGEnum.TEMPERATURE.getColumnIndex()] =
            this.temperature;
        array[NormalisedATGEnum.PRODUCT_CODE.getColumnIndex()] =
            this.productCode;
        array[NormalisedATGEnum.TANK_ULLAGE.getColumnIndex()] = this.tankUllage;
        array[NormalisedATGEnum.SOD_VOLUME.getColumnIndex()] = this.sODVolumve;
        array[NormalisedATGEnum.DELIVERIES.getColumnIndex()] = this.deliveries;
        array[NormalisedATGEnum.DISPENSER_SALES.getColumnIndex()] =
            this.dispenserSales;
        array[NormalisedATGEnum.OPERATING_VARIANCE.getColumnIndex()] =
            this.operatingVariance;
        array[NormalisedATGEnum.STATUS.getColumnIndex()] = this.status;
        array[NormalisedATGEnum.BACK_FILLED.getColumnIndex()] = this.backfilled;
        array[NormalisedATGEnum.S3_TIMESTAMP.getColumnIndex()] =
            this.s3Timestamp;
        return array;

    }

    public String getS3Timestamp() {
        return s3Timestamp;
    }

    public void setS3Timestamp(String s3Timestamp) {
        this.s3Timestamp = s3Timestamp;

    }

}
