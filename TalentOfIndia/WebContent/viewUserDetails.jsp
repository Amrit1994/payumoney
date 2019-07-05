<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.toi.model.*" %>
<!DOCTYPE html>
<html>
<head>
<title>TALENT OF INDIA is the biggest talent platform that offers for all aspiring new talents such as singing, dancing, comedy & acting to showcase their talent & bringing one's self to the national stage to share one's talent. We hold the value in creating excellent experience for all participants to let them shine and be proud of who they are and the talent they possess.</title>
<meta name=description content="TALENT OF INDIA is the biggest talent platform that offers for all aspiring new talents such as singing, dancing, comedy & acting to showcase their talent & bringing one's self to the national stage to share one's talent. We hold the value in creating excellent experience for all participants to let them shine and be proud of who they are and the talent they possess."/>
<meta name=keywords content="singing auditions, singing competitions, auditions in india, auditions in ludhiana, upcoming singing auditions, singing competition in india, singing."/>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="style.css" />
</head>
<body  class=bck>
<%User user = (User)request.getAttribute("userdetails");%>
<div class="container c">
<table class="t">
<tr>
<td colspan="2"><img src="" height="150px" width="470px" class="slogo">
<!--  <td class="ss" ><b style="font-size:30px; color:#d31f4e;">SUR SANGAM</b>-->
           <h5 class="text-center" class="sc"><b class="sc">Singing Competition 2019</b></h5>
           </td>

</tr>
<tr><td colspan="2"><b class="areg"> <h5><b class="areg">Audition Registration Form:</b></h5></td></tr>
<tr>
<td>First Name:</td><td><%=user.getUfname()%>&nbsp;<%=user.getUmname()%>&nbsp;<%=user.getUlname()%></td>
</tr>
<tr>
<td>Father's Name:</td><td><%=user.getFfname()%>&nbsp;<%=user.getFmname()%>&nbsp;<%=user.getFlname()%></td>
<!--  <td>Father's Middle Name</td><td><%=user.getFmname()%></td>
<td>Father's Last Name</td><td><%=user.getFlname()%></td>-->
</tr>
<tr>
<td>Mother's Name:</td><td><%=user.getMfname()%>&nbsp;<%=user.getMmname()%>&nbsp;<%=user.getMlname()%></td>
<!-- <td>Mother's Middle Name</td><td><%=user.getMmname()%></td>
<td>Mother's Last Name</td><td><%=user.getMlname()%></td>-->
</tr>
<tr>
<td>Email:</td><td><%=user.getEmail()%></td>
</tr>
<tr>
<td>Mobile:</td><td><%=user.getMobile()%></td>
</tr>
<tr>
<td>Category:</td><td><%=user.getCategory()%></td>
</tr>
<tr>
<td>Audition City:</td><td><%=user.getAudCity()%></td>
</tr>
<tr>
<td>Gender:</td><td><%=user.getGender()%></td>
</tr>
<tr>
<td>Date of Birth(dd/mm/yy):</td><td><%=user.getDob().getDate()%>/<%=user.getDob().getMonth()+1%>/<%=user.getDob().getYear()%></td>
</tr>
<tr>
<td>Address:</td><td><%=user.getAddress()%></td>
</tr>

<tr>
<td>State:</td><td><%=user.getState()%></td>
</tr>

<tr>
<td>City:</td><td><%=user.getCity()%></td>
</tr>

<tr>
<td>Pincode:</td><td><%=user.getPincode()%></td>
</tr>

<tr>
<td>Picture:</td><td><img src="<%=user.getPicture()%>" width="100px" height="100px"/></td>
</tr>

<tr>
<td>Document:</td><td><img src="<%=user.getDocument()%>" width="100px" height="100px"/></td>
</tr>

<tr>
<td>Signature:</td><td><img src="<%=user.getSignature()%>" width="100px" height="100px"/></td>
</tr>
<tr class="edit">
<td colspan="2"><a href="Update"><button class="btn btn-primary editb">Edit</button></a>

<form action="Payment"  name="payuform" method=POST>
<input type="submit" value="Make Payment"  class="btn btn-primary payment" />
</form>
</td>
</tr>
</table>
</div>

</body>
</html>