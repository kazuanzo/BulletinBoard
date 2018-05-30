$(function(){
  var dat = ""; 
  $.getJSON("terminal",function(data){
    jQuery.each(data,function(i,val){
      dat +=`<option value="${data[i].stationName}">${data[i].stationName}</option>`;  
    });
  $("#terminal").append(dat);
  });
});



