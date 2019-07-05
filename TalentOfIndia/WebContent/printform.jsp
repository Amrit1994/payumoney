<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.toi.model.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<script>
function pdff(){	 
	 var HTML_Width = $(".canvas_div_pdf").width();
	 var HTML_Height = $(".canvas_div_pdf").height();
	 var top_left_margin = 15;
	 var PDF_Width = HTML_Width+(top_left_margin*2);
	 var PDF_Height = (PDF_Width*1.5)+(top_left_margin*2);
	 var canvas_image_width = HTML_Width;
	 var canvas_image_height = HTML_Height;
	 var totalPDFPages = Math.ceil(HTML_Height/PDF_Height)-1;
	 html2canvas($(".canvas_div_pdf")[0],{allowTaint:false}).then(function(canvas) {
	 canvas.getContext('2d');
	 var imgData = canvas.toDataURL("image/jpeg", 1.0);
	 var pdf = new jsPDF('p', 'pt',  [PDF_Width, PDF_Height]);
	     pdf.addImage(imgData, 'JPG', top_left_margin, top_left_margin,canvas_image_width,canvas_image_height);
	   for (var i = 1; i <= totalPDFPages; i++) { 
	    pdf.addPage(PDF_Width, PDF_Height);
	    pdf.addImage(imgData, 'JPG', top_left_margin, -(PDF_Height*i)+(top_left_margin*4),canvas_image_width,canvas_image_height);
	   }
	   //alert(-(PDF_Height*i)+(top_left_margin*4));
	   pdf.save("Reg_Form.pdf");
	 });
};     
</script>
</head>
<body class=bck1 >
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="js/jspdf.debug.js"></script>
<script src="js/jspdf.min.js"></script>
<script src="js/html2canvas.js"></script>

<%User user = (User)request.getSession(false).getAttribute("userdetail");%>
  <div  class="canvas_div_pdf container c1" id="printDiv" style="background-color:#FFF; border:1px solid #000; width:900px;">
	<div class="row pid">
    	<div class="col-md-3 text-center">
    	<img src="images/logo1.png" height="80px" width="140px"/>
          <p class="text-center" style="margin-top:50px;">
        	Contestant Id :<br><%=request.getAttribute("usercode")%>
          </p>  
        </div>
        <div class="col-md-6 text-center">
        	  <img src="images/logo-sursangam.png" height="100px" width="230px"/><br>
          Singing Competition 2019<br><br>
          <h2>  Audition Registration Form</h2>
        </div>
        <div class="col-md-3 photo text-center">
        		<img src="<%=user.getPicture()%>">
        	<p class="text-center" style="margin-top:8px;">
        	Audition City:<br><%=user.getAudCity()%>
          </p> 
        </div>
        </div>
      
        	<form class="original-form">
              <div class="row">
            	Name:<input type="text"  class="pname1 text-center" value="<%=user.getUfname()%>" disabled>
                <input type="text"  class="pnam text-center" value="<%=user.getUmname()%>" disabled>
                <input type="text"  class="pnam text-center" value="<%=user.getUlname()%>" disabled>
                </div>
              <div class="row in">
            	Father's Name:<input type="text"  class="pname2 text-center" value="<%=user.getFfname()%>" disabled>
                <input type="text"  class="pname2 text-center" value="<%=user.getFmname()%>" disabled>
                <input type="text" class="pname2 text-center" value="<%=user.getFlname()%>" disabled>
                </div>
                 <div class="row in">
            	Mother's Name:<input type="text"  class="pnamem text-center" value="<%=user.getMfname()%>" disabled>
            	 <input type="text"  class="pname2 text-center" value="<%=user.getMmname()%>" disabled>
                <input type="text"  class="pname2 text-center" value="<%=user.getMlname()%>" disabled>
                </div>
                   <div class="row in">
                   <div class="col-md-6 mname">
            	D.O.B:<input type="text"    class="states text-center" value="<%=user.getDob().getDate()%>-<%=user.getDob().getMonth()+1%>-<%=user.getDob().getYear()%>" disabled>
                 </div>
                  <div class="col-md-6">
            	 Mobile:<input type="text"  class="mobile text-center" value="<%=user.getMobile()%>" disabled>
                 </div>
                </div>
                <div class="row in">
                   <div class="col-md-6 mname">
            	Email Id:<input type="mail"    class=" emailid  text-center" value="<%=user.getEmail()%>" disabled>
                 </div>
                  <div class="col-md-6">
            	Pincode:<input type="text"  class="pincode text-center" value="<%=user.getPincode()%>" disabled>
                 </div>
                 </div>
               <div class="row in">
            	Address:<input type="text"  class="add" value="<%=user.getAddress()%>" disabled><br>
            
                </div>  
                 <div class="row in">
                 <div class="col-md-6 state1">
            	 State:<input type="text"  class="states text-center" value="<%=user.getState()%>" disabled>
                 </div>
                 <div class="col-md-1"></div>
                  <div class="col-md-5">
            	City:<input type="text"  class="cities text-center" value="<%=user.getCity()%>" disabled>
                 </div> 
                </div>
            </form>
             <div class="row id1">
             <div class="col-md-4 text-center">
             	<h5 class="float-left">Payment Information:</h5>
                </div>
                <div class="col-md-4"></div>
             </div>
            <div class="row pay">
             <div class="col-md-1"></div>
             <div class="col-md-11">
             <table class="fees">
             <tr>
             	<td>Payment Id:</td>
             <td><input type="text"  class=" ref text-center" value="<%=request.getAttribute("pay_id")%>"disabled></td>
             	<td></td>
             </tr>
              <tr>
             	<td> Registration Fee:</td>
             <td  class="text-center"> 1000/-</td>
             	<td > Rupees One Thousand </td>
             </tr>
              <tr>
             	<td>   Transaction charges :</td>
             <td  class=" text-center">30/-</td>
             	<td> Rupees Thirty </td>
             </tr>
             <tr>
             	<td>  Toatl Amount Paid:</td>
             <td  class=" text-center"> 1030/-</td>
             	<td> Rupees One Thousand Thirty</td>
             </tr>
                </table>
                </div>
             
             </div> 
             <div class="row id2">
             <div class="col-md-4 text-center">
             	<h5>Terms & Conditions:</h5>
                </div>
                <div class="col-md-4"></div>
             </div>
              <div class="row tc">
             <div class="col-md-11">
             	<div class="entry-content">
                <h4 class="a">  A. GENERAL TERMS & CONDITIONS</h4>
     <ul type="none">
   <li> 1. Registration form to be submitted online only.</li>
   <li> 2. Registration will be completed after paying Registration fee which is INR 1,000 <b>(Non-Refundable)</b>.</li>
   <li>3. To participate in <b>Sur Sangam</b>, your Age must be 15-40 years.</li>
   <li> 4. The Contest Winner shall be eligible to win the Contest Prize as decided by Contest Organizer at Contest Organizer's sole discretion. Any and all taxes and/or levies applicable under the English laws of INDIA shall be borne by the Contest Winner in relation to the Contest Prize.</li>
    <li> 5. Incomplete, erroneous and/or submission of answers/response submitted after the Contest Period shall be considered and shall be null and void.</li>
	<li> 6. Contest Organiser shall not be responsible for any technical disruption and/or failure/ server problems and/ or any other difficulties of such nature, due to which the participant is unable to participate in theContest.</li>
 <li> 7. Each Contest Participant(s) stand a chance of winning only once during the Contest and any subsequent wins if declared, will be automatically void.</li>
<li>8. Contest Organiser reserves the right to disqualify any Contest Participant from participating in the Contest without assigning any reason. The decision of Contest Organiser in this regard shall be final and binding upon the Contest Participants.</li>
 <li>9. The Contest Participants shall ensure that the answer/response/post on the Online Platform:
 	<ul type="none">
 		<li>a. shall not violate the rights of any third party, including, but not limited to, privacy rights, copyrights, 
 		trademark rights and/or any other intellectual property rights; The participants shall indemnify the Contest Organiser, 
 		its officials, employees, representatives against any claim, loss, damages and liability arising as a result of 
 		infringement of third party intellectual property rights.</li>
 	<li>b. is not harmful, harassing, blasphemous, defamatory, obscene, pedophilic, libelous, invasive of another's privacy, hateful, or racially, ethnically objectionable, disparaging, or otherwise unlawful in any manner whatever.</li>
 	<li>c. does not harm minors in anyway.</li>
 	<li>d. does not violate any law for the time being inforce.</li>
 	<li>e. does not deceive or mislead about the origin of such messages or communicates any information which is grossly offensive or menacing in nature.</li>
 	<li>f. they are well aware of the terms and conditions of use of websites, especially policy against spamming and/or privacy policies, and shall participate in the Contest with strict adherence to such terms and policies. In no event Contest Organiser shall be responsible or held liable for any acts of the Contest Participants.</li>
 	<li>g. does not contain software viruses or any other computer code, files or programs designed to interrupt, destroy or limit the functionality of any computer resource.</li>
 	<li>h. shall not create any liability for Contest Organiser or any of its respective parents, subsidiaries, affiliates, successors, assigns, employees, agents, directors, officers and shareholders.</li>
 	<li>i. The participant(s) represents and warrants that the entries are an original work of the participant and the participant has all necessary rights, licenses, consents and permissions to use, and to authorize Contest Organiser to use, any and all copyrights ,or other intellectual property rights in and to entries in order for Contest Organiser to use the entries on any of its platforms or otherwise.</li>
 	<li>j. In the event of any discrepancy as to the date and/or the time of receipt to fany entry, Contest Organiser shall have the final decision in resolving such discrepancy.</li>
 	<li>k. In relation to the Contest, Contest Organiser shall make any such marketing and/or promotional announcement as a part of its promotional activity. Contest Organiser does not confirm the validity/truthfulness of such promotional announcement.</li>
 	</ul>
 </li>
<li> 10. The competition requires a non-refundable entrance fee to complete an entry; this covers administration costs plus my audition at my selected region. The entrance fee does not cover any contestant expenses such as travel. At the Company discretion and where possible alternative audition dates will be offered if in the unlikely event an audition is cancelled or if you are unable to attend your audition. Submission of an application does not guarantee the opportunity to audition or participate in the competition.</li>
<li> 11. I agree to make myself available, at my own expense, at such times and in such locations as the Company may reasonably require in respect of the competition including without limitation rehearsals, publicity, press calls, photographs, recordings and/or other contributions. Such events will be organised and paid for by the Company. I understand that I am not entitled to receive exposure to such events.</li>
<li> 12. No filming, recording or photography will be permitted at any of the event nights unless agreed in writing by the Company 7 days prior to an event that will cost as per the company norms.</li>
<li> 13. The Company (or other such company as chosen by the Company) may film and/or record performances at the events. I agree to the use of this material by the Company for marketing and promotional purposes, including but not limited to domestic (State Level), national and international broadcast, including rights to reproduce and edit footage. The Company will own all intellectual property rights in any film and sound recording of the performances.</li>
<li> 14. I am free to enter into this agreement and hereby agree to indemnify the Company in respect of all actions, proceedings, claims, damages and other liabilities which may be brought against or incurred by the Company as a result of the breach of any of my warranties, representations or obligations contained in this agreement. I agree that in the event of any breach of this agreement by the Company I shall not be entitled to injunct the competition and any legal remedy I may have shall lie in an action at law for damages only.</li>
<li>15. I hereby warrant that I have not entered into any commercial, sponsorship or other agreement or arrangement with any person, firm or company in respect of my entry in the competition and/or musical, musical writing and/or performing abilities and will not do so.</li>
</ol>
<h4>  B. ELIGIBILITY FOR PARTICIPATION IN THE CONTEST</h4>
<ul type="none">
	<li>1. The Contest is open for residents of NORTH INDIA only and is not open for participants from other parts or elsewhere.</li>
	<li>2. This Contest is strictly governed by the laws of INDIA including the Privacy Laws of INDIA.</li>
	<li>3. Contest Participants must have attained the age of 15-40 years to participate in the Contest.</li>
	<li>4. Employees, agents and promoters (including their immediate family members) of Contest Organiser and any of their divisions, affiliates and subsidiaries, and others associated with the Contest in any manner, are not eligible to participate in the Contest.</li>
</ul> 
 
 <h4>  C. TERMS AND CONDITIONS TO CLAIM THE CONTEST PRIZE</h4>
<ul type="none">
	<li>1. The mode of delivery/obtaining the Contest Prize shall be communicated by Contest Organiser to Contest Winner upon completion of the Contest Period at Contest Organiser's sole discretion.</li>
	<li>2. Providing of Contest Prize and related services shall be held at such venue and time, and of such class and/or value as may be decided by Contest Organiser at its sole discretion.</li>
	<li>3. Within a period of twenty four (24) hours from the announcement of the Winner(s), the Winners will have to send a direct message to the contact address/phonenumber ("Communication Platform"Äù), as may be notified by Contest Organiser, with complete details of the Winner including their Name, Telephone No, Postal Address, E-Mail Address & copy of Photo ID Proof(issued by Government authority)(Contact DetailsÄ), failing which Contest Organiser may or may not select another Winner. In the event, successful contact with the Winner is not established (i.e. in case the Winner fails to provide Contact Details to Contest Organiser on the Communication Platform within twenty four (24) hours from the time of announcement of winner(s) for any reason whatsoever)
    , that Winner shall not be considered for the Prize and Contest Organiser may/may not choose other Winner at its sole discretion.</li>
</ul> 
<h4>  D. OTHER TERMS AND CONDITIONS</h4>
<ul type="none">
	<li>1. Competition finalists (TOP 10), defined as any act making the Grand Final, acknowledge and agree to make themselves available for appearances and promotion for an 18 month period from the end of the competition for a minimum of 5 times (Without Cost). These will be at such times and in such locations as the Company may reasonably require in respect of the competition including without limitation showcases, Regional Finals and the Grand Final for the following year, interviews, publicity, press calls, photographs, recordings and/or other contributions. I agree to attend such events and will advise of (and) provide receipts to the Company for reimbursement of any reasonable travel expenses incurred.</li>
	<li>2. The Company will entertain only those contestants who will be selected for Mega Auditions. All expenses (Food & Accommodations) Etc. will be afforded by TALENT OF INDIA.</li>
	<li>3. Contest Organiser shall not be responsible for any technical disruption and/or failure/ server problems and/ or any other difficulties of such nature, due to which the participant is unable to participate in the Contest.</li>
	<li>4. I acknowledge and agree to abide fully by the rules, regulations, terms and conditions for this competition (the Rules). I agree to observe all procedures and obey all reasonable instructions in force or given by a member of the Company and/or any location staff in connection with the competition and the management of the locations
and the fire safety and security arrangements in those locations.</li>
<li>5. I acknowledge and agree that if I am successful at the auditions & Winner I will be given tickets to sell for the live Regional Final show which I will try my best to sell to family, friends and fans.</li>
<li>6. I acknowledge that the Company reserve the right to amend the Rules (including without limitation verbally) or terminate the competition at any time without liability to me. The Company's decisions shall be final.</li>
<li>7. If I am under 18 years old I must obtain the consent of my parent(s) or legal guardian(s) and enter their details as provided in the application form prior to my entry into the competition.</li>
<li>8. I must be resident in the INDIA. I may be asked to provide the Company with supporting documentation in order to substantiate this (i.e. birth certificate and/or valid passport, Gov. Proofs). I acknowledge that the Company reserves the right to require at any time proof of my identity and/or eligibility.</li>
<li>9. All personal details and/or information given in my application either in this form or otherwise must be truthful, accurate and in no way misleading. I undertake to inform the Company immediately if any such information becomes inaccurate.</li>
<li>10. I acknowledge that the Company reserves the right to remove or disqualify me from the competition at their absolute discretion and that the decision of the Company is final. I acknowledge that the Company will have no liability to me if I am unable to attend or take part in the competition.</li>
<li>11. The Company reserves the right to disqualify any contestant if they supply untruthful, inaccurate or misleading personal details and/or information, have failed to abide by the Rules and/or are in breach of the terms hereof.</li>
<li>12. The Company reserves the right to disqualify any contestant if they are deemed to be acting outside the spirit of the competition. The Company's decisions shall be final.</li>
<li>13. The Company will endeavour to operate the competition and apply the Rules and conditions of the competition as devised by the Company.</li>
<li>14. If any provision of this agreement is adjudged by a court to be void or unenforceable such provision shall no way affect any other provisions of this agreement, the application of the provision in any other circumstances or the validity or enforceability of this agreement and such provision shall be curtailed and limited only to the extent necessary to bring it within legal requirement.</li>
<li>15. The courts of PUNJAB & HARYANA shall have sole jurisdiction in relation to the terms and conditions of the agreement contained in this release which shall be interpreted according to the laws of INDIA.</li>
<li>16. Lastly have fun!</li>
<br/>
<li><b>I agree to the above terms and conditions, and signing this agreement, am stating that the information in the sanction applicaiton is true.</b></li>
</ul> 

                </div>
                <div class="col-md-1"></div>
             </div>
             
         <div class="signature">
             <div class="date">
                	<b>Date :</b> <% 
                	        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
                	        TimeZone istTimeZone = TimeZone.getTimeZone("Asia/Kolkata");
                			Date d = new Date();
                			sdf.setTimeZone(istTimeZone);
                			String strtime = sdf.format(d);
                	        out.print(strtime);
                	      %><br>
                	<b>Place:</b> <%= user.getCity()%>
                </div>
                	<div class=" signature1 text-center">
                	<div class="sign-img">
                		 <img src="<%=user.getSignature()%>" height="50px" width="110px">
                		</div>        		
                </div>
                <div class=" signature2 text-center">
                <b>Signature</b>
                </div>
             </div> 
             
             </div> 
        </div>
        <button type="button" class="btn btn-warning" id="pdfDownloader" onclick="pdff()" style="margin-top:20px;margin-left:600px;">Download</button>
          <button type="button" class="btn btn-warning" id="pdfDownloader" onClick="window.print()" style="margin-top:20px;margin-left:20px;">Print</button>
        </div>
</body>
</html>