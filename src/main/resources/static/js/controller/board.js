function contribution(){
  var requestObj = {
      boardId:null,
      comment:null,
  };

//リクエスト用のオブジェクトに値を詰め込む
  requestObj.boardId = $("#board").val();
  requestObj.comment = $("#comment").val();
//JavaScriptのオブジェクトをJSONに変換する 
  var requestJson =JSON.stringify(requestObj); 

  $.getJSON('/commentContribution', {data : requestJson},function(){

  });


}
