 var AiportsFinderValues;
 var selectedAiportsFinder;
 var html;


function searchCityAiportsFinder(){
    getCityAiportsFinder();
}
 function getCityAiportsFinder(){
         
         area =$('#data');
        selectedCity=$('#city').val();
    
        var url="https://andres-vasquez-arsw-t2.herokuapp.com/AirportsFinder/"+selectedCity
        var xmlHttp = new XMLHttpRequest();
        xmlHttp.open("GET", url, false); // false for synchronous request
        xmlHttp.send(null);
        var lista =xmlHttp.responseText;
        lista=JSON.parse(lista);
        var up= getVals(lista)
        area.val(up);

    }
    function getVals(lista){
        var answer='';
        answer=answer+'Nombre -->'+lista['city']['name']
        answer= answer +' Locación -->' + lista['location']['pressure'];
        answer= answer + ' Code Country -->' + lista['main']['countryCode'];
        return answer;
    }