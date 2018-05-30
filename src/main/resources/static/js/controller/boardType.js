$(function(){
//  var selectBoardType = boardType;
  var dat = ""; 
  $.getJSON("boardType",function(data){
    jQuery.each(data,function(i,val){
//      if(data[i].id == selectBoardType){
//        dat +=`<option value="${data[i].id}"selected>${data[i].boardType}</option>`;  
//      }else{
//        dat +=`<option value="${data[i].id}">${data[i].boardType}</option>`;  
//      }
      dat +=`<option value="${data[i].id}">${data[i].boardType}</option>`;  
    });
    $("#board_type").append(dat);
    $("#regist_board_type").append(dat);
  });
});


