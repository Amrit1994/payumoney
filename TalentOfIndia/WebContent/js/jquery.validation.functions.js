function isValidDate(year,month,day){var date=new Date(year,(month-1),day);var DateYear=date.getFullYear();var DateMonth=date.getMonth();var DateDay=date.getDate();if(DateYear==year&&DateMonth==(month-1)&&DateDay==day)
return true;else
return false;}
function isChecked(id){var ReturnVal=false;$("#"+id).find('input[type="radio"]').each(function(){if($(this).is(":checked"))
ReturnVal=true;});$("#"+id).find('input[type="checkbox"]').each(function(){if($(this).is(":checked"))
ReturnVal=true;});return ReturnVal;}