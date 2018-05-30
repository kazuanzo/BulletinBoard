<script src="https://maps.googleapis.com/maps/api/js"></script>
// Geolocation APIに対応している
if (navigator.geolocation) {
  alert("この端末では位置情報が取得できます");
  // Geolocation APIに対応していない
} else {
  alert("この端末では位置情報が取得できません");
}

// 現在地取得処理
function getPosition() {
  // 現在地を取得
  navigator.geolocation.getCurrentPosition(
      // 取得成功した場合
      function(position) {
        var data = position.coords;

        // 必要な緯度経度だけ取得
        var lat = data.latitude;
        var lng = data.longitude;

        //Google Mapsで住所を取得
        var geocoder = new google.maps.Geocoder();
        latlng = new google.maps.LatLng(lat, lng);
        geocoder.geocode({'latLng': latlng}, function(results, status) {
          if (status == google.maps.GeocoderStatus.OK) {
            alert(results[0].formatted_address);
          }
          else {
            alert("エラー" + status);
          }
        }); 


      },
      // 取得失敗した場合
      function(error) {
        switch(error.code) {
        case 1: //PERMISSION_DENIED
          alert("位置情報の利用が許可されていません");
          break;
        case 2: //POSITION_UNAVAILABLE
          alert("現在位置が取得できませんでした");
          break;
        case 3: //TIMEOUT
          alert("タイムアウトになりました");
          break;
        default:
          alert("その他のエラー(エラーコード:"+error.code+")");
        break;
        }
      }
  );
}