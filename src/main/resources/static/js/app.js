var app = (function () {

    var res = [];

    var getAirports = function (locationName) {
        var getPromise = $.get("/AirportsFinder/"+"{"+locationName+"}");

        getPromise.then(
            function (data,status){

                $("#listAirports tbody").empty();
                JSON.parse(data).map(function (value, index) {
                    var toAdd = '<tr><td>'+value.code+'</td><td>'+value.name+'</td><td>'+value.city+'</td><td>'+value.countryCode+'</td></tr>'
                    $("#listAirports tbody").append(toAdd);
                    res.push(value.location);
                });

            },
            function () {
                console.log("Bad request");
            }
        );
        return getPromise;
    };


    return {

        searchAirports: function(){
            var locationName =  document.getElementById("locationInput").value;

            getAirports(locationName).then(function () {
                document.getElementById("map").style.display = "inline-flex";

            });

        },

    };

})();