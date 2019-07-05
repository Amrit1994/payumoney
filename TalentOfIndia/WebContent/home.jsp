<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>TALENT OF INDIA is the biggest talent platform that offers for all aspiring new talents such as singing, dancing, comedy & acting to showcase their talent & bringing one's self to the national stage to share one's talent. We hold the value in creating excellent experience for all participants to let them shine and be proud of who they are and the talent they possess.</title>
<meta name=description content="TALENT OF INDIA is the biggest talent platform that offers for all aspiring new talents such as singing, dancing, comedy & acting to showcase their talent & bringing one's self to the national stage to share one's talent. We hold the value in creating excellent experience for all participants to let them shine and be proud of who they are and the talent they possess."/>
<meta name=keywords content="singing auditions, singing competitions, auditions in india, auditions in ludhiana, upcoming singing auditions, singing competition in india, singing."/>
<meta http-equiv=X-UA-Compatible content="IE=EmulateIE7; IE=EmulateIE9"/>
<meta http-equiv=Content-Type content="text/html; charset=utf-8"/>
<link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico">
<meta name=viewport content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
<meta name=robots content="index, follow"/>
<meta name=GOOGLEBOT content="index,follow"/>
<meta name=rating content=general />
<meta name=revisit-after content="7 days"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel=stylesheet type="text/css" href=style.css media=all />
<link rel=stylesheet type="text/css" href=demo.css media=all />
<link rel=stylesheet type="text/css" href=jquery_popup.css media=all />
<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-78356029-1', 'auto');
  ga('send', 'pageview');

</script>
<script src="js/jquery-1.3.2.js"></script>
<script src="js/jquery.validate.js"></script>
<script src="js/jquery.validation.functions.js"></script>

<script src="js/jquery_popup.js"></script>

<!--Start of Tawk.to Script
<script type="text/javascript">
var Tawk_API=Tawk_API||{}, Tawk_LoadStart=new Date();
(function(){
var s1=document.createElement("script"),s0=document.getElementsByTagName("script")[0];
s1.async=true;
s1.src='https://embed.tawk.to/551b7cc3809161cc22d4b818/default';
s1.charset='UTF-8';
s1.setAttribute('crossorigin','*');
s0.parentNode.insertBefore(s1,s0);
})();
</script>-->
<!--End of Tawk.to Script-->
<script type="text/javascript">
/* <![CDATA[ */
var google_conversion_id = 944310629;
var google_custom_params = window.google_tag_params;
var google_remarketing_only = true;
/* ]]> */
</script>
<script type="text/javascript" src="//www.googleadservices.com/pagead/conversion.js">
</script>
<noscript>
<div style="display:inline;">
<img height="1" width="1" style="border-style:none;" alt="" src="//googleads.g.doubleclick.net/pagead/viewthroughconversion/944310629/?value=0&amp;guid=ON&amp;script=0"/></div>
</noscript>

 <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script> 
 
<script type="text/javascript"> 
	function getCities(state)
	{
		    $(".aa").remove();
		     $.ajax({
		     type: "POST",
		     url: "${pageContext.request.contextPath}/BindStates",
		     data: {stateId:state.value},
		     success : 
              function(data) {
		    	 var obj = JSON.parse(data);
		    	 var city = obj.cities;
		    	 $("#productCity").append('<option class="aa" style="color:black;" value="">Select City</option>');
		    	 for (var citi in city) {
		    		$("#productCity").append('<option class="aa" style="color:black;" value="'+city[citi].cityname+'">'+city[citi].cityname+'</option>');
		    	 } 
		    	},
		       error : function() {
		            alert('error');
		       }
		    });
         }
	
	function dateValidator()
	{
		var _myDate = $('#bd').val();
		var new_date=_myDate.split('-');
	    //var month=new_date[0];
	    //var day=new_date[1];
	    var year=new_date[0];
	    if(year>2004)
	    {
	     alert("Contestant Age Should be 15-40 Years only");	
	     return false;
	    }
	    
	    if(year<1979)
	    {
	     alert("Contestant Age Should be 15-40 Years only");
	     return false;
	    }
		
	}
	</script>
</head>
<body class=bck onload="calll()">

<div class=container>
  <div class=freshdesignweb-top> <a href="SendYoutubeLink" class="video"> Upload your video on our youtube channel</a>
  <!--  <a href=""><button class=" button btn-primary">Click here</button></a>
 <a href="https://www.facebook.com/" target=_blank><i class="fa fa-facebook-square" style="font-size:24px"></i></a>
    <a href="https://" target=_blank><i class="fa fa-instagram" style="font-size:24px;"></i></a>
   <a href="https://" target=_blank> <i class="fa fa-twitter-square" style="font-size:24px;"></i></a>
   <a href="https://" target=_blank> <i class="fa fa-pinterest-square" style="font-size:24px;"></i></a>
    <a href="https://" target=_blank><i class="fa fa-youtube-square" style="font-size:24px;"></i></a>-->

  <span class=right menu>
  <a href="OfficialSite?page=officialsitehomepage9512827347287783488374784723478" target=_blank>OFFICIAL SITE</a> 
  </span>
    
    
    <div class=clr></div>
  </div>
  <div class="container">
   <div class=form>
    <h1  class=reg> Singing Audition Registration Form  </h1>
    <br>
    <p class=reg1>
   
    <br>
    <br>
    <form id="contactform" name="regform" action="UserRegistrationController" method="post" enctype="multipart/form-data" class="form-inline" onsubmit="return dateValidator()">
      <p class=contact>
        <label for=name>Name:</label>
      </p>
      <input  id="name" name="ufname" placeholder="First name" minlength=3 required>
       <input  id="name" name="umname" placeholder="Middle name">
        <input id="name" name="ulname" placeholder="last name">
           <p class=contact>
        <label for=name>Father's Name:</label>
      </p>
      <input  id="name" name="ffname" placeholder="First name" required>
       <input  id="name" name="fmname" placeholder="Middle name">
        <input  id="name" name="flname" placeholder="last name">
           <p class=contact>
        <label for=name>Mother's Name:</label>
      </p>
      <input  id="name" name="mfname" placeholder="First name" required>
       <input id="name" name="mmname" placeholder="Middle name">
        <input  id="name" name="mlname" placeholder="last name">
          <br>
          <br>
       <p class=contact>
        <label for=email>Email:</label>
        <input id=email name="email" placeholder="example@domain.com"  type=email  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required>
        
        <label for=phone class="mob">Mobile phone:</label>
        <input id=phone name="phone" placeholder="phone number" onkeypress='return event.charCode >= 48 && event.charCode <= 57'  minlength=10 maxlength=10  type=tel required>
       </p>
       <fieldset>
         <label>Category:</label>
             <select class = "myList1" name="cat">
               <option value="SUR SANGAM (SINGING)">SUR SANGAM (SINGING)</option>
             </select>
             <br>
          <label class = "audcity1">Audition City:</label>
               <select class = "audcity" name="audcity" >
                    <option value="">Select Audition City</option>
                    <c:forEach var="ac" items="${audcities}">
				     <option value="${ac.acityname}">${ac.acityname}</option>
					</c:forEach>
              </select>    
             
        <span class=ValidationErrors></span>
        </fieldset>
        <br>
        <p class=contact>
        <label>Gender: </label>
      <input type="radio" name="gender" value="male"> Male
      <input type="radio" name="gender" value="female" checked> Female

      <label class="dob">D.O.B: </label>
      <input type="date" name="bday" id="bd" class="date"  required>
      </p>
      <br>
       <p class=contact>
        <label for=phone>Address:</label>
      </p>
      <textarea id=address name="address" placeholder=" enter Address" rows="4" ></textarea>
      <br><br>
       
       <p class=contact>
         <label>State:</label>
                <select class = "state" name="state" onchange="getCities(this)" required>
                    <option value="">Select State</option>
                    <c:forEach var="st" items="${states}">
				    <option value="${st.statename}">${st.statename}</option>
					</c:forEach>
              </select>
        <span class=ValidationErrors></span>
          <label class="city" >City:</label>
              <select id="productCity"  class = "city1" name="city" required >
       			 <span class=ValidationErrors></span>
    		 </select>
        </p>
       <br>
       <label class="pinnam" >Pincode:</label>
      <input id=address name="pincode" placeholder="Enter Pincode" onkeypress='return event.charCode >= 48 && event.charCode <= 57'  minlength=6 maxlength=6  type=tel required>
      <p class=contact>
       <label class="academy">Academy Code:</label>
      <input id=address class="academy1" name="pincode" placeholder="Academy Code" minlength=6 maxlength=6  type=tel disabled>
    </p>
      <br>
        <p class=contact>
        Picture: <input type="file" name="myFile1" class="pic" accept="image/*" required> (Image size should be less than 400 kb)
      <!-- <img src="images/logo.png" height="70px" width="60px" class="img1"> -->
      </p>
       <p class=contact>
        Id Proof:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="file" name="myFile2" class="id" accept="image/*" required> (Image size should be less than 400 kb)
      <!-- <img src="images/logo.png" height="70px" width="60px" class="img1"> -->
      </p>
      <p class=contact>
        Signature: <input type="file" name="myFile3" class="sig" accept="image/*" required>(Image size should be less than 400 kb)
      <!-- <img src="images/logo.png" height="30px" width="80px" class="img1"> -->
      </p>
      <br>
       <br>
    <input type="checkbox" name="vehicle" value="Bike" required> &nbsp;I fully agree with the Terms and Conditions of Talent of India (Sur Sangam Singing Competition)<br>
     
        <br>
        <input class="buttom" name="submit" id="submit" tabindex="5" value="Submit" type="submit">
         <script type="text/javascript">
        window.onbeforeunload = function () {
            var inputs = document.getElementsByTagName("INPUT");
            for (var i = 0; i < inputs.length; i++) {
                if (inputs[i].type == "button" || inputs[i].type == "submit") {
                    inputs[i].disabled = true;
                }
            }
          };
    </script>
       <br>
       <br> 
      <p><span class=style1> <a href=terms.html>Terms of Use</a> </span></p>
    </form>
  </div>
</div>
</body>
<h3 align="center" style="color:white;">Visitor Count :<img src="https://smallseotools.com/counterDisplay?code=7d394327a50cbdcab069a01abfb462ce&style=0010&pad=7&type=page&initCount=100"  title="Visitor Hit Counter" Alt="Visitor Hit Counter" border="0"></h3>
</html>