
import java.io.Serializable;

public class NormaliseTXNRaw implements Serializable {
    private String siteCode;
    private String transactionId;
    private String trasactionStartDate;
    private String trasactionEndDate;
    private String dispenserCode;
    private String hoseCode;
    private String gradeCode;
    private String value;
    private String volume;
    private String unitPrice;
    private String attendantCode;
    private String authTime;
    private String payTime;
    private String tankCode;
    private String tankStartVol;
    private String tankEndVol;
    private String tankInUse;
    private String startMeterVolume;
    private String startMeterAmount;
    private String endMeterVolume;
    private String endMeterAmount;
    private String backfilled;
    private String s3Timestamp;

    public NormaliseTXNRaw(String siteCode, String transactionId,
        String trasactionStartDate, String trasactionEndDate,
        String dispenserCode, String hoseCode, String gradeCode, String value,
        String volume, String unitPrice, String attendantCode, String authTime,
        String payTime, String tankCode, String tankStartVol, String tankEndVol,
        String tankInUse, String startMeterVolume, String startMeterAmount,
        String endMeterVolume, String endMeterAmount, String backfilled,  String s3Timestamp ) {
        this.siteCode = siteCode;
        this.transactionId = transactionId;
        this.trasactionStartDate = trasactionStartDate;
        this.trasactionEndDate = trasactionEndDate;
        this.dispenserCode = dispenserCode;
        this.hoseCode = hoseCode;
        this.gradeCode = gradeCode;
        this.value = value;
        this.volume = volume;
        this.unitPrice = unitPrice;
        this.attendantCode = attendantCode;
        this.authTime = authTime;
        this.payTime = payTime;
        this.tankCode = tankCode;
        this.tankStartVol = tankStartVol;
        this.tankEndVol = tankEndVol;
        this.tankInUse = tankInUse;
        this.startMeterVolume = startMeterVolume;
        this.startMeterAmount = startMeterAmount;
        this.endMeterVolume = endMeterVolume;
        this.endMeterAmount = endMeterAmount;
        this.backfilled = backfilled;
        this.s3Timestamp=s3Timestamp;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTrasactionStartDate() {
        return trasactionStartDate;
    }

    public void setTrasactionStartDate(String trasactionStartDate) {
        this.trasactionStartDate = trasactionStartDate;
    }

    public String getTrasactionEndDate() {
        return trasactionEndDate;
    }

    public void setTrasactionEndDate(String trasactionEndDate) {
        this.trasactionEndDate = trasactionEndDate;
    }

    public String getDispenserCode() {
        return dispenserCode;
    }

    public void setDispenserCode(String dispenserCode) {
        this.dispenserCode = dispenserCode;
    }

    public String getHoseCode() {
        return hoseCode;
    }

    public void setHoseCode(String hoseCode) {
        this.hoseCode = hoseCode;
    }

    public String getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getAttendantCode() {
        return attendantCode;
    }

    public void setAttendantCode(String attendantCode) {
        this.attendantCode = attendantCode;
    }

    public String getAuthTime() {
        return authTime;
    }

    public void setAuthTime(String authTime) {
        this.authTime = authTime;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getTankCode() {
        return tankCode;
    }

    public void setTankCode(String tankCode) {
        this.tankCode = tankCode;
    }

    public String getTankStartVol() {
        return tankStartVol;
    }

    public void setTankStartVol(String tankStartVol) {
        this.tankStartVol = tankStartVol;
    }

    public String getTankEndVol() {
        return tankEndVol;
    }

    public void setTankEndVol(String tankEndVol) {
        this.tankEndVol = tankEndVol;
    }

    public String getTankInUse() {
        return tankInUse;
    }

    public void setTankInUse(String tankInUse) {
        this.tankInUse = tankInUse;
    }

    public String getStartMeterVolume() {
        return startMeterVolume;
    }

    public void setStartMeterVolume(String startMeterVolume) {
        this.startMeterVolume = startMeterVolume;
    }

    public String getStartMeterAmount() {
        return startMeterAmount;
    }

    public void setStartMeterAmount(String startMeterAmount) {
        this.startMeterAmount = startMeterAmount;
    }

    public String getEndMeterVolume() {
        return endMeterVolume;
    }

    public void setEndMeterVolume(String endMeterVolume) {
        this.endMeterVolume = endMeterVolume;
    }

    public String getEndMeterAmount() {
        return endMeterAmount;
    }

    public void setEndMeterAmount(String endMeterAmount) {
        this.endMeterAmount = endMeterAmount;
    }

    public String getBackfilled() {
        return backfilled;
    }

    public void setBackfilled(String backfilled) {
        this.backfilled = backfilled;
    }

    public String[] toArray() {

        String[] array = new String[NormalisedTXNEnum.values().length];
        array[NormalisedTXNEnum.SITE_CODE.getColumnIndex()] = this.siteCode;
        array[NormalisedTXNEnum.TRANSACTION_ID.getColumnIndex()] =
            this.transactionId;
        array[NormalisedTXNEnum.TRANSACTION_START_DATE.getColumnIndex()] =
            this.trasactionStartDate;
        array[NormalisedTXNEnum.TRANSACTION_END_DATE.getColumnIndex()] =
            this.trasactionEndDate;
        array[NormalisedTXNEnum.DISPENSER_CODE.getColumnIndex()] =
            this.dispenserCode;
        array[NormalisedTXNEnum.HOSE_CODE.getColumnIndex()] = this.hoseCode;
        array[NormalisedTXNEnum.GRADE_CODE.getColumnIndex()] = this.gradeCode;
        array[NormalisedTXNEnum.VALUE.getColumnIndex()] = this.value;
        array[NormalisedTXNEnum.VOLUME.getColumnIndex()] = this.volume;
        array[NormalisedTXNEnum.UNIT_PRICE.getColumnIndex()] = this.unitPrice;
        array[NormalisedTXNEnum.ATTENDANT_CODE.getColumnIndex()] =
            this.attendantCode;
        array[NormalisedTXNEnum.AUTH_TIME.getColumnIndex()] = this.authTime;
        array[NormalisedTXNEnum.PAY_TIME.getColumnIndex()] = this.payTime;
        array[NormalisedTXNEnum.TANK_CODE.getColumnIndex()] = this.tankCode;
        array[NormalisedTXNEnum.TANK_START_VOLUME.getColumnIndex()] =
            this.tankStartVol;
        array[NormalisedTXNEnum.TANK_END_VOLUME.getColumnIndex()] =
            this.tankEndVol;
        array[NormalisedTXNEnum.TANK_IN_USE.getColumnIndex()] = this.tankInUse;
        array[NormalisedTXNEnum.START_METER_VOLUME.getColumnIndex()] =
            this.startMeterVolume;
        array[NormalisedTXNEnum.START_METER_AMOUNT.getColumnIndex()] =
            this.startMeterAmount;
        array[NormalisedTXNEnum.END_METER_VOLUME.getColumnIndex()] =
            this.endMeterVolume;
        array[NormalisedTXNEnum.END_METER_AMOUNT.getColumnIndex()] =
            this.endMeterAmount;
        array[NormalisedTXNEnum.BACK_FILLED.getColumnIndex()] = this.backfilled;
        array[NormalisedTXNEnum.S3_TIMESTAMP.getColumnIndex()] = this.s3Timestamp;
        
        return array;

    }

    public String getS3Timestamp() {
        return s3Timestamp;
    }

    public void setS3Timestamp(String s3Timestamp) {
        this.s3Timestamp = s3Timestamp;
        
    }

}
