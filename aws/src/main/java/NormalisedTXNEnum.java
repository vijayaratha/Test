

public enum NormalisedTXNEnum {
    SITE_CODE("SiteCode",0),
	TRANSACTION_ID("TransactionId",1),
	TRANSACTION_START_DATE("TrasactionStartDate",2),
	TRANSACTION_END_DATE("TrasactionEndDate",3),
	DISPENSER_CODE("DispenserCode",4),//Dispenser code and pump code is same(as a discussion 31/08/16)
	HOSE_CODE("HoseCode",5),
	GRADE_CODE("GradeCode",6),
	VALUE("Value",7),
	VOLUME("Volume",8),
	UNIT_PRICE("UnitPrice",9),
	ATTENDANT_CODE("AttendantCode",10),
	AUTH_TIME("AuthTime",11),
	PAY_TIME("PayTime",12),
	TANK_CODE("TankCode",13),
	TANK_START_VOLUME("TankStartVol",14),
	TANK_END_VOLUME("TankEndVol",15),
	TANK_IN_USE("TankInUse",16),
	START_METER_VOLUME("StartMeterVolume",17),
	START_METER_AMOUNT("StartMeterAmount",18),
	END_METER_VOLUME("EndMeterVolume",19),
	END_METER_AMOUNT("EndMeterAmount",20),
	BACK_FILLED("Backfilled",21),
    S3_TIMESTAMP("S3 Timestamp", 22);
    
	  private final String name;
	  private final Integer columnIndex;
	  
    NormalisedTXNEnum(final String name, final Integer columnIndex) { 
    	this.name = name; 
    	this.columnIndex = columnIndex; 
    }
    
    public String getName()
    {
    	return name;
    }
    
    public Integer getColumnIndex()
    {
    	return columnIndex;
    }
    
    public static String getHeader()
    {
    	return "\""+SITE_CODE.getName()+"\""+","+"\""+TRANSACTION_ID.getName()+"\""+","+"\""+TRANSACTION_START_DATE.getName()+"\""+","+
    			"\""+TRANSACTION_END_DATE.getName()+"\""+","+"\""+DISPENSER_CODE.getName()+"\""+","+"\""+HOSE_CODE.getName()+"\""+","+
    			"\""+GRADE_CODE.getName()+"\""+","+"\""+VALUE.getName()+"\""+","+"\""+VOLUME.getName()+"\""+","+
    			"\""+UNIT_PRICE.getName()+"\""+","+"\""+ATTENDANT_CODE.getName()+"\""+","+"\""+AUTH_TIME.getName()+"\""+","+
    			"\""+PAY_TIME.getName()+"\""+","+"\""+TANK_CODE.getName()+"\""+","+"\""+TANK_START_VOLUME.getName()+"\""+","+
    			"\""+TANK_END_VOLUME.getName()+"\""+","+"\""+TANK_IN_USE.getName()+"\""+","+"\""+START_METER_VOLUME.getName()+"\""+","+
    			"\""+START_METER_AMOUNT.getName()+"\""+","+"\""+END_METER_VOLUME.getName()+"\""+","+"\""+END_METER_AMOUNT.getName()+"\""+","+
    			"\""+BACK_FILLED.getName()+"\""+S3_TIMESTAMP.getName()+"\""
    			+ "\n";
    }
    public static String[] getHeaderArray()
    {
    	
    	String[] array=new String[NormalisedTXNEnum.values().length];
    	array[NormalisedTXNEnum.SITE_CODE.getColumnIndex()]=NormalisedTXNEnum.SITE_CODE.getName();
    	array[NormalisedTXNEnum.TRANSACTION_ID.getColumnIndex()]=NormalisedTXNEnum.TRANSACTION_ID.getName();
    	array[NormalisedTXNEnum.TRANSACTION_START_DATE.getColumnIndex()]=NormalisedTXNEnum.TRANSACTION_START_DATE.getName();
    	array[NormalisedTXNEnum.TANK_CODE.getColumnIndex()]=NormalisedTXNEnum.TANK_CODE.getName();
    	array[NormalisedTXNEnum.TRANSACTION_END_DATE.getColumnIndex()]=NormalisedTXNEnum.TRANSACTION_END_DATE.getName();
    	array[NormalisedTXNEnum.DISPENSER_CODE.getColumnIndex()]=NormalisedTXNEnum.DISPENSER_CODE.getName();
    	array[NormalisedTXNEnum.HOSE_CODE.getColumnIndex()]=NormalisedTXNEnum.HOSE_CODE.getName();
    	array[NormalisedTXNEnum.GRADE_CODE.getColumnIndex()]=NormalisedTXNEnum.GRADE_CODE.getName();
    	array[NormalisedTXNEnum.VALUE.getColumnIndex()]=NormalisedTXNEnum.VALUE.getName();
    	array[NormalisedTXNEnum.VOLUME.getColumnIndex()]=NormalisedTXNEnum.VOLUME.getName();
    	array[NormalisedTXNEnum.UNIT_PRICE.getColumnIndex()]=NormalisedTXNEnum.UNIT_PRICE.getName();
    	array[NormalisedTXNEnum.ATTENDANT_CODE.getColumnIndex()]=NormalisedTXNEnum.ATTENDANT_CODE.getName();
    	array[NormalisedTXNEnum.AUTH_TIME.getColumnIndex()]=NormalisedTXNEnum.AUTH_TIME.getName();
    	array[NormalisedTXNEnum.PAY_TIME.getColumnIndex()]=NormalisedTXNEnum.PAY_TIME.getName();
    	array[NormalisedTXNEnum.TANK_CODE.getColumnIndex()]=NormalisedTXNEnum.TANK_CODE.getName();
    	array[NormalisedTXNEnum.TANK_START_VOLUME.getColumnIndex()]=NormalisedTXNEnum.TANK_START_VOLUME.getName();
    	array[NormalisedTXNEnum.TANK_END_VOLUME.getColumnIndex()]=NormalisedTXNEnum.TANK_END_VOLUME.getName();
    	array[NormalisedTXNEnum.TANK_IN_USE.getColumnIndex()]=NormalisedTXNEnum.TANK_IN_USE.getName();
    	array[NormalisedTXNEnum.START_METER_VOLUME.getColumnIndex()]=NormalisedTXNEnum.START_METER_VOLUME.getName();
    	array[NormalisedTXNEnum.START_METER_AMOUNT.getColumnIndex()]=NormalisedTXNEnum.START_METER_AMOUNT.getName();
    	array[NormalisedTXNEnum.END_METER_VOLUME.getColumnIndex()]=NormalisedTXNEnum.END_METER_VOLUME.getName();
    	array[NormalisedTXNEnum.END_METER_AMOUNT.getColumnIndex()]=NormalisedTXNEnum.END_METER_AMOUNT.getName();
    	array[NormalisedTXNEnum.BACK_FILLED.getColumnIndex()]=NormalisedTXNEnum.BACK_FILLED.getName();
        array[NormalisedTXNEnum.S3_TIMESTAMP.getColumnIndex()]=NormalisedTXNEnum.S3_TIMESTAMP.getName();
    	return array;
    }
}
