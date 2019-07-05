package com.toi.util;

public class DbQueries {
	
	public static final String GETSTATES = "SELECT `StateID`,`StateName` FROM `states` Where `IsActive`=1;";
	
	public static final String GETAUDCITIES = "SELECT `Audition_cityId`,`CityName` FROM `audition_city` WHERE `IsActive` = 1";
	
	public static final String GETCITIES = "SELECT `DistrictID`,`DistrictName` FROM district d inner join states s on d.StateID = s.StateID" +
			                               " where s.StateName = ? and d.IsActive = 1";
	
	//public static final String INSERTUSER = "INSERT INTO `userregistration` (`UserCode`,`UserFirstName`,`UserMiddleName`," +
	//		"`UserLastName`,`UserFatherFirstName`,`UserFatherMiddleName`,`UserFatherLastName`,`UserMotherFirstName`," +
	//		"`UserMotherMiddleName`,`UserMotherLastName`,`Email`,`Mobile`,`Category`,`Gender`,`DOB`,`Address`,`State`," +
	//		"`City`,`Pincode`,`Picture`,`Document`,`Signature`,`CreatedDate`)VALUES " +
	//		"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,now());";
	
    public static final String INSERTUSER = "call SP_insertuser(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
    //public static final String UPDATETRANSACTON = "UPDATE `transaction` SET `PaymentId` = ?, `PaymentStatusId` = ?, " +
   	//											 "`PaymentDone` = 1, `CreatedDate` = now() WHERE `TransactionID`=? ";
    
    public static final String UPDATETRANSACTON = "call SP_updatePaymentStatus(?,?,?)";
    
}
