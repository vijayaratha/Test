
public enum NormalisedATGEnum {
                               // 001193,2015-07-20T06:21:02,1,2,55000,39076.34,39174.75,1541.2,0,13,15923.66,38887.09,0,333.12,0,,N

                               SITE_CODE("SiteCode", 0),
                               TIMESTAMP("Timestamp", 1),
                               FORECOURT_CODE("ForecourtCode", 2),
                               TANK_CODE("TankCode", 3),
                               CAPACITY("TankCapacity", 4),
                               RAW_VOLUME("RawVolumeL", 5),
                               ATG_VOLUME("AtgVolumeL", 6),
                               ATG_LEVEL("AtgLevelMM", 7),
                               WATER_LEVEL("WaterLevel", 8),
                               TEMPERATURE("Temperature", 9),
                               PRODUCT_CODE("ProductCode", 10),
                               TANK_ULLAGE("TankUllage", 11),
                               SOD_VOLUME("SODVolumve", 12),
                               DELIVERIES("Deliveries", 13),
                               DISPENSER_SALES("DispenserSales", 14),
                               OPERATING_VARIANCE("Operating Variance", 15),
                               STATUS("Status", 16),
                               BACK_FILLED("Back filled", 17),
                               S3_TIMESTAMP("S3 Timestamp", 18);

    private final String name;
    private final Integer columnIndex;

    NormalisedATGEnum(final String name, final Integer columnIndex) {
        this.name = name;
        this.columnIndex = columnIndex;
    }

    public String getName() {
        return name;
    }

    public Integer getColumnIndex() {
        return columnIndex;
    }

    public static String getHeader() {
        return "\"" + SITE_CODE.getName() + "\"" + "," + "\""
            + TIMESTAMP.getName() + "\"" + "," + "\"" + FORECOURT_CODE.getName()
            + "\"" + "," + "\"" + TANK_CODE.getName() + "\"" + "," + "\""
            + CAPACITY.getName() + "\"" + "," + "\"" + RAW_VOLUME.getName()
            + "\"" + "," + "\"" + ATG_VOLUME.getName() + "\"" + "," + "\""
            + ATG_LEVEL.getName() + "\"" + "," + "\"" + WATER_LEVEL.getName()
            + "\"" + "," + "\"" + TEMPERATURE.getName() + "\"" + "," + "\""
            + PRODUCT_CODE.getName() + "\"" + "," + "\"" + TANK_ULLAGE.getName()
            + "\"" + "," + "\"" + SOD_VOLUME.getName() + "\"" + "," + "\""
            + DELIVERIES.getName() + "\"" + "," + "\""
            + DISPENSER_SALES.getName() + "\"" + "," + "\""
            + OPERATING_VARIANCE.getName() + "\"" + "," + "\""
            + STATUS.getName() + "\"" + "," + "\"" + BACK_FILLED.getName()+"\""+S3_TIMESTAMP.getName()
            + "\"" + "\n";
    }

    public static String[] getHeaderArray() {

        String[] array = new String[NormalisedATGEnum.values().length];
        array[NormalisedATGEnum.SITE_CODE.getColumnIndex()] =
            NormalisedATGEnum.SITE_CODE.getName();
        array[NormalisedATGEnum.TIMESTAMP.getColumnIndex()] =
            NormalisedATGEnum.TIMESTAMP.getName();
        array[NormalisedATGEnum.FORECOURT_CODE.getColumnIndex()] =
            NormalisedATGEnum.FORECOURT_CODE.getName();
        array[NormalisedATGEnum.TANK_CODE.getColumnIndex()] =
            NormalisedATGEnum.TANK_CODE.getName();
        array[NormalisedATGEnum.CAPACITY.getColumnIndex()] =
            NormalisedATGEnum.CAPACITY.getName();
        array[NormalisedATGEnum.RAW_VOLUME.getColumnIndex()] =
            NormalisedATGEnum.RAW_VOLUME.getName();
        array[NormalisedATGEnum.ATG_VOLUME.getColumnIndex()] =
            NormalisedATGEnum.ATG_VOLUME.getName();
        array[NormalisedATGEnum.ATG_LEVEL.getColumnIndex()] =
            NormalisedATGEnum.ATG_LEVEL.getName();
        array[NormalisedATGEnum.WATER_LEVEL.getColumnIndex()] =
            NormalisedATGEnum.WATER_LEVEL.getName();
        array[NormalisedATGEnum.TEMPERATURE.getColumnIndex()] =
            NormalisedATGEnum.TEMPERATURE.getName();
        array[NormalisedATGEnum.PRODUCT_CODE.getColumnIndex()] =
            NormalisedATGEnum.PRODUCT_CODE.getName();
        array[NormalisedATGEnum.TANK_ULLAGE.getColumnIndex()] =
            NormalisedATGEnum.TANK_ULLAGE.getName();
        array[NormalisedATGEnum.SOD_VOLUME.getColumnIndex()] =
            NormalisedATGEnum.SOD_VOLUME.getName();
        array[NormalisedATGEnum.DELIVERIES.getColumnIndex()] =
            NormalisedATGEnum.DELIVERIES.getName();
        array[NormalisedATGEnum.DISPENSER_SALES.getColumnIndex()] =
            NormalisedATGEnum.DISPENSER_SALES.getName();
        array[NormalisedATGEnum.OPERATING_VARIANCE.getColumnIndex()] =
            NormalisedATGEnum.OPERATING_VARIANCE.getName();
        array[NormalisedATGEnum.STATUS.getColumnIndex()] =
            NormalisedATGEnum.STATUS.getName();
        array[NormalisedATGEnum.BACK_FILLED.getColumnIndex()] =
            NormalisedATGEnum.BACK_FILLED.getName();
        array[NormalisedATGEnum.S3_TIMESTAMP.getColumnIndex()] =
                NormalisedATGEnum.S3_TIMESTAMP.getName();
        return array;
    }

}
